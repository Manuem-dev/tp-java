package gestionStock;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Produits> Articles= new ArrayList<Produits>();
		
		Produits p001 = new Produits("projecteur Nasco 09", 35000, 12);
		Articles.add(p001);
		
		Produits p002 = new Produits("Ecran LG 17''", 20000, 8);
		Articles.add(p002);
		
		Produits p003 = new Produits("Tecno Spark 40pro+ 256Gb", 95000, 32);
		Articles.add(p003);
		
		Produits p004 = new Produits("Itel A70", 55000, 6);
		Articles.add(p004);
		
		Produits p005 = new Produits("Clavier HP", 4000, 21);
		Articles.add(p005);
		
		Produits p006 = new Produits("Infinix Hot 60i", 75000, 9);
		Articles.add(p006);

		//for (int i=0; i<Articles.size(); i++) {
			//System.out.println(Articles.get(i).toString());
		//}	
		
		p001.setNom("LG");
		p003.setPrix(57000);
		
		for (int i=0; i<Articles.size(); i++) {
			System.out.println(Articles.get(i).toString());
		}	
		
	}
}