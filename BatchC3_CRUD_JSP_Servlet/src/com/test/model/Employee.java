package com.test.model;

public class Employee {
	
	private int id;
	private String  name;
	private String designation;
	private float salary;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	public Employee(int id) {
		super();
		this.id = id;
	}
	public Employee(String name, String designation, float salary) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	public Employee(int id, String name, String designation, float salary) {
		
		this(name,designation,salary);
		this.id = id;
		
	}
	
	
	
	
	
	
	
	

}
