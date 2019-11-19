/**
 * mettere i javadoc
 */
package uiip43_Test2giorno;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DefaultProdottoProdottoInterf implements ProdottoIterf<Prodotto> {


	private String dataFile = "/data/prodotti.dat";


	@Override
	public void save(List<Prodotto> List) throws IOException {

		ObjectOutputStream out = null;

		try {

			try {
				out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (int i = 0; i < List.size(); i++) {

				out.writeObject(List.get(i));

			}
		} finally {
			out.close();
		}

	}

	@Override
	public List<Prodotto> read() throws FileNotFoundException, IOException, ClassNotFoundException {

		double totale = 0;
		ObjectInputStream in = null;
		List<Prodotto> lista = new ArrayList<>();
		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)));

			try {
				while (true) {

					Prodotto prodotto = (Prodotto) in.readObject();
					lista.add(prodotto);					
				}

				
				
			} catch (EOFException e) {
			}
		} 

		finally {
			in.close();
		}
		
		for (Prodotto p:lista) {
			totale += (p.getPrezzo()*p.getUnita());
		}
		System.out.println("Il conto totale della spesa � " + totale + " �");
		return lista;
	}
	
	public List<Prodotto> inizializzaLista() {
		ArrayList<Prodotto> list = new ArrayList<>();
		
		Prodotto prodotto1 = new Prodotto("Sale",0.69,15);
		Prodotto prodotto2 = new Prodotto("Carne", 10.0 , 10);
		Prodotto prodotto3 = new Prodotto("Latte", 0.80, 12);
		Prodotto prodotto4 = new Prodotto("Sugo", 1.50, 30);
		Prodotto prodotto5 = new Prodotto("Salumi", 23.5,10);
		
		list.add(prodotto1);
		list.add(prodotto2);
		list.add(prodotto3);
		list.add(prodotto4);
		list.add(prodotto5);
		return list;
	}

}
