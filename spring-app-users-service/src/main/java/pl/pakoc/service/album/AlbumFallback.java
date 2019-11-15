package pl.pakoc.service.album;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.pakoc.model.album.AlbumModel;

@Component
public class AlbumFallback implements AlbumServiceClient {

	@Override
	public List<AlbumModel> getAlbums(Integer id) {
		return new ArrayList<>();
	}
	
}
