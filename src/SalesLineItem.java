public class SalesLineItem {
	Description product;
	Catalog catalog;

	public SalesLineItem(int ID) {
		this.catalog = Factory.getInstanceCatalog();
		this.product = catalog.getDescription(ID);
	}

	public double getWeight() {
		return this.product.getWeight();
	}
}
