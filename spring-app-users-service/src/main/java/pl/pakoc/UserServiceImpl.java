package pl.pakoc;

import java.util.ArrayList;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	private ModelMapper modelMapper;

	private BCryptPasswordEncoder bCryptPasswordEncoder;	
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public void createUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = userRepository.findByEmail(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return new org.springframework.security.core.userdetails.User
				(user.getEmail(), user.getPassword(), true, true, true, true, new ArrayList<>()); 
	}

	@Override
	public UserDto getUserDetailsByEmail(String email) {
		User user = userRepository.findByEmail(email);
		
		if(user == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserModel getUserById(Integer userId) {
		
		Optional<User> user = userRepository.findById(userId);
		
		if(user.get() == null) {
			throw new UsernameNotFoundException(userId.toString());
		}
		
		return modelMapper.map(user.get(), UserModel.class);
		
	}

}
 