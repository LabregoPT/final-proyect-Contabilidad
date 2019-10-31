package UserInterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class. Starts the program.
 * @version 1.0 - 10/2019
 */
public class Main extends Application{
	
	/**
	 * Main method. Initialises the program.
	 * @param args The arguments to launch the program with.
	 */
	public static void main(String [] args) {
		launch(args);
	}

	@Override
	public void start(Stage Stage ) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("CostosUI.fxml"));
		Scene scene = new Scene(root);
		Stage.setTitle("Costos");
		Stage.setScene(scene);
		Stage.show();
	}
}
