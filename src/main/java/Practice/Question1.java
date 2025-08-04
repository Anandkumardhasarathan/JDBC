package Practice;

import java.sql.*;
public class Question1 {

	public static void main(String[] args) throws SQLException{
//		create();
		read();

	}
	
	public static void create() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/placement_training";
		String un = "root";
		String pw = "7547";
		String q = "create table task(EmpId int, EmpName varchar(30), EmpLocation varchar(30));";
		String i = "insert into task values(001,'Anand','Dharmapuri'),(002, 'Barani Keshava', 'Valappady'),(003, 'Kalaipriyan','Dharmapuri');";
		Connection c = DriverManager.getConnection(url, un, pw);
		Statement s = c.createStatement();
		s.executeUpdate(i);
	}
	
	public static void read() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/placement_training";
		String un = "root";
		String pw = "7547";
		String q = "Select * from task";
		Connection c = DriverManager.getConnection(url, un, pw);
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(q);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" \t\t | "+ rs.getString(3));
		}
	}

}
