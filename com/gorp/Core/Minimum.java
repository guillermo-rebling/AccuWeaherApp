package com.gorp.Core;

public class Minimum {
	
	public String Value;
	public String Unit;
	public String UnitType;
	
	
	public Minimum(String value, String unit, String unitType) {
		super();
		Value = value;
		Unit = unit;
		UnitType = unitType;
	}


	public String getValue() {
		return Value;
	}


	public void setValue(String value) {
		Value = value;
	}


	public String getUnit() {
		return Unit;
	}


	public void setUnit(String unit) {
		Unit = unit;
	}


	public String getUnitType() {
		return UnitType;
	}


	public void setUnitType(String unitType) {
		UnitType = unitType;
	}
	
	

}
