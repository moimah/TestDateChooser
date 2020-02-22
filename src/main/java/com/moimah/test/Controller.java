package com.moimah.test;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.componentes.DateChooser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Controller implements Initializable {
	@FXML
	private VBox root;	
	@FXML
	private DateChooser dateChooserA;
	@FXML
	private Button btnSpanish;
	@FXML
	private Button btnEnglish;
	@FXML
	private DateChooser dateChooserB;	
	@FXML
	private Button btnReservar;
	@FXML
	private Button resetA;
	@FXML
	private Button resetB;

	
	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TemplateView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
			
				
	}
	
		// Event Listener on Button[#btnSpanish].onAction
		@FXML
		public void onActionSpanish(ActionEvent event) {
			
			try {
				btnEnglish.setDefaultButton(false);
				btnSpanish.setDefaultButton(true);
				
				dateChooserA.setSpanish(true);
				dateChooserB.setSpanish(true);
				
			} catch (Exception e) {
				
			}
			
			
			
			
		}
		// Event Listener on Button[#btnEnglish].onAction
		@FXML
		public void onActionEnglish(ActionEvent event) {
			
			try {
				
				btnEnglish.setDefaultButton(true);
				btnSpanish.setDefaultButton(false);
				
				dateChooserA.setSpanish(false);
				dateChooserB.setSpanish(false);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
			
			
		}
		// Event Listener on Button[#btnReservar].onAction
		@FXML
		public void onActionBooking(ActionEvent event) {
			
			String day_in =  dateChooserA.getDayCombo().getSelectionModel().getSelectedIndex()+1 +"";			
			if(day_in.length()==1) {
				day_in = "0" + day_in;
			}
			
			String month_in = dateChooserA.getMonthCombo().getSelectionModel().getSelectedIndex()+1 + "";			
			if(month_in.length()==1) {
				month_in = "0" + month_in; 
			}
						
			String year_in = dateChooserA.getYearCombo().getSelectionModel().getSelectedItem() +"";
			
			
			String date_in = "Entrada: " + day_in + "/" + month_in + "/" + year_in;
			
			
			
			String day_out =  dateChooserB.getDayCombo().getSelectionModel().getSelectedIndex()+1 +"";			
			if(day_out.length()==1) {
				day_out = "0" + day_out;
			}
			
			String month_out = dateChooserB.getMonthCombo().getSelectionModel().getSelectedIndex()+1 + "";			
			if(month_out.length()==1) {
				month_out = "0" + month_out; 
			}
			
			
			
			String year_out = dateChooserB.getYearCombo().getSelectionModel().getSelectedItem() +"";
			
			String date_out = "Salida:    " + day_out + "/" + month_out + "/" + year_out;
			
		
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmar");
			alert.setHeaderText("Confirme la reserva");
			alert.setContentText(date_in + "\n" + date_out);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
			   alert.close();
			} else {
			   alert.close();
			}
		}
		
		
	@FXML
	void onActionResetA(ActionEvent event) {
		
		LocalDate today = LocalDate.now();
		dateChooserA.setDateProperty(today);
	
		
	}

	@FXML
	void onActionResetB(ActionEvent event) {

		LocalDate today = LocalDate.now();
		dateChooserB.setDateProperty(today);
	}
	
	
	public VBox getRoot() {
		return root;
	}

}
