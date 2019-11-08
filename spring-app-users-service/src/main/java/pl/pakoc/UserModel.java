package pl.pakoc;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
	
	private int id;
	private String firstName;
	private String lastName;
	private String street;
	private Integer age;
	private List<AlbumModel> albums = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public List<AlbumModel> getAlbums() {
		return albums;
	}
	public void setAlbums(List<AlbumModel> albums) {
		this.albums = albums;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

}
