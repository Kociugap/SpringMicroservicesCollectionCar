package pl.pakoc;

import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import feign.Logger;

@Configuration
public class Config {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
	
	public FeignErrorDecoder feignErrorDecoder() {
		return new FeignErrorDecoder();
	}

}
