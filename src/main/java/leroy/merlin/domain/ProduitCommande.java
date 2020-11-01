/**
 * 
 */
package leroy.merlin.domain;

/**
 * @author ahsouri
 *
 */
public class ProduitCommande {

	/***/
	private Produit produit;
	/***/
	private int quantity;

	/**
	 * @param produit
	 * @param quantity
	 */
	public ProduitCommande(Produit produit, int quantity) {
		super();
		this.produit = produit;
		this.quantity = quantity;
	}

	/**
	 * @return the produit
	 */
	public Produit getProduit() {
		return produit;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

}
