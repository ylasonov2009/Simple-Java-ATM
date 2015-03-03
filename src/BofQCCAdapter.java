import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class BofQCCAdapter implements ICCAdapter {

	private String Name;
	private String CCN;
	private int CVN;
	private String ExpDate;
	private Sale sale;
	Scanner kb = new Scanner(System.in);

	public BofQCCAdapter() {
		System.out.println("Bank of Qatar");
	}

	private void getCustomerName() {
		System.out.print("Enter Name on Credit Card: ");
		this.Name = this.kb.nextLine();
	}

	private void getCCN() {
		do {
			System.out.println("Enter Credit Card Number");
			this.CCN = this.kb.nextLine();

			if (this.CCN.length() != 19)
				System.out
						.println("Credit Card Number entered is incorect");

		} while (this.CCN.length() != 19);
	}

	private void getCVN() {
		do {
			try {
				System.out.print("Enter CVN: ");
				this.CVN = this.kb.nextInt();
			} catch (InputMismatchException e) {
				this.CVN = 0;
			}

			if (this.CVN < 100 || this.CVN > 999)
				System.out.println("CVN is not valid, it is 3 digits long");

		} while (this.CVN < 100 || this.CVN > 999);
		this.kb.nextLine();
	}

	private boolean checkFormatt() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH);

		if (this.ExpDate.length() != 7)
			return false;
		if (this.ExpDate.lastIndexOf('/') != 2)
			return false;
		if (Integer.parseInt(this.ExpDate.substring(0, 2)) > 12)
			return false;
		if (Integer.parseInt(this.ExpDate.substring(0, 2)) < 1)
			return false;
		if (Integer.parseInt(this.ExpDate.substring(0, 2)) < month)
			return false;
		if (Integer.parseInt(this.ExpDate.substring(3, 7)) < year)
			return false;
		return true;
	}

	private void getExpirationDate() {
		do {
			System.out.println("Enter Credit Card Expiration Date (MM/YYYY):");
			this.ExpDate = this.kb.nextLine();

			if (!this.checkFormatt())
				System.out.println("Incorret Format");

		} while (this.ExpDate.length() != 7);
	}


	@Override
	public void getCreditInfo() {
		this.getCustomerName();
		this.getCCN();
		this.getCVN();
		this.getExpirationDate();
	}

	@Override
	public void getSaleInfo(Sale sale) {
		this.sale = sale;

	}

	@Override
	public void passToBank() {
		System.out.printf(
				"Sending Info to Bank: CCN: xxxx-xxxx-xxxx-%s | Amount: $%.2f",
				this.CCN.substring(15, 19), this.sale.getCreditPayement()
						.getTotal());
	}

	@Override
	public String getName() {
		return this.Name;
	}

	@Override
	public boolean validate() {
		Random rng = new Random();
		if (rng.nextInt() % 10 < 7)
			return true;
		return false;
	}
}
