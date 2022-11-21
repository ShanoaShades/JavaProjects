package jCheckBox;

import javax.swing.*;
import java.awt.event.*;

public class CheckBoxIL {
	CheckBoxIL() {
		JFrame f = new JFrame("CheckBox Example");
		final JLabel label = new JLabel();
		// On peut centrer un élément horizontalement et verticalement : LEFT. CENTER,
		// RIGHT
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setSize(400, 100);
		JCheckBox checkbox1 = new JCheckBox("C++");
		checkbox1.setBounds(150, 100, 50, 50);
		JCheckBox checkbox2 = new JCheckBox("Java");
		checkbox2.setBounds(150, 150, 50, 50);
		f.add(checkbox1);
		f.add(checkbox2);
		f.add(label);
		// On rajoute cette fois-ci non pas un écouteur d'action mais un écouteur
		// d'objet qui va permettre de contrôler l'état de l'objet et agir en
		// conséquence.
		checkbox1.addItemListener(new ItemListener() {
			// Que va-t'il se passer si l'état de l'objet change. Si l'état est égal à 1
			// (Coché) le label devient "C++ Checkbox: " + checked. Sinon il devient
			// unchecked
			public void itemStateChanged(ItemEvent e) {
				label.setText("C++ Checkbox: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));
			}
		});
		// Même chose pour la checkbox 2
		checkbox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				label.setText("Java Checkbox: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));
			}
		});
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);
	}

	public static void main(String args[]) {
		new CheckBoxIL();
	}
}
