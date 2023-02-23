package com.canddella.entity;

public class Pet_Category {

	private int categoryId;
	private String categoryName;
	
	public Pet_Category(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	public Pet_Category() {
		// TODO Auto-generated constructor stub
	}
	public Pet_Category(String categoryName) {
		super();
		
		this.categoryName = categoryName;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
