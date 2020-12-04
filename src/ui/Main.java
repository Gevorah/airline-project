package ui;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.AirLine;


public class Main extends Application {

	private AirLineGUI airLineGUI;
	private static  AirLine airline;

	public Main() throws IOException {

		airline= new AirLine();
		airLineGUI = new AirLineGUI(airline);

	}

	public static void main(String[] args) {

		launch(args);

	}



	@Override
	public void start(Stage stage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPane.fxml"));

		loader.setController(airLineGUI);
		Parent root = loader.load();

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Main Window");
		airLineGUI.loadSettingWindow(null);
		stage.show();

	}


}
