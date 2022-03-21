package com.palla.data;

public class HelloWorldBean {

	private String name;

	public HelloWorldBean(String name) {
		super();
		this.name = name;
	}

	//If we don't have getter then white label error will come while generating response for bean
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [name=" + name + "]";
	}
	
	
}
