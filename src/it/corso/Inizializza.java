package it.corso;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class Inizializza {

	Scanner input = new Scanner(System.in);
	
	ArrayList<Clienti> ListaClienti = new ArrayList<>();
    ArrayList<Veicoli> ListaVeicoli = new ArrayList<>();
	ArrayList<Noleggi> ListaNoleggi = new ArrayList<>();
	
	
	
	public void menu() {
		
		while(true) {
			
			System.out.println("Benvenuto nel software noleggi");
			System.out.println("Digita 1 per registrare, 2 per visualizzare le liste,3 per uscire");
		
			String sceltaMenu = input.nextLine();
			if (sceltaMenu.equals("1")){
				registra();
			
			} else if (sceltaMenu.equals("2")){
				mostraLista();
			
			} else if (sceltaMenu.equals("3")){
				System.out.println("Spegnimento in corso...");
				System.exit(0);
			} else {
				System.out.println("Input errato");
			}
		}
	
	}
	
	public void registra() {

	    while(true) {
	    	
			System.out.println("Cosa vuoi registrare ? ");
			System.out.println("Digita 1 per registrare i clienti, 2 per registrare i veicoli, 3 per registrare i noleggi,4 per tornare al menu principale");
			
			String sceltaReg = input.nextLine();
			
			if (sceltaReg.equals("1")) {
				
				registrazioneCliente();
				
			} else if (sceltaReg.equals("2")) {
				System.out.println("Digita 1 per registrare autovettura,2 per registrare furgone");
				
				String sceltaVettura = input.nextLine();
				
				if (sceltaVettura.equals("1"))
					
					registrazioneAutovettura();
					
				else if (sceltaVettura.equals("2")) 
					
					registrazioneFurgone();
				
				else 
					System.out.println("Input errato");
					
			    
		   } else if (sceltaReg.equals("3")) 
				
				registrazioneNoleggio();
				
			 else if (sceltaReg.equals("4")) {
				System.out.println("Sto tornando al menu principale...\n");
				return;
			
			} else 
				System.out.println("Input errato");

		}
	}
	
	public void registrazioneNoleggio() {

		if (ListaClienti.isEmpty() || ListaVeicoli.isEmpty()) {
	        System.out.println("Devi prima registrare almeno un cliente e un veicolo.");
	        registra(); // Torna al menu principale
	    }
		
		LocalDate dataInizio = null;
		LocalDate dataFine = null;
		Veicoli veicolo = null;
		Clienti cliente = null;
		double tariffaGiornaliera = 0;
		long numerogiorni = 0;
		double importoTotale = 0.0;
		
		while(true) {
			
			try {
				System.out.println("Inserendo la data inizio noleggio...");
				dataInizio = LocalDate.now();
				System.out.println("La data registrata è: " + dataInizio);
				System.out.println("Inserisci la data fine noleggio (nel formato YYYY-MM-GG)");
				String dataString = input.nextLine();
				dataFine = LocalDate.parse(dataString);
				
				if(dataFine.isBefore(dataInizio)) {
					System.out.println("La data di fine noleggio non può essere antecedente alla data corrente.");
				}
				else {
		            System.out.println("La durata noleggio è di giorni: " + ChronoUnit.DAYS.between(dataInizio, dataFine));
		            break;
		        }
				
			} catch (Exception e) {
				System.out.println("Input Errato");
			} 
		
		}	
	
		while(true) {
			try {

				System.out.println("Selezionare il veicolo tra quelli disponibili(digitare il numero corrispondente)");
				int veicoloIndex = 1;
				for (Veicoli v : ListaVeicoli) {
			        System.out.println(veicoloIndex + ". " + v.getMarca() + " " + v.getModello());
			        veicoloIndex++;
			    }
				
				int sceltaVeicolo = input.nextInt();
				input.nextLine(); // Pulisci il buffer dell'input
				veicolo = ListaVeicoli.get(sceltaVeicolo - 1);
				break;
			
			} catch (Exception e) {
			System.out.println("Input errato");
			input.nextLine();
			
			}
		}
		
		while(true) {
			
		try {
			
			System.out.println("Selezionare il cliente tra quelli disponibili(digitare il numero corrispondente) ");
			int clienteIndex = 1;
			
			for (Clienti c:ListaClienti) {
				System.out.println(clienteIndex + ". " + c.getNome() + " " + c.getCognome());
		        clienteIndex++;
		    }
			int sceltaCliente = input.nextInt();
			input.nextLine();
		    cliente = ListaClienti.get(sceltaCliente - 1);
			
			break;
			
		} catch (Exception e) {
			System.out.println("Input errato");
			input.nextLine();
		}
		
		}
		
		System.out.println("Registrazione noleggio effettuata con successo");

		// Aggiungi qui il calcolo della durata e dell'importo
        numerogiorni = ChronoUnit.DAYS.between(dataInizio, dataFine);
        importoTotale = tariffaGiornaliera * numerogiorni;
	    Noleggi noleggio = new Noleggi(dataInizio, dataFine, veicolo, cliente,numerogiorni);
        ListaNoleggi.add(noleggio);
		
		
	}
	
	//registrazione cliente
	public void registrazioneCliente() {
		
		
		String nomeCliente= null;
		String cognomeCliente = null;
		String numPatenteGuida = null;
		
		
		System.out.println("Inserire nome cliente");
		nomeCliente = input.nextLine();
		System.out.println("Inserire cognome cliente");
		cognomeCliente = input.nextLine();
		
		
		while(true) {
			System.out.println("Inserire numero patente di guida (formato AB1234567)");
			numPatenteGuida = input.nextLine();
			
			// Vediamo se la targa rispetta il pattern per la patente (2 lettere, 7 cifre)
			if (numPatenteGuida.matches("[A-Z]{2}\\d{7}")) {
	            System.out.println("Patente valida!");
	            break;
	        } else {
	            System.out.println("Patente non valida. Assicurati di inserire il formato corretto.");
	        }
		}
		
		System.out.println("Cliente registrato con successo!");
		Clienti cliente = new Clienti(nomeCliente,cognomeCliente,numPatenteGuida);
		// Altra soluz. metodo factory per rispet. incapsulamento : Clienti cliente = Clienti.creaCliente(nomeCliente, cognomeCliente, numPatenteGuida);
		ListaClienti.add(cliente);
		
	}
	
	//registrazione autovettura
	public void registrazioneAutovettura() {
		
		
		String marca = null;
		String modello = null;
		String numeroTarga = null;
		double tariffaGiornaliera = 0.0;
		int numeroPorte = 0;
		int numeroPosti = 0;

		
		System.out.println("Inserisci la marca:");
		marca = input.nextLine();
		System.out.println("Inserisci il modello");
		modello = input.nextLine();
		
		
		while(true) {
			System.out.println("Inserisci il numero di targa (es. AB123CD)");
			numeroTarga = input.nextLine();
			
			// Vediamo se la targa rispetta il pattern per la targa (2 lettere, 3 numeri, 2 lettere)
			if (numeroTarga.matches("[A-Z]{2}\\d{3}[A-Z]{2}")) {
	            System.out.println("Targa valida!");
	            break;
	        } else {
	            System.out.println("Targa non valida. Assicurati di inserire il formato corretto.");
	        }
		}
		 

		while(true) {
			try {
			
				System.out.println("Inserisci la tariffa giornaliera");
				tariffaGiornaliera = input.nextDouble();
				input.nextLine();
				break;
		}   catch (Exception e) {
			System.out.println("Input errato");
		}
		}
		
		while(true) {
			try {
				
				System.out.println("Inserisci il num. di porte (max. 6)");
				numeroPorte = input.nextInt();
				
				if(numeroPorte < 7) {
					input.nextLine();
					break;
				}
				else {
					System.out.println("Input errato, inserire un numero min. di 7");
				}
			} catch (Exception e) {
				System.out.println("Input errato");
			}
			}
		
		while(true) {
			try {
				System.out.println("Inserisci il numero di posti a sedere");
				numeroPosti = input.nextInt();

				if(numeroPosti < 10) {
					input.nextLine();
					break;
				}
				else {
					System.out.println("Input errato, inserire un numero min. di 10");
				}
				
			} catch (Exception e) {
				System.out.println("Input errato");
			}
			}
		
		System.out.println("Autovettura registrata con successo!");
		Autovetture auto = new Autovetture(marca, modello, numeroTarga, tariffaGiornaliera, numeroPorte, numeroPosti);
		ListaVeicoli.add(auto);

	}
	
	//registrazione furgone
	public void registrazioneFurgone() {
		
		
		String marca = null;
		String modello = null;
		String numeroTarga = null;
		double tariffaGiornaliera = 0.0;
		int portata = 0;
		int lunghezza = 0;
		int larghezza = 0;
		int altezza = 0;
		
		
		System.out.println("Inserisci la marca:");
		marca = input.nextLine();
		System.out.println("Inserisci il modello");
		modello = input.nextLine();
		
		while(true) {
			System.out.println("Inserisci il numero di targa (es. AB123CD)");
			numeroTarga = input.nextLine();
			
			// Vediamo se la targa rispetta il pattern per la targa (2 lettere, 3 numeri, 2 lettere)
			if (numeroTarga.matches("[A-Z]{2}\\d{3}[A-Z]{2}")) {
	            System.out.println("Targa valida!");
	            break;
	        } else {
	            System.out.println("Targa non valida. Assicurati di inserire il formato corretto.");
	        }
		}
		
		while(true) {
			try {
			
				System.out.println("Inserisci la tariffa giornaliera");
				tariffaGiornaliera = input.nextDouble();
				break;
		}   catch (Exception e) {
			System.out.println("Input errato");
		}
		}
		
		
		while(true) {
			try {
				System.out.println("Inserisci la portata(Max 10000 Kg):");
				portata = input.nextInt();
				if (portata < 10001)
				break;
				else {
					System.out.println("Inserisci una portata max di 10000 Kg");
				}
				
			} catch (Exception e) {
				System.out.println("Input errato");
			}
		}
		
		
		while(true) {
			try {
				System.out.println("Inserisci la lunghezza(max 500 cm):");
				lunghezza = input.nextInt();
				
				if (lunghezza < 501)
				break;
				
				else {
					System.out.println("Inserisci una lunghezza max di 500 cm");
				}

			} catch (Exception e) {
				System.out.println("Input errato");
			}
		}
		
		while(true) {
			try {
				System.out.println("Inserisci la larghezza(max 300 cm):");
				larghezza = input.nextInt();
				
				if (larghezza < 301)
					break;
					
					else {
						System.out.println("Inserisci una lunghezza max di 300 cm");
					}
			} catch (Exception e) {
				System.out.println("Input errato");
			}
		}
		
		while(true) {
			try {
				System.out.println("Inserisci l'altezza(max 300 cm):");
				altezza = input.nextInt();
				if (altezza < 301) {
					input.nextLine();
					break;
				}
					else {
						System.out.println("Inserisci una altezza max di 300 cm");
					}
				
			} catch (Exception e) {
				System.out.println("Input errato");
			}
		}
		
		System.out.println("Furgone registrato con successo");
		Furgoni furgone = new Furgoni(marca, modello, numeroTarga, tariffaGiornaliera, portata, lunghezza,larghezza, altezza);
		ListaVeicoli.add(furgone);

		
	}
	
	//per mostrare gli arraylist
	public void mostraLista() {
		
	    while(true) { 
			System.out.println("Quale lista vuoi mostrare ? ");
			
			if (ListaClienti.isEmpty() && ListaVeicoli.isEmpty() && ListaNoleggi.isEmpty() ) {
		        System.out.println("Nessuna lista presente.");
		        System.out.println("Torno al menu principale");
		        return; // Torna al menu principale
		    }
			
			System.out.println("Digita 1 per mostrare lista Clienti, 2 per mostrare lista Veicoli , 3 per mostrare lista Noleggi,4 per tornare al menu principale");
			
			
			
			String sceltaLista = input.nextLine();
			
			
			if (sceltaLista.equals("1")){

				if (ListaClienti.isEmpty()) {
			        System.out.println("Nessuna lista clienti presente.");
			        mostraLista();}
				
				int id = 1;
				for (Clienti cliente:ListaClienti) {
					System.out.println("Cliente" + " #" +id +" | " + cliente);
					id++;
				}
				
			} else if (sceltaLista.equals("2")){
				
				if (ListaVeicoli.isEmpty()) {
			        System.out.println("Nessuna lista veicoli presente.");
			        mostraLista();}
				
				int id = 1;
				for (Veicoli veicolo:ListaVeicoli) {
					System.out.println("Veicolo" + " #" +id +" | " + veicolo);
					id++;
				}
				
			} else if (sceltaLista.equals("3")){
				
				if (ListaNoleggi.isEmpty()) {
			        System.out.println("Nessuna lista noleggi presente.");
			        mostraLista();}
				
				int id = 1;
				for (Noleggi noleggio:ListaNoleggi) {
					System.out.println("Noleggio" + " #" +id +" | " + noleggio);
					id++;
				}
				
			} 
	
			else if (sceltaLista.equals("4")){
				System.out.println("Sto tornando al menu principale...\n");
				return;
			} else {
				System.out.println("Input errato");
				mostraLista();
			}
		
		
		}
	}
	
}
