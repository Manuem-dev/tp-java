package boucle_while;

import java.util.Scanner;

public class Principale_5 {

	public static void main(String[]args) {

		// Variables
		int nombreAnnees; 
		double tauxInteret, capitalInitial, capitalFinal;
		Scanner clavier=new Scanner(System.in);
		
		System.out.println("Entrer le montant du capital à placer : ");
		capitalInitial=clavier.nextDouble();
		
		System.out.println(" Entrer le nombre d'années pour lequel le capital sera placer");
		nombreAnnees=clavier.nextInt();
				
		System.out.println(" Entrer le taux d'intérêt du placement");
		tauxInteret=clavier.nextDouble();
		
		capitalFinal=capitalInitial;
		
		for (int i=1;i<=nombreAnnees; i++ ) {
			capitalFinal=(1+tauxInteret/100)*capitalFinal;
		}
		
		System.out.println("Les intérêts acquis au bout des " +nombreAnnees+ "ans correspond à ");
		
		System.out.printf("%6.2f", capitalFinal-capitalInitial);
		
		System.out.println("€");
		
		clavier.close();
	}



	}

