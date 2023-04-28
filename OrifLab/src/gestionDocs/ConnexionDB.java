package gestionDocs;

import java.sql.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class ConnexionDB {
	/**
	 * Cette classe s'occupe de la connexion à la base de données. Elle a été mise à
	 * part pour davantage de sécurité. De plus, elle va aller lire les informations
	 * dans un fichier xml situé hors du code pour encore plus de sécurité !
	 */

	public static Connection getConnection()
			throws SQLException, ClassNotFoundException, ParserConfigurationException, Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		String path = System.getProperty("user.dir") + "/src/gestionDocs/config.xml";
		Document doc = builder.parse(path);

		NodeList urlList = doc.getElementsByTagName("url");
		NodeList userList = doc.getElementsByTagName("user");
		NodeList passwordList = doc.getElementsByTagName("password");

		String url = urlList.item(0).getTextContent();
		String user = userList.item(0).getTextContent();
		String password = passwordList.item(0).getTextContent();

		return DriverManager.getConnection(url, user, password);
	}
}
