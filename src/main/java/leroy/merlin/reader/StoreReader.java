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
import leroy.merlin.domain.Store;

/**
 * @author ahsouri
 *
 */
public class StoreReader implements Constants {

	/***/
	private static List<Store> stores = new ArrayList<Store>();

	/**
	 * 
	 * @return
	 */
	public static List<Store> getStores() {
		String line = "";
		int counter = 1;

		try (BufferedReader br = new BufferedReader(new FileReader(STORES_CSV))) {

			while ((line = br.readLine()) != null) {

				if (counter > 1) {
					String[] csvLine = line.split(SEPARATEUR);

					stores.add(new Store(csvLine[0], Integer.valueOf(csvLine[1]), Integer.valueOf(csvLine[2])));
				}

				counter++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return stores;
	}

	/**
	 * 
	 * @param storeId
	 * @return
	 */
	public static Store getStoreById(String storeId) {
		return stores.stream().filter(store -> store.getStoreId().equalsIgnoreCase(storeId)).findFirst().get();
	}
}
