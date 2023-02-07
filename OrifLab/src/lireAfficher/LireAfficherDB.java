package lireAfficher;

import javax.swing.*;
import java.awt.event.*;

public class LireAfficherDB implements ActionListener {
	/**
	 * Cette classe gère la mise en forme et les actions exécutées lorsque les
	 * boutons seront cliqués.Les manières dont les champs de texte seront traités
	 * sont définies dans la classe Action.
	 */

	JFrame fenetre;
	JLabel nomLabel, ageLabel, tailleLabel;
	JTextField nomTF, ageTF, tailleTF;
	JButton lire, afficher, effacer;

	LireAfficherDB() {
		// LABELS
		nomLabel = new JLabel("Nom");
		nomLabel.setBounds(25, 35, 300, 20);
		ageLabel = new JLabel("Age");
		ageLabel.setBounds(25, 70, 300, 20);
		tailleLabel = new JLabel("Taille (m)");
		tailleLabel.setBounds(25, 105, 300, 20);

		// CHAMPS DE TEXTE
		nomTF = new JTextField();
		nomTF.setBounds(100, 35, 110, 20);
		ageTF = new JTextField();
		ageTF.setBounds(100, 70, 55, 20);
		tailleTF = new JTextField();
		tailleTF.setBounds(100, 105, 60, 20);

		// BOUTONS
		lire = new JButton("Lire");
		lire.setBounds(242, 35, 79, 20);
		lire.addActionListener(this);
		afficher = new JButton("Afficher");
		afficher.setBounds(242, 70, 79, 20);
		afficher.addActionListener(this);
		effacer = new JButton("Effacer");
		effacer.setBounds(242, 105, 79, 20);
		effacer.addActionListener(this);

		// FENÊTRE
		fenetre = new JFrame("Lire Afficher");
		fenetre.setSize(350, 195);
		fenetre.setLayout(null);
		fenetre.setVisible(true);

		// AJOUT DES ÉLÉMENTS
		fenetre.add(nomLabel);
		fenetre.add(ageLabel);
		fenetre.add(tailleLabel);
		fenetre.add(nomTF);
		fenetre.add(ageTF);
		fenetre.add(tailleTF);
		fenetre.add(lire);
		fenetre.add(afficher);
		fenetre.add(effacer);
	}

	// Ici on s'occupe de l'action, de ce qui se passe quand l'action est exécutée
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Lire")) {
			// VERIFICATION QUE LES DONNEES CORRESPONDENT à CE QUI EST ATTENDU
			boolean success = Action.controler(nomTF, ageTF, tailleTF);
			// LECTURE DES TEXTFIELD ET ENREGISTREMENT DANS LA DB
			if (success) {
				Action.lire(nomTF, ageTF, tailleTF);
			}
		} else if (e.getActionCommand().equals("Afficher")) {
			// LECTURE DE LA DB ET AFFICHAGE DIRECTEMENT DANS LES TEXTFIELDS
			Action.afficher(nomTF, ageTF, tailleTF);
		} else if (e.getActionCommand().equals("Effacer")) {
			// SUPPRESSION DU CONTENU DE LA DB ET DES CHAMPS DE TEXTE
			Action.effacer(nomTF, ageTF, tailleTF);
		}
	}
}