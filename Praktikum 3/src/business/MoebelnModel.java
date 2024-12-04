package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import ownUtil.Observable;
import ownUtil.Observer;
import reader.ConcreteCSVCreator;
import reader.ConcreteTXTCreator;
import reader.Creator;
import reader.Product;

public class MoebelnModel implements Observable{
	private Moebeln moebeln;
	private Vector<Observer> observers = new Vector<Observer>();
			
	
	private static MoebelnModel moebelnModel;
	
	 private MoebelnModel() {
		super();
	}
	 
	public static MoebelnModel getInstance() {
		if(moebelnModel == null) {
			moebelnModel = new MoebelnModel();
		}
		return moebelnModel;
	}
	
	
	
	public Moebeln getMoebeln() {
		return moebeln;
	}
	public void setMoebeln(Moebeln moebeln) {
		this.moebeln = moebeln;
	}


	public void schreibeMoebelnInCsvDatei() throws IOException{
		    BufferedWriter aus = new BufferedWriter(new FileWriter("MoebelnAusgabe.csv", false));
		   	aus.write(this.moebeln.gibMoebeknZurueck(';'));
		    aus.close();
	 	}
	
	public void leseAusDatei(String typ) throws IOException {
		if ("csv".equals(typ)) {			BufferedReader ein = new BufferedReader(new FileReader("MoebelnAusgabe.csv"));
		String[] zeile = ein.readLine().split(";");
		this.moebeln = new Moebeln(zeile[0], Float.parseFloat(zeile[1]), zeile[2], Float.parseFloat(zeile[3]), zeile[4].split(";"));
		ein.close();
		notifyObserver();
	}
		Creator creator = null;
		if(typ.equals("csv")) {
			creator = new ConcreteCSVCreator();
		}
		else {
			creator = new ConcreteTXTCreator();
		}
		
		Product reader = creator.factoryMethod(typ);
		
		String[] zeile = reader.leseAusDatei();
		this.moebeln = new Moebeln(zeile[0], Float.parseFloat(zeile[1]), zeile[2], Float.parseFloat(zeile[3]), zeile[4].split(";"));
		notifyObserver();
	}

	@Override
	public void adObserver(Observer obs) {
		this.observers.addElement(obs);
		
	}

	@Override
	public void removeObserver(Observer obs) {
		this.observers.remove(obs);
		
	}

	@Override
	public void notifyObserver() {
		for (Observer observer : observers) {
			observer.update();
		}
		
	}

}
