package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteTXTProduct extends Product{
private BufferedReader br;
	
	public ConcreteTXTProduct() throws IOException {
		super();
		this.br = new BufferedReader(new FileReader("MoebelnAusgabe.txt"));
	}
	@Override
	public String[] leseAusDatei() throws IOException {
		String[] ergebniszeile = new String[5];
		String zeile = br.readLine();
		int i = 0;
		
		while(i < ergebniszeile.length) {
			ergebniszeile[i] = zeile;
			zeile = br.readLine();
			i++;
		}
		return ergebniszeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		br.close();
		
	}

}
