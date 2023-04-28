package gestionDocs;

import javax.swing.*;

public class GestionDocuments {
	/**
	 * Cette classe gère la mise en forme et l'intégration des données au tableau.
	 */

	JFrame fenetre;
	JTable tableau;
	JScrollPane sp;
	
	// En-têtes des colonnes
	String column[]={"ID","NAME","DATE", "SIZE", "VERSION", "PRIVACY", "APPROVED BY", "TYPE", "CATEGORY", "USER"};
	// Données du tableau
	String data[][]= TableDatas.get();
	
	GestionDocuments() {
		
		// TABLEAU
		tableau = new JTable(data,column);    
	    tableau.setBounds(30,40,200,300);
	    sp = new JScrollPane(tableau);

		// FENÊTRE
		fenetre = new JFrame("Gestion de documents");
		fenetre.setSize(1300,400);
		fenetre.setVisible(true);

		// AJOUT DES ÉLÉMENTS
		fenetre.add(sp);
	}
}