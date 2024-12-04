package business;

public class Moebeln {
	
	// Name des Moebelns
    private String name;
    // Oeffnungszeiten
    private float wohnraum;
    private String still;
    // Strasse und Hausnummer des Moebelns
    private float preis;
    // Materialien  des Moebelns
    private String[] Materialien ;

    public Moebeln(String name, float wohnraum, String still,float preis, String[] Materialien ){
   		this.name = name;
  	    this.wohnraum = wohnraum;
   	    this.still = still;
   	    this.preis = preis;
   	    this.Materialien  = Materialien ;
    }
  
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getWohnraum() {
		return wohnraum;
	}


	public void setWohnraum(float wohnraum) {
		this.wohnraum = wohnraum;
	}


	public String getStill() {
		return still;
	}


	public void setStill(String still) {
		this.still = still;
	}


	public float getPreis() {
		return preis;
	}


	public void setPreis(float preis) {
		this.preis = preis;
	}


	public String[] getMaterialien() {
		return Materialien;
	}


	public void setMaterialien(String[] materialien) {
		Materialien = materialien;
	}


	public String getMaterialienAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getMaterialien ().length - 1; i++) {
			ergebnis = ergebnis + this.getMaterialien ()[i] + trenner; 
		}
		return ergebnis	+ this.getMaterialien ()[i];
	}
	
	public String gibMoebeknZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getWohnraum() + trenner
  		    + this.getStill() + trenner
  		    + this.getPreis() + trenner
  		    + this.getMaterialienAlsString(trenner);
  	}

	
}

