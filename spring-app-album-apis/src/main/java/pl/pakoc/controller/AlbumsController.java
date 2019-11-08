
package pl.pakoc.controller;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.pakoc.dto.AlbumDto;
import pl.pakoc.service.AlbumsService;

@RestController
@RequestMapping("/users/{id}/albums")
public class AlbumsController {
    
    @Autowired
    AlbumsService albumsService;
    
    @Autowired
    ModelMapper modelMapper;
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AlbumDto> userAlbums(@PathVariable String id) {
    	
        return albumsService.getAlbums(id);
    }
}
