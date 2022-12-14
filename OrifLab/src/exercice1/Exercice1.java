package exercice1;

import javax.swing.*;
import java.awt.event.*;

public class Exercice1 implements ActionListener {
	JFrame f;
	JTextField texte;
	JButton set, reset;
	int count = 0;

	Exercice1() {
		f = new JFrame("COMPTEUR");
		texte = new JTextField("Vous n'avez jamais cliqué ;-)");
		texte.setBounds(0, 0, 400, 30);
		texte.setHorizontalAlignment(JLabel.CENTER);
		set = new JButton("SET");
		set.setBounds(130, 325, 56, 25);
		set.addActionListener(this);
		reset = new JButton("RESET");
		reset.setBounds(190, 325, 71, 25);
		reset.addActionListener(this);

		f.add(texte);
		f.add(set);
		f.add(reset);
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == set) {
			count++;
		} else if (e.getSource() == reset) {
			if (count == 0) {
				JOptionPane.showMessageDialog(f, "Le compteur est déjà à zéro !", "MESSAGE", JOptionPane.ERROR_MESSAGE);
			} else {
				count = 0;
				JOptionPane.showMessageDialog(f, "Le compteur a été réinitialisé", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		texte.setText("Vous avez cliqué "+count+" fois");
	
	}

	public static void main(String[] args) {
		new Exercice1();
	}
}