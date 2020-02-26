
public class Customer {
	/**
	* Skapar en kund (kontoinnehavare) med namnet ’name’ och id-nummer ’idNr’.
	* Kunden tilldelas också ett unikt kundnummer.
	*/
	private String name;
	private long idNbr;
	private int csNbr;
	private static int internalCustomerNbr = 3141592; //Godtyckligt tal att börja på, ökar med 1 och tillhör klassen. 
	Customer(String name, long idNr){
		this.name = name;
		this.idNbr = idNr;
		this.csNbr = internalCustomerNbr;
		internalCustomerNbr += 1;
		
	}
	/** Tar reda på kundens namn. */
	String getName() {
		return name;
	}
	/** Tar reda på kundens personnummer. */
	long getIdNr() {
		return idNbr;
	}
	/** Tar reda på kundens kundnummer. */
	int getCustomerNr() {
		return csNbr;
	}
	/** Returnerar en strängbeskrivning av kunden. */
	 public String toString() { //Varför ska denna vara public, kolla upp!!!
	return("Kundnamn: " + name +  ", Personnummer: " + idNbr +  ", Kundnummer: " + csNbr);
	//Ny rad på alla värden, snyggare!
	}
	
}
