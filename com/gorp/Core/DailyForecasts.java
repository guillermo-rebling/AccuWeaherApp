package com.gorp.Core;

public class DailyForecasts {
	
	public String Date;
	public String EpochDate;
	public Temperature Temperature;
	public Day Day;
	public Night Night;
	public String[] Sources;
	public String MobileLink;
	public String Link;
	
	
	public DailyForecasts(String date, String epochDate, Temperature Temperature, Day Day, Night Night,
			String[] sources, String mobileLink, String link) {
		super();
		Date = date;
		EpochDate = epochDate;
		this.Temperature = Temperature;
		this.Day = Day;
		this.Night = Night;
		Sources = sources;
		MobileLink = mobileLink;
		Link = link;
	}


	public String getDate() {
		return Date;
	}


	public void setDate(String date) {
		Date = date;
	}


	public String getEpochDate() {
		return EpochDate;
	}


	public void setEpochDate(String epochDate) {
		EpochDate = epochDate;
	}


	public Temperature getTemperature() {
		return Temperature;
	}


	public void setTemperature(Temperature temperature) {
		this.Temperature = temperature;
	}


	public Day getDay() {
		return Day;
	}


	public void setDay(Day day) {
		this.Day = day;
	}


	public Night getNight() {
		return Night;
	}


	public void setNight(Night night) {
		this.Night = night;
	}


	public String[] getSources() {
		return Sources;
	}


	public void setSources(String[] sources) {
		Sources = sources;
	}


	public String getMobileLink() {
		return MobileLink;
	}


	public void setMobileLink(String mobileLink) {
		MobileLink = mobileLink;
	}


	public String getLink() {
		return Link;
	}


	public void setLink(String link) {
		Link = link;
	}
	
	
	
	
}
