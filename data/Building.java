package data;

import java.io.Serializable;
import java.util.Objects;

public class Building implements Serializable{	

	private static final long serialVersionUID = 1L;
	private String name;
	private String address;
	private int capacity;

	public Building(){}

	public Building(String address){
		setAddress(address);
	}

	public Building(String address, int capacity){
		this(address);
		setCapacity(capacity);
	}

	public Building(String name, String address, int capacity){
		this(address, capacity);
		setName(name);
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public int getCapacity() {
		return capacity;
	}

	public boolean equals(Object o) {
		if(o == null) {return false;}
		if(this == o) {return true;}
		if(this.getClass() != o.getClass()) {return false;}
		Building b = (Building) o;
		return this.name.equals(b.name) && this.address.equals(b.address)
				&& this.capacity == b.capacity;
	}

	public int hashCode() {
		return Objects.hash(name, address, capacity);	
	}

	public String toString() {
		return "Building's name: " + name + ", address: " + address
				+ ", capacity: " + capacity;
	}
	
	public int compareTo(Building b) {
		if(capacity > b.capacity) {return 1;}
		if(capacity < b.capacity) {return -1;}
		return 0;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public void setCapacity(int capacity){
		this.capacity = capacity;
	}
}

