package main;


import gui.guiStaedtischeEinrichtungen.WarenuebersichtControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new gui.guiMoebeln.MoebelnControl(primaryStage);
		Stage fensterStaedtischeEinrichtungen = new Stage();
		new WarenuebersichtControl(fensterStaedtischeEinrichtungen);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
