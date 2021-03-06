package com.gorp.Core;

public class ForecastReading {
	

	public Headline Headline;
	public DailyForecasts[] DailyForecasts;


	public ForecastReading(Headline Headline, DailyForecasts[] dailyForecasts) {
		this.Headline = Headline;
		this.DailyForecasts = dailyForecasts;
	}



	public Headline getHeadline() {
		return Headline;
	}


	public void setHeadline(Headline Headline) {
		this.Headline = Headline;
	}


	public DailyForecasts[] getDailyForecasts() {
		return DailyForecasts;
	}


	public void setDailyForecasts(DailyForecasts[] dailyForecasts) {
		this.DailyForecasts = dailyForecasts;
	}


	@Override
	public String toString() {
		return "ForecastReading [Headline=" + Headline + ", dailyForecasts=" + DailyForecasts
				+ ", getHeadline()=" + getHeadline() + ", getDailyForecasts()=" + getDailyForecasts()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
}
