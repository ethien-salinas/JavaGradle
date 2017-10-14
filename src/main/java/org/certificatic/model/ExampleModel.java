package org.certificatic.model;

public class ExampleModel {
	private String name;

	public void setName(String s){
		name = s;
	}
	public String getName(){
		return name;
	}
	public int getNameLength(){
		return name.length();
	}
}