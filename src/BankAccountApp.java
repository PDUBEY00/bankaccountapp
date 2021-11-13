import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import utility.CsvReader;

public class BankAccountApp {

	public static void main(String[] args) throws FileNotFoundException {

		/*Checking checkAccount1 = new Checking("Prateek", "ST123423", 1500);
		Savings saveAccount1 = new Savings("Shubhangi", "ST12328", 500);
		//checkAccount1.showInfo();
		saveAccount1.showInfo();
		saveAccount1.deposit(5000);
		saveAccount1.withdraw(200);
		saveAccount1.transfer("Tom", 300);
		saveAccount1.getBalance();
		saveAccount1.calculateInterest();*/
		List<Account> accountHolders = new LinkedList<>();

		List<String[]> accountData = CsvReader.readCsv(
				"../resource/NewBankAccounts.csv");
		System.out.println("The size of the list is " + accountData.size());
		for (String[] str : accountData) {
			String name = str[0];
			String niNumber = str[1];
			double deposit = Double.parseDouble(str[3]);
			if (str[2].equals("Savings")) {
				accountHolders.add(new Savings(name, niNumber, deposit));
			} else if (str[2].equals("Checking")) {
				accountHolders.add(new Checking(name, niNumber, deposit));
			} else {
				throw new RuntimeException("Invalid Account type");
			}
		}

		for (Account acc : accountHolders) {
			System.out.println("******************" +
									   "\n");
			acc.showInfo();
		}
	}
}
