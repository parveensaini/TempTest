package com.parveen.process;

import java.sql.Time;
import java.util.Map;

import com.parveen.resources.Person;
import com.parveen.resources.Room;


public class Meeting 
{
	public slot getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(slot timeslot) {
		this.timeslot = timeslot;
	}

	private final int ID;
	private static int counter = 0;
	private String locaton;
	private Map<Person, Boolean> attendees;
	private Room room;
	
	private slot timeslot;
	
	
	public static class slot
	{
		public Time getStartTime() {
			return startTime;
		}
		public void setStartTime(Time startTime) {
			this.startTime = startTime;
		}
		public Time getEndTime() {
			return endTime;
		}
		public void setEndTime(Time endTime) {
			this.endTime = endTime;
		}
		private Time startTime;
		private Time endTime;
		public slot(Time startTime, Time endTime) {
			super();
			this.startTime = startTime;
			this.endTime = endTime;
		}
		
		
	}

	
	public int getID() 
	{
		return ID;
	}
	
	public String getLocaton() {
		return locaton;
	}
	public void setLocaton(String locaton) {
		this.locaton = locaton;
	}
	public Map<Person, Boolean> getAttendees() {
		return attendees;
	}
	public void setAttendees(Map<Person, Boolean> attendees) {
		this.attendees = attendees;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public Meeting() {
		ID = ++counter;
	}
	
	public Meeting(String locaton, Map<Person, Boolean> attendees, Room room) {
		super();
		ID = ++counter;
		this.locaton = locaton;
		this.attendees = attendees;
		this.room = room;
	}
	
	
}
