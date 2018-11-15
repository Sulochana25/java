package com.ggktech.FormFill;

import org.springframework.web.multipart.MultipartFile;

public class User {
	private String name;
	private String email;
	private String phone;
	private String gender;
	private String country;

	private String address;
	private String [] languages;
	private MultipartFile photo;
	private MultipartFile resume;
	private String password;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String[] getLanguages() {
		return languages;
	}
	public void setLanguages(String[] languages) {
		this.languages = languages;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	public MultipartFile getResume() {
		return resume;
	}
	public void setResume(MultipartFile resume) {
		this.resume = resume;
	}
	public String getResumeName(){
		return  getResume().getOriginalFilename();
	}
	public String getPhotoName(){
		return getPhoto().getOriginalFilename();
	}
}
