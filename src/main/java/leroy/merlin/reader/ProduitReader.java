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
import leroy.merlin.domain.Produit;
import leroy.merlin.domain.Stock;

/**
 * @author ahsouri
 *
 */
public class ProduitReader implements Constants {

	/***/
	private static List<Produit> produits = new ArrayList<Produit>();

	/**
	 * 
	 * @return
	 */
	public static List<Produit> getProduits() {
		String line = "";
		int counter = 1;

		try (BufferedReader br = new BufferedReader(new FileReader(PRODUITS_CSV))) {

			while ((line = br.readLine()) != null) {

				if (counter > 1) {

					String[] csvLine = line.split(SEPARATEUR);

					/** On suppose qu'on a toujours store + quantité dans le fichier csv */
					if ((csvLine.length - 2) % 2 == 0) {

						int nombreStock = (csvLine.length - 2) / 2;

						List<Stock> stocks = getStocks(csvLine, nombreStock);

						produits.add(new Produit(csvLine[0], csvLine[1], stocks));

					} else
						try {
							throw new Exception("Erreur dans la ligne du produit " + csvLine[0]);
						} catch (Exception e) {
							e.printStackTrace();
						}
				}

				counter++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return produits;
	}

	/**
	 * 
	 * @param csvColonne
	 * @param nombreStock
	 * @return
	 */
	private static List<Stock> getStocks(String[] csvColonne, int nombreStock) {
		List<Stock> stocks = new ArrayList<Stock>();
		for (int step = 1; step < nombreStock + 1; step++) {
			stocks.add(new Stock(StoreReader.getStoreById(csvColonne[step * 2]),
					Integer.valueOf(csvColonne[1 + step * 2])));
		}
		return stocks;
	}

	/**
	 * 
	 * @param produiId
	 * @return
	 */
	public static Produit getProduitById(String produiId) {
		return produits.stream().filter(produit -> produit.getProductId().equalsIgnoreCase(produiId)).findFirst().get();
	}
}
