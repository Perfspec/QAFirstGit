package com.qa.InfiniteTerrain;

import java.util.Random;

public class TwoD {
	private double i;
	private double j;
	
	TwoD(int far) {
		Random k = new Random();
		boolean m = k.nextBoolean();
		boolean m2 = k.nextBoolean();
		double d = k.nextDouble()*far;
		double d2 = k.nextDouble()*far;
		if(m) {
			d*=-1;
		}
		if(m2) {
			d2*=-1;
		}
		i = d;
		j = d2;
	}
	
	TwoD(double a, double b) {
		i = a;
		j = b;
	}
	
	public double get(int g) {
		if(g==0) {
			return i;
		} else {
			return j;
		}
		
	}
	
	public void set(double a, double b) {
		i = a;
		j = b;
	}
	
	public void set(TwoD a) {
		i = a.get(0);
		j = a.get(1);
	}
	
	public void update(TwoD a) {
		i -= a.get(0);
		j -= a.get(1);
	}
	
	public double dist() {
		double u = i*i+j*j;
		return Math.sqrt(u);
	}

}
