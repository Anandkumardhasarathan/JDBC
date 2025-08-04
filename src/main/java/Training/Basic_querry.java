package Training;

import java.sql.*;

public class Basic_querry {

	public static void main(String[] args) throws SQLException {
		create();
	}
	public static void create() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/placement_training";
		String un = "root";
		String pw = "7547";
		String q = "create table students(Roll_no int, Name varchar(30));";
		String i = "insert into students values(1,'Anand'),(2,'Harish');";		
		String u = "alter table students add column year int;";
		String safe = "set SQL_SAFE_UPDATES=0;";
		String setVal = "update students set passedOut_year = 2026 where Roll_no = 2;";
		String addCol = "alter table students add column passedOut_year int;";
		String del = "Delete from students where Roll_no = 2;";
		String alt = "Alter table students drop column passedOut_year;";
		Connection c = DriverManager.getConnection(url, un, pw);
		Statement s = c.createStatement();
		s.executeLargeUpdate(alt);
	}
}