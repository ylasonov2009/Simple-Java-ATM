public class Receipt {
	Sale sale;
	ATM atm;
	String PaymentType;

	public Receipt(Sale sale, ATM atm, String PaymentType) {
		this.sale = sale;
		this.atm = atm;
		this.PaymentType = PaymentType;
	}
}
