package lireAfficher;

import javax.swing.*;
import java.sql.*;

public class Action {
	/**
	 * Cette classe va posséder diverses méthodes d'actions principales pour traiter
	 * les données des champs de texte. La méthode de connexion à la base de données
	 * a été mise à part pour plus de sécurité.
	 */

	// VERIFICATION QUE LES DONNEES CORRESPONDENT à CE QUI EST ATTENDU
	public static boolean controler(JTextField nomTF, JTextField ageTF, JTextField tailleTF) {
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
			JOptionPane.showMessageDialog(null, "Veuillez saisir un nom et des nombres valides.", "Erreur de saisie",
					JOptionPane.ERROR_MESSAGE);
		} else if (errorName) {
			JOptionPane.showMessageDialog(null, "Veuillez saisir un nom.", "Erreur de saisie",
					JOptionPane.ERROR_MESSAGE);
		} else if (errorNum) {
			JOptionPane.showMessageDialog(null, "Veuillez saisir un nombre valide.", "Erreur de saisie",
					JOptionPane.ERROR_MESSAGE);
		}

		return success;
	}

	// LECTURE DES TEXTFIELD ET ENREGISTREMENT DANS LA DB
	public static void lire(JTextField nomTF, JTextField ageTF, JTextField tailleTF) {
		String nom, age, taille, sql;
		nom = nomTF.getText();
		age = ageTF.getText();
		taille = tailleTF.getText();

		try {
			Connection con = ConnexionDB.getConnection();
			Statement stmt = con.createStatement();

			// On vide la table avant toute chose pour n'avoir qu'une seule ligne.
			sql = "TRUNCATE TABLE user_datas";
			stmt.executeUpdate(sql);
			sql = "INSERT INTO `user_datas` (`nom`, `age`, `taille`) VALUES ('" + nom + "', '" + age + "', '" + taille
					+ "')";
			stmt.executeUpdate(sql);
			con.close();

			nomTF.setText(null);
			ageTF.setText(null);
			tailleTF.setText(null);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	// LECTURE DE LA DB ET AFFICHAGE DIRECTEMENT DANS LES TEXTFIELDS
	public static void afficher(JTextField nomTF, JTextField ageTF, JTextField tailleTF) {
		try {
			Connection con = ConnexionDB.getConnection();
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select *  from user_datas");
			while (rs.next()) {

				nomTF.setText(rs.getString(1));
				ageTF.setText(Integer.toString(rs.getInt(2)));
				tailleTF.setText(Double.toString(rs.getDouble(3)));
			}
			con.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	// SUPPRESSION DU CONTENU DE LA DB ET DES CHAMPS DE TEXTE
	public static void effacer(JTextField nomTF, JTextField ageTF, JTextField tailleTF) {
		try {
			Connection con = ConnexionDB.getConnection();
			Statement stmt = con.createStatement();

			String sql = "TRUNCATE TABLE user_datas";
			stmt.executeUpdate(sql);
			con.close();

			nomTF.setText(null);
			ageTF.setText(null);
			tailleTF.setText(null);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}