package it.corso;

public class Veicoli {
	private String marca;
	private String modello;
	private String numeroTarga;
	private double tariffaGiornaliera;
	
	public Veicoli(String marca, String modello, String numeroTarga,double tariffaGiornaliera) {
		this.marca = marca;
		this.modello = modello;
		this.numeroTarga = numeroTarga;
		this.tariffaGiornaliera = tariffaGiornaliera;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public String getNumeroTarga() {
		return numeroTarga;
	}
	public void setNumeroTarga(String numeroTarga) {
		this.numeroTarga = numeroTarga;
	}
	
	

	public double getTariffaGiornaliera() {
		return tariffaGiornaliera;
	}

	public void setTariffaGiornaliera(double tariffaGiornaliera) {
		this.tariffaGiornaliera = tariffaGiornaliera;
	}

	@Override
	public String toString() {
		return "Marca: " + marca + ", Modello: " + modello + ", Numero Targa: " + numeroTarga
				+ ", Tariffa Giornaliera: " + tariffaGiornaliera + " euro";
	}
	
	
	
}
