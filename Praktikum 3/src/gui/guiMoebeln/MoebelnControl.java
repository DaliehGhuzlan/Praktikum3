package gui.guiMoebeln;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Moebeln;
import business.MoebelnModel;
import javafx.stage.Stage;

public class MoebelnControl {
	private MoebelnView moebelnView;
	private MoebelnModel moebelnModel;
	private Moebeln moebeln;
	
	public MoebelnControl(Stage primaryStage) {
		this.moebelnModel = moebelnModel.getInstance();
		this.moebelnView = new MoebelnView(this, primaryStage, moebelnModel);
	}
	public void nehmeMoebelnAuf(){
    	try{
    		this.moebelnModel.setMoebeln(new Moebeln(
    			moebelnView.getTxtName().getText(), 
   	            Float.parseFloat(moebelnView.getTxtWohnraum().getText()),
   	            moebelnView.getTxtStill().getText(),
   	            Float.parseFloat(moebelnView.getTxtPreis().getText()),
   	         	moebelnView.getTxtMaterialien().getText().split(";")));
    			moebelnView.zeigeInformationsfensterAn("Das Moebel wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		moebelnView.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }

	public void leseAusDatei(String typ) {
		try {
			this.moebelnModel.leseAusDatei(typ);
			this.moebelnView.zeigeInformationsfensterAn("Moebel wurde aufgenommen");
		} catch (IOException exc) {
			this.moebelnView.zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
		} catch (Exception exc) {
			this.moebelnView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!" + exc.getMessage());
			// exc.printStackTrace(); // Detaillierte Ausgabe des Fehlers in der Konsole
		}
	}

	public void schreibeMoebelnInCsvDatei() {
		try {
			this.moebelnModel.schreibeMoebelnInCsvDatei();
			this.moebelnView.zeigeInformationsfensterAn("Die Moebeln wurden gespeichert!");
		} catch (IOException exc) {
			this.moebelnView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc) {
			this.moebelnView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}
    
	
	
	
}
