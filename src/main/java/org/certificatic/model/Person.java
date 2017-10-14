package org.certificatic.model;

import java.util.ArrayList;

public class Person{

    private long id;
    private String name;
    private int age;
    private String city;
    private String gender;
    private String job;
    private ArrayList<String> books;

    public Person(){}

    public Person(long id, String name, int age, String city, String gender, String job, ArrayList<String> books){
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.gender = gender;
        this.job = job;
        this.books = books;
    }

	public long getId() {
		return id;
	}

    public void setId(long id) {
		this.id = id;
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

    public String getGender() {
		return gender;
	}

    public void setGender(String gender) {
		this.gender = gender;
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
        return new StringBuilder()
            .append("Person{")
            .append("id:").append(id)
            .append(", name:").append(name)
            .append(", age:").append(age)
            .append(", city:").append(city)
            .append(", gender:").append(gender)
            .append(", job:").append(job)
            .append(", books:").append(books)
            .append("}").toString();
    }

}