package it.corso;

public class Furgoni extends Veicoli{
	
	private int portata;
	private int lunghezza; 
	private int larghezza; 
	private int altezza;


	public Furgoni(String marca, String modello, String numeroTarga,double tariffaGiornaliera,int portata, int lunghezza, int larghezza,
			int altezza) {
		super(marca, modello, numeroTarga,tariffaGiornaliera);
		this.portata = portata;
		this.lunghezza = lunghezza;
		this.larghezza = larghezza;
		this.altezza = altezza;
	}


	public int getPortata() {
		return portata;
	}

	public void setPortata(int portata) {
		this.portata = portata;
	}

	public int getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(int lunghezza) {
		this.lunghezza = lunghezza;
	}

	public int getLarghezza() {
		return larghezza;
	}

	public void setLarghezza(int larghezza) {
		this.larghezza = larghezza;
	}

	public int getAltezza() {
		return altezza;
	}

	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}


	@Override
	public String toString() {
		return super.toString() + " ,Portata: " + portata + " Kg," + "Lunghezza: " + lunghezza + " cm, Larghezza: " + larghezza + " cm , Altezza: "
				+ altezza + " cm";
	}
	
	

}
