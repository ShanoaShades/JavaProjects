package lireAfficher;

/**
 * Ceci est un programme qui permettra d'enregistrer les données des champs de
 * texte nom, âge, taille dans une base de données avec le type correspondant
 * pour chacun. nom chaîne de caractères, âge entier, taille double. Le bouton
 * Lire lira les données, les enregistrera dans la base de données et effacera
 * les champs. Un contrôle sera effectué au préalable pour vérifier si tous les
 * champs sont remplis et si les données correspondent aux types attendus. Les
 * exceptions sont traitées. Il est également à noter que la base de données
 * sera vidée à chaque lecture afin qu'il n'y aie qu'une ligne de données. Le
 * bouton Afficher ira chercher les informations dans la base de données et les
 * affichera dans les champs correspondants. Si il n'y a rien, rien ne sera
 * affiché tout simplement. Le bouton Effacer videra les champs de texte et
 * supprimera les données de la base de données.
 * 
 * @author Shanoa
 */

public class Main {

	public static void main(String[] args) {
		new LireAfficherDB();
	}
}