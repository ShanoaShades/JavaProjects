package lireAfficher;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class LireAfficherDB implements ActionListener {
	JFrame fenetre;
	JLabel nomLabel, ageLabel, tailleLabel;
	JTextField nomTF, ageTF, tailleTF;
	JButton lire, afficher, effacer;
	File file;

	private String nom, donnees, userHome, sql;
	private int age;
	private double taille;

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

			// LECTURE DES TEXTFIELD ET ENREGISTREMENT DANS LA DB
			if (success) {
				String nom, age, taille;
				nom = nomTF.getText();
				age = ageTF.getText();
				taille = tailleTF.getText();
				
				try {					
					Connection con=ConnexionDB.getConnection();
					Statement stmt=con.createStatement();
					
					// On vide la table avant toute chose pour n'avoir qu'une seule ligne.
					sql = "TRUNCATE TABLE user_datas";
					stmt.executeUpdate(sql);
					sql = "INSERT INTO `user_datas` (`nom`, `age`, `taille`) VALUES ('"+ nom +"', '"+ age + "', '"+ taille +"')";
					stmt.executeUpdate(sql);					
					con.close();
					
					nomTF.setText(null);
					ageTF.setText(null);
					tailleTF.setText(null);
				}catch (Exception e1){
					e1.printStackTrace();
				}
			}

		} else if (e.getActionCommand().equals("Afficher")) {
			// LECTURE DE LA DB ET AFFICHAGE DIRECTEMENT DANS LES TEXTFIELDS
			try {
				Connection con=ConnexionDB.getConnection();
				Statement stmt=con.createStatement();

				ResultSet rs=stmt.executeQuery("select *  from user_datas");
				while(rs.next()) {
					
					nomTF.setText(rs.getString(1));
					ageTF.setText(Integer.toString(rs.getInt(2)));
					tailleTF.setText(Double.toString(rs.getDouble(3)));				
				}			
				con.close();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getActionCommand().equals("Effacer")) {
			// SUPPRESSION DU CONTENU DE LA DB ET DES CHAMPS DE TEXTE
			try {
				Connection con=ConnexionDB.getConnection();
				Statement stmt=con.createStatement();
				
				sql = "TRUNCATE TABLE user_datas";
				stmt.executeUpdate(sql);				
				con.close();
				
				nomTF.setText(null);
				ageTF.setText(null);
				tailleTF.setText(null);
			}catch (Exception e1){
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new LireAfficherDB();
	}
}