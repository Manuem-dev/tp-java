public class Produits {
	private String nom;
	private double prix;
	private int stock;

	public Produits(String pNom, double pPrix) {
		nom = pNom;
		prix = pPrix;
		stock = 0;
	}

	public String getNom() {
		return nom;
	}

	public double getPrix() {
		return prix;
	}

	public int getStock() {
		return stock;
	}

	// Entrée ou réception
	public void entree(int pStock) {
		stock = stock + pStock;
		System.out.println(
				"Le stock du produit " + this.nom + " a été augmenté avec succès de " + pStock + " produit(s) \n");
	}

	// Sortie ou vente
	public void sortie(int pStock) {
		if ((this.stock - pStock) >= 0) {
			stock = stock - pStock;
			System.out.println(
					"Le stock du produit " + this.nom + " a été diminué avec succès de " + pStock + " produit(s) \n");
		} else {
			System.out.println("Le stock ne peut pas être négatif car le stock disponible pour le produit " + this.nom
					+ " est de " + this.stock);
			System.out.println("alors que vous voulez faire une sortie de " + pStock + "\n");
		}
	}

	public String toString() {
		return "[nom=" + nom + " | prix=" + prix + " | stock=" + stock + "] \n";
	}

	// Rupture de stocke
	public void ruptureStock(){
		int rupture = 10;
		if (stock <= rupture) {
			System.out.println("Votre produit " + nom + " est en rupture de stock; il ne reste que " + stock + " produit(s) en stock");
		}
	}

}
