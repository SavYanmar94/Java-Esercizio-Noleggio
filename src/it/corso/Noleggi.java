package it.corso;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Noleggi {
	LocalDate dataInizio;
	LocalDate dataFine;
	Veicoli veicolo;
	Clienti cliente;

	long numerogiorni;
	double importoTotale;
	
	
	public Noleggi(LocalDate dataInizio, LocalDate dataFine, Veicoli veicolo, Clienti cliente, long numerogiorni) {
	    this.dataInizio = dataInizio;
	    this.dataFine = dataFine;
	    this.veicolo = veicolo;
	    this.cliente = cliente;
	    
	    this.numerogiorni = numerogiorni;
	    this.importoTotale = this.veicolo.getTariffaGiornaliera() * this.numerogiorni; // Calcola l'importo totale
	}


	@Override
	public String toString() {
		return "Data Inizio Noleggio: " + dataInizio + ", Data Fine Noleggio: " + dataFine + ", Veicolo: " + veicolo + ", Cliente: "
				+ cliente + ", Durata Noleggio (in giorni): " + numerogiorni
				+ ", Importo Totale: " + importoTotale + " euro";
	}
	
	
	
}
