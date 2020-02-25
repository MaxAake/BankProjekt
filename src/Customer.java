
public class Customer {
	/**
	* Skapar en kund (kontoinnehavare) med namnet ’name’ och id-nummer ’idNr’.
	* Kunden tilldelas också ett unikt kundnummer.
	*/
	String name;
	long idNbr;
	int csNbr;
	static int internalAccountNbr = 3141592;
	Customer(String name, long idNr){
		this.name = name;
		this.idNbr = idNr;
		this.csNbr = internalAccountNbr;
		newAcc();
		
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
	return("Kundnamn: " + name + "\n" + "Personnummer: " + idNbr + "\n" + "Kundnummer: " + csNbr);

	}
	 
	 public void newAcc() {
		 internalAccountNbr +=1;
	 }

	
}
