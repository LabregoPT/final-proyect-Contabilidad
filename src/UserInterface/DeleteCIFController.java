package UserInterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;

/**
 * Simple Small GUI to select an already added CIF and delete it.
 */
public class DeleteCIFController {

	/**Stage in which all of the program will happen.*/
	private Stage stage;
	
	/**Relation with model.*/
	private Organization model;
	
	/**Displays the already added CIF.*/
	@FXML
	private TextArea displayTA;

	/**Input for the CIF to be deleted.*/
	@FXML
	private TextField inputTF;
	
	/**The value to return from this program.*/
	private int value;
	
	protected boolean finished = false;

	/**
	 * Sets a given Stage to the Scene in this app.
	 * @param s The given Stage.
	 */
	void setStage(Stage s) {
		stage = s;
	}
	
	void setModel(Organization m) {
		model = m;
	}
	
	void initialize() {
		displayTA.setText(model.getCIS());
	}
	
	@FXML
	void cancelButtonPressed(ActionEvent event) {
		stage.close();
	}

	@FXML
	void selectionButtonPressed(ActionEvent event) {
		try {
			int val = Integer.parseInt(inputTF.getText());
			if(val < 0 || val >= model.getCISSize()) {
				throw new NumberFormatException();
			}
			value = val;
			finished = true;
			stage.close();
		}catch(NumberFormatException e) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.initStyle(StageStyle.UTILITY);
			alert.setTitle("Informacion");
			alert.setHeaderText("WARNING!");
			alert.setContentText("Por favor ingrese un tipo de dato adecuado");
			alert.showAndWait();
		}
	}

	int getValue() {
		return value;
	}
}
