/**
 * 
 */
package leroy.merlin.domain;

import java.util.List;

/**
 * @author ahsouri
 *
 */
public class Produit {

	/***/
	private String productId;
	/***/
	private String name;
	/***/
	private List<Stock> stock;

	/**
	 * @param productId
	 * @param name
	 * @param produitStored
	 */
	public Produit(String productId, String name, List<Stock> stock) {
		super();
		this.productId = productId;
		this.name = name;
		this.stock = stock;
	}

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the stock
	 */
	public List<Stock> getStock() {
		return stock;
	}

}
