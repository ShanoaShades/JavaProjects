package jButton;

import javax.swing.*;

public class ButtonIMG {
	ButtonIMG() {
		JFrame f = new JFrame("Bouton Image");
		// On va jouter le lien vers l'image qui sera utilisée à la place d'un simple texte on va utiliser l'objet ImageIcon
		JButton b = new JButton(new ImageIcon("C:\\Users\\AigleShanoaAugsburge\\Pictures\\start.png"));
		b.setBounds(200, 200, 512, 512);
		f.add(b);
		f.setSize(1000, 1000);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ButtonIMG();
	}
}