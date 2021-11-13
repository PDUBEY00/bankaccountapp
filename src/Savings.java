public class Savings extends Account {

	private int safetyBoxId;
	private int safetyDepositBoxKey;

	public Savings(String name, String niNumber, double initDeposit) {
		super(name, niNumber, initDeposit);
		accountNumber = "2" + accountNumber;
		setSafetyBoxDetails();
		setBaseRate();
	}

	@Override
	public void setBaseRate() {
		rate = getRate() - .25;
	}

	public void showInfo() {
		super.showInfo();
		System.out.println(" Your Saving account features :" +
								   "\nSafety box id : " + safetyBoxId +
								   "\nSafetyBox Key : " + safetyDepositBoxKey +
								   "\nRate for savings " + rate);

	}

	private void setSafetyBoxDetails() {
		safetyBoxId = (int) (Math.random() * Math.pow(10, 3));
		safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
	}

}
