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
			int val = sc.nextInt();
			switch (val) {
			case 1:
				byHolder(sc, bank);
				break;

			case 2:
				byPartOfName(sc, bank);
				break;

			case 3:

				break;

			case 4:

				break;

			case 5:

				break;

			case 6:
				addAccount(sc, bank);
				break;

			case 7:

				break;

			case 8:
				ArrayList<BankAccount> all = bank.getAllAccounts();
				for(BankAccount b: all) {
					System.out.println(b.toString());
				}
				break;

			case 9:
				running = false;
				break;

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
		for(BankAccount b: byHolder) {
			System.out.println(b.toString());
		}
	}
	static void byPartOfName(Scanner sc, Bank bank) {
		System.out.println("Sökterm: ");
		sc.nextLine();
		String part = sc.nextLine();
		ArrayList<Customer> byHolder = bank.findByPartofName(part);
		for(Customer b: byHolder) {
			System.out.println(b.toString());
		}
	}
}