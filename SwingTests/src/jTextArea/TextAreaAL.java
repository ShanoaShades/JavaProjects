package jTextArea;

import javax.swing.*;
import java.awt.event.*;

// On ajoute des récepteurs sur les objets suivants
public class TextAreaAL implements ActionListener {
	JLabel l1, l2;
	JTextArea area;
	JButton b;
// On paramètre nos objets
	TextAreaAL() {
		// On alloue un espace mémoire pour un objet f de type JFrame
		JFrame f = new JFrame();
		// On crée un objet de classe JLabel et on le paramètre
		l1 = new JLabel();
		l1.setBounds(50, 25, 100, 30);
		l2 = new JLabel();
		l2.setBounds(160, 25, 100, 30);
		area = new JTextArea();
		area.setBounds(20, 75, 250, 200);
		b = new JButton("Count Words");
		b.setBounds(100, 300, 120, 30);
		b.addActionListener(this);
		// On paramètre l'objet f en fonction des paramètres desa classe.
		f.add(l1);
		f.add(l2);
		f.add(area);
		f.add(b);
		f.setSize(450, 450);
		f.setLayout(null);
		f.setVisible(true);
	}

	// On définit les actions qui seront exécutées en intéragissant avec les objets/récepteurs
	public void actionPerformed(ActionEvent e) {
		// On crée l'objet text de classe String à partir du contenu de l'objet area de classe TextArea
		String text = area.getText();
		/* Ici, c'est un peu tricky, on crée l'objet words [] (tableau ?)de type String à partir du contenu du texte qui aura été splitté  à chaque fois que ce qui est entre () se présentera ici \\s un espace j'imagine.
		On va ensuite récupérer le nombre de fois où le split a eu lieu et stocker chaque partie splittée donc mot dans le tableau words. */
		String words[] = text.split("\\s");
		// On définit le texte de l'objet l1 à partir de la longueur du tableau words et donc, le nombre de portions de texte splittées qu'il contient (mots)
		l1.setText("Words: " + words.length);
		// On récupère simplement la longueur l'objet de texte donc chaque caractère et on l'envoie dans l'objet l2 pour affichage.
		l2.setText("Characters: " + text.length());
	}

	public static void main(String[] args) {
		new TextAreaAL();
	}
}
