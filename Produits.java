package tp;

public class Produits {
	private String nom;
	private double prix;
	private int stock;
	
	public Produits(String pNom, double pPrix, int pStock) {	
		pNom = nom;
		pPrix = prix;
		pStock = stock;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String pNom) {
		pNom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double pPrix) {
		pPrix = prix;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int pStock) {
		pStock = stock;
	}

	public String toString() {
		return "Produits [nom=" + nom + ", prix=" + prix + ", stock=" + stock + "]";
	}
	
	
	

}
