package lireAfficher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LireAfficher implements ActionListener {
	JFrame fenetre;
	JLabel nomLabel, ageLabel, tailleLabel;
	JTextField nomTF, ageTF, tailleTF;
	JButton lire, afficher, effacer;
	
	private String nom;
	private int age;
	private double taille;

 
	LireAfficher() {
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
			nom = nomTF.getText();
			age = Integer.parseInt(ageTF.getText());
			taille = Double.parseDouble(tailleTF.getText());
			
			nomTF.setText(null);
			ageTF.setText(null);
			tailleTF.setText(null);
		} else if (e.getActionCommand().equals("Afficher")) {
			nomTF.setText(nom);
			
			if(age == 0) {
				ageTF.setText(null);
			} else {
				ageTF.setText(Integer.toString(age));
			}
			
			if(taille == 0) {
				tailleTF.setText(null);
			} else {
				tailleTF.setText(Double.toString(taille));
			}
		} else if (e.getActionCommand().equals("Effacer")) {
			nom = null;
			age = 0;
			taille = 0;
			
			nomTF.setText(null);
			ageTF.setText(null);
			tailleTF.setText(null);
		}
	}

	public static void main(String[] args) {
		new LireAfficher();
	}
}