
public class BankAccount {
	/**
	* Skapar ett nytt bankkonto åt en innehavare med namn ’holderName’ och
	* id ’holderId’. Kontot tilldelas ett unikt kontonummer och innehåller
	* inledningsvis 0 kr.
	*/
	double amount;
	Customer holder;
	int accountNumber;
	static int internalAccountNumber = 1001;
	BankAccount(String holderName, long holderId){
		amount = 0;
		holder = new Customer(holderName, holderId);
		this.accountNumber = internalAccountNumber;
		internalAccountNumber += 1;
	}
	/**
	* Skapar ett nytt bankkonto med innehavare ’holder’. Kontot tilldelas
	* ett unikt kontonummer och innehåller inledningsvis 0 kr.
	*/
	BankAccount(Customer holder){
		amount = 0;
		this.holder = holder;
		this.accountNumber = internalAccountNumber;
		internalAccountNumber += 1;
	}
	/** Tar reda på kontots innehavare. */
	Customer getHolder() {
		return holder;
		
	}
	/** Tar reda på det kontonummer som identifierar detta konto. */
	int getAccountNumber() {
		return accountNumber;
		
	}
	/** Tar reda på hur mycket pengar som finns på kontot. */
	double getAmount() {
		return amount;
	}
	/** Sätter in beloppet ’amount’ på kontot. */
	void deposit(double amount) {
		this.amount += amount;
	}
	/**
	* Tar ut beloppet ’amount’ från kontot. Om kontot saknar täckning
	* blir saldot negativt.
	*/
	void withdraw(double amount) {
		this.amount -= amount;
	}
/** Returnerar en strängrepresentation av bankkontot. */
	public String toString() { //Varför public???
		return ("Konto " + accountNumber + " (" + holder.toString() + "): Saldo: " + amount);
	}
}
