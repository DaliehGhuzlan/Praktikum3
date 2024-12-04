package gui.guiStaedtischeEinrichtungen;

import business.MoebelnModel;
import javafx.stage.Stage;

public class WarenuebersichtControl {
	private WarenuebersichtView warenuebersichtView;
	private MoebelnModel moebelModel;

		public WarenuebersichtControl(Stage primaryStage){
			this.moebelModel = moebelModel.getInstance();	
			this.warenuebersichtView 
		 	= new WarenuebersichtView(this, primaryStage,
			moebelModel);
}


}
