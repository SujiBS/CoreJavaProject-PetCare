package com.canddella.entity;

public class Pet {
	
	private int petId;
	private Customer customer; //HAS A 
	private Pet_Category petCategory; //HAS A 
	private String petName;
	private int age;
	private String colour;
	private String gender;
	private String breed;
	private String vaccination;
	private double weight;
	private double height;
	private String disabilities;
	
	
	public Pet() {
		super();
	}
	
	public Pet(int petId, Customer customer, Pet_Category petCategory, String petName, int age, String colour,
			String gender, String breed, String vaccination, double weight, double height, String disabilities) {
		super();
		this.petId = petId;
		this.customer = customer;
		this.petCategory = petCategory;
		this.petName = petName;
		this.age = age;
		this.colour = colour;
		this.gender = gender;
		this.breed = breed;
		this.vaccination = vaccination;
		this.weight = weight;
		this.height = height;
		this.disabilities = disabilities;
	}
	
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Pet_Category getPetCategory() {
		return petCategory;
	}
	public void setPetCategory(Pet_Category petCategory) {
		this.petCategory = petCategory;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getVaccination() {
		return vaccination;
	}
	public void setVaccination(String vaccination) {
		this.vaccination = vaccination;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String getDisabilities() {
		return disabilities;
	}
	public void setDisabilities(String disabilities) {
		this.disabilities = disabilities;
	}
	
	
	

}
