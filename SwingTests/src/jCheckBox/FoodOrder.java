package jCheckBox;

import javax.swing.*;
import java.awt.event.*;

public class FoodOrder extends JFrame implements ActionListener {
	JLabel l;
	JCheckBox cb1, cb2, cb3;
	JButton b;

	FoodOrder() {
		l = new JLabel("Food Ordering System");
		l.setBounds(50, 50, 300, 20);
		cb1 = new JCheckBox("Pizza @ 100");
		cb1.setBounds(100, 100, 150, 20);
		cb2 = new JCheckBox("Burger @ 30");
		cb2.setBounds(100, 150, 150, 20);
		cb3 = new JCheckBox("Tea @ 10");
		cb3.setBounds(100, 200, 150, 20);
		b = new JButton("Order");
		b.setBounds(100, 250, 80, 30);
		b.addActionListener(this);
		add(l);
		add(cb1);
		add(cb2);
		add(cb3);
		add(b);
		setSize(400, 400);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// Ce qui va se passer quand l'action sera exécutée
	public void actionPerformed(ActionEvent e) {
		// Le totale sera un nombre décimal
		float amount = 0;
		// La chaîne de caractère du messageest créée, vide pour l'instant.
		String msg = "";
		// Des condition sont créées, on va les traverser toutes et ce qui correspondra
		// aux paramètres de la condition sera exécuté, les autres seront ignorées.
		if (cb1.isSelected()) {
			// Le prix de la nourriture sélectionnée sera additionnée
			amount += 100;
			// Le message deviendra Pizza, son prix et à la ligne.
			msg = "Pizza: 100\n";
		}
		if (cb2.isSelected()) {
			amount += 30;
			// Important ici : Le texte sera "additionné" au message avec le += car ne
			// mettre qu'un = ne ferait que remplacer le message.
			msg += "Burger: 30\n";
		}
		if (cb3.isSelected()) {
			amount += 10;
			msg += "Tea: 10\n";
		}
		// Quels qu'aient été les résultats du passage dans les conditions, on ajoute
		// une petite mise en forme et un retour à la ligne dans le message.
		msg += "-----------------\n";
		// On va utiliser la classe JOptionPane pour créer un Pop up de type message
		// grâce à la méthode .showMessageDialog. Puis, on va afficher le message +
		// Total : + la somme des prix.
		JOptionPane.showMessageDialog(this, msg + "Total: " + amount);
	}

	public static void main(String[] args) {
		new FoodOrder();
	}
}