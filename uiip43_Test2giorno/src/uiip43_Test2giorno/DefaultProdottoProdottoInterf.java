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
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;

public class DefaultProdottoProdottoInterf implements ProdottoIterf<Prodotto> {

	private String dataFile = "C:/data/prodotti.dat";
	private LocalDate date = LocalDate.now();

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
		
		LocalDate blackFridayDate = LocalDate.of(2019, 11, 19);
		
		if (date.compareTo(blackFridayDate) == 0) {
			System.out.println("Oggi � il BlackFriday! Ottieni uno sconto del 10%.");
			totale = totale - totale / 100 * 10;
			System.out.println("Il totale da pagare risulta ora: " + totale + "�");
		}
		
		return lista;
	}

}
