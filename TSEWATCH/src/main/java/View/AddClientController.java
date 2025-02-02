package View;

import java.awt.event.MouseEvent;
import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import Launcher.DisplayController;
import Model.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AddClientController {
	
	
	
	
	@FXML
	private Button ACAjouterButton;
	
	@FXML
	private JFXTextField nameClient,addrMail;
	
	@FXML
	private DisplayController displayCtrl;
	
	
	@FXML
	public void initialize() {
		displayCtrl = DisplayController.getInstance();
	}
	
	@FXML
	private JFXButton btn_ac_cancel,btn_ac_ok;
	
	 @FXML
	 private void handleButtonAction(ActionEvent event) {
		 if(event.getSource() == btn_ac_ok) {
			 addClient2DiffusionTable();
			 displayCtrl.closeAddClientStage();
		 }
		 if(event.getSource() == btn_ac_cancel) {
			 displayCtrl.closeAddClientStage();
		 }
		 
	 }
	
	public void addClient2DiffusionTable() {
		Client client = new Client(nameClient.getText(),addrMail.getText());
		displayCtrl.getHomecontroller().addClient2TableView(client);
		displayCtrl.getHomecontroller().saveOneClient(client);
	}
	
	
	 
	 
	 @FXML
	 private void handleEvent(MouseEvent event) {    
	   
	 }
	
}
