package com.callor.hello.models;

public class UserDto {
	
	private String username;
	private String password;
	private String name;
	private String email;
	private String tel;
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(String username, String password, String name, String email, String tel) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.tel = tel;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "UserDto [username=" + username + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", tel=" + tel + "]";
	}
	
	

}
