package pl.pakoc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import pl.pakoc.dto.UserDto;
import pl.pakoc.dto.UserModel;
import pl.pakoc.model.User;
import pl.pakoc.model.album.AlbumModel;
import pl.pakoc.service.UserService;
import pl.pakoc.service.album.AlbumServiceClient;

@RestController
@RequestMapping("/users")
@RefreshScope
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AlbumServiceClient albumServiceClient;
	
	private static final String URI = "http://ALBUMS-WS/users/%s/albums";
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${info.property}")
    private String property;

	@GetMapping("/status")
	public String checkConditional() {
		return "Working User Service.. Property of repository " + property;
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody @Valid UserDto userDto) {
		userService.createUser(userDto);
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{userId}")
	//@HystrixCommand(fallbackMethod = "getDefaultUser", )
	public ResponseEntity<UserModel> getUser(@PathVariable("userId") Integer userId) {
		
		UserModel user = userService.getUserById(userId);
		
//		ResponseEntity<List<AlbumModel>> albumList = restTemplate.exchange(String.format(URI, userId), HttpMethod.GET, null, new ParameterizedTypeReference<List<AlbumModel>>(){});
//		user.setAlbums(albumList.getBody());
		logger.info("Before calling albums method");
		List<AlbumModel> albums = albumServiceClient.getAlbums(userId);
		user.setAlbums(albums);
		logger.info("After calling albums method");
		
		return new ResponseEntity<UserModel>(user, HttpStatus.OK);
	}
	
	public ResponseEntity<UserModel> getDefaultUser(Integer id) {
		UserModel userModel = new UserModel("Jan", "Kowalski", "Wzorcowa", 24, new ArrayList<>());
		return new ResponseEntity<>(userModel, HttpStatus.FOUND);
	}
	
}
