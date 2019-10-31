package model;

import java.util.*;

/**
 * Class that will represent the organization who will use this program.
 * @version 1.0 - 10/2019
 */
public class Organization {
	
	/**The indirect costs already added.*/
	private ArrayList<CostoIndirecto> cis;
	
	/**The orders already added.*/
	private ArrayList<Orden> orders;
	
	/**
	 * Constructor method.
	 */
	public Organization() {
		cis = new ArrayList<>();
		orders = new ArrayList<>();
	}
	
	/**
	 * Registers a new CostoIndirecto in the system.
	 * @param c The CostoIndirecto to be registered.
	 */
	public void registerIFC(CostoIndirecto c) {
		cis.add(c);
	}
}
