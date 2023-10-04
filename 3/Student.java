package com.pratham.hibernate;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@Column(name = "Id")
	private int id;
	
	@Column(name = "Branch")
	private String branch;
	
	@Column(name = "Name")
	private String name;
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
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Student[Id = " + id + ", Name = " + name + ", Branch = " + branch + "]";
	}
	
}
