import java.io.FileNotFoundException;

public class Factory {

	static Factory factoryInstance;
	static ICCAdapter CCAdapter;
	static Catalog PCInstance;

	public static synchronized Factory getInstanceFactory() {
		if (factoryInstance == null)
			factoryInstance = new Factory();
		return factoryInstance;
	}

	public static synchronized Catalog getInstanceCatalog() {
		if (PCInstance == null)
			try {
				PCInstance = new Catalog();
			} catch (FileNotFoundException e) {
				System.out.println("Error!");
				System.exit(0);
			}
		return PCInstance;
	}

	public static synchronized ICCAdapter getInstanceICCAdapter() {
		if (CCAdapter == null) {
			String className;
			try {
				className = System.getProperty("acquiringbank.class.name");
				CCAdapter = (ICCAdapter) Class.forName(className).newInstance();
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				System.out.println("Error!");
				System.exit(0);
			}
		}
		return CCAdapter;
	}

}
