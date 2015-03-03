import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;











public class GUI {
	public void printStockMessageOut() {
		System.out
				.println("Items out of stock.");
		System.exit(0);
	}

	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings({ "resource" })
	public int enterItem(Catalog PC) {

		Scanner sc = new Scanner(System.in);
		int temp = -1;

		System.out.print("Choose your desired item: ");

		try {
			temp = sc.nextInt();
		} catch (InputMismatchException e) {
			temp = -1;
		}
		do {
			if (PC.getDescription(temp) != null && PC.getQuantity(temp) > 0)
				break;

			System.out
					.println("Product ID error!");
			System.out.print("Item ID: ");

			try {
				temp = sc.nextInt();
			} catch (InputMismatchException e) {
				temp = -1;
				sc.nextLine();
			}
		} while (true);

		System.out.println();
		return temp;
	}

	
	
	
	
	
	
	
	
	
	
	public void ShowCatalog(Catalog PC) {
		System.out
				.println("Welcome to the Gold ATM!");
		for (Map.Entry<Integer, Description> entry : PC.Products
				.entrySet()) {
			System.out.printf("Item : %01d", entry.getKey());
			System.out.printf(" -> Weight  : %.1f oz(s)", entry.getValue()
					.getWeight());

			if (entry.getValue().getAmount() > 0)
				System.out.printf(" | Available: %-5d", entry
						.getValue().getAmount());
			else
				System.out.printf(" |  Out of Stock\n");

			System.out.printf(" | Description:%s\n", entry.getValue()
					.getDescription());
		}
	}

	public String showLocation(Address l) {
		return l.Street + "\n                  " + l.Country + ": " + l.City
				+ ", " + l.State + " " + l.ZIP;
	}

	
	
	
	
	
	
	
	
	
	public void makeReceipt(Receipt r, Address l, String name) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");
		System.out.println("\n====================:");
		
		System.out.println("\nReceipt:");
		
		System.out.printf("Time of Sale: %s\n",
				dateFormat.format(r.sale.getSaleDate()));
		System.out.printf("Customer Name: %s\n", name);
		System.out.printf("Weight: %.1f  oz(s)\n",
				r.sale.getSalesLineItem().product.getWeight());
		System.out.printf("Description:%s\n",
				r.sale.getSalesLineItem().product.getDescription());

		System.out.printf("Total: $%.2f + TAX\n", r.sale.getCreditPayement()
				.getTotal());
		System.out.printf("Payment Type: %s\n", r.PaymentType);
		System.out.println("\n====================");
	}

}
