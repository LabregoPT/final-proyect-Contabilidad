package model;

/**
 * Class that represents all of the orders in the system.
 */
public class Orden {

	/**The number of the order*/
	private int OrderNumber;
	
	/**The quantity of Direct Material used in this order.*/
	private double MD;
	
	/**The quantity of Direct Hand Work used in this order.*/
	private double MOD;
	
	/**The real base used by this organization.*/
	private double realBase;
	
	/**The quantity of indirect fabrication costs of this order.*/
	private double CiF;

	/**Order constructor. Registers a new order in the system with the given values*/
	public Orden(int order, double md, double mod, double rb) {
		OrderNumber = order;
		MD = md;
		MOD = mod;
		realBase = rb;
		CiF = 0.0;
	}

	/**Returns the quantity of Direct Material used in this order.*/
	public double getMD() {
		return MD;
	}

	/**Returns the quantity of Direct Hand Work used in this order.*/
	public double getMOD() {
		return MOD;
	}

	/**Returns the number of this order.*/
	public int getOrderNumber() {
		return OrderNumber;
	}

	/**Returns the quantity of CIF used in this order.*/
	public double getCIF() {
		return CiF;
	}
	
	/**Sets the CIF of this order given the CIF rate used by the organization.*/
	public void setCif(double percentage) {
		CiF = (percentage/100)*realBase;
	}

}
