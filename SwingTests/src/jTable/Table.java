package jTable;

import javax.swing.*;

public class Table {
	JFrame f;

	Table() {
		f = new JFrame();
		/* En créant notre tableau, un objet avec [][] va indiquer qu'il s'agira de lignes tandisqu'un seul [] va indiquer les colonnes.
		On ouvre des accolades{} et chaque groupe d'accolades à l'intérieur sera une nouvelle ligne d edonnées. */
		String data[][] = { { "101", "Amit", "670000" }, { "102", "Jai", "780000" }, { "101", "Sachin", "700000" } };
		String column[] = { "ID", "NAME", "SALARY" };
		// Ensuite on crée notre tableau jt en lui donnant les paramètres (lignes, collonnes)
		JTable jt = new JTable(data, column);
		jt.setBounds(30, 40, 200, 300);
		// On va utiliser  la classe JScrollPane pour mettre le tableau en forme donc on va créer un objet de cette classe en lui donnant le tableau jt comme attribut
		JScrollPane sp = new JScrollPane(jt);
		f.add(sp);
		f.setSize(300, 400);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Table();
	}
}