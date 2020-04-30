package com.gorp.Core.Utils;

import com.gorp.Core.Imperial;
import com.gorp.Core.Metric;

public class Temperature {
	
	public Metric Metric;
	public Imperial Imperial;
	
	public Temperature(Metric Metric, Imperial Imperial) {
		this.Metric = Metric;
		this.Imperial = Imperial;
	}

}
