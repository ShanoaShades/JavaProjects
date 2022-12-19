package testChange;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class Fenetre implements ActionListener{
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
		JLabel chfL = new JLabel("CHF");
		chfL.setBounds(6, 0, 75, 30);
		JLabel euroL = new JLabel("EURO");
		euroL.setBounds(396, 0, 75, 30);

		// CHAMPS DE TEXTE
		JTextField chfTF = new JTextField();
		chfTF.setBounds(32, 6, 93, 20);
		chfTF.setEditable(true);
		JTextField euroTF = new JTextField();
		euroTF.setBounds(300, 6, 93, 20);
		euroTF.setEditable(false);

		// BOUTONS RADIO
		JRadioButton chfToEuroRB = new JRadioButton("CHF => €", true);
		chfToEuroRB.setBounds(135, 0, 75, 34);
		JRadioButton euroToChfRB = new JRadioButton("€ => CHF");
		euroToChfRB.setBounds(214, 0, 75, 34);
		// On place les deux boutons dans un groupe.
		ButtonGroup sensDeConversion = new ButtonGroup();
		sensDeConversion.add(chfToEuroRB);
		sensDeConversion.add(euroToChfRB);
		// ITEM LISTENERS DES CHECK BOXES
		// Afin de swap le textfield qui est sélectionnable ou non.
		chfToEuroRB.addItemListener(new ItemListener() {    
            public void itemStateChanged(ItemEvent e) {                 
            	chfTF.setEditable(true);
				euroTF.setEditable(false);
            }    
         });
		euroToChfRB.addItemListener(new ItemListener() {    
            public void itemStateChanged(ItemEvent e) {                 
            	chfTF.setEditable(false);
				euroTF.setEditable(true);
            }    
         });   

		// BOUTONS
		Bouton calculer = new Bouton("CALCULER", Color.BLUE, 125, 52, 92, 24);
		calculer.addActionListener(this);
		Bouton effacer = new Bouton("EFFACER", Color.BLACK, 222, 52, 86, 24);
		effacer.addActionListener(this);

		// FENETRE
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
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getSource());
		if(e.getSource() == calculer){ 
			System.out.println("Saaaaaaaaaaaaaaaaaaaaluuuuuuuuuuuuuuut");
			
			String devise, resultat;
			double tauxChange, deviseAConvertir, deviseConvertie;
			
			if(chfToEuroRB.isSelected()){    
				tauxChange = 0.967328;
				
				devise = chfTF.getText();
				deviseAConvertir = Double.parseDouble(devise);
				deviseConvertie = deviseAConvertir * tauxChange;
				
				resultat = String.valueOf(deviseConvertie);  
		        euroTF.setText(resultat);
				}   
			if(euroToChfRB.isSelected()){    
				tauxChange = 1.033775;
				
				devise = euroTF.getText();
				deviseAConvertir = Double.parseDouble(devise);
				deviseConvertie = deviseAConvertir * tauxChange;
				
				resultat = String.valueOf(deviseConvertie);  
				chfTF.setText(resultat);
				}  
        } else if(e.getSource() == effacer){
        	System.out.println("YEAH");
			chfTF.setText("POUET");
			euroTF.setText("ça marche on dirait");
		}
		   
		/*
		 * firstName = fieldFirstName.getText(); name = fieldName.getText(); age =
		 * fieldAge.getText(); section = fieldSection.getText();
		 * 
		 * if (firstName.isEmpty() || name.isEmpty() || age.isEmpty() ||
		 * section.isEmpty() == true) { JOptionPane.showMessageDialog(f,
		 * "Vous devez remplir tous les champs !", "MESSAGE",
		 * JOptionPane.ERROR_MESSAGE); } else { newMember.setFirstName(firstName); msg =
		 * "Prénom : " + newMember.getFirstName() + "\n"; newMember.setName(name); msg
		 * += "Nom : " + newMember.getName() + "\n"; newMember.setAge(age); msg +=
		 * "Âge : " + newMember.getAge() + "\n"; newMember.setSection(section); msg +=
		 * "Section : " + newMember.getSection() + "\n-----------------\n";
		 * 
		 * JOptionPane.showMessageDialog(f, msg + "Merci pour votre inscription"); }
		 */
	}

}