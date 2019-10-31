package UserInterface;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;

public class MainController {
	
	/**Scene in which all of this application happens.*/
	private Scene scene;

	/**Text Field to introduce the Real Base type to be used in this program.*/
	@FXML
	private TextField realBaseTF;

	/**Text Field to introduce the ICF percentage to be used in this program.*/
	@FXML
	private TextField percentageCIF;

	/**Text Field to introduce the order number to be added in the program.*/
	@FXML
	private TextField orderNumberTF;

	/**Text Field to introduce the direct material to be added in the program.*/
	@FXML
	private TextField directMatTF;

	/**Text Field to introduce the MOD to be added in the program.*/
	@FXML
	private TextField modTF;

	/**Text Field to introduce the applied real base to be added in the program.*/
	@FXML
	private TextField appRealBaseTF;

	/**Text Area to display all of the elements to be displayed in the program.*/
	@FXML
	private TextArea displayTA;

	/**The organization that represents the model.*/
	private Organization model;
	
	/**
	 * Sets a given Scene to the Scene in this app.
	 * @param s The given Scene.
	 */
	void setScene(Scene s) {
		scene = s;
	}
	
	void initialize() {
		model = new Organization();
	}
	
	/**
	 * Handles the event in which the addCIF option is pressed.
	 * @param event The event of pressing "Añadir CIF" in the menu options. 
	 */
	@FXML
	void addCIF(ActionEvent event) throws IOException {
		//Display AddCIF GUI
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddCIFGUI.fxml"));
		Parent root = fxmlLoader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(root);
		stage.setTitle("Agregar CIF");
		AddCIFController clr = fxmlLoader.getController();
		clr.setStage(stage);
		stage.setScene(scene);
		stage.show();
		
		CostoIndirecto ci = clr.getInput();
		model.registerIFC(ci);
	}

	/**
	 * Handles the event in which the calculateCIF button is pressed.
	 * @param event The event of pressing the "Calcular" button.
	 */
	@FXML
	void calculateCIF(ActionEvent event) {
		//TODO: Basically all of the logic of the program.
	}	

	/**
	 * Handles the event in which the close option is pressed.
	 * @param event The event of pressing "Salir" in the menu options.
	 */
	@FXML
	void close(ActionEvent event) {

	}

	/**
	 * Handles the event in which the deleteCIF option is pressed.
	 * @param event The event of pressing "Eliminar CIF..." in the menu options.
	 */
	@FXML
	void deleteCIF(ActionEvent event) {

	}

	/**
	 * Handles the event in which the help option is pressed.
	 * @param event The event of pressing "Acerca de" in the menu options.
	 */
	@FXML
	void help(ActionEvent event) {

	}

	/**
	 * Handles the event in which the newFile option is pressed.
	 * @param event The vent of pressing "Nuevo" in the menu options.
	 */
	@FXML
	void newFile(ActionEvent event) {

	}

	/**
	 * Handles the event in which the openFile option is pressed.
	 * @param event The event of pressing "Abrir..." in the menu options.
	 */
	@FXML
	void openFile(ActionEvent event) {

	}

	/**
	 * Handles the event in which the registerOrder button is pressed.
	 * @param event The event of pressing "Registrar" from the order options.
	 */
	@FXML
	void registerOrder(ActionEvent event) {

	}

	/**
	 * Handles the event in which the registerRealBase button is pressed.
	 * @param event The event of pressing "Registrar" from the Real Base options.
	 */
	@FXML
	void registerRealBase(ActionEvent event) {

	}

	/**
	 * Handles the event in which the saveFile option is pressed.
	 * @param event The event of pressing "Guardar cómo..." from the menu options.
	 */
	@FXML
	void saveFile(ActionEvent event) {

	}

}
