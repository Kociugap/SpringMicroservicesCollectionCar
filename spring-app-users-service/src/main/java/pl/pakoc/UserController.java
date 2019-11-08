package pl.pakoc;

import java.util.List;

import javax.validation.Valid;

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
	public ResponseEntity<UserModel> getUser(@PathVariable("userId") Integer userId) {
		
		UserModel user = userService.getUserById(userId);
		
//		ResponseEntity<List<AlbumModel>> albumList = restTemplate.exchange(String.format(URI, userId), HttpMethod.GET, null, new ParameterizedTypeReference<List<AlbumModel>>(){});
//		user.setAlbums(albumList.getBody());
		
		List<AlbumModel> albums = albumServiceClient.getAlbums(userId);
		user.setAlbums(albums);
		
		return new ResponseEntity<UserModel>(user, HttpStatus.OK);
	}
}
