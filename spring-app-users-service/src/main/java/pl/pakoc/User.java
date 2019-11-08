package pl.pakoc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotNull(message = "First Name can't be null")
	private String firstName;
	@NotNull(message = "Last Name can't be null")
	private String lastName;
	@NotNull(message = "Age can't be null")
	private int age;
	@NotNull(message = "Street can't be null")
	private String street;
	@NotNull(message = "Password can't be null")
	private String password;
	@NotNull(message = "Email can't be null")
	@Email
	private String email;
	
	protected User() { }
	
	public User(String firstName, String lastName, int age, String street) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.street = street;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
