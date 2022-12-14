package jRadioButton;

import javax.swing.*;

public class RadioButton {
	JFrame f;

	RadioButton() {
		f = new JFrame();
		// Similaire aux checkboxes sauf que l'on ne peut choisir qu'une seule case de type radio
		JRadioButton r1 = new JRadioButton("A) Male");
		JRadioButton r2 = new JRadioButton("B) Female");
		r1.setBounds(75, 50, 100, 30);
		r2.setBounds(75, 100, 100, 30);
		// Petite spécificité ici, on crée un groupe de boutons nommé bg afin de définir quel radio font partie du groupe et du choix. Puis on y ajoute r1 et r2
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		f.add(r1);
		f.add(r2);
		f.setSize(300, 300);
		f.setLayout(null);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new RadioButton();
	}
}