package jLabel;

import javax.swing.*;

class LabelExample {
	public static void main(String args[]) {
		JFrame f = new JFrame("Label Simple");
		// On déclare les labels ici, deux d'un seul coup avec une virgule.
		JLabel l1, l2;
		// On écrit le texte qui sera contenu dans le label en question.
		l1 = new JLabel("Premier texte.");
		// Et on définit sa position et sa taille.
		l1.setBounds(50, 50, 100, 30);
		// Pareil avec les deuxième label
		l2 = new JLabel("Deuxième texte.");
		l2.setBounds(50, 100, 100, 30);
		// On ajoute les labels ainsi créés dans la fenêtre d'affichage.
		f.add(l1);
		f.add(l2);
		f.setSize(300, 300);
		f.setLayout(null);
		f.setVisible(true);
	}
}