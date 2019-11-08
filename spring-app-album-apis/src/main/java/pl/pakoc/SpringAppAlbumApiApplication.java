package pl.pakoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringAppAlbumApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAppAlbumApiApplication.class, args);
	}

}

