public class ATM {
	ATMInitiation Info;

	public ATM() {
		this.Info = new ATMInitiation();
	}

	
	public void makeSale() {
		while (this.Info.PC.hasStock()) {

			this.Info.userInterface.ShowCatalog(this.Info.PC);
			int selected = this.Info.userInterface.enterItem(this.Info.PC);

			Sale sale = new Sale(this.Info.CCAdapter);
			sale.makeLineItem(selected);

			this.Info.CCAdapter.getCreditInfo();
			this.Info.CCAdapter.getSaleInfo(sale);

			System.out.println();

			if (sale.madeSale()) {
				this.Info.PC.madeSale(selected);
				this.Info.CCAdapter.passToBank();
				System.out.println();

				Receipt r = new Receipt(sale, this, "Credit Card");
				this.Info.userInterface.makeReceipt(r, this.Info.Location,
						this.Info.CCAdapter.getName());
			}
			System.out
					.println("\n_________________\nNext Sale\n_________________\n");
		}

		this.Info.userInterface.printStockMessageOut();
	}

	public static void main(String[] args) {
		ATM main = new ATM();
		main.makeSale();
	}
}
