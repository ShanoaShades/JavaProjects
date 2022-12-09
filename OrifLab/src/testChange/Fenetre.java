package testChange;

import javax.swing.*;

import java.awt.event.*;

public class Fenetre implements ActionListener {
	JFrame f;
	JLabel title, labelName, labelFirstName, labelAge, labelSection;
	JTextField fieldFirstName, fieldName, fieldAge, fieldSection;
	JButton confirm;
	Bouton boutons;
	//Member newMember;
	
	String firstName = "";
	String name = "";
	String age = "";
	String section = "";
	String msg = "";

	Fenetre() {
		// On alloue l'espace mémoire pour l'objet newMember
		//newMember = new Member();
		Bouton boutons = new Bouton();
		// AFFICHAGE
		f = new JFrame("Convertisseur de devises");
		// LABELS
		title = new JLabel("Convertisseur de devises");
		title.setBounds(0, 30, 500, 30);
		title.setHorizontalAlignment(JLabel.CENTER);
		labelFirstName = new JLabel("Prénom");
		labelFirstName.setBounds(100, 100, 50, 30);
		labelName = new JLabel("Nom");
		labelName.setBounds(100, 150, 50, 30);
		labelAge = new JLabel("Âge");
		labelAge.setBounds(100, 200, 50, 30);
		labelSection = new JLabel("Section");
		labelSection.setBounds(100, 250, 50, 30);
		
		// CHAMPS DE TEXTE
		fieldFirstName = new JTextField();
		fieldFirstName.setBounds(170, 100, 200, 30);
		fieldName = new JTextField();
		fieldName.setBounds(170, 150, 200, 30);
		fieldAge = new JTextField();
		fieldAge.setBounds(170, 200, 200, 30);
		fieldSection = new JTextField();
		fieldSection.setBounds(170, 250, 200, 30);
		
		// BOUTON

		confirm = new JButton("POUET");
		confirm.setBounds(190, 350, 100, 25);
		confirm.addActionListener(this);

		f.add(title);
		f.add(fieldFirstName);
		f.add(fieldName);
		f.add(fieldAge);
		f.add(fieldSection);
		f.add(labelName);
		f.add(labelFirstName);
		f.add(labelAge);
		f.add(labelSection);
		f.add(boutons);
		f.add(confirm);
		f.setSize(500, 500);
		f.setLayout(null);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		/*firstName = fieldFirstName.getText();
		name = fieldName.getText();
		age = fieldAge.getText();
		section = fieldSection.getText();
		
		if (firstName.isEmpty() || name.isEmpty() || age.isEmpty() || section.isEmpty() == true) {
			JOptionPane.showMessageDialog(f, "Vous devez remplir tous les champs !", "MESSAGE", JOptionPane.ERROR_MESSAGE);
		}
		else {
			newMember.setFirstName(firstName);
			msg = "Prénom : " + newMember.getFirstName() + "\n";
			newMember.setName(name);
			msg += "Nom : " + newMember.getName() + "\n";
			newMember.setAge(age);
			msg += "Âge : " + newMember.getAge() + "\n";
			newMember.setSection(section);
			msg += "Section : " + newMember.getSection() + "\n-----------------\n";
			
			JOptionPane.showMessageDialog(f, msg + "Merci pour votre inscription");
		}*/
	}

	
}