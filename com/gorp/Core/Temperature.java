package com.gorp.Core;

public class Temperature {
	
	public Minimum Minimum;
	public Maximum Maximum;
	
	
	public Temperature(Minimum Minimum, Maximum Maximum) {
		super();
		this.Minimum = Minimum;
		this.Maximum = Maximum;
	}


	public Minimum getMinimum() {
		return Minimum;
	}


	public void setMinimum(Minimum Minimum) {
		this.Minimum = Minimum;
	}


	public Maximum getMaximum() {
		return Maximum;
	}


	public void setMaximum(Maximum Maximum) {
		this.Maximum = Maximum;
	}
	
	

}
