package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import model.AirLine;

public class AirLineGUI {

	@FXML
	private BorderPane mainPane;

	@FXML
	private TextField departureTF;

	@FXML
	private TextField arrivalTF;

	@FXML
	private RadioButton speed;

	@FXML
	private ToggleGroup criteria;

	@FXML
	private RadioButton cost;



	private AirLine main;

	public AirLineGUI(AirLine al) {

		main = al;
	}

	public void loadSettinWindow(Object object) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
		fxmlLoader.setController(this);
		Parent setting = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.setCenter(setting);
	}
	
	@FXML
	void calculate(ActionEvent event) {

		String criterio=((RadioButton) criteria.getSelectedToggle()).getText();
		String departure=departureTF.getText();
		String arrival=arrivalTF.getText();
		
		if(departure.equals("")|| arrival.equals("")|| criterio.equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Invalid Information");
			alert.setContentText("Fill in all the fields");
			alert.showAndWait();
		}else {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Route");
		alert.setContentText(calculateRoute(departure, arrival, criterio));
		alert.showAndWait();
		}
	}
	
	public String calculateRoute(String departure, String arrival, String criterio ) {
		String text= "";
		
		text= main.calculateRoute(departure,arrival,criterio);
		
		return text;
	}
}
