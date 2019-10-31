package UserInterface;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;
import model.CostoIndirecto;
import model.Orden;

public class CostosController {
	
	/**TextField to input the number of this order.*/ 
	@FXML
	    private TextField OrderNumTF;
	 
	/**Button to add an order in the system.*/
	@FXML
	    private Button AddOrderBt;
    
	/**TextField to input the number of direct material used in an order.*/
	    @FXML
	    private TextField DirectMaterialTF;
	 
	/**TextField to input the number of direct hand work used in an order.*/
	    @FXML
	    private TextField ManoDeObraTF;

	/**TextField to input indirect fabrication costs.*/
	    @FXML
	    private TextField CostoIndirectoTF;
	    
	     
    /**Button to add the indirect fabrication costs input in the system.*/
	    @FXML
	    private Button CostoIndirectoBt;

	/**TextArea to display all the calculations done to costs.*/
	    @FXML
	    private TextArea ResultTA;
	    
    /**Button that, when pressed, performs the calculations on indirect costs and displays them in the TextArea*/
	    @FXML
	    private Button CalcularCostosBt;
	
	/**TextField with the name of the IFC*/    
	    @FXML
	    private TextField CIFNameTF;
	    
	/**A list holding all of the orders already in the system.*/     
	    private ArrayList<Orden> Orders;
	    
	/**A list holding all of the IFCs already used in the system.*/
	    private ArrayList<CostoIndirecto> CIFS;
	    
	    /**
	     * Initialises the Graphic User Interface and its different local variables.
	     */
	    @FXML
	    public void initialize() {
	    	Orders = new ArrayList<Orden>();
	    	CIFS = new ArrayList<CostoIndirecto>();
	    }
	    
	    
	    /**
	     * Adds a new order in the system
	     * @param e The action of pressing the button.
	     */
	    @FXML
	    public void AddOrder(ActionEvent e) {
	    
	    //First, verify user input.
	    	try {
	    	int numOrder = Integer.parseInt(OrderNumTF.getText());
	 
	    	double ManoDeObra = Double.parseDouble(ManoDeObraTF.getText());
	    	double MaterialDirecto = Double.parseDouble(DirectMaterialTF.getText());
	    	
	    	searchNumberOrder(numOrder);
	    	Orden o = new Orden(numOrder,ManoDeObra,MaterialDirecto, 0.0);
	    	Orders.add(o);
	    	
	    	}catch(NumberFormatException ex) {
	    		//Display error message in case a NumberFormatException is caught, meaning the user put wrong data in input.
	    		Alert alert = new Alert(Alert.AlertType.WARNING);
		        alert.initStyle(StageStyle.UTILITY);
		        alert.setTitle("Informacion");
		        alert.setHeaderText("WARNING!");
		        alert.setContentText("Porfavor ingrese un tipo de dato adecuado");

		       alert.showAndWait();
	    	}
	  
	    }
	    
	    /**
	     * Searches for an order with a given number, and returns either true or false if the order could be found.
	     * @param number The number of the order to be searched.
	     * @return True if the order was found, false otherwise.
	     */
	    public boolean searchNumberOrder(int number) {
	    	
	    	for(int c = 0; c < Orders.size();c++) {
	    		if(number == Orders.get(c).getOrderNumber()) {
	    			return true;
	    		}
	    	}
	    	return false;
	    }
	    
	    /**
	     * Adds the user given IFC to the system.
	     * @param e The action to press the CostoIndirectoBt Button
	     */
	    public void AgregarCIF(ActionEvent e) {
	    	try {
	    		//Create a new IFC
	    		String CIFname = CIFNameTF.getText();
	    		double CIFValue = Double.parseDouble(CostoIndirectoTF.getText());
	    		CostoIndirecto ci = new CostoIndirecto(CIFname,CIFValue);
	    		//Add it to the list of IFCs
	    		CIFS.add(ci);
	    		
	    	}catch(NumberFormatException ex) {
	    		//In case an input mismatches, display a warning to the user.
	    		Alert alert = new Alert(Alert.AlertType.WARNING);
		        alert.initStyle(StageStyle.UTILITY);
		        alert.setTitle("Informacion");
		        alert.setHeaderText("WARNING!");
		        alert.setContentText("Porfavor ingrese un tipo de dato adecuado");

		       alert.showAndWait();
	    	}
	    }
	    
//Para calcular los CIFS Aplicados primero tenemos que tener un CIf aplicado ya dado o una tasa en especifico

}
