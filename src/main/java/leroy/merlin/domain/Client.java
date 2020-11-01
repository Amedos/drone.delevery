/**
 * 
 */
package leroy.merlin.domain;

/**
 * @author ahsouri
 *
 */
public class Client extends Point {

	/***/
	private String clientId;

	/***/
	public Client(String clientId, int x, int y) {
		super();
		this.clientId = clientId;
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

}
