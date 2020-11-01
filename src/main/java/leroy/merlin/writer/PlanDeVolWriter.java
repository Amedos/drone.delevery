/**
 * 
 */
package leroy.merlin.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import leroy.merlin.common.Constants;
import leroy.merlin.domain.PlanDeVol;
import leroy.merlin.processor.PlanDeVolProcessor;

/**
 * @author ahsouri
 * @since 01/11/2020
 */
public class PlanDeVolWriter implements Constants {

	/**
	 * 
	 * @param destination
	 */
	public static void main(String... destination) {
		PlanDeVolProcessor planDeVolProcessor = new PlanDeVolProcessor();

		planDeVolProcessor.loadData();
		List<PlanDeVol> planDeVols = planDeVolProcessor.getPlanDeVol();

		/**
		 * Ce plan de vol permet d'affecter les drones par trajet le plus court sans
		 * pris en compte la contrainte du temps
		 */

		try (FileWriter file = writeToCsv(PLAN_DE_VOL_CSV, planDeVols)) {
			planDeVols.stream()
					.forEach(planVol -> System.out
							.println(HEADER + NEW_LINE + planVol.getDroneId() + SEPARATEUR + planVol.getStoreId()
									+ SEPARATEUR + planVol.getProductId() + SEPARATEUR + planVol.getClientId()));
		} catch (Exception e) {
			System.err.print(e);
		}

	}

	/**
	 * 
	 * @param fileName
	 * @param planDeVols
	 * @return
	 * @throws IOException
	 */
	private static FileWriter writeToCsv(String fileName, List<PlanDeVol> planDeVols) throws IOException {
		FileWriter file = new FileWriter(fileName);

		file.append(HEADER);

		file.append(NEW_LINE);

		planDeVols.stream().map(planVol -> {
			try {
				file.append(planVol.getDroneId() + SEPARATEUR);
				file.append(planVol.getStoreId() + SEPARATEUR);
				file.append(planVol.getProductId() + SEPARATEUR);
				file.append(planVol.getClientId());
				file.append(NEW_LINE);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return file;
		}).collect(Collectors.toList());

		return file;
	}

}
