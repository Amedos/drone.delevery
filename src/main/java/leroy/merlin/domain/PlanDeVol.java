/**
 * 
 */
package leroy.merlin.domain;

/**
 * @author ahsouri
 *
 */
public class PlanDeVol {

	/***/
	private String droneId;
	/***/
	private String storeId;
	/***/
	private String productId;
	/***/
	private String clientId;

	/**
	 * @param droneId
	 * @param storeId
	 * @param productId
	 * @param clientId
	 */
	public PlanDeVol(String droneId, String storeId, String productId, String clientId) {
		super();
		this.droneId = droneId;
		this.storeId = storeId;
		this.productId = productId;
		this.clientId = clientId;
	}

	/**
	 * @return the droneId
	 */
	public String getDroneId() {
		return droneId;
	}

	/**
	 * @return the storeId
	 */
	public String getStoreId() {
		return storeId;
	}

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	@Override
	public String toString() {
		return "PlanDeVol [droneId=" + droneId + ", storeId=" + storeId + ", productId=" + productId + ", clientId="
				+ clientId + "]";
	}

}
