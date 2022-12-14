package jPasswordField;

import javax.swing.*;
import java.awt.event.*;

public class PasswordFieldAL {
	public static void main(String[] args) {
		JFrame f = new JFrame("Password Field Example");
		final JLabel label = new JLabel();
		label.setBounds(20, 150, 500, 50);
		final JPasswordField value = new JPasswordField();
		value.setBounds(100, 75, 100, 30);
		JLabel l1 = new JLabel("Username:");
		l1.setBounds(20, 20, 80, 30);
		JLabel l2 = new JLabel("Password:");
		l2.setBounds(20, 75, 80, 30);
		JButton b = new JButton("Login");
		b.setBounds(100, 120, 80, 30);
		final JTextField text = new JTextField();
		text.setBounds(100, 20, 100, 30);
		f.add(value);
		f.add(l1);
		f.add(label);
		f.add(l2);
		f.add(b);
		f.add(text);
		f.setSize(1000, 1000);
		f.setLayout(null);
		f.setVisible(true);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// On récupère les données et on les stocke dans l'objet data.
				String data = "Username " + text.getText();
				// On y ajoute les données de l'objet value. Elles seront stockées à la suite, formant un texte combiné.
				data += ", Password: " + new String(value.getPassword());
				// On affiche le joli texte combiné contenu dans data, directement dans label
				label.setText(data);
			}
		});
	}
}