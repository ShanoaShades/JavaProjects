package jOptionPane;

import javax.swing.*;

public class ShowInputDialog {
	JFrame f;

	ShowInputDialog() {
		f = new JFrame();
		String name = JOptionPane.showInputDialog(f, "Enter Name");
	}

	public static void main(String[] args) {
		new ShowInputDialog();
	}
}