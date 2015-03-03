import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Catalog {

	Map<Integer, Description> Products;
	public Description getDescription(int ID) {
		if (this.Products.containsKey(ID))
			return this.Products.get(ID);
		return null;
	}
	public Catalog() throws FileNotFoundException {
		this.Products = new HashMap<Integer, Description>();
		this.read();
	}



	public int getQuantity(int ID) {
		if (this.Products.containsKey(ID))
			return this.Products.get(ID).getAmount();
		return -1;
	}

	public void madeSale(int ID) {
		this.Products.get(ID).setAmount(this.Products.get(ID).getAmount() - 1);
	}

	public boolean hasStock() {
		for (Map.Entry<Integer, Description> entry : this.Products
				.entrySet())
			if (entry.getValue().getAmount() > 0)
				return true;
		return false;
	}

	public void update() {
		this.write();
	}

	private void read() {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("Stock.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Stock File NOT Found");
			System.exit(0);
		}

		while (sc.hasNext()) {
			int id = sc.nextInt();
			double weight = sc.nextDouble();
			int amount = sc.nextInt();
			String desc = sc.nextLine();
			Description temp = new Description(id, weight,amount, desc);
			this.Products.put(temp.getID(), temp);
		}

		sc.close();
	}

	private void write() {
		File cat = new File("Stock.txt");
		cat.delete();
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("Stock.txt", "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			System.out.println("ERROR: Stock File NOT Found");
			System.exit(0);
		}

		for (Map.Entry<Integer, Description> entry : this.Products
				.entrySet()) {
			writer.print((int) entry.getKey() + " ");
			writer.print(entry.getValue().getWeight() + " ");
			writer.print((int) entry.getValue().getAmount() + " ");
			writer.print(entry.getValue().getDescription());
			writer.println();
		}
		writer.close();
	}
}
