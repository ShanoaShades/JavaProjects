package testChange;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class Fenetre implements ActionListener, ItemListener {
	/**
	 * Cette classe s'occupe de la gestion du placement des différents objets ainsi
	 * que des actions exécutées lorsque les boutons seront appuyés.
	 */
	JFrame fenetre;
	JLabel chfL, euroL;
	JTextField chfTF, euroTF;
	JRadioButton chfToEuroRB, euroToChfRB;
	ButtonGroup sensDeConversion;
	Bouton calculer, effacer;
	

	Fenetre() {
		// LABELS
		chfL = new JLabel("CHF");
		chfL.setBounds(6, 0, 75, 30);
		euroL = new JLabel("EURO");
		euroL.setBounds(396, 0, 75, 30);

		// CHAMPS DE TEXTE
		chfTF = new JTextField();
		chfTF.setBounds(32, 6, 93, 20);
		chfTF.setEditable(true);
		euroTF = new JTextField();
		euroTF.setBounds(300, 6, 93, 20);
		euroTF.setEditable(false);

		// BOUTONS RADIO
		chfToEuroRB = new JRadioButton("CHF => €", true);
		chfToEuroRB.setBounds(135, 0, 75, 34);
		chfToEuroRB.addItemListener(this);
		euroToChfRB = new JRadioButton("€ => CHF");
		euroToChfRB.setBounds(214, 0, 75, 34);
		euroToChfRB.addItemListener(this);
		// On place les deux boutons dans un groupe.
		sensDeConversion = new ButtonGroup();
		sensDeConversion.add(chfToEuroRB);
		sensDeConversion.add(euroToChfRB);

		// BOUTONS
		calculer = new Bouton("CALCULER", Color.BLUE, 125, 52, 92, 24);
		calculer.addActionListener(this);
		effacer = new Bouton("EFFACER", Color.BLACK, 222, 52, 86, 24);
		effacer.addActionListener(this);

		// FENÊTRE
		fenetre = new JFrame("Convertisseur de devises");
		fenetre.setSize(450, 120);
		fenetre.setLayout(null);
		fenetre.setVisible(true);
		fenetre.setResizable(false);

		// AJOUT DES ÉLÉMENTS
		fenetre.add(chfL);
		fenetre.add(euroL);
		fenetre.add(chfTF);
		fenetre.add(euroTF);
		fenetre.add(chfToEuroRB);
		fenetre.add(euroToChfRB);
		fenetre.add(calculer);
		fenetre.add(effacer);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (chfToEuroRB.isSelected()) {
			chfTF.setEditable(true);
			euroTF.setEditable(false);
		}
		if (euroToChfRB.isSelected()) {
			chfTF.setEditable(false);
			euroTF.setEditable(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("CALCULER")) {
			String textFieldCheck, devise, resultat;
			double tauxChange, deviseAConvertir, deviseConvertie, arrondi;

			if (chfToEuroRB.isSelected()) {
				textFieldCheck = chfTF.getText();
				
				
				if (!isNumeric(textFieldCheck)) {
					JOptionPane.showMessageDialog(fenetre, "Veuillez saisir la valeur en CHF");
				} else {
					tauxChange = 0.967328;

					devise = chfTF.getText();
					deviseAConvertir = Double.parseDouble(devise);
					deviseConvertie = deviseAConvertir * tauxChange;
					arrondi = Math.round(deviseConvertie * 100.0) / 100.0;

					resultat = String.valueOf(arrondi);
					euroTF.setText(resultat);
				}
			}

			if (euroToChfRB.isSelected()) {
				textFieldCheck = euroTF.getText();

				if (!isNumeric(textFieldCheck)) {
					JOptionPane.showMessageDialog(fenetre, "Veuillez saisir la valeur en EUR");
				} else {
					tauxChange = 1.033775;

					devise = euroTF.getText();
					deviseAConvertir = Double.parseDouble(devise);
					deviseConvertie = deviseAConvertir * tauxChange;
					arrondi = Math.round(deviseConvertie * 100.0) / 100.0;

					resultat = String.valueOf(arrondi);
					chfTF.setText(resultat);
				}
			}
		} else if (e.getActionCommand().equals("EFFACER")) {
			// Vider les champs
			chfTF.setText(null);
			euroTF.setText(null);

			// Mettre la sélection sur CHF => €
			chfToEuroRB.setSelected(true);
			euroToChfRB.setSelected(false);

			// Présélection CHF => € active
			chfTF.setEditable(true);
			euroTF.setEditable(false);
		}
	}
	
	public boolean isNumeric(String textFieldCheck) {
		// Méthode pour contrôler si le champ est bien numérique et si il n'est pas vide.		
	    if(textFieldCheck == null || textFieldCheck.equals("")) {    
	        return false;
	    }
		try {
		    double doubleValue = Double.parseDouble(textFieldCheck);
		    return true;
		} catch (NumberFormatException e) {}
		return false;
	}
}