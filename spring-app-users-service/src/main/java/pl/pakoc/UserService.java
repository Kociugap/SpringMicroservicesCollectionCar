package pl.pakoc;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	
	void createUser(UserDto user);
	
	UserDetails loadUserByUsername(String username);
	
	UserDto getUserDetailsByEmail(String email);
	
	UserModel getUserById(Integer userId);

}
