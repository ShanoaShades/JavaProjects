package jPasswordField;

import javax.swing.*;

public class PasswordField {
	public static void main(String[] args) {
		JFrame f = new JFrame("Password Field Example");
		// JPasswordField est en fait une extension de JTextField qui va cacher les caractère pendant qu'ils sont écrits.
		JPasswordField value = new JPasswordField();
		JLabel l1 = new JLabel("Password:");
		l1.setBounds(20, 100, 80, 30);
		value.setBounds(100, 100, 100, 30);
		f.add(value);
		f.add(l1);
		f.setSize(300, 300);
		f.setLayout(null);
		f.setVisible(true);
	}
}