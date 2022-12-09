package testChange;

import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;



public class Bouton extends Component {
		// Bien hériter de Component pour pouvoir l'utiliser après avec la méthode add de Fenetre.
			
		public Bouton() {
		super();
		
		JButton calculer = new JButton("EFFACER");
		calculer.setBounds(0, 50, 95, 30);
		calculer.setBackground(Color.BLUE);
		calculer.setOpaque(true);
		calculer.setForeground(Color.WHITE);
		calculer.setFont(new Font("Verdana", Font.BOLD, 10));
		
		JButton effacer = new JButton("EFFACER");
		effacer.setBounds(0, 100, 95, 30);
		effacer.setBackground(Color.BLUE);
		effacer.setOpaque(true);
		effacer.setForeground(Color.WHITE);
		effacer.setFont(new Font("Verdana", Font.BOLD, 10));
	}

}
