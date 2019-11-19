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
import java.util.Scanner;



public class DefaultProdottoProdottoInterf implements ProdottoIterf<Prodotto>{
	
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
<<<<<<< Updated upstream
		
		
		
		double totale=0;
=======
        String codiceSconto = "uiip43";
		String scelta="";
		System.out.println("Inserisci il codice sconto: ");
        Scanner inputk = new Scanner(System.in);
        scelta=inputk.nextLine();
        
		double totale = 0;
>>>>>>> Stashed changes
		ObjectInputStream in = null;
		List<Prodotto> lista = new ArrayList<>();
		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)));
            
			try {
				while (true) {
					Prodotto prodotto = (Prodotto) in.readObject();
					lista.add(prodotto);
					
					for (int i=0; i<lista.size();i++) {
						lista.get(i).getNome();
						lista.get(i).getPrezzo();
						lista.get(i).getUnita();
						totale=totale+(lista.get(i).getPrezzo()*lista.get(i).getUnita());
					}
					
					
				} 
				
				
			} catch (EOFException e) {
			}
		} 
		finally {
			
			System.out.println("Il conto totale della spesa è" + totale);
			in.close();
		}
<<<<<<< Updated upstream
=======
	
		if(scelta.equals(codiceSconto)) {
		for (Prodotto p:lista) {
			totale += (p.getPrezzo()*p.getUnita());
			
		}
		totale -= 20;
		}else {
			for (Prodotto p:lista) {
				totale += (p.getPrezzo()*p.getUnita());
				
			}
		}
		System.out.println("Il conto totale della spesa è " + totale + " €");
>>>>>>> Stashed changes
		return lista;
	}

}
