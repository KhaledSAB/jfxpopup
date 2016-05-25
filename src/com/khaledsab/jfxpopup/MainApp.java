package com.khaledsab.jfxpopup;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
		private Stage primaryStage;

		public static void main(String[] args) {
			launch(args);
		}

		@Override
		public void start(Stage primaryStage) throws Exception {
			this.primaryStage = primaryStage;

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("MainWindow.fxml"));
			MainWindowController mainWindowController = new MainWindowController();
			mainWindowController.setMainApp(this);
			loader.setController(mainWindowController);
			Parent layout = loader.load();

			Scene scene = new Scene(layout);
			primaryStage.setScene(scene);
			primaryStage.show();
		}

		public Stage getPrimaryStage() {
			return primaryStage;
		}
}
