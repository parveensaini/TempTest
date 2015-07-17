package com.parveen.resources;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory 
{

	public static String[] getLocations() {
		return locations;
	}

	public static void setLocations(String[] locations) {
		Inventory.locations = locations;
	}

	public static String[] getRoomnames() {
		return roomnames;
	}

	public static void setRoomnames(String[] roomnames) {
		Inventory.roomnames = roomnames;
	}

	public static Map<Room, Boolean> getListofMeetingRoom() {
		return listofMeetingRoom;
	}

	public static void setListofMeetingRoom(Map<Room, Boolean> listofMeetingRoom) {
		Inventory.listofMeetingRoom = listofMeetingRoom;
	}

	public static Map<Room, Boolean> getListofChatRoom() {
		return listofChatRoom;
	}

	public static void setListofChatRoom(Map<Room, Boolean> listofChatRoom) {
		Inventory.listofChatRoom = listofChatRoom;
	}

	public static Map<Room, Boolean> getListofTrainingRooms() {
		return listofTrainingRooms;
	}

	public static void setListofTrainingRooms(Map<Room, Boolean> listofTrainingRooms) {
		Inventory.listofTrainingRooms = listofTrainingRooms;
	}
	private static int NumOfMeetingRooms = 10;
	private static int NumOfTrainingRooms = 10;
	private static int NumOfChatRooms = 10;
	private static int NumOfPhones = 10;
	private static int NumOfProjectors = 10;
	
	private static String[] locations = {"Bangalore", "Pune", "Mumbai"};
	private static String[] roomnames = {"PACMAN", "ROADRUNNER", "BOMBERMAN"};
	private static Random rand = new Random(37);
	
	private static Map<Room, Boolean> listofMeetingRoom = new ConcurrentHashMap<Room, Boolean>();
	private static Map<Room, Boolean> listofChatRoom = new ConcurrentHashMap<Room, Boolean>();
	private static Map<Room, Boolean> listofTrainingRooms = new ConcurrentHashMap<Room, Boolean>();
	
	static
	{
		loadinventory();
	}
	
	public static void loadinventory()
	{
		
		for(int i=0; i<NumOfMeetingRooms; ++i)
		{
			Room meet = new MeetingRoom(roomnames[rand.nextInt(3)], rand.nextInt(10), locations[rand.nextInt(3)]);
			listofMeetingRoom.put(meet, false);
		}
		
		for(int i=0; i<NumOfChatRooms; ++i)
		{
			Room chat = new ChatRoom(roomnames[rand.nextInt(3)], rand.nextInt(10), locations[rand.nextInt(3)]);
			listofChatRoom.put(chat, false);
		}
		
		for(int i=0; i<NumOfMeetingRooms; ++i)
		{
			Room train = new MeetingRoom(roomnames[rand.nextInt(3)], rand.nextInt(10), locations[rand.nextInt(3)]);
			listofTrainingRooms.put(train, false);
		}
	}
	
	public static int getNumOfMeetingRooms() {
		return NumOfMeetingRooms;
	}
	public static void setNumOfMeetingRooms(int numOfMeetingRooms) {
		NumOfMeetingRooms = numOfMeetingRooms;
	}
	public static int getNumOfTrainingRooms() {
		return NumOfTrainingRooms;
	}
	public static void setNumOfTrainingRooms(int numOfTrainingRooms) {
		NumOfTrainingRooms = numOfTrainingRooms;
	}
	public static int getNumOfChatRooms() {
		return NumOfChatRooms;
	}
	public static void setNumOfChatRooms(int numOfChatRooms) {
		NumOfChatRooms = numOfChatRooms;
	}

	public static int getNumOfPhones() {
		return NumOfPhones;
	}
	public static void setNumOfPhones(int numOfPhones) {
		NumOfPhones = numOfPhones;
	}
	public static int getNumOfProjectors() {
		return NumOfProjectors;
	}
	public static void setNumOfProjectors(int numOfProjectors) {
		NumOfProjectors = numOfProjectors;
	}
}
