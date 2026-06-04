import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Variables
		String statut = new String();

		ArrayList <Produits> produits = new ArrayList<Produits>();

		produits.add(new Produits("LG V20",30000));

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
						
						break;
					case "r":
						
						break;
				
					
				}
				
				break;
			case "r":
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
				
				break;
			case "v":
				System.out.println("Bienvenue Vendeur");
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
				
			
		}
		

	}
}
