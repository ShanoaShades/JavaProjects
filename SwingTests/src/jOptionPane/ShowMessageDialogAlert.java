package jOptionPane;

import javax.swing.*;

public class ShowMessageDialogAlert {
	JFrame f;

	ShowMessageDialogAlert() {
		f = new JFrame();
		JOptionPane.showMessageDialog(f, "Successfully Updated.", "Alert", JOptionPane.WARNING_MESSAGE);
	}

	public static void main(String[] args) {
		new ShowMessageDialogAlert();
	}
}