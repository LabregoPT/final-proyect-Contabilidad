package UserInterface;

import model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Controller for a small window to add IFC to the program.
 */
public class AddCIFController {
	
	/**The Stage in which all of this window happens.*/
	private Stage stage;

	/** IFC name input TextField */
	@FXML
	private TextField cifNameTF;

	/** IFC name input TextField */
	@FXML
	private TextField cifValueTF;

	/** The IFC to be added to the system. */
	private CostoIndirecto ci;

	/**
	 * Handles the event in which the confirmation button is pressed.
	 * 
	 * @param event The event of pressing the "Agregar" button.
	 */
	@FXML
	void addCif(ActionEvent event) {
		try {
			String name = cifNameTF.getText();
			double val = Double.parseDouble(cifValueTF.getText());
			ci = new CostoIndirecto(name, val);
			stage.close();
		} catch (NumberFormatException e) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.initStyle(StageStyle.UTILITY);
			alert.setTitle("Informacion");
			alert.setHeaderText("WARNING!");
			alert.setContentText("Por favor ingrese un tipo de dato adecuado");
			alert.showAndWait();
		}
	}
	
	/**
	 * Returns the added IFC instance.
	 * @return the added IFC instance.
	 */
	CostoIndirecto getInput() {
		return ci;
	}

	/**
	 * Sets the Scene of this window to the one given as parameter.
	 * @param scene The given Scene.
	 */
	public void setStage(Stage sc) {
		stage = sc;
	}
}
