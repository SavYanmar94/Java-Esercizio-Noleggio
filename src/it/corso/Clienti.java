package it.corso;

public class Clienti {
	private String nome;
	private String cognome;
	private String numeroPatenteDiguida;
	
	/* Soluzione alternativa per far rispettare meglio l'incapsulamento
	 * Metodo Factory
	 * public static Clienti creaCliente(String nome, String cognome, String numeroPatenteDiguida) {
        return new Clienti(nome, cognome, numeroPatenteDiguida); 
    }*/  

	public Clienti(String nome, String cognome, String numeroPatenteDiguida) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.numeroPatenteDiguida = numeroPatenteDiguida;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNumeroPatenteDiguida() {
		return numeroPatenteDiguida;
	}
	public void setNumeroPatenteDiguida(String numeroPatenteDiguida) {
		this.numeroPatenteDiguida = numeroPatenteDiguida;
	}
	@Override
	public String toString() {
		return "Nome: " + nome + ", Cognome: " + cognome + ", Num. Patente di guida: " + numeroPatenteDiguida
				;
	} 

	
}
