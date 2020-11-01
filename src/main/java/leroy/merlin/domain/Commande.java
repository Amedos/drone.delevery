/**
 * 
 */
package leroy.merlin.domain;

import java.util.List;

/**
 * @author ahsouri
 *
 */
public class Commande {

	/***/
	private String orderId;
	/***/
	private Client client;
	/***/
	private List<ProduitCommande> produitsCommande;

	/**
	 * @param orderId
	 * @param client
	 * @param produitCommande
	 */
	public Commande(String orderId, Client client, List<ProduitCommande> produitsCommande) {
		super();
		this.orderId = orderId;
		this.client = client;
		this.produitsCommande = produitsCommande;
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @return the produitCommande
	 */
	public List<ProduitCommande> getProduitsCommande() {
		return produitsCommande;
	}
}
