package jTextField;

import javax.swing.*;
import java.awt.event.*;

// On va ajouter des actions sur les objets suivants des genre de Récepteurs.
public class TextFieldAL implements ActionListener {
	JTextField tf1, tf2, tf3;
	JButton b1, b2;

	TextFieldAL() {
		JFrame f = new JFrame("Calculatrice +/-");
		tf1 = new JTextField();
		tf1.setBounds(50, 50, 150, 20);
		tf2 = new JTextField();
		tf2.setBounds(50, 100, 150, 20);
		tf3 = new JTextField();
		tf3.setBounds(50, 150, 150, 20);
		tf3.setEditable(false);
		b1 = new JButton("+");
		b1.setBounds(50, 200, 50, 50);
		b2 = new JButton("-");
		b2.setBounds(120, 200, 50, 50);
		// Le récepteur va agir sur l'instance de la classe en cours.
		b1.addActionListener(this);
		b2.addActionListener(this);
		f.add(tf1);
		f.add(tf2);
		f.add(tf3);
		f.add(b1);
		f.add(b2);
		f.setSize(300, 300);
		f.setLayout(null);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// On va récupérer les textes entrés dans les TextFields 1 et 2 et les stocker dans s1 et s2
		String s1 = tf1.getText();
		String s2 = tf2.getText();
		// On va convertir les chaînes de caractères s1, s2 en int et les stocker dans a et b qui sont déclarés comme int.
		int a = Integer.parseInt(s1);
		int b = Integer.parseInt(s2);
		// On déclare la variable c en lui donnant la valeur 0 comme valeur par défaut.
		int c = 0;
		/* On  va créer la condition suivante : "Si c'est le bouton 1 qui est appuyé, fait une addition. Sinon Si c'est le bouton 2, fais une soustraction."
		Le résultat sera stocké dans c*/
		if (e.getSource() == b1) {
			c = a + b;
		} else if (e.getSource() == b2) {
			c = a - b;
		}
		// On stock la valeur de c dans une chaîne de caractères nommée result et ensuite on l'affiche dans TextField 3
		String result = String.valueOf(c);
		tf3.setText(result);
	}

	public static void main(String[] args) {
		new TextFieldAL();
	}
}

// On dirait bien que TextField ne prend que des string et non des int. Doù la conversion durant l'opération j'imagine.