
public class BankAccount {
	/**
	* Skapar ett nytt bankkonto åt en innehavare med namn ’holderName’ och
	* id ’holderId’. Kontot tilldelas ett unikt kontonummer och innehåller
	* inledningsvis 0 kr.
	*/
	double amount;
	Customer holder;
	int accountNumber;
	BankAccount(String holderName, long holderId){
		amount = 0;
		holder = new Customer(holderName, holderId);
	}
	/**
	* Skapar ett nytt bankkonto med innehavare ’holder’. Kontot tilldelas
	* ett unikt kontonummer och innehåller inledningsvis 0 kr.
	*/
	BankAccount(Customer holder){
		amount = 0;
		this.holder = holder;
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
	String toString() {
		return ("Konto " + accountNumber + " (" + holder.toString + "): " + amount);
	}
}
