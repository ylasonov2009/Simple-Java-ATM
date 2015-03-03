public class CreditPayment {
	private double total;
	ICCAdapter bank;

	private boolean validated = false;
	private boolean realValid = false;

	public CreditPayment(ICCAdapter bank) {
		this.bank = bank;
	}

	public CreditPayment(double total, ICCAdapter bank) {
		this.setTotal(total);
		this.bank = bank;
	}
	public boolean validate() {
		if (!this.validated) {
			this.realValid = bank.validate();
			this.validated = true;
		}
		return this.realValid;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
