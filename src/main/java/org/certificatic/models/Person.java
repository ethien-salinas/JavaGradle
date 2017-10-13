package org.certificatic.models;

import java.util.ArrayList;

public class Person{
	
	private String name;
	private int age;
	private String city;
	private String job;
	private ArrayList<String> books;

	public Person(){}

	public Person(String name, int age, String city, String job, ArrayList<String> books){
		this.name = name;
		this.age = age;
		this.city = city;
		this.job = job;
		this.books = books;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public ArrayList<String> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<String> books) {
		this.books = books;
	}

	public String toString(){
		return
			new StringBuilder()
			.append("Person{")
			.append("name:").append(name)
			.append(", age:").append(age)
			.append(", city:").append(city)
			.append(", job:").append(job)
			.append(", books:").append(books)
			.append("}")
			.toString();
	}

}