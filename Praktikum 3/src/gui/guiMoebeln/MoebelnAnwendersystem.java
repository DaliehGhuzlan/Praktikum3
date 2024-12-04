package gui.guiMoebeln;
   
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Moebeln;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class MoebelnAnwendersystem {
	  
    //---Anfang Attribute der grafischen Oberflaeche---
    private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblName 					= new Label("Name:");
    private Label lblWohnraum   			= new Label("Wohnraum:");
    private Label lblStill  	 			= new Label("Still:");
    private Label lblPreis   				= new Label("Preis");
    private Label lblMaterialien   			= new Label("Materialien :");
    private TextField txtName 	 			= new TextField();
    private TextField txtWohnraum			= new TextField();
    private TextField txtStill				= new TextField();
    private TextField txtPreis				= new TextField();
    private TextField txtMaterialien 		= new TextField();
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
    //-------Ende Attribute der grafischen Oberflaeche-------
    
    // speichert temporaer ein Objekt vom Typ Moebeln
    private Moebeln Moebeln;
    
    public MoebelnAnwendersystem(Stage primaryStage){
    	Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von Moebelnn");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
    }
    
    private void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	lblName.setLayoutX(20);
    	lblName.setLayoutY(90);
    	lblWohnraum.setLayoutX(20);
    	lblWohnraum.setLayoutY(130);
    	lblStill.setLayoutX(20);
    	lblStill.setLayoutY(170);
    	lblPreis.setLayoutX(20);
    	lblPreis.setLayoutY(210);
    	lblMaterialien .setLayoutX(20);
    	lblMaterialien .setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblName, lblWohnraum, lblStill,
       		lblPreis, lblMaterialien );
    
    	// Textfelder
     	txtName.setLayoutX(170);
    	txtName.setLayoutY(90);
    	txtName.setPrefWidth(200);
    	txtWohnraum.setLayoutX(170);
    	txtWohnraum.setLayoutY(130);
    	txtWohnraum.setPrefWidth(200);
    	txtStill.setLayoutX(170);
    	txtStill.setLayoutY(170);
    	txtStill.setPrefWidth(200);
      	txtPreis.setLayoutX(170);
    	txtPreis.setLayoutY(210);
    	txtPreis.setPrefWidth(200);
    	txtMaterialien .setLayoutX(170);
    	txtMaterialien .setLayoutY(250);
    	txtMaterialien .setPrefWidth(200);
      	pane.getChildren().addAll( 
     		txtName, txtWohnraum, txtStill,
     		txtPreis, txtMaterialien );
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
  	    this.mnDatei.getItems().add(mnItmCsvExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   private void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
        	    nehmeMoebelnAuf();
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	            zeigeMoebelnAn();
	        } 
   	    });
	    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	       	 	leseAusDatei("csv");
	    	}
	    });
	    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		     	leseAusDatei("txt");
		    }
    	});
	    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				schreibeMoebelnInCsvDatei();
			}	
	    });
    }
    
    private void nehmeMoebelnAuf(){
    	try{
    		this.Moebeln = new Moebeln(
    			txtName.getText(), 
   	            Float.parseFloat(txtWohnraum.getText()),
   	            txtStill.getText(),
    			Float.parseFloat(txtPreis.getText()),
    		    txtMaterialien.getText().split(";"));
    		zeigeInformationsfensterAn("Das Moebeln wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
   
    private void zeigeMoebelnAn(){
    	if(this.Moebeln != null){
    		txtAnzeige.setText(
    			this.Moebeln.gibMoebeknZurueck(' '));
    	}
    	else{
    		zeigeInformationsfensterAn("Bisher wurde kein Moebeln aufgenommen!");
    	}
    }    
		  
    private void leseAusDatei(String typ){
    	try {
      		if("csv".equals(typ)){
      			BufferedReader ein = new BufferedReader(new FileReader("Moebeln.csv"));
      			String[] zeile = ein.readLine().split(";");
      			this.Moebeln = new Moebeln(zeile[0], 
      				Float.parseFloat(zeile[1]), 
      				zeile[2], 
      				Float.parseFloat(zeile[3]), 
      				zeile[4].split("_"));
      				ein.close();
      	  			zeigeInformationsfensterAn(
      	  	   			"Die Moebeln wurden gelesen!");
      		}
       		else{
	   			zeigeInformationsfensterAn(
	   				"Noch nicht implementiert!");
	   		}
		}
		catch(IOException exc){
			zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
		
	private void schreibeMoebelnInCsvDatei() {
		try {
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("MoebelnAusgabe.csv", true));
			aus.write(Moebeln.gibMoebeknZurueck(';'));
			aus.close();
   			zeigeInformationsfensterAn(
	   			"Die Moebeln wurden gespeichert!");
		}	
		catch(IOException exc){
			zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}

    private void zeigeInformationsfensterAn(String meldung){
    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
    		"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
    void zeigeFehlermeldungsfensterAn(String meldung){
       	new MeldungsfensterAnzeiger(AlertType.ERROR,
        	"Fehler", meldung).zeigeMeldungsfensterAn();
    }

}
