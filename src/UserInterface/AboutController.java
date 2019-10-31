package UserInterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * Controller for the simple window that displays information about the app.
 */
public class AboutController {
	
	private Stage stage;
	
	void setStage(Stage st) {
		stage = st;
	}
	
	@FXML
	void close(ActionEvent event) {
		stage.close();
	}

}
