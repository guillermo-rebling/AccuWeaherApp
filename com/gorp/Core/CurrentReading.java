package com.gorp.Core;

public class CurrentReading {
	
	public String LocalObservationTime;
	public String EpochTime;
	public String WeatherText;
	public String Weathericon;
	public String HasPrecipitation;
	public String PrecipitationType;
	public com.gorp.Core.Utils.Temperature Temperature;
	public String MobileLink;
	public String Link;
	
	public CurrentReading(String LocalObservationTime, String EpochTime, String WeatherText, String Weathericon, String HasPrecipitation, String PrecipitationType, com.gorp.Core.Utils.Temperature Temperature, String MobileLink, String Link) {
		this.LocalObservationTime = LocalObservationTime;
		this.EpochTime = EpochTime;
		this.WeatherText = WeatherText;
		this.Weathericon = Weathericon;
		this.HasPrecipitation = HasPrecipitation;
		this.PrecipitationType = PrecipitationType;
		this.Temperature = Temperature;
		this.MobileLink = MobileLink;
		this.Link = Link;
	}
	
	@Override
	public String toString() {
		return "CurrentReading [LocalObservationTime=" + LocalObservationTime + ", EpochTime=" + EpochTime
				+ ", WeatherText=" + WeatherText + ", Weathericon=" + Weathericon + "HasPrecipitation=" + HasPrecipitation
				+ "PrecipitationType=" + PrecipitationType 
				+ "temperature metric value=" 
				+ Temperature
				+ "temperature imperial value=" + Temperature.Imperial.Value + "MobileLink=" + MobileLink
				+ "Link=" + Link
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
