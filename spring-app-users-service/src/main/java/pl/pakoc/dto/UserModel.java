package pl.pakoc.dto;

import java.util.ArrayList;
import java.util.List;

import pl.pakoc.model.album.AlbumModel;

public class UserModel {
	
	private int id;
	private String firstName;
	private String lastName;
	private String street;
	private Integer age;
	private List<AlbumModel> albums = new ArrayList<>();
	
	public UserModel() { }
	
	public UserModel(String firstName, String lastName, String street, Integer age, List<AlbumModel> albums) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.age = age;
		this.albums = albums;
	}
	
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
