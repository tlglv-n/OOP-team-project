package data;

import java.util.Objects;

public class Room
{

	private Building building;

	private int number;

	public Room(){
		super();
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	public int hashCode() {
		return Objects.hash(building, number);
	}
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Room other = (Room) obj;
		return Objects.equals(building, other.building) && number == other.number;
	}
	

}

