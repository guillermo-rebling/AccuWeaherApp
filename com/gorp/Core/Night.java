package com.gorp.Core;

public class Night {
	
	public String Icon;
	public String IconPhrase;
	public String HasPrecipitation;

	public Night(String icon, String iconPhrase, String hasPrecipitation) {
		super();
		Icon = icon;
		IconPhrase = iconPhrase;
		HasPrecipitation = hasPrecipitation;
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
	
	
}
