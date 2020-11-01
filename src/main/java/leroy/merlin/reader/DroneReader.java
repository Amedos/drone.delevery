/**
 * 
 */
package leroy.merlin.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import leroy.merlin.common.Constants;
import leroy.merlin.domain.Drone;

/**
 * @author ahsouri
 *
 */
public class DroneReader implements Constants {

	/***/
	private static List<Drone> drones = new ArrayList<Drone>();

	/***/
	public static List<Drone> getDrones() {
		String line = "";
		int counter = 1;

		try (BufferedReader br = new BufferedReader(new FileReader(DRONES_CSV))) {

			while ((line = br.readLine()) != null) {

				if (counter > 1) {

					String[] csvLine = line.split(SEPARATEUR);

					drones.add(new Drone(csvLine[0], Integer.valueOf(csvLine[1]), Integer.valueOf(csvLine[2])));
				}

				counter++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return drones;
	}
}
