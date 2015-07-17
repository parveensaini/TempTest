package com.parveen.resources;

public class Room {
	
	private String name;
	private int capacity;
	private String location;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Room(String name, int capacity, String location) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.location = location;
	}

	
	

}
