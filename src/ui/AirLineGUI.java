package ui;

import java.io.IOException;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import model.AirLine;

public class AirLineGUI {

	@FXML
	private BorderPane mainPane;

	@FXML
	private RadioButton speed;

	@FXML
	private ToggleGroup criteria;

	@FXML
	private RadioButton cost;

	@FXML
	private RadioButton graphList;

	@FXML
	private ToggleGroup tipoGraph;

	@FXML
	private RadioButton graphMatrix;

	@FXML
    private ComboBox<String> listOfPlaceFrom;

    @FXML
    private ComboBox<String> listOfPlacesTo;

	private AirLine main;

	public AirLineGUI(AirLine al) throws IOException {
		main = al;
		main.init();
	}

	public void  loadSettingWindow(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
		fxmlLoader.setController(this);
		Parent setting = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.setCenter(setting);

		initializecomboBox();
	}

	@FXML
	void calculate(ActionEvent event) {

		String criterio = ((RadioButton) criteria.getSelectedToggle()).getText();
		String departure = listOfPlaceFrom.getSelectionModel().getSelectedItem();
		String arrival = listOfPlacesTo.getSelectionModel().getSelectedItem();
		String graph = ((RadioButton) tipoGraph.getSelectedToggle()).getText();

		if (departure.trim().isEmpty() || arrival.trim().isEmpty() || criterio.trim().isEmpty()
				|| graph.trim().isEmpty()) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Invalid Information");
			alert.setContentText("Fill in all the fields");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Route");
			alert.setContentText(main.calculateRoute(departure, arrival, criterio, graph));
			alert.showAndWait();
		}
	}

	public String calculateRoute(String departure, String arrival, String criterio, String typeGraph) {
		String text = "";

		text = main.calculateRoute(departure, arrival, criterio, typeGraph);

		return text;
	}

	public void initializecomboBox() {
		listOfPlaceFrom.getItems().clear();
		ArrayList<String> a = main.getDestinations();

		listOfPlaceFrom.getItems().addAll(a);
		listOfPlaceFrom.setVisible(true);
		
		
		listOfPlacesTo.getItems().clear();
		ArrayList<String> b = main.getDestinations();

		listOfPlacesTo.getItems().addAll(b);
		listOfPlacesTo.setVisible(true);
		
	}

}
