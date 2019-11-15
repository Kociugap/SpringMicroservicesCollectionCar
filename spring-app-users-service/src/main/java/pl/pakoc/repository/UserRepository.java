package pl.pakoc.repository;

import org.springframework.data.repository.CrudRepository;

import pl.pakoc.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByEmail(String email);

}
