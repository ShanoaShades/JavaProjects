package jTable;

import javax.swing.*;
import javax.swing.event.*;

public class TableLSL {
	public static void main(String[] a) {
		JFrame f = new JFrame("Table Example");
		String data[][] = { { "101", "Amit", "670000" }, { "102", "Jai", "780000" }, { "101", "Sachin", "700000" } };
		String column[] = { "ID", "NAME", "SALARY" };
		final JTable jt = new JTable(data, column);
		// On active la sélection de cellule sur le tableau jt.
		jt.setCellSelectionEnabled(true);
		// On va définir le type de sélection qui sera utilisé.
		ListSelectionModel select = jt.getSelectionModel();
		select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// On ajoute un écouteur de sélection.
		select.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String Data = null;
				// On récupère l'index de la ligne sélectionnée.
				int[] row = jt.getSelectedRows();
				// On récupère l'index de la colonne sélectionnée
				int[] columns = jt.getSelectedColumns();
				
				for (int i = 0; i < row.length; i++) {
					for (int j = 0; j < columns.length; j++) {
						Data = (String) jt.getValueAt(row[i], columns[j]);
					}
				}
				System.out.println("Table element selected is: " + Data);
			}
		});
		JScrollPane sp = new JScrollPane(jt);
		f.add(sp);
		f.setSize(300, 200);
		f.setVisible(true);
	}
}

// Va falloir que je demande un coup de main pour celle-ci.