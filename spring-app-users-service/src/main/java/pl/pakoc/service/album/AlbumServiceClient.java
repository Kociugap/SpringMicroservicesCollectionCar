package pl.pakoc.service.album;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pl.pakoc.model.album.AlbumModel;

@FeignClient(name="album-api", fallback=AlbumFallback.class)
public interface AlbumServiceClient {

	@GetMapping("/users/{id}/albums")
	List<AlbumModel> getAlbums(@PathVariable("id") Integer id);
	
}
