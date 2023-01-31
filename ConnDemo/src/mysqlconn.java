
import java.sql.*;

public class mysqlconn {
	public static void main(String args[]){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Ici, la DB se nomme demo
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");
			Statement stmt=con.createStatement();
			
			String sql = "INSERT INTO emp (age, name, favourite_food) VALUES ('43', 'Janine', 'Onigri')";
			stmt.executeUpdate(sql);

			// Là, la table se nomme emp
			ResultSet rs=stmt.executeQuery("select *  from emp");
			while(rs.next())
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			
		}catch (Exception e){
			
		}
	}
}
