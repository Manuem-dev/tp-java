import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Variables globales
		String statut = new String();
		ArrayList <Produits> produits = new ArrayList<Produits>();
		Scanner input = new Scanner(System.in);
		boolean condition = true;
		
		
		// Entrée dans le menu principale
		while (condition) {
			System.out.println("==========MENU PRINCIPALE==========");
			System.out.println("Se connecter en tant que:");
			System.out.println("G/g : Gerant");
			System.out.println("R/r : Réceptionniste");
			System.out.println("V/v : Vendeur");
			
			statut = input.next();
			String q = new String();
			q = "";
			
			// Gestion des cas
			switch (statut.toLowerCase()) {
				
				// Cas du gérant
				case "g":
					// Variables
					int choix,newQuantite;
					boolean quit = true;
					
					while (quit) {
						
						// Entrée dans le MENU GÉRANT
						String role = new String();
						System.out.println("==========_____MENU GÉRANT_____==========");
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
								// Variables
								boolean go=true;
								String r = new String();
								String nom = new String();
								double price=0;

								System.out.println("==========_____MENU AJOUT DE PRODUIT_____==========");
								System.out.print("Veuillez entrer le nom du produit à ajouter: ");
								input.nextLine(); 
								nom = input.nextLine();
								System.out.print("Veuillez le prix de ce produit: ");
								price = input.nextDouble();
								produits.add(new Produits(nom, price));
								System.out.println("Le produit " + nom + " a été enrégistré avec succès au prix de " + price);
								
								// Permettre d'ajouter autant de produit que voulu en même temps plutôt que de retourner au MENU AJOUT DE PRODUIT avant de revenir
								while (go) {
									System.out.println("\nVoulez-vous encore ajouter un produit  ? (O/o)/(N/n)");
									input.nextLine();
									r = input.next();
									while (!r.toLowerCase().equals("o") && !r.toLowerCase().equals("n")) {
										System.out.println("\nVoulez-vous encore ajouter un produit  ? (O/o)/(N/n)");
										input.nextLine();
										r = input.next();
									}
									

									if (r.toLowerCase().equals("o")) {
										System.out.print("Veuillez entrer le nom du produit à ajouter: ");
										input.nextLine(); // consomme le \n résiduel
										nom = input.nextLine();
										System.out.print("Veuillez le prix de ce produit: ");
										price = input.nextDouble();
										produits.add(new Produits(nom, price));
										System.out.println("Le produit " + nom + " a été enrégistré avec succès au prix de " + price);
										continue;
									} else{
										
										go = false;
										break;
									}
								}

								break;
							case "e":
								System.out.println("==========_____MENU ENTREPÔSER_____==========");
								
								// Liester les produits si l'entrepôt n'est pas vide
								if (produits.size()>0) {
									System.out.println("==========_____MENU RÉCEPTIONNISTE_____==========");
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
								System.out.println("==========_____MENU VENDRE_____==========");
								
								// Lister les produits si l'entrepôt n'est pas vide
								if (produits.size()>0) {
						
									System.out.println("Voici la liste des produits disponibles; veuillez choisir un produit par son indice");
									for(int i=0;i<produits.size();i++){
										System.out.println("[indice: "+ (i+1) + " | produit: " + produits.get(i).getNom() + "]");
									}
									System.out.print("Votre choix: ");
									choix = input.nextInt();
									System.out.print("Vous avez choisi le produit [" + produits.get(choix-1).getNom() + "]; \n veuillez entrer la quantité que vous souhaiter vendre: "   );
									newQuantite = input.nextInt();
									produits.get(choix-1).sortie(newQuantite);
									if (produits.get(choix-1).getStock()>0) {
										System.out.println("Vous avez retiré " + newQuantite + " produit(s) à l'entrepôt de " + produits.get(choix-1).getNom());	
									}
								} else{
									
									System.out.println("Le magasin est vide pour le moment, laissez le gérant ajouter un produit d'abord");
								}
						
								break;
							case "p":
								int total=0;
								System.out.println("==========_____MENU AFFICHAGE DE STOCK_____==========");
								for(int i=0;i<produits.size();i++){
									total = total + produits.get(i).getStock();
								}
								if (total > 0) {
									System.out.println("Le magasin comporte: ");
									for(int i=0;i<produits.size();i++){
										System.out.println(produits.get(i).toString()); 
									}
								} else{
									System.out.println("Le magasin est vide pour le moment, veuillez donc ajoutez des produits ");
								}
								
								break;
							case "r":
								int all=0;
								System.out.println("==========_____MENU AFFICHAGE RUPTURE DE STOCK_____==========");
								for(int i=0;i<produits.size();i++){
									all = all + produits.get(i).getStock();
								}
								if (all > 0) {
									System.out.println("Les produits en rupture de stock sont: ");
									for(int i=0;i<produits.size();i++){
										produits.get(i).ruptureStock();;
									}
								} else{
									System.out.println("Le magasin est vide pour le moment, veuillez donc ajoutez des produits ");
								}
								break;
						}

						System.out.println("\nVoulez-vous quitter le MENU GÉRANT  ? (O/o)/(N/n)");
						q = input.next();	
						while (!q.toLowerCase().equals("o") && !q.toLowerCase().equals("n")) {
							System.out.println("\nVoulez-vous quitter le MENU GÉRANT ? (O/o)/(N/n)");
							q = input.next();
						}
						if (q.toLowerCase().equals("o")) {
							quit = false;
							break;
						} else{
							continue;
						}
					}

					break;
				
				
				// Cas du réceptionniste
				case "r":
					System.out.println("==========_____MENU RÉCEPTIONNISTE_____==========");
					System.out.println("Bienvenue Réceptionniste");
					if (produits.size()>0) {
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

				// Cas du vendeur
				case "v":
					System.out.println("==========_____MENU VENDEUR_____==========");
					System.out.println("Bienvenue Vendeur");
					if (produits.size()>0) {
						
						System.out.println("Voici la liste des produits disponibles; veuillez choisir un produit par son indice");
						for(int i=0;i<produits.size();i++){
							System.out.println("[indice: "+ (i+1) + " | produit: " + produits.get(i).getNom() + "]");
						}
						System.out.print("Votre choix: ");
						choix = input.nextInt();
						System.out.print("Vous avez choisi le produit [" + produits.get(choix-1).getNom() + "]; \n veuillez entrer la quantité que vous souhaiter vendre: "   );
						newQuantite = input.nextInt();
						produits.get(choix-1).sortie(newQuantite);
						if (produits.get(choix-1).getStock()>0) {
							System.out.println("Vous avez retiré " + newQuantite + " produit(s) à l'entrepôt de " + produits.get(choix-1).getNom());	
						}
					} else{
						
						System.out.println("Le magasin est vide pour le moment, laissez le gérant ajouter un produit d'abord");
					}
					
					
					break;
				
			
			}

			System.out.println("\nVoulez-vous quitter le MENU PRINCIPALE ? (O/o)/(N/n)");
			q = input.next();
			while (!q.toLowerCase().equals("o") && !q.toLowerCase().equals("n")) {
				System.out.println("\nVoulez-vous quitter le MENU PRINCIPALE ? (O/o)/(N/n)");
				q = input.next();
			}
			

			if (q.toLowerCase().equals("o")) {
				condition = false;
				System.out.println("Au revoir.........!");
				break;
			} else{
				continue;
			}
		}
		
		// fermeture de Scanner
		input.close();
	}
}
