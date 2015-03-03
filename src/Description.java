public class Description {
	private int PID;
	private double weight;
	private int amount;
	private String description;

	public int getID() {
		return this.PID;
	}

	public double getWeight() {
		return this.weight;
	}

	public int getAmount() {
		return this.amount;
	}

	public String getDescription() {
		return this.description;
	}

	public void setAmount(int i) {
		this.amount = i;
	}
	
	public Description(int ID, double weight, int amount,
			String description) {
		this.PID = ID;
		this.weight = weight;
		this.amount = amount;
		this.description = description;
	}
}
