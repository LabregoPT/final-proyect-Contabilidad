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
	 * Main method. Initializes the program.
	 * @param args The arguments to launch the program with.
	 */
	public static void main(String [] args) {
		launch(args);
	}

	@Override
	public void start(Stage Stage ) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI.fxml"));
		Parent root = fxmlLoader.load();
		Stage stage = new Stage();
		Scene scene = new Scene(root);
		stage.setTitle("Costos");
		MainController clr = fxmlLoader.getController();
		clr.setStage(stage);
		stage.setScene(scene);
		stage.show();
	}
}
