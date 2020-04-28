package com.gorp.Core;

public class Headline {
	

	public String EffectiveDate;
	public String EffectiveEpochDate;
	public String Severity;
	public String Text;
	public String Category;
	public String EndDate;
	public String EndEpochDate;
	public String MobileLink;
	public String Link;
	
	public Headline(String EffectiveDate,String EffectiveEpochDate, String Severity, String Text, String Category,  String EndDate, String EndEpochDate, String MobileLink, String Link ) {
		this.EffectiveDate = EffectiveDate;
		this.EffectiveEpochDate = EffectiveEpochDate;
		this.Severity = Severity;
		this.Text = Text;
		this.Category = Category;
		this.EndDate = EndDate;
		this.EndEpochDate = EndEpochDate;
		this.MobileLink = MobileLink;
		this.Link = Link;
	}

	public String getEffectiveDate() {
		return EffectiveDate;
	}
	
	public void setEffectiveDate(String effectiveDate) {
		EffectiveDate = effectiveDate;
	}
	
	public String getEffectiveEpochDate() {
		return EffectiveEpochDate;
	}
	
	public void setEffectiveEpochDate(String effectiveEpochDate) {
		EffectiveEpochDate = effectiveEpochDate;
	}
	
	public String getSeverity() {
		return Severity;
	}
	
	public void setSeverity(String severity) {
		Severity = severity;
	}
	
	public String getText() {
		return Text;
	}
	
	public void setText(String text) {
		Text = text;
	}
	
	public String getCategory() {
		return Category;
	}
	
	public void setCategory(String category) {
		Category = category;
	}
	
	public String getEndDate() {
		return EndDate;
	}
	
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	
	public String getEndEpochDate() {
		return EndEpochDate;
	}
	
	public void setEndEpochDate(String endEpochDate) {
		EndEpochDate = endEpochDate;
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
