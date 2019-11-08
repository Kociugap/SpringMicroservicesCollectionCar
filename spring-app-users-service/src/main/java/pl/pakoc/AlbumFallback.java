package pl.pakoc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AlbumFallback implements AlbumServiceClient {

	@Override
	public List<AlbumModel> getAlbums(Integer id) {
		return new ArrayList<>();
	}
	
}
