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

/**
 * @author ahsouri
 *
 */
public class ClientReader implements Constants {

	/***/
	private static List<Client> clients = new ArrayList<Client>();

	/**
	 * 
	 * @return
	 */
	public static List<Client> getClients() {
		String line = "";
		int counter = 1;

		try (BufferedReader br = new BufferedReader(new FileReader(CLIENTS_CSV))) {

			while ((line = br.readLine()) != null) {

				if (counter > 1) {

					String[] csvLine = line.split(SEPARATEUR);

					clients.add(new Client(csvLine[0], Integer.valueOf(csvLine[1]), Integer.valueOf(csvLine[2])));
				}

				counter++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return clients;
	}

	/**
	 * 
	 * @param clientId
	 * @return
	 */
	public static Client getClientById(String clientId) {
		return clients.stream().filter(client -> client.getClientId().equalsIgnoreCase(clientId)).findFirst().get();
	}
}
