/**
 * 
 */
package leroy.merlin.domain;

/**
 * @author ahsouri
 *
 */
public class Drone extends Point {

	/***/
	private String droneId;

	/***/
	private double autonomie = 100;

	/***/
	public Drone(String droneId, int x, int y) {
		super();
		this.droneId = droneId;
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the droneId
	 */
	public String getDroneId() {
		return droneId;
	}

	/**
	 * @return the autonomie
	 */
	public double getAutonomie() {
		return autonomie;
	}

	/**
	 * @param autonomie the autonomie to set
	 */
	public void setAutonomie(double autonomie) {
		this.autonomie = autonomie;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void setDroneCoordonnées(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

}
