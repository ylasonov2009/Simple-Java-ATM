import java.util.Scanner;

public interface ICCAdapter {

	String Name = null;
	String CCN = null;
	int CVN = 0;
	String ExpDate = null;
	Sale sale = null;
	Scanner kb = null;

	public void getCreditInfo();

	public void getSaleInfo(Sale sale);

	public void passToBank();

	public String getName();

	public boolean validate();
}
