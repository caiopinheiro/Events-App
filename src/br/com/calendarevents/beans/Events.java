package br.com.calendarevents.beans;

import java.util.ArrayList;

public class Events {
	
	private int nEvents;
	private String tag;
	private String nameEvent;
	private ArrayList<String> durations = new ArrayList<String>();
	private ArrayList<String> dates = new ArrayList<String>();
	
	public int getnEvents() {
		return nEvents;
	}
	public void setnEvents(int nEvents) {
		this.nEvents = nEvents;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getNameEvent() {
		return nameEvent;
	}
	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}
	public ArrayList<String> getDurations() {
		return durations;
	}
	public void setDurations(ArrayList<String> durations) {
		this.durations = durations;
	}
	public ArrayList<String> getDates() {
		return dates;
	}
	public void setDates(ArrayList<String> dates) {
		this.dates = dates;
	}
	
	

}
