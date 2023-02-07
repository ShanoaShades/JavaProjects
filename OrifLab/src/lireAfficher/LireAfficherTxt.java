package lireAfficher;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class LireAfficherTxt implements ActionListener {
	/**
	 * Cette classe gère la mise en forme et les actions exécutées lorsque les
	 * boutons seront cliqués.Les données seront enregistrées dans un fichier txt
	 * contrairement à la classe LireAfficherDB.
	 */

	JFrame fenetre;
	JLabel nomLabel, ageLabel, tailleLabel;
	JTextField nomTF, ageTF, tailleTF;
	JButton lire, afficher, effacer;
	File file;

	private String nom, donnees, userHome;
	private int age;
	private double taille;

	LireAfficherTxt() {
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
		userHome = System.getProperty("user.home"); // Récupération des chemins de l'utilisateur
		file = new File(userHome + "/Documents/file.txt"); // Création du fichier file.txt dans Documents

		if (e.getActionCommand().equals("Lire")) {
			// VERIFICATION QUE LES DONNEES CORRESPONDENT à CE QUI EST ATTENDU
			// Création d'un flag qui permettra de passer d'un testeur d'exception à un
			// autre tant qu'il est true
			boolean success, errorName, errorNum;
			success = true;
			errorName = false;
			errorNum = false;

			// Vérifier si le champ nom est vide
			if (nomTF.getText().isEmpty()) {
				success = false;
				errorName = true;
			}

			// Vérifier si les nombres sont corrects
			try {
				int age = Integer.parseInt(ageTF.getText());
				double taille = Double.parseDouble(tailleTF.getText());
			} catch (NumberFormatException e1) {
				// Affichage d'un message d'erreur
				success = false;
				errorNum = true;
			}

			// PERSONNALISATION DES MESSAGES D'ERREUR
			if (errorName && errorNum) {
				JOptionPane.showMessageDialog(null, "Veuillez saisir un nom et des nombres valides.",
						"Erreur de saisie", JOptionPane.ERROR_MESSAGE);
			} else if (errorName) {
				JOptionPane.showMessageDialog(null, "Veuillez saisir un nom.", "Erreur de saisie",
						JOptionPane.ERROR_MESSAGE);
			} else if (errorNum) {
				JOptionPane.showMessageDialog(null, "Veuillez saisir un nombre valide.", "Erreur de saisie",
						JOptionPane.ERROR_MESSAGE);
			}

			// LECTURE DES TEXTFIELD ET ENREGISTREMENT DANS UN FICHIER
			if (success) {
				// Récupération des données des champs de texte et stockage dans une variable
				// String
				donnees = nomTF.getText() + "\n" + ageTF.getText() + "\n" + tailleTF.getText();

				// Créer un nouveau fichier "file.txt"
				try (FileWriter ecriture = new FileWriter(file)) {
					BufferedWriter bw = new BufferedWriter(ecriture);
					// Écrire le contenu dde la variable donnees dans le fichier.
					bw.write(donnees);
					// On ferme le fichier
					bw.close();

					nomTF.setText(null);
					ageTF.setText(null);
					tailleTF.setText(null);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		} else if (e.getActionCommand().equals("Afficher")) {
			// LECTURE DU FICHIER ET AFFICHAGE DIRECTEMENT DANS LES TEXTFIELDS
			try {
				// Création du lecteur et du buffer qui va lire ligne par ligne
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String ligne;
				int i = 0;

				// Cette boucle va continuer tant qu'elle ne rencontre pas de ligne vide
				// On enregistrera dans un champ différent à chaque passage en incrémentant
				while ((ligne = bufferedReader.readLine()) != null) {
					if (i == 0) {
						nomTF.setText(ligne);
					}
					if (i == 1) {
						ageTF.setText(ligne);
					}
					if (i == 2) {
						tailleTF.setText(ligne);
					}
					i++;
				}
				bufferedReader.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("Effacer")) {
			// SUPPRESSION DU CONTENU DU FICHIER ET DES CHAMPS DE TEXTE
			// Il s'agira là d'une réécriture, tout simplement.
			try {
				FileWriter suppression = new FileWriter(file);
				suppression.write("");
				// On vide le tampon de sortie
				suppression.flush();
				suppression.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			// On vide les champs de texte
			nomTF.setText(null);
			ageTF.setText(null);
			tailleTF.setText(null);
		}
	}

	public static void main(String[] args) {
		new LireAfficherTxt();
	}
}