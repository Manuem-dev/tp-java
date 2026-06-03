import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		//_______DEVELOPPEMENT LOGIQUE_______

		ArrayList<Produits> Articles = new ArrayList<Produits>();
		int stockTotal = 0;
		
		Produits p001 = new Produits("projecteur Nasco 09", 35000);
		Articles.add(p001);
		
		Produits p002 = new Produits("Ecran LG 17", 20000);
		Articles.add(p002);
		
		// Entree
		p001.entree(50);
		p002.entree(10);

		// Sorties
		 p001.sortie(10);
		 p002.sortie(20);

		
		
		for (int i=0; i<Articles.size(); i++) {
			System.out.println(Articles.get(i).toString());
		}	

		// stock total du magasin avec tous produits confondus
		for (int i=0; i<Articles.size(); i++) {
			stockTotal = stockTotal + Articles.get(i).getStock();
		}
		
		System.out.println(" Le nombre total de produit présent dans le magasin est : " + stockTotal);


		//_____DEVELOPPEMENT GRAPHIQUE_____

		Fenetre window = new Fenetre();
		



	}
}