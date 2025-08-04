package JDBC_READ_OPERATION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class read_querry {
	
	public static void main(String[] args) throws SQLException {
		read();
//		create();
	}
	
	public static void read() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/placement_training";
		String un = "root";
		String pw = "7547";
		String q = "select * from sample; ";
		Connection c = DriverManager.getConnection(url, un, pw);
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(q);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+ " "+rs.getString(2));
		}
	}
	
	public static void create() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/placement_training";
		String un = "root";
		String pw = "7547";
		String q = "create table sample(rno int, name varchar(30));";
		String v = "insert into sample values(1,'Anand'),(2, 'Barani');";
		Connection c = DriverManager.getConnection(url,un,pw);
		Statement s = c.createStatement();
		s.executeUpdate(v);
		
	}

	

}
