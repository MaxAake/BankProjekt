import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Bank bank = new Bank();
		runApplication(sc, bank);

	}

	static void runApplication(Scanner sc, Bank bank) {
		boolean running = true;
		while (running) {
			System.out.println(" 1. Hitta konto utifrån innehavare \n 2. Sök kontoinnehavare utifrån (del av) namn \n "
					+ "3. Sätt in \n 4. Ta ut \n 5. Överföring \n 6. Skapa konto \n 7. Ta bort konto \n "
					+ "8. Skriv ut konton \n 9. Avsluta");
			int val;
			try {
				val = sc.nextInt();
			} 
			catch (Exception e) {
				val = 10;
				sc.nextLine();
			}
				switch (val) {
				case 1:
					byHolder(sc, bank);
					break;

				case 2:
					byPartOfName(sc, bank);
					break;

				case 3:
					deposit(sc, bank);
					break;

				case 4:
					withdraw(sc, bank);
					break;

				case 5:
					transaction(sc, bank);
					break;

				case 6:
					addAccount(sc, bank);
					break;

				case 7:
					remove(sc, bank);
					break;

				case 8:
					ArrayList<BankAccount> all = bank.getAllAccounts();
					if (all == null) {
						break;
					}
					for (BankAccount b : all) {
						System.out.println(b.toString());
					}
					break;

				case 9:
					running = false;
					break;
				default:
					System.err.println("Fel input");

				}
			
		}
	}

	static void addAccount(Scanner sc, Bank bank) {
		System.out.println("Name: ");
		sc.nextLine();
		String holderName = sc.nextLine();
		System.out.println("ID Nummer: ");
		long idNr = sc.nextInt();
		System.out.println("Kontonummer: " + bank.addAccount(holderName, idNr));
	}

	static void byHolder(Scanner sc, Bank bank) {
		System.out.println("Id Nummer: ");
		long idNr = sc.nextLong();
		ArrayList<BankAccount> byHolder = bank.findAccountsForHolder(idNr);
		for (BankAccount b : byHolder) {
			System.out.println(b.toString());
		}
	}

	static void byPartOfName(Scanner sc, Bank bank) {
		System.out.println("Sökterm: ");
		sc.nextLine();
		String part = sc.nextLine();
		ArrayList<Customer> byHolder = bank.findByPartofName(part);
		for (Customer b : byHolder) {
			System.out.println(b.toString());
		}
	}

	static void withdraw(Scanner sc, Bank bank) {

		System.out.println("Kontonummer: ");
		int nr = sc.nextInt();
		System.out.println("Hur mycket? ");
		double val = sc.nextDouble();
		if (bank.findByNumber(nr) == null) {
			System.err.println("kontot finns ej");
		} else if (bank.findByNumber(nr).getAmount() >= val) {
			bank.findByNumber(nr).withdraw(val);
		} else {
			System.err.println("Insufficient funds");
		}
	}

	static void deposit(Scanner sc, Bank bank) {
		System.out.println("Kontonummer: ");
		int nr = sc.nextInt();
		System.out.println("Hur mycket? ");
		double val = sc.nextDouble();
		if (val < 0) {
			System.err.println("Inga negativa belopp");
		} else if (bank.findByNumber(nr) == null) {
			System.err.println("kontot finns ej");
		} else {
			bank.findByNumber(nr).deposit(val);
		}
	}

	static void transaction(Scanner sc, Bank bank) {

		System.out.println("Kontonummer från: ");
		int nr1 = sc.nextInt();
		System.out.println("Kontonummer till: ");
		int nr2 = sc.nextInt();
		System.out.println("Hur mycket? ");
		double val = sc.nextDouble();
		if (val < 0) {
			System.err.println("Inga negativa belopp");
		} else if (bank.findByNumber(nr1) == null) {
			System.err.println("sändarkontot finns ej");
		} else if (bank.findByNumber(nr2) == null) {
			System.err.println("mottagarkontot finns ej");
		} else {
			if (bank.findByNumber(nr1).getAmount() >= val) {
				bank.findByNumber(nr1).withdraw(val);
				bank.findByNumber(nr2).deposit(val);
			} else {
				System.err.println("Insufficient funds");
			}
		}
	}

	static void remove(Scanner sc, Bank bank) {
		System.out.println("Kontonummer: ");
		int nr = sc.nextInt();
		bank.removeAccount(nr);
	}
}