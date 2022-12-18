package data;

import java.io.Serializable;
import java.util.Vector;

public final class Schedule implements Serializable{

	private static Schedule instance;
	private Vector <Lesson> lessons;

	public Schedule(){
		super();
	}

	public static Schedule getInstance(){
		return instance;
	}

	public Vector <Lesson> getLessons(){
		return lessons;
	}

}

