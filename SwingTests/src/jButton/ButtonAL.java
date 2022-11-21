package jButton;

import java.awt.event.*;
import javax.swing.*;

public class ButtonAL {
	public static void main(String[] args) {
		// On crée la fenêtre, on lui donne un nom et un titre
		JFrame f = new JFrame("Bouton Action");
		final JTextField tf = new JTextField();
		tf.setBounds(125, 50, 150, 50);
		JButton b = new JButton("Cliquez");
		b.setBounds(150, 150, 95, 30);
		// On ajoute une action (Listener car il va écouter si la personne appuie ?) Puis on défini ce qui sera exécuté.
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Ici, l'action sera d'ajouter du texte dans l'objet tf qui est le TextField
				tf.setText("BOOM !!!");
			}
		});
		
		// Paramètres de la fenêtre
		f.add(b);
		f.add(tf);
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);
	}
}

// On constate que setBound permet de définir la taille et la position d'un objet. Que ce soit un bouton ou un champ de texte.