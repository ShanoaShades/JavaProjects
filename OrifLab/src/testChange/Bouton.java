package testChange;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class Bouton extends JButton{
	/** Cette classe s'occupe de la gestion de la mise en forme de nos deux boutons CALCULER et EFFACER. */

	// CONSTRUCTEUR
	public Bouton(String name, Color bgColor, int positionX, int positionY, int largeur, int hauteur) {
		super();
		this.setText(name);
		
		// MISE EN FORME - BOUTON CALCULER
		this.setBounds(positionX, positionY, largeur, hauteur);
		this.setBackground(bgColor);
		this.setOpaque(true);
		// POLICE
		this.setForeground(Color.WHITE);
		this.setFont(new Font("Verdana", Font.BOLD, 10));
	}
}
