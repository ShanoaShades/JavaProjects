package jOptionPane;

import javax.swing.*;

public class ShowMessageDialog {
	JFrame f;

	ShowMessageDialog() {
		f = new JFrame();
		JOptionPane.showMessageDialog(f, "Hello, Welcome to Javatpoint.");
	}

	public static void main(String[] args) {
		new ShowMessageDialog();
	}
}