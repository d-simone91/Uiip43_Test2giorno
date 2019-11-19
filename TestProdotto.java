package it.uiip.esercitazioneFineModuloJavaIII.SimoneDElia;

import java.io.IOException;
import java.util.ArrayList;



public class TestProdotto {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ArrayList<Prodotto> List = new ArrayList<>();
		ArrayList<Prodotto> List2 = new ArrayList<>();
		
		Prodotto prodotto1 = new Prodotto("Sale",0.69,15);
		Prodotto prodotto2 = new Prodotto("Carne", 10.0 , 10);
		Prodotto prodotto3 = new Prodotto("Latte", 0.80, 12);
		Prodotto prodotto4 = new Prodotto("Sugo", 1.50, 30);
		Prodotto prodotto5 = new Prodotto("Salumi", 23.5,10);
		
		List.add(prodotto1);
		List.add(prodotto2);
		List.add(prodotto3);
		List.add(prodotto4);
		List.add(prodotto5);
		
		ProdottoIterf<Prodotto> prodottoI = new DefaultProdottoProdottoInterf();
		System.out.println("Sto per salvare la lista della spesa!");
		prodottoI.save(List);
		
		
		List2 = (ArrayList<Prodotto>) prodottoI.read();
		System.out.println("Sto per Stampare! la lista della spesa");
		
		
		for(int i=0; i<List2.size();i++) {
			System.out.println(List2.get(i).toString());
			}
		

	}

}
