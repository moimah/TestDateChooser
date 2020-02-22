package com.moimah.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	
	private Controller controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		controller = new Controller();

				
        Scene scene = new Scene(controller.getRoot(), 420, 600);				
		
		primaryStage.setTitle("TestingDateChooser");
		primaryStage.setScene(scene);
		primaryStage.setMinHeight(420);
		primaryStage.setMinWidth(600);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
