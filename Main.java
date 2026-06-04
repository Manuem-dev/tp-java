import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Variables
		String statut = new String();

		ArrayList <Produits> produits = new ArrayList<Produits>();

		Scanner input = new Scanner(System.in);

		System.out.println("Se connecter en tant que:");
		System.out.println("G/g : Gerant");
		System.out.println("R/r : Réceptionniste");
		System.out.println("V/v : Vendeur");
		
		statut = input.next();

		switch (statut.toLowerCase()) {
			case "g":
				int choix,newQuantite;
				String role = new String();
				System.out.println("Bienvenue Gérant");
				System.out.println("Veuillez choisir ce que vous voulez faire: ");
				System.out.println("A/a : Ajouter un produit");
				System.out.println("E/e : Entreposer le stock d'un produit");
				System.out.println("V/v : Vendre un produit");
				System.out.println("P/p : Afficher le stock du magasin");
				System.out.println("R/r : Afficer les produits en rupture de stock");
				role = input.next();

				switch (role.toLowerCase()) {
					case "a":
						String nom = new String();
						double price;
						System.out.print("Veuillez entrer le nom du produit à ajouter: ");
						nom = input.next();
						System.out.print("Veuillez le prix de ce produit: ");
						price = input.nextDouble();
						produits.add(new Produits(nom, price));
						System.out.println("Le produit " + nom + " a été enrégistré avec succès au prix de " + price);

						break;
					case "e":
						System.out.println("Voici la liste des produits disponibles; veuillez choisir un produit par son indice");
						for(int i=0;i<produits.size();i++){
							System.out.println("[indice: "+ (i+1) + " | produit: " + produits.get(i).getNom() + "]");
						}
						System.out.print("Votre choix: ");
						choix = input.nextInt();
						System.out.print("Vous avez choisi le produit [" + produits.get(choix-1).getNom() + "];\nveuillez entrer la quantité que vous souhaiter entreposer: "   );
						newQuantite = input.nextInt();
						produits.get(choix-1).entree(newQuantite);
						System.out.println("Vous avez ajouté " + newQuantite + " produit(s) à l'entrepôt de " + produits.get(choix-1).getNom());
				
						break;
					case "v":
						System.out.println("Voici la liste des produits disponibles; veuillez choisir un produit par son indice");
						for(int i=0;i<produits.size();i++){
							System.out.println("[indice: "+ (i+1) + " | produit: " + produits.get(i).getNom() + "]");
						}
						System.out.print("Votre choix: ");
						choix = input.nextInt();
						System.out.print("Vous avez choisi le produit [" + produits.get(choix-1).getNom() + "]; \n veuillez entrer la quantité que vous souhaiter vendre                  : "   );
						newQuantite = input.nextInt();
						produits.get(choix-1).entree(newQuantite);
						System.out.println("Vous avez retiré " + newQuantite + " produit(s) à l'entrepôt de " + produits.get(choix-1).getNom());
				
						break;
					case "p":
						int total=0;
						for(int i=0;i<produits.size();i++){
							total = total + produits.get(i).getStock();
						}
						if (total > 0) {
							System.out.println("Le magasin comporte: ");
							for(int i=0;i<produits.size();i++){
								produits.get(i).toString();
							}
						} else{
							System.out.println("Le magasin est vide pour le moment, veuillez donc ajoutez des produits ");
						}
						
						break;
					case "r":
						System.out.println("Les produits en rupture de stock sont: ");
						for(int i=0;i<produits.size();i++){
							produits.get(i).ruptureStock();;
						}
						break;
				
					
				}
				
				break;
			case "r":
				if (produits.size()>0) {
					
					System.out.println("Bienvenue Réceptionniste");
					System.out.println("Voici la liste des produits disponibles; veuillez choisir un produit par son indice");
					for(int i=0;i<produits.size();i++){
						System.out.println("[indice: "+ (i+1) + " | produit: " + produits.get(i).getNom() + "]");
					}
					System.out.print("Votre choix: ");
					choix = input.nextInt();
					System.out.print("Vous avez choisi le produit [" + produits.get(choix-1).getNom() + "];\nveuillez entrer la quantité que vous souhaiter entreposer: "   );
					newQuantite = input.nextInt();
					produits.get(choix-1).entree(newQuantite);
					System.out.println("Vous avez ajouté " + newQuantite + " produit(s) à l'entrepôt de " + produits.get(choix-1).getNom());
				} else{
					System.out.println("Le magasin est vide pour le moment, laissez le gérant ajouter un produit d'abord");
				}
				
				break;
			case "v":
				System.out.println("Bienvenue Vendeur");
				if (produits.size()>0) {
					
					System.out.println("Voici la liste des produits disponibles; veuillez choisir un produit par son indice");
					for(int i=0;i<produits.size();i++){
						System.out.println("[indice: "+ (i+1) + " | produit: " + produits.get(i).getNom() + "]");
					}
					System.out.print("Votre choix: ");
					choix = input.nextInt();
					System.out.print("Vous avez choisi le produit [" + produits.get(choix-1).getNom() + "]; \n veuillez entrer la quantité que vous souhaiter vendre                  : "   );
					newQuantite = input.nextInt();
					produits.get(choix-1).entree(newQuantite);
					System.out.println("Vous avez retiré " + newQuantite + " produit(s) à l'entrepôt de " + produits.get(choix-1).getNom());
				} else{
					
					System.out.println("Le magasin est vide pour le moment, laissez le gérant ajouter un produit d'abord");
				}
				
				
				break;
				
			
		}
		
		input.close();
	}
}
