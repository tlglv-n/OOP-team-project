package data;

import java.util.Objects;

public class Building
{	
	private String name;
	private String address;
	private int capacity;

	public Building(){
		super();
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
}

