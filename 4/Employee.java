package com.pratham.hibernate;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {
	@Id
	@Column(name = "EID")
	private int id;
	@Column(name = "ENAME")
	private String name;
	@Column(name = "ESALARY")
	private int salary;
	
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee[Id = " + id + ", Name = " + name + ", Salary = " + salary + "]";
	}
}
