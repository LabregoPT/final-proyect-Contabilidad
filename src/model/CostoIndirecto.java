package model;

public class CostoIndirecto {
	
	private String name;
	private double value;
	
	public CostoIndirecto(String n, double v) {
		name = n;
		value = v;
	}
	
	
	public String getName() {
		return name;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setValue(double value) {
		this.value = value;
	}

}
