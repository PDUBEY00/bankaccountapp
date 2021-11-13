public class Checking extends Account {

	private int debitCardNumber;
	private int debitCardPin;

	public Checking(String name, String niNumber, double initDeposit) {
		super(name, niNumber, 1500);
		accountNumber = "1" + accountNumber;
		checkingCardDetails();
		setBaseRate();
	}

	@Override
	public void setBaseRate() {
		rate = getRate() * .15;
	}

	private void checkingCardDetails() {
		this.debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
		this.debitCardPin = (int) (Math.random() * Math.pow(10, 4));

	}

	public void showInfo() {
		super.showInfo();
		System.out.println(" Your Checking account features :" +
								   "\ndebit card number : " + debitCardNumber +
								   "\ndebit card pin Key : " + debitCardPin +
								   "\nRate for checkin " + rate);
	}

}
