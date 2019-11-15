package pl.pakoc.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import pl.pakoc.dto.UserDto;
import pl.pakoc.dto.UserModel;

public interface UserService extends UserDetailsService {
	
	void createUser(UserDto user);
	
	UserDetails loadUserByUsername(String username);
	
	UserDto getUserDetailsByEmail(String email);
	
	UserModel getUserById(Integer userId);

}
