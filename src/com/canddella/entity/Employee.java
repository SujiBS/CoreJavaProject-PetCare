package com.canddella.entity;

public class Employee {

	private int employee_id;
	private String employee_name ;
	private int experience ;
	private String work_category;
	public Employee(int employee_id, String employee_name, int experience, String work_category) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.experience = experience;
		this.work_category = work_category;
	}
	public Employee(String employee_name, int experience, String work_category) {
		super();
		
		this.employee_name = employee_name;
		this.experience = experience;
		this.work_category = work_category;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getWork_category() {
		return work_category;
	}
	public void setWork_category(String work_category) {
		this.work_category = work_category;
	}
	
	
}
