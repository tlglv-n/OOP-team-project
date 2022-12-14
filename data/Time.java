package data;

import java.util.Objects;

public class Time
{
	private int start;
	private int duration;

	public Time(){
		super();
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int hashCode() {
		return Objects.hash(duration, start);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return duration == other.duration && start == other.start;
	}

	public String toString() {
		return "Time [start=" + start + ", duration=" + duration + "]";
	}
	
}

