package pl.pakoc.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import ch.qos.logback.classic.Logger;
import pl.pakoc.dto.AlbumDetailsDto;
import pl.pakoc.dto.AlbumDto;
import pl.pakoc.model.Album;

@Service
@PropertySource("classpath:album.properties")
public class AlbumsServiceImpl implements AlbumsService {
	
	@Value("${names}")
	private String[] names;
	@Value("${descriptions}")
	private String[] descriptions;
	
	@Autowired
	private ModelMapper modelMapper;

    @Override
    public List<AlbumDto> getAlbums(String userId) {
    	
    	List<Album> albums = prepareAlbumsForUser(userId);
    	List<AlbumDto> albumDtoList = new ArrayList<>();
    	
    	if(CollectionUtils.isEmpty(albums)) {
        	return albumDtoList;
        }
    	
    	Type albumResponseList = new TypeToken<List<AlbumDto>>(){}.getType();
    	   
        albumDtoList = modelMapper.map(albums, albumResponseList);
        
        return albumDtoList;
        
    }
    
    private List<Album> prepareAlbumsForUser(String userId) {
    	List<Album> albums = new ArrayList<>();
    	
    	AlbumDetailsDto albumDetails = generateNameAndDescForAlbum();
        Album album = new Album(1L, albumDetails.getId(), userId, albumDetails.getName(), albumDetails.getDescription());
        
        AlbumDetailsDto albumDetailsTwo = generateNameAndDescForAlbum();
        Album albumTwo = new Album(2L,  albumDetailsTwo.getId(), userId, albumDetailsTwo.getName(), albumDetailsTwo.getDescription());	
        
        albums = Arrays.asList(album, albumTwo);
        
        return albums;
    }
    
    private AlbumDetailsDto generateNameAndDescForAlbum() {
    	
    	int id = new Random().nextInt(20);
    	String name = names[new Random().nextInt(names.length)];
    	String description = descriptions[new Random().nextInt(descriptions.length)];
    	
        return new AlbumDetailsDto(name, description, String.valueOf(id));
    }
    
}
