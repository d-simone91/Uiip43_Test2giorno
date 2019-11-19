package uiip43_Test2giorno;

import java.io.IOException;
import java.util.ArrayList;



public class TestProdotto {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ArrayList<Prodotto> List = new ArrayList<>();
		ArrayList<Prodotto> List2 = new ArrayList<>();
		ProdottoIterf<Prodotto> prodottoI = new DefaultProdottoProdottoInterf();
		DefaultProdottoProdottoInterf prod= new DefaultProdottoProdottoInterf();
		List=(ArrayList<Prodotto>) prod.inizializzaLista();
		
		System.out.println("Sto per salvare la lista della spesa!");
		prodottoI.save(List);
		
		List2 = (ArrayList<Prodotto>) prodottoI.read();
		System.out.println("Sto per Stampare! la lista della spesa");
		
		for(int i=0; i<List2.size();i++) {
			System.out.println(List2.get(i).toString());
			}
		
	}
	
	

}
