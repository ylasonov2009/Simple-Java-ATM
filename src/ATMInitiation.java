public class ATMInitiation {


	GUI userInterface = new GUI();
	
	
	
	Catalog PC = Factory.getInstanceCatalog();
	
	
	
	ICCAdapter CCAdapter = Factory.getInstanceICCAdapter();

	
	
	Address Location = new Address("Dubai", "AlRab",
			"Asia", "blq blq", 13131);
}
