/**
 * 
 */
package processor;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import leroy.merlin.domain.Client;
import leroy.merlin.domain.Commande;
import leroy.merlin.domain.Drone;
import leroy.merlin.domain.Produit;
import leroy.merlin.domain.ProduitCommande;
import leroy.merlin.domain.Stock;
import leroy.merlin.domain.Store;
import leroy.merlin.processor.PlanDeVolProcessor;

/**
 * @author ahsouri
 *
 */

public class PlanDeVolProcessorTest {

	PlanDeVolProcessor planvol = new PlanDeVolProcessor();

	List<Commande> commandes = new ArrayList<>();
	List<Drone> drones = new ArrayList<>();

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		initData();
	}

	@Test
	public void test_plan_vol_not_null() {
		planvol.commandes = Mockito.spy(commandes);
		planvol.drones = Mockito.spy(drones);
		assertNotNull(planvol.getPlanDeVol());
	}
	
	@Test
	public void test_plan_vol_commande_null() {
		planvol.drones = Mockito.spy(drones);
		assertNotNull(planvol.getPlanDeVol());
	}
	
	@Test
	public void test_plan_vol_drone_null() {
		planvol.drones = Mockito.spy(drones);
		assertNotNull(planvol.getPlanDeVol());
	}

	public void initData() {
		drones.add(new Drone("drone1", 10, 23));
		Store store1 = new Store("store1", 2, 45);
		Client client1 = new Client("client1", 4, 6);
		List<Stock> stocks = Arrays.asList(new Stock(store1, 3));
		Produit produit1 = new Produit("produit1", "prd-01", stocks);
		List<ProduitCommande> produitCommande = Arrays.asList(new ProduitCommande(produit1, 1));
		commandes.add(new Commande("order1", client1, produitCommande));
	}
}
