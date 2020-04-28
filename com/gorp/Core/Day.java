package com.gorp.Core;

public class Day {
	
	public String Icon;
	public String IconPhrase;
	public String HasPrecipitation;
	public String PrecipitationType;
	public String PrecipitationIntensity;
	
	
	public Day(String icon, String iconPhrase, String hasPrecipitation, String precipitationType,
			String precipitationIntensity) {
		super();
		Icon = icon;
		IconPhrase = iconPhrase;
		HasPrecipitation = hasPrecipitation;
		PrecipitationType = precipitationType;
		PrecipitationIntensity = precipitationIntensity;
	}


	public String getIcon() {
		return Icon;
	}


	public void setIcon(String icon) {
		Icon = icon;
	}


	public String getIconPhrase() {
		return IconPhrase;
	}


	public void setIconPhrase(String iconPhrase) {
		IconPhrase = iconPhrase;
	}


	public String getHasPrecipitation() {
		return HasPrecipitation;
	}


	public void setHasPrecipitation(String hasPrecipitation) {
		HasPrecipitation = hasPrecipitation;
	}


	public String getPrecipitationType() {
		return PrecipitationType;
	}


	public void setPrecipitationType(String precipitationType) {
		PrecipitationType = precipitationType;
	}


	public String getPrecipitationIntensity() {
		return PrecipitationIntensity;
	}


	public void setPrecipitationIntensity(String precipitationIntensity) {
		PrecipitationIntensity = precipitationIntensity;
	}
	
	

}
