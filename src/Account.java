public abstract class Account implements IRate {

	private static int counterNum = 10000;
	private String name;
	private String niNumber;
	private double balance;
	protected String accountNumber;
	protected double rate;

	public Account(String name, String niNumber, double initDeposit) {
		this.name = name;
		this.niNumber = niNumber;
		this.balance = initDeposit;
		this.accountNumber = setAccountNumber();
		counterNum++;
	}

	private String setAccountNumber() {
		String lastTwoDigit = this.niNumber.substring(niNumber.length() - 2);
		int uniqueNum = counterNum;
		int randNum = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoDigit + uniqueNum + randNum;
	}

	public abstract void setBaseRate();

	public void deposit(double amount) {
		balance = balance + amount;
	}

	public void withdraw(double amount) {
		balance = balance - amount;
	}

	public void transfer(String whereTo, double amount) {
		balance = balance - amount;
		System.out.println("£" + amount + " is transferred to " + whereTo);
	}

	public void getBalance() {
		System.out.println("The balance is £" + balance);
	}

	public void calculateInterest() {
		double accruedInterestMoney = balance * rate / 100;
		System.out.println("Interest Money is £" + accruedInterestMoney);
		balance = balance + accruedInterestMoney;
		System.out.println("Balance after Interest £" + balance);
	}

	public void showInfo() {
		System.out.println("Name : " + this.name +
								   "\nAccount number : " + this.accountNumber +
								   "\nBalance : " + this.balance);
	}

}
