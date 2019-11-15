package pl.pakoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringAppDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAppDiscoveryServiceApplication.class, args);
	}

}
