package jComboBox;

import javax.swing.*;

public class ComboBox {
	JFrame f;

	ComboBox() {
		f = new JFrame("ComboBox Example");
		// On crée un tableau de type string avec les différentes options de notre uture liste à choix.
		String country[] = { "India", "Aus", "U.S.A", "England", "Newzealand" };
		// Cela va permettre de créer un menu avec une liste à choix. On va utiliser le tableau précédemment créé en paramètres.
		JComboBox cb = new JComboBox(country);
		cb.setBounds(50, 50, 90, 20);
		f.add(cb);
		f.setLayout(null);
		f.setSize(400, 500);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new ComboBox();
	}
}