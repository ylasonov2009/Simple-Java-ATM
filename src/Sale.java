import java.util.Date;

public class Sale {
	private Date saleDate;
	private SalesLineItem SLI;
	private CreditPayment credit;

	public Sale(ICCAdapter bank) {
		this.saleDate = new Date();
		this.credit = new CreditPayment(bank);
	}

	public void makeLineItem(int ID) {
		this.SLI = new SalesLineItem(ID);
		this.credit.setTotal(this.SLI.getWeight() * 1160.86);
	}

	public boolean madeSale() {
		if (!this.credit.validate())
			System.out.println("Credit Card denied");
		return this.credit.validate();
	}

	public Date getSaleDate() {
		return this.saleDate;
	}

	public SalesLineItem getSalesLineItem() {
		return this.SLI;
	}

	public CreditPayment getCreditPayement() {
		return this.credit;
	}

}
