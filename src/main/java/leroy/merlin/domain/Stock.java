/**
 * 
 */
package leroy.merlin.domain;

/**
 * @author ahsouri
 *
 */
public class Stock {
	/***/
	private Store store;
	/***/
	private int quantity;

	/**
	 * @param store
	 * @param quantity
	 */
	public Stock(Store store, int quantity) {
		super();
		this.store = store;
		this.quantity = quantity;
	}

	/**
	 * @return the store
	 */
	public Store getStore() {
		return store;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
