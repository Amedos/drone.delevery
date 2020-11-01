/**
 * 
 */
package leroy.merlin.common;

import leroy.merlin.domain.Client;
import leroy.merlin.domain.Drone;
import leroy.merlin.domain.Point;
import leroy.merlin.domain.Stock;

/**
 * @author ahsouri
 *
 */
public class CalculeUtil {
	/**
	 * 
	 * @param depart
	 * @param destination
	 * @return
	 */
	private static double calculeDistance(Point depart, Point destination) {
		return (double) Math.sqrt(
				Math.pow(destination.getX() - depart.getX(), 2) + Math.pow(destination.getY() - depart.getY(), 2));
	}

	/**
	 * 
	 * @param drone
	 * @param stock
	 * @param client
	 * @return
	 */
	public static double getTrajet(Drone drone, Stock stock, Client client) {
		return calculeDistance(drone, stock.getStore()) + calculeDistance(stock.getStore(), client);
	}
}
