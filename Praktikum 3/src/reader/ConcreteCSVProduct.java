package reader;

import java.io.*;

public class ConcreteCSVProduct extends Product {
	private BufferedReader br;
	
	public ConcreteCSVProduct() throws IOException {
		super();
		this.br = new BufferedReader(new FileReader("MoebelnAusgabe.csv"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		String[] ergebniszeile = br.readLine().split(";");
		return ergebniszeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		br.close();
		
	}

}
