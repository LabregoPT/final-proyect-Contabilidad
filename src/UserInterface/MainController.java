package UserInterface;

import java.io.*;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;

public class MainController {

	/** Stage in which all of this application happens. */
	private Stage stage;

	/** Text Field to introduce the Real Base type to be used in this program. */
	@FXML
	private TextField realBaseTF;

	/** Text Field to introduce the ICF percentage to be used in this program. */
	@FXML
	private TextField percentageCIF;

	/** Text Field to introduce the order number to be added in the program. */
	@FXML
	private TextField orderNumberTF;

	/** Text Field to introduce the direct material to be added in the program. */
	@FXML
	private TextField directMatTF;

	/** Text Field to introduce the MOD to be added in the program. */
	@FXML
	private TextField modTF;

	/** Text Field to introduce the applied real base to be added in the program. */
	@FXML
	private TextField appRealBaseTF;

	/** Text Area to display all of the elements to be displayed in the program. */
	@FXML
	private TextArea displayTA;

	/** The organization that represents the model. */
	private Organization model;

	/**
	 * Sets a given Stage to the Scene in this app.
	 * 
	 * @param s The given Stage.
	 */
	void setStage(Stage s) {
		stage = s;
	}

	@FXML
	void initialize() {
		model = new Organization();
	}

	/**
	 * Handles the event in which the addCIF option is pressed.
	 * 
	 * @param event The event of pressing "Añadir CIF" in the menu options.
	 */
	@FXML
	void addCIF(ActionEvent event) throws IOException {
		// Display AddCIF GUI
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddCIFGUI.fxml"));
		Parent root = fxmlLoader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(root);
		stage.setTitle("Agregar CIF");
		AddCIFController clr = fxmlLoader.getController();
		clr.setStage(stage);
		stage.setScene(scene);
		stage.show();

		// Add CIF to model.
		CostoIndirecto ci = clr.getInput();
		model.registerIFC(ci);
	}

	/**
	 * Handles the event in which the calculateCIF button is pressed.
	 * 
	 * @param event The event of pressing the "Calcular" button.
	 */
	@FXML
	void calculateCIF(ActionEvent event) {
		// TODO: Basically all of the logic of the program.
	}

	/**
	 * Handles the event in which the close option is pressed.
	 * 
	 * @param event The event of pressing "Salir" in the menu options.
	 */
	@FXML
	void close(ActionEvent event) {
		stage.close();
	}

	/**
	 * Handles the event in which the deleteCIF option is pressed.
	 * 
	 * @param event The event of pressing "Eliminar CIF..." in the menu options.
	 * @throws IOException
	 */
	@FXML
	void deleteCIF(ActionEvent event) throws IOException {
		// Display DeleteCIF GUI
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DeleteCIFGUI.fxml"));
		Parent root = fxmlLoader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(root);
		stage.setTitle("Eliminar CIF");
		DeleteCIFController clr = fxmlLoader.getController();
		clr.setModel(model);
		clr.setStage(stage);
		clr.initialize();
		stage.setScene(scene);
		stage.show();
		// Delete CIF From model
		if (clr.finished) {
			int value = clr.getValue();
			model.deleteCIF(value);
		}
	}

	/**
	 * Handles the event in which the help option is pressed.
	 * 
	 * @param event The event of pressing "Acerca de" in the menu options.
	 * @throws IOException
	 */
	@FXML
	void help(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AboutGUI.fxml"));
		Parent root = fxmlLoader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(root);
		stage.setTitle("Acerca de");
		AboutController clr = fxmlLoader.getController();
		clr.setStage(stage);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Handles the event in which the newFile option is pressed.
	 * 
	 * @param event The vent of pressing "Nuevo" in the menu options.
	 */
	@FXML
	void newFile(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmación");
		alert.setHeaderText("Abrir un nuevo archivo eliminará todos los datos registrados");
		alert.setContentText("¿Estás de acuerdo con esto?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			model = new Organization();
		}
	}

	/**
	 * Handles the event in which the openFile option is pressed.
	 * 
	 * @param event The event of pressing "Abrir..." in the menu options.
	 */
	@FXML
	void openFile(ActionEvent event) throws ClassNotFoundException {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText("Abrir un nuevo archivo eliminará todos los datos registrados");
		alert.setContentText("¿Estás de acuerdo con esto?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			try {
				// Open File Chooser
				Stage s = new Stage();
				FileChooser fc = new FileChooser();
				fc.setTitle("Seleccione el archivo a cargar");
				// Path chosen with File Chooser
				String path = fc.showOpenDialog(s).getPath();
				// File in Path
				File f = new File(path);
				// Deserialize
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				model = (Organization) ois.readObject();
				ois.close();
			} catch (IOException e) {
				Alert err = new Alert(AlertType.ERROR);
				err.setContentText("Hubo un error cargando los archivos.");
				err.showAndWait();
			} catch (NullPointerException e) {
				// Do Nothing
			}
		}
	}

	/**
	 * Handles the event in which the registerOrder button is pressed.
	 * 
	 * @param event The event of pressing "Registrar" from the order options.
	 */
	@FXML
	void registerOrder(ActionEvent event) {
		try {
			int numOrder = Integer.parseInt(orderNumberTF.getText());
			double manoDeObra = Double.parseDouble(modTF.getText());
			double materialDirecto = Double.parseDouble(directMatTF.getText());
			double baseReal = Double.parseDouble(appRealBaseTF.getText());
			if (model.searchNumberOrder(numOrder)) {
				
			} else {
				Orden o = new Orden(numOrder, manoDeObra, materialDirecto, baseReal);
				model.registerOrder(o);
			}
		} catch (NumberFormatException ex) {
			// Display error message in case a NumberFormatException is caught, meaning the
			// user put wrong data in input.
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.initStyle(StageStyle.UTILITY);
			alert.setTitle("Informacion");
			alert.setHeaderText("¡Cuidado!");
			alert.setContentText("Por favor ingrese un tipo de dato adecuado");
			alert.showAndWait();
		}
	}

	/**
	 * Handles the event in which the registerRealBase button is pressed.
	 * 
	 * @param event The event of pressing "Registrar" from the Real Base options.
	 */
	@FXML
	void registerRealBase(ActionEvent event) {
		String 
	}

	/**
	 * Handles the event in which the saveFile option is pressed.
	 * 
	 * @param event The event of pressing "Guardar cómo..." from the menu options.
	 */
	@FXML
	void saveFile(ActionEvent event) throws FileNotFoundException, IOException {
		FileChooser fileChooser = new FileChooser();
		Stage s = new Stage();
		// Set extension filter for text files
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Archivos CYC (*.cyc)", "*.cyc");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show save file dialog
		File file = fileChooser.showSaveDialog(s);

		if (file != null) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(model);
			oos.close();
		}
	}

}
