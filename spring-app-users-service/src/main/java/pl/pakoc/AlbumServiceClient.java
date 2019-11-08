package pl.pakoc;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="albums-ws", fallback=AlbumFallback.class)
public interface AlbumServiceClient {

	@GetMapping("/users/{id}/albums")
	List<AlbumModel> getAlbums(@PathVariable("id") Integer id);
	
}
