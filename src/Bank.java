import java.util.ArrayList;


public class Bank {
	/** Skapar en ny bank utan konton. */
	ArrayList<BankAccount> accs;
	Bank(){
		accs = new ArrayList<BankAccount>();
	}
	/**
	* Öppna ett nytt konto i banken. Om det redan finns en kontoinnehavare
	* med de givna uppgifterna ska inte en ny Customer skapas, utan istället
	* den befintliga användas. Det nya kontonumret returneras.
	*/
	int addAccount(String holderName, long idNr) {
		Customer holder = findHolder(idNr);
		if(holder != null) {
			accs.add(new BankAccount(holder));
		}
		else {
			accs.add(new BankAccount(holderName, idNr));
		}
		int newAcc = accs.get(accs.size()-1).accountNumber;
		return newAcc;
	}
	/**
	* Returnerar den kontoinnehavaren som har det givna id-numret,
	* eller null om ingen sådan finns.
	*/
	Customer findHolder(long idNr) {
		for(int i = 0; i<accs.size();i++){
			if(accs.get(i).getHolder().getIdNr() == idNr) {
				return accs.get(i).getHolder();
			}
		}
		return null;
	}
	/**
	* Tar bort konto med nummer ’number’ från banken. Returnerar true om
	* kontot fanns (och kunde tas bort), annars false.
	*/
	boolean removeAccount(int number) {
		for(int i = 0; i<accs.size();i++){
			if(accs.get(i).getAccountNumber() == number) {
				accs.remove(i);
				return true;
			}
		}
		return false;
	}
	/**
	* Returnerar en lista innehållande samtliga bankkonton i banken.
	* Listan är sorterad på kontoinnehavarnas namn.
	*/
	ArrayList<BankAccount> getAllAccounts(){
		ArrayList<BankAccount> output = new ArrayList<BankAccount>();
		ArrayList<BankAccount> unsorted = new ArrayList<BankAccount>(accs);
		while(unsorted.size() > 1) {
			int smallest = 0;
			for(int i = 1; i < unsorted.size(); i++) {
				if(comparison(unsorted.get(i), unsorted.get(smallest)) < 0){
					smallest = i;
				}
			}
			output.add(unsorted.get(smallest));
			unsorted.remove(smallest);
		}
		output.add(unsorted.get(0));
		return output;
	}
	static int comparison(BankAccount a, BankAccount b) {
		return a.getHolder().getName().toLowerCase().compareTo(b.getHolder().getName().toLowerCase());
	}
	/**
	* Söker upp och returnerar bankkontot med kontonummer ’accountNumber’.
	* Returnerar null om inget sådant konto finns.
	*/
	BankAccount findByNumber(int accountNumber) {
		for(int i = 0; i<accs.size();i++){
			if(accs.get(i).getAccountNumber() == accountNumber) {
				return accs.get(i);
			}
		}
		return null;
	}
	/**
	* Söker upp alla bankkonton som innehas av kunden med id-nummer ’idNr’.
	* Kontona returneras i en lista. Kunderna antas ha unika id-nummer.
	*/
	ArrayList<BankAccount> findAccountsForHolder(long idNr){
		ArrayList<BankAccount> holderAccs = new ArrayList<BankAccount>();
		for(int i = 0; i<accs.size();i++){
			if(accs.get(i).getHolder().getIdNr() == idNr) {
				holderAccs.add(accs.get(i));
			}
		}
		return holderAccs;
	}
	/**
	* Söker upp kunder utifrån en sökning på namn eller del av namn. Alla
	* personer vars namn innehåller strängen ’namePart’ inkluderas i
	* resultatet, som returneras som en lista. Samma person kan förekomma
	* flera gånger i resultatet. Sökningen är "case insensitive", det vill
	* säga gör ingen skillnad på stora och små bokstäver.
	*/
	ArrayList<Customer> findByPartofName(String namePart){
		ArrayList<Customer> holderAccs = new ArrayList<Customer>();
		for(int i = 0; i<accs.size();i++){
			if(accs.get(i).getHolder().getName().toLowerCase().contains(namePart.toLowerCase())) {
				holderAccs.add(accs.get(i).getHolder());
			}
		}
		return holderAccs;
	}
}
