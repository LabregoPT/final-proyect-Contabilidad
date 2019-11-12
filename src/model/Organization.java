package model;

import java.io.Serializable;
import java.util.*;

import exceptions.NoDataException;

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

	/** The affectation rate. */
	private double percentage;
	
	/** the accounting period*/
	
	private String period;

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
			return "No se han a�adido CIF todav�a";
		}
	}

	/** Returns the number of Indirect costs already registered in the program. */
	public int getCISSize() {
		return cis.size();
	}

	/** Given the number of an IC already registered in the program, deletes it. */
	public void deleteCIF(int ind) {
		cis.remove(ind);
	}

	/** Registers a new order in the Organization */
	public void registerOrder(Orden o) {
		o.setCif(percentage);
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

	/** Registers a the CIF rate to be used in this program. */
	public void registerRate(String n, double p) {
		realBaseName = n;
		percentage = p;
	}

	/**
	 * Returns the name of the applied real base name. Defaults to "Base Real
	 * Aplicada".
	 * 
	 * @return Either the name of the applied real base name, or the default value.
	 */
	public String getRealBaseName() {
		if (realBaseName == null) {
			return "Base Real Aplicada";
		} else {
			return realBaseName;
		}
	}

	/**
	 * Computes the different CIF registered in the program.
	 */
	public String calculateCIF() throws NoDataException {
		// First sets all of the totals to 0.
		double totalMod = 0.0;
		double totalMD = 0.0;
		double totalCIF = 0.0;
		// Adds all of the totals already registered.
		String out2 = "";

		for (Orden o : orders) {
			totalMod += o.getMOD();
			totalMD += o.getMD();
			totalCIF += o.getCIF();
			out2 += "Numero de Orden : " + o.getOrderNumber() + "\n" + "Material Directo : " + o.getMOD() + "\n"
					+ "Mano de Obra Directa : " + o.getMOD() + "\n" + "CIFS Aplicables :  " + o.getCIF() + "\n"
					+ "-------------------------------------------------\n";
		}

		// Create output String with totals calculated.
		if (totalMod == 0.0 && totalMD == 0.0 && totalCIF == 0.0) {
			throw new NoDataException();
		}
		String out =  "Se han registrado " + orders.size() + " �rdenes.";
		out += "\nSus costos sumados son:";
		out += "\n En Mano de Obra Directa: " + totalMod;
		out += "\n En Materiales Directos: " + totalMD;
		out += "\n En Costos Indirectos de Fabricaci�n: " + totalCIF;

		out += "\n\nSe registraron " + cis.size() + " otros costos.";

		// Sets the ICs to 0.
		double otherCI = 0.0;
		for (CostoIndirecto c : cis) {
			otherCI += c.getValue();
			out += "\n En " + c.getName() + ": " + c.getValue();
		}
		out += "\n Para un total de " + otherCI + " en otros costos,";

		out += "\n\nEn total, los costos de producci�n suman " + (totalMod + totalMD + totalCIF + otherCI);
		String totalOut =   "Periodo contable : " + period + "\n" +"\n" + out2 + "\n" + "_______________________________________________" + "\n" + out;
		return totalOut;
	}
	
	public String getPeriod() {
		return period;
	}
	
	public void setPeriod(String period) {
		this.period = period;
	}
}
