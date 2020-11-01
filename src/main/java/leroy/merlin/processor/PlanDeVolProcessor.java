/**
 * 
 */
package leroy.merlin.processor;

import java.util.ArrayList;
import java.util.List;

import leroy.merlin.common.CalculeUtil;
import leroy.merlin.domain.Client;
import leroy.merlin.domain.Commande;
import leroy.merlin.domain.Drone;
import leroy.merlin.domain.PlanDeVol;
import leroy.merlin.domain.Produit;
import leroy.merlin.domain.ProduitCommande;
import leroy.merlin.domain.Stock;
import leroy.merlin.reader.ClientReader;
import leroy.merlin.reader.CommandeReader;
import leroy.merlin.reader.DroneReader;
import leroy.merlin.reader.ProduitReader;
import leroy.merlin.reader.StoreReader;

/**
 * @author ahsouri
 *
 */
public class PlanDeVolProcessor {

	/***/
	public List<Commande> commandes;
	/***/
	public List<Drone> drones;

	/**
	 * Initialisation des données
	 */
	public void loadData() {
		StoreReader.getStores();

		ClientReader.getClients();

		ProduitReader.getProduits();

		commandes = CommandeReader.getCommandes();

		drones = DroneReader.getDrones();
	}

	/**
	 * @param args
	 */
	public List<PlanDeVol> getPlanDeVol() {
		List<PlanDeVol> planDeVols = new ArrayList<PlanDeVol>();
		try {
			for (Commande commande : commandes) {
				for (ProduitCommande produitCommande : commande.getProduitsCommande()) {
					for (int quantity = 0; quantity < produitCommande.getQuantity(); quantity++) {

						planDeVols.add(getBestPlanDeVol(drones, produitCommande.getProduit(), commande.getClient()));

					}
				}
			}
		} catch (Exception e) {
			System.out.println("Erreur lors d'établissement d'un plan de vol");
		}
		return planDeVols;
	}

	/***
	 * 
	 * @param drones
	 * @param store
	 * @param client
	 * @return
	 */
	private static PlanDeVol getBestPlanDeVol(List<Drone> drones, Produit produits, Client client) throws Exception {
		Drone bestDrone = null;
		Stock bestStock = null;
		double trajetAParcourir = 100;

		for (Drone drone : drones) {
			for (Stock stock : produits.getStock()) {

				if (stock.getQuantity() >= 1) {
					double trajet = CalculeUtil.getTrajet(drone, stock, client);

					if (drone.getAutonomie() >= trajet && trajetAParcourir >= trajet) {
						trajetAParcourir = trajet;
						bestStock = stock;
						bestDrone = drone;
					}
				}
			}
		}

		bestDrone.setAutonomie(bestDrone.getAutonomie() - trajetAParcourir);

		bestDrone.setDroneCoordonnées(client.getX(), client.getY());

		bestStock.setQuantity(bestStock.getQuantity() - 1);

		return new PlanDeVol(bestDrone.getDroneId(), bestStock.getStore().getStoreId(), produits.getProductId(),
				client.getClientId());
	}

}
