package gestionDocs;

import java.sql.*;
import java.util.*;

public class TableDatas {
	/**
	 * Cette classe va permettre de récupérer les données de la bases de données.
	 * Plus précisément, elle va y joindre les trois tables correspondantes aux clés
	 * étrangères et récupérer certaines de leurs données spécifiques afin de les
	 * afficher à la place des clés étrangères. Les noms, en l'occurrence.
	 * 
	 * Chaque ligne de la base de donnée document sera stockée dans une liste de
	 * listes puis le tout sera transféré dans un tableau bidimensionnel pour
	 * pouvoir être utilisé par JTable dans la classe GestionDocuments.
	 * 
	 * @return
	 */

	public static String[][] get() {
		List<List<String>> rows = new ArrayList<>();
		try {
			Connection con = ConnexionDB.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT d.DOC_ID, d.DOC_NAME, d.DOC_DATE, d.DOC_SIZE, d.DOC_VERSION, d.DOC_PRIVACY, d.DOC_APPROVED_BY, t.TYPE_NAME, c.CATEGORY_NAME, u.USER_USERNAME "
							+ "FROM document d " + "LEFT JOIN document_type t ON d.TYPE_ID = t.TYPE_ID "
							+ "LEFT JOIN categorie c ON d.CATEGORY_ID = c.CATEGORY_ID "
							+ "LEFT JOIN user u ON d.USER_ID = u.USER_ID");

			while (rs.next()) {
				List<String> row = new ArrayList<>();
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					String columnName = rs.getMetaData().getColumnName(i);
					String value = rs.getString(columnName);
					if (columnName.equals("TYPE_NAME")) {
						value = rs.getString("t.TYPE_NAME");
					} else if (columnName.equals("CATEGORY_NAME")) {
						value = rs.getString("c.CATEGORY_NAME");
					} else if (columnName.equals("USER_USERNAME")) {
						value = rs.getString("u.USER_USERNAME");
					}
					row.add(value);
				}
				rows.add(row);
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String[][] result = new String[rows.size()][];
		for (int i = 0; i < rows.size(); i++) {
			List<String> row = rows.get(i);
			result[i] = row.toArray(new String[0]);
		}
		return result;
	}
}