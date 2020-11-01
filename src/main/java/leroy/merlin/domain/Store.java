/**
 * 
 */
package leroy.merlin.domain;

/**
 * @author ahsouri
 *
 */
public class Store extends Point {

	/***/
	private String storeId;

	/***/
	public Store(String storeId, int x, int y) {
		super();
		this.storeId = storeId;
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the storeId
	 */
	public String getStoreId() {
		return storeId;
	}

}
