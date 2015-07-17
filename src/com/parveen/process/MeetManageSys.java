package com.parveen.process;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.parveen.process.Meeting.slot;
import com.parveen.resources.Attendee;
import com.parveen.resources.Inventory;
import com.parveen.resources.Person;
import com.parveen.resources.Room;


enum MeetingRoomEnum
{
	MeetingRoom,
	TrainingRoom,
	ChatRoom
}

public class MeetManageSys {
	
	private static List<Room> roomList;
	private static Map<Integer, Meeting> scheduledMeetings;
	
	public MeetManageSys() 
	{
		roomList = new ArrayList<Room>();
		scheduledMeetings = new ConcurrentHashMap<Integer, Meeting>();
	}
	
	public int AddMeeting(List<Attendee> listOfAttendees, String location, slot timeslot, MeetingRoomEnum meetroom, 
											int numOfprojectors, int numOfPhones) throws Exception
	{
		Meeting meet = new Meeting();
		
		switch (meetroom) 
		{
		case MeetingRoom: if(Inventory.getNumOfMeetingRooms() == 0)
							{
								throw new Exception("Out of meeting Room. Request can not be complete.");
							}
						else
							{
							boolean found = false;
								
								for(Map.Entry<Room, Boolean> m: Inventory.getListofMeetingRoom().entrySet())
								{
									if(!m.getValue())
									{
										if(m.getKey().getCapacity() >= listOfAttendees.size())
										{
											meet.setRoom(m.getKey());
											break;
										}

									}
										
								}
								if(!found)
								{
									throw new Exception("No room found with given capacity");
								}
							}
						break;
						
		case TrainingRoom: if(Inventory.getNumOfTrainingRooms() == 0)
		{
			throw new Exception("Out of meeting Room. Request can not be complete.");
		}
	else
		{
		boolean found = false;
			
			for(Map.Entry<Room, Boolean> m: Inventory.getListofTrainingRooms().entrySet())
			{
				if(!m.getValue())
				{
					if(m.getKey().getCapacity() >= listOfAttendees.size())
					{
						meet.setRoom(m.getKey());
						break;
					}

				}
					
			}
			if(!found)
			{
				throw new Exception("No room found with given capacity");
			}
		}
	break;
	
		case ChatRoom: if(Inventory.getNumOfChatRooms() == 0)
		{
			throw new Exception("Out of chat Room. Request can not be complete.");
		}
	else
		{
		boolean found = false;
			
			for(Map.Entry<Room, Boolean> m: Inventory.getListofChatRoom().entrySet())
			{
				if(!m.getValue())
				{
					if(m.getKey().getCapacity() >= listOfAttendees.size())
					{
						meet.setRoom(m.getKey());
						break;
					}

				}
					
			}
			if(!found)
			{
				throw new Exception("No room found with given capacity");
			}
		}
	break;

			
		default:
			break;
		}
		if(Inventory.getNumOfPhones() == 0)
		{
			throw new Exception("No phone available");
		}
		else
		{
		}
		
		Map<Person, Boolean> attendees = new HashMap<Person, Boolean>();
		
		for(Attendee a: listOfAttendees)
		{
			attendees.put(a, true);
		}
		
		meet.setAttendees(attendees);
		
		scheduledMeetings.put(meet.getID(), meet);
		
		return meet.getID();
	}
	
	public boolean deleteMeeting(int id)
	{
		return true;
	}
	
	public boolean updateMeeting()
	{
		return true;
	}

	public static void main(String[] args) throws Exception {
		
		MeetManageSys mms = new MeetManageSys();
		
		List<Attendee> listOfAttendees = new ArrayList<Attendee>();
		
		listOfAttendees.add(new Attendee("X", 25, "bangalore", "EMP1"));
		listOfAttendees.add(new Attendee("Y", 25, "bangalore", "EMP1"));
		
		Meeting.slot timeslot = new slot(new Time(10),new Time(11));
		
		int meetid = mms.AddMeeting(listOfAttendees, "bangalore", timeslot, MeetingRoomEnum.MeetingRoom, 5, 5);

	}

}
