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
import leroy.merlin.domain.Client;
import leroy.merlin.domain.Commande;
import leroy.merlin.domain.ProduitCommande;

/**
 * @author ahsouri
 *
 */
public class CommandeReader implements Constants {

	/***/
	private static List<Commande> commandes = new ArrayList<Commande>();

	/**
	 * 
	 * @return
	 */
	public static List<Commande> getCommandes() {

		String line = "";

		int counter = 1;

		try (BufferedReader br = new BufferedReader(new FileReader(COMMANDES_CSV))) {

			while ((line = br.readLine()) != null) {

				if (counter > 1) {

					String[] csvLine = line.split(SEPARATEUR);

					if ((csvLine.length - 2) % 2 == 0) {

						int nombreProduit = (csvLine.length - 2) / 2;

						List<ProduitCommande> produits = getProduitCommande(csvLine, nombreProduit);

						Client client = getClient(csvLine[1]);

						commandes.add(new Commande(csvLine[0], client, produits));

					} else
						try {
							throw new Exception("Erreur dans la ligne du commande " + csvLine[0]);
						} catch (Exception e) {
							e.printStackTrace();
						}
				}

				counter++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return commandes;
	}

	/**
	 * 
	 * @param csvColonne
	 * @param nombreStock
	 * @return
	 */
	private static List<ProduitCommande> getProduitCommande(String[] csvColonne, int nombreStock) {
		List<ProduitCommande> produitCommande = new ArrayList<ProduitCommande>();
		if (ProduitReader.getProduits().size() != 0) {
			for (int step = 1; step < nombreStock + 1; step++) {
				produitCommande.add(new ProduitCommande(ProduitReader.getProduitById(csvColonne[step * 2]),
						Integer.valueOf(csvColonne[1 + step * 2])));
			}
		}
		return produitCommande;
	}

	/**
	 * 
	 * @param clientId
	 * @return
	 */
	private static Client getClient(String clientId) {
		return ClientReader.getClientById(clientId);
	}
}
