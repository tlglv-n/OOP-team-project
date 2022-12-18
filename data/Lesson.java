package data;

import java.io.Serializable;
import java.time.DayOfWeek;

public class Lesson implements Serializable{
    
	private static final long serialVersionUID = 1L;
	private Course course;
    private Room room;
    private DayOfWeek day;
    private Time time;

    protected Lesson(){}

    public Lesson(Course course, Room room, DayOfWeek day, Time time){
        this.course = course;
        setRoom(room);
        setDay(day);
        setTime(time);
    }

    public void setRoom(Room room){
        this.room = room;
    }

    public void setDay(DayOfWeek day){
        this.day = day;
    }

    public void setTime(Time time){
        this.time = time;
    }

    public Course getCourse(){
        return course;
    }

    public DayOfWeek getDay(){
        return day;
    }

    public Room getRoom(){
        return room;
    }

    public Time getTime(){
        return time;
    }
}
