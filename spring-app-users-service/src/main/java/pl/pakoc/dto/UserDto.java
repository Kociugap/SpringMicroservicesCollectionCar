package pl.pakoc.dto;

import java.util.ArrayList;
import java.util.List;

import pl.pakoc.model.album.AlbumModel;

public class UserDto {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private int age;
	private String street;
	private String password;
	private String email;
	private List<AlbumModel> albums = new ArrayList<>();
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<AlbumModel> getAlbums() {
		return albums;
	}
	public void setAlbums(List<AlbumModel> albums) {
		this.albums = albums;
	}
	
	
	
}
