package uiip43_Test2giorno;


import java.util.ArrayList;

public class ListaProdotti {

	
	public ArrayList<Prodotto> inizializzaLista(){
		ArrayList<Prodotto> List = new ArrayList<>();
		
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
		
		return List;
	}


	
}
