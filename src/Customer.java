
public class Customer {
	/**
	* Skapar en kund (kontoinnehavare) med namnet ’name’ och id-nummer ’idNr’.
	* Kunden tilldelas också ett unikt kundnummer.
	*/
	String name;
	long idNr;
	Customer(String name, long idNr){
		this.name = name;
		this.idNr = idNr;
	}
	/** Tar reda på kundens namn. */
	String getName() {
		return name;
	}
	/** Tar reda på kundens personnummer. */
	long getIdNr() {
		return idNr;
	}
	/** Tar reda på kundens kundnummer. */
	int getCustomerNr() {
		
	}
	/** Returnerar en strängbeskrivning av kunden. */
	String toString() {
		
	}
}
