package com.khaledsab.jfxpopup;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainWindowController extends AbstractController implements Initializable {

	@FXML private Button popitBtn;
	@FXML private Label resultLbl;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		resultLbl.setText("Lets get something in here");
		popitBtn.setOnAction((event)->{
			HashMap<String, Object> resultMap = showPopupWindow();
			resultLbl.setText("I've got this (username: "+resultMap.get("username")
					+" /Password: "+resultMap.get("password")+")");
		});

	}


	private HashMap<String, Object> showPopupWindow() {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Popup.fxml"));
		// initializing the controller
		PopupController popupController = new PopupController();
		loader.setController(popupController);
		Parent layout;
		try {
			layout = loader.load();
			Scene scene = new Scene(layout);
			// this is the popup stage
			Stage popupStage = new Stage();
			// now
			popupController.setStage(popupStage);
			if(this.main!=null) {
				popupStage.initOwner(main.getPrimaryStage());
			}
			popupStage.initModality(Modality.WINDOW_MODAL);
			popupStage.setScene(scene);
			popupStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			new Alert(AlertType.ERROR, "There was an error trying to load the popup fxml file.").show();
		}
		return popupController.getResult();
	}

}
