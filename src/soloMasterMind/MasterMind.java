// Definir les variables 
// Creation des methodes 
// Constitution du jeu
package soloMasterMind;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MasterMind {

	static final char[] COLORS = { 'b', 'j', 'g', 'm', 'n', 'o', 'r', 'v' };
//	int test[]={}; //A Supprimer
	static char[] couleurs = new char[4];
	static char[] couleursJoueur = new char[4];
	static boolean winner = false;

	static int maxEssais = 3;

	public static void main(String[] args) {

		char[] codeSecret = generateurCode();
		System.out.println(codeSecret); // Test à supprimer
		System.out.println("JEU MASTERMIND");
		System.out.println("Vous avez " + maxEssais + " essais pour trouver la combinaison de 4 lettres.");

		for (int i = 0; i < maxEssais; i++) {
			System.out.println(" ");
			System.out.println("Voici les lettres disponibles: B, J, G, M, N, O, R, V");
			System.out.println(" ");
			System.out.println("Essaie n°" + (i + 1));
			couleursJoueur = combinaisonJoueur();
//			System.out.println(couleursJoueur);
			couleurs = codeSecret;
			System.out.println(" ");
			help();
			if (winner == true) {
				break;

			}
		}
		if (winner == true) {
			System.out.println(" ");
		} else {
			System.out.println("perdu !");
		}
	}

	// Fonctions/Methodes:
	// Une méthode pour générer la suite de lettre: pas deux fois la même couleur
	// 3 tableaux nécessaire : 1 pour la définition des couleurs; 1 pour les
	// "chiffres" et pour la géneration des couleurs dans le jeu

	public static char[] generateurCode() {
		// Génération d'une combi aléatoire de 4 couleurs usant couleurs dispo dans
		// couleurDispo
		char[] colors = Arrays.copyOf(COLORS, COLORS.length);
		Random random = new Random();

		char[] code = new char[couleurs.length]; // Création de code pour stoker les couleurs générés
		int[] indexes = new int[couleurs.length]; // tableau pour stocker les indexes des couleurs sélectionnées
		for (int i = 0; i < couleurs.length; i++) { // a chaque iteration de la boucle, on ajoute une color aléatoire au
													// tablo code. A la fin du tableau, on return code.
			int index = random.nextInt(colors.length);
			code[i] = colors[index];
			indexes[i] = index; // stock l'index de la couleur sélectionnée aléatoire
		}
		for (int i = 0; i < couleurs.length; i++) {
			for (int j = i + 1; j < couleurs.length; j++) {
				if (indexes[i] == indexes[j]) {
					// si deux couleurs identiques sont selec, on régénère la combinaison
					code = generateurCode();
				}
			}
		}
		return code;
	}

	// Une méthode pour demander au joueur d'entrer sa combinaison:
	public static char[] combinaisonJoueur() {
		Scanner input = new Scanner(System.in);
		System.out.println("Entrez la combinaison de 4 couleurs: ");
		// vu que y'a pas de .nextChar():
		String couleursJoueurStr = input.nextLine().toLowerCase();
		// pour que le joueur tape exactement 4 lettres
		while (couleursJoueurStr.length() != 4) {
			System.out.println("Entrez 4 lettres seulement: ");
			couleursJoueurStr = input.nextLine().toLowerCase();
		}
		char[] couleursJoueur = couleursJoueurStr.toCharArray();
//		System.out.println(couleursJoueur); // A supprimer
		return couleursJoueur;
	}

	// Une méthode pour vérifier si la suite de lettre donnée par le joueur est
	// correcte ou non

//	static void verification() {
//		// test du resultat du joueur
//		int a = 0;
//		int b = 0;
//		int c = 0;
//		int d = 0;
//
//		for (int i = 0; i < 4; i++) {
//			// test case par case
//			if (couleurs[0] == couleursJoueur[0]) {
//				a = 1;
//			}
//			if (couleurs[1] == couleursJoueur[1]) {
//				b = 1;
//			}
//			if (couleurs[2] == couleursJoueur[2]) {
//				c = 1;
//			}
//			if (couleurs[3] == couleursJoueur[3]) {
//				d = 1;
//			}
//			// aucune case correcte
//			if (a == 0 && b == 0 && c == 0 && d == 0) {
//				System.out.println("aucune couleur correcte");
//			}
//
//			// Une seule case bonne
//			else if (a == 1 && b == 0 && c == 0 && d == 0) {
//				System.out.println("case 1 correcte");
//			} else if (a == 0 && b == 1 && c == 0 && d == 0) {
//				System.out.println("case 2 correcte");
//			} else if (a == 0 && b == 0 && c == 1 && d == 1) {
//				System.out.println("case 3 correcte");
//			} else if (a == 0 && b == 0 && c == 0 && d == 1) {
//				System.out.println("case 4 correcte");
//
//				// deux cases corectes
//			} else if (a == 1 && b == 1 && c == 0 && d == 0) {
//				System.out.println("case 1 et 2 correctes");
//			} else if (a == 1 && b == 0 && c == 1 && d == 0) {
//				System.out.println("case 1 et 3 correctes");
//			} else if (a == 1 && b == 0 && c == 0 && d == 1) {
//				System.out.println("case 1 et 4 correctes");
//			} else if (a == 0 && b == 1 && c == 1 && d == 0) {
//				System.out.println("case 2 et 3 correctes");
//			} else if (a == 0 && b == 1 && c == 0 && d == 1) {
//				System.out.println("case 2 et 4 correctes");
//			} else if (a == 0 && b == 0 && c == 1 && d == 1) {
//				System.out.println("case 3 et 4 correctes");
//
//				// trois cases correctes
//			} else if (a == 1 && b == 1 && c == 1 && d == 0) {
//				System.out.println("case 1 2 et 3 correctes");
//			} else if (a == 1 && b == 1 && c == 0 && d == 1) {
//				System.out.println("case 1 2 et 4 correctes");
//			} else if (a == 1 && b == 0 && c == 1 && d == 1) {
//				System.out.println("case 1 3 et 4 correctes");
//			} else if (a == 0 && b == 1 && c == 1 && d == 1) {
//				System.out.println("case 2 3 et 4 correctes");
//
//				// quatre cases correctes
//			} else {
//				System.out.println("4 cases correctes");
//			}
//
//		}
//	}

	// Une méthode pour donner des indices à chaque essaie du joueur: il annonce la
	// position des lettres correctes

	static void help() {
		int j = 0;
		int k = 0;
		for (int h = 0; h < 4; h++) {

			if (couleursJoueur[h] == couleurs[h]) {
				System.out.println("La position " + h + " choisie est juste");
				j++;

			} else {
				System.out.println("La position " + h + " choisie est fausse");
				k++;
			}

		}
		System.out.println(+j + " couleur(s) bien placées");
		System.out.println(+k + " couleur(s) mal placées");
		if (j == 4) {
			System.out.println("bingooo");
			winner = true;
		}
	}

}
