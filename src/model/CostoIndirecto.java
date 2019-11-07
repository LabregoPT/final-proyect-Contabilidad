package model;

/**Represents all of the indirect costs of the organization.*/
public class CostoIndirecto {
	
	/**The name of this indirect cost.*/
	private String name;
	
	/**The value of this indirect cost.*/
	private double value;
	
	/**Constructor method. Initializes a new instance of this class with the given information.*/
	public CostoIndirecto(String n, double v) {
		name = n;
		value = v;
	}
	
	/**Returns the name of this Indirect Cost.*/
	public String getName() {
		return name;
	}
	
	/**Returns the value of this Indirect Cost.*/
	public double getValue() {
		return value;
	}
}
