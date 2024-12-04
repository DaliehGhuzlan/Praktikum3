package gui.guiStaedtischeEinrichtungen;

import business.MoebelnModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;
import ownUtil.Observer;

public class WarenuebersichtView implements Observer {
		private WarenuebersichtControl warenuebersichtControl;
		private MoebelnModel moebelModel;		
    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane = new  Pane();
    	private Label lblAnzeige   	 	    	= new Label("Anzeige");
    	private TextArea txtAnzeige  			= new TextArea();
    	private Button btnAnzeige 		 		= new Button("Anzeige");
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public WarenuebersichtView(WarenuebersichtControl warenuebersichtControl, Stage primaryStage,MoebelnModel moebelModel){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige der Warenübersicht");
    		primaryStage.show();
    		this.warenuebersichtControl = warenuebersichtControl;
	 		this.moebelModel = moebelModel;
	 		this.initKomponenten();
			this.initListener();
			this.moebelModel.adObserver(this);
    	}

 	private void initKomponenten(){
    		// Label
 		Font font = new Font("Arial", 20);
       	lblAnzeige.setLayoutX(310);
    	lblAnzeige.setLayoutY(40);
    	lblAnzeige.setFont(font);
   		lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeige);           
       	// Textbereich	
        txtAnzeige.setEditable(false);
        txtAnzeige.setLayoutX(310);
        txtAnzeige.setLayoutY(90);
        txtAnzeige.setPrefWidth(220);
   		txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige);        	
        	// Button
        btnAnzeige.setLayoutX(310);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().add(btnAnzeige); 
   }
   
	private void initListener() {

		btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				update();

			}
		});

	}
   
// private void zeigeMoebelnAn() {
//		if (this.moebelnModel.getMoebeln() != null) {
//			txtAnzeige.setText(this.moebelnModel.getMoebeln().gibMoebeknZurueck(' '));
//		} else {
//			zeigeInformationsfensterAn("Bisher wurde kein Moebeln aufgenommen!");
//		}
//	}
   
    public void zeigeInformationsfensterAn(String meldung){
	   	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
	   		"Information", meldung).zeigeMeldungsfensterAn();
	   }	

	@Override
	public void update() {
		if (this.moebelModel.getMoebeln() != null) {
			txtAnzeige.setText(this.moebelModel.getMoebeln().gibMoebeknZurueck(' '));
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Moebeln aufgenommen!");
		}
		
	}	


}
