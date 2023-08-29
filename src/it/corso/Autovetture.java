package it.corso;

public class Autovetture extends Veicoli{

	private int numeroPorte;
	private int numeroPosti;

	public Autovetture(String marca, String modello, String numeroTarga,double tariffaGiornaliera, int numeroPorte, int numeroPosti) {
		super(marca, modello, numeroTarga,tariffaGiornaliera);
		this.numeroPorte = numeroPorte;
		this.numeroPosti = numeroPosti;
	}


	public int getNumeroPorte() {
		return numeroPorte;
	}

	public void setNumeroPorte(int numeroPorte) {
		this.numeroPorte = numeroPorte;
	}

	public int getNumeroPosti() {
		return numeroPosti;
	}

	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}


	@Override
	public String toString() {
		return super.toString() + " , Numero Porte: "+ numeroPorte + ", Numero Posti: " + numeroPosti;
	}
	
	
	
	
}
