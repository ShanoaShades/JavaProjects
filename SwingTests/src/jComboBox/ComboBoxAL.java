package jComboBox;

import javax.swing.*;
import java.awt.event.*;

public class ComboBoxAL {
	JFrame f;

	ComboBoxAL() {
		f = new JFrame("ComboBox Example");
		final JLabel label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setSize(400, 100);
		JButton b = new JButton("Show");
		b.setBounds(200, 100, 75, 20);
		// On crée notre menu déroulant.
		String languages[] = { "C", "C++", "C#", "Java", "PHP" };
		final JComboBox cb = new JComboBox(languages);
		cb.setBounds(50, 100, 90, 20);
		f.add(cb);
		f.add(label);
		f.add(b);
		f.setLayout(null);
		f.setSize(350, 350);
		f.setVisible(true);
		// On ajoute une action sur le bouton.
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// On crée une variable de type String nommée data qui va aller chercher dans l'objet cb, l'index sélectionné. On va ajouter cet index  au texte Langage sélectionné.
				String data = "Programming language Selected: " + cb.getItemAt(cb.getSelectedIndex());
				// On affiche le contenu de data dans un label et wàlà.
				label.setText(data);
			}
		});
	}

	public static void main(String[] args) {
		new ComboBoxAL();
	}
}