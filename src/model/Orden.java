package model;

public class Orden {

	private int OrderNumber;
	private double MD;
	private double MOD;
	private double realBase;
	private double CiF;

	public Orden(int order, double md, double mod, double rb) {
		OrderNumber = order;
		MD = md;
		MOD = mod;
		realBase = rb;
		CiF = 0.0;
	}

	public double getMD() {
		return MD;
	}

	public double getMOD() {
		return MOD;
	}

	public int getOrderNumber() {
		return OrderNumber;
	}

	public void setMD(double mD) {
		MD = mD;
	}

	public void setMOD(double mOD) {
		MOD = mOD;
	}

	public void setOrderNumber(int orderNumber) {
		OrderNumber = orderNumber;
	}

}
