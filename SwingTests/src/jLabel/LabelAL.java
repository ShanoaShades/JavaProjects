package jLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LabelAL extends Frame implements ActionListener {
	// On déclare ici les trois objets : TextFiel, Label et Button
	JTextField tf;
	JLabel l;
	JButton b;

	// On va s'occuper de la cosmétique de base. Taille, position du TextField, Label et Bouton ainsi que son texte. On va les placer dans la fenêtre. 
	LabelAL() {
		tf = new JTextField("Entrez une adresse");
		tf.setBounds(50, 50, 150, 20);
		l = new JLabel();
		l.setBounds(50, 100, 300, 20);
		b = new JButton("Rechercher IP");
		b.setBounds(50, 150, 150, 30);
		b.addActionListener(this);
		add(b);
		add(tf);
		add(l);
		setSize(400, 400);
		setLayout(null);
		setVisible(true);
	}

	// Ici on s'occupe de l'action, de ce qui se passe quand l'action est exécutée
	public void actionPerformed(ActionEvent e) {
		try {
			// L'objet host est créé à partir de ce qui est entré dans le TextField. Donc une adresse par exemple.
			String host = tf.getText();
			// Ici, l'objet ip sera créé en récupérant les données de host et en allant chercherson ip sur internet. Puis cet ip sera stocké dans l'objet.
			String ip = java.net.InetAddress.getByName(host).getHostAddress();
			// Enfin, on crée notre label avec notre texte en chaîne de caractère " " et nos objets pour compléter la phrase avec +
			l.setText("l'IP de " + host + " est : " + ip);
		} catch (Exception ex) {
			// On l'affiche
			System.out.println(ex);
		}
	}

	public static void main(String[] args) {
		new LabelAL();
	}
}