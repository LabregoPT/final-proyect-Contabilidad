package model;

import java.io.Serializable;
import java.util.*;

/**
 * Class that will represent the organization who will use this program.
 * 
 * @version 1.0 - 10/2019
 */
public class Organization implements Serializable {

	private static final long serialVersionUID = 1L;

	/** The indirect costs already added. */
	private ArrayList<CostoIndirecto> cis;

	/** The orders already added. */
	private ArrayList<Orden> orders;

	/** The name of the real base. */
	private String realBaseName;
	
	/** The affectation percentage. */
	private String percentage;
	
	
	/**
	 * Constructor method.
	 */
	public Organization() {
		cis = new ArrayList<>();
		orders = new ArrayList<>();
	}

	/**
	 * Registers a new CostoIndirecto in the system.
	 * 
	 * @param c The CostoIndirecto to be registered.
	 */
	public void registerIFC(CostoIndirecto c) {
		cis.add(c);
	}

	/**
	 * Returns a String representation with all of the CIS already added.
	 * 
	 * @return a String with the information of all of the CIS already added in the
	 *         program.
	 */
	public String getCIS() {
		if (!cis.isEmpty()) {
			String ret = "Numero - Nombre - Valor";
			for (int i = 0; i < cis.size(); i++) {
				ret += (i + 1) + " - " + cis.get(i).getName() + " - " + cis.get(i).getValue() + "\n";
			}
			return ret;
		} else {
			return "No se han añadido CIF todavía";
		}
	}

	public int getCISSize() {
		return cis.size();
	}

	public void deleteCIF(int ind) {
		cis.remove(ind);
	}

	public void registerOrder(Orden o) {
		orders.add(o);
	}

	/**
	 * Searches for an order with a given number, and returns either true or false
	 * if the order could be found.
	 * 
	 * @param number The number of the order to be searched.
	 * @return True if the order was found, false otherwise.
	 */
	public boolean searchNumberOrder(int number) {

		for (int c = 0; c < orders.size(); c++) {
			if (number == orders.get(c).getOrderNumber()) {
				return true;
			}
		}
		return false;
	}
}
