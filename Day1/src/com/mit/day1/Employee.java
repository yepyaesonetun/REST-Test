package com.mit.day1;

public class Employee {
	String id;
	String name;
	double salary;

	public Employee(String id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void print(String id, String name, double salary) {
		System.out.println("ID:\t" + id + "\nName:\t" + name + "\nSalary: " + salary);
		System.out.println();
	}

}
