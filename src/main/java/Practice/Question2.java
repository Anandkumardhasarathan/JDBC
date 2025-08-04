package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Question2 {
	public static void main(String[] args) throws SQLException{
//		create();
//		insertrt2();
		read();
		readMaxMark();
	}
	
	public static void create() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/placement_training";
		String un = "root";
		String pw = "7547";
		String q = "create table task2(RollNo int, StudentName varchar(30), Mark int);";
//		String i = "insert into task2 values(001,'Anand','Dharmapuri'),(002, 'Barani Keshava', 'Valappady'),(003, 'Kalaipriyan','Dharmapuri');";
		Connection c = DriverManager.getConnection(url, un, pw);
		Statement s = c.createStatement();
		s.executeUpdate(q);
	}
	
	public static void read() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/placement_training";
		String un = "root";
		String pw = "7547";
		String q = "Select * from task2";
		Connection c = DriverManager.getConnection(url, un, pw);
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(q);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" \t\t | "+ rs.getString(3));
		}
		
		
	}
	
	public static void insertrt1() throws SQLException{
		Scanner scan = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/placement_training";
		String un = "root";
		String pw = "7547";
		Connection c = DriverManager.getConnection(url, un, pw);
		Statement s = c.createStatement();
		
		System.out.print("Enter the Number of values to be insert : ");
		int n = scan.nextInt();
		
		for(int k = 1;k<=n;k++) {
			
			int val1 = scan.nextInt();
			scan.nextLine();
			
			String val2 = scan.nextLine();
			
			
			String val3 = scan.nextLine();
			
			String q = "insert into task2 values("+val1+",'"+val2+"','"+val3+"');";
			s.executeUpdate(q);
			
		}

	}
	
	
	
	public static void insertrt2() throws SQLException{
		Scanner scan = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/placement_training";
		String un = "root";
		String pw = "7547";
		String q="insert into task2 values(?,?,?);";
		Connection c = DriverManager.getConnection(url, un, pw);
		Statement s = c.createStatement();
		
		PreparedStatement ps=c.prepareStatement(q);
		
		System.out.print("Enter the no of Students Written Exam : ");
		int n=scan.nextInt();
		
		for(int i=1;i<=n;i++)
		{
				System.out.println("Enter the Student Roll No : ");
				int roll=scan.nextInt();
				scan.nextLine();
				
				System.out.println("Enter the Student Name : ");
				String str=scan.nextLine();
				
				System.out.println("Enter the Student Mark : ");
				int mark = scan.nextInt();
				
				ps.setInt(1, roll);
				ps.setString(2, str);
				ps.setInt(3, mark);
				ps.executeUpdate();
		}

	}
	
	
	public static void readMaxMark() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/placement_training";
		String un = "root";
		String pw = "7547";
		
		String q = "select StudentName, case when Mark>=90 then 'A Grade' when Mark>=80 then 'B Grade' when Mark>=70 then 'C Grade' else 'Fail' end as Grade from task2 order by grade limit 3;";
		Connection c = DriverManager.getConnection(url, un, pw);
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(q);
		
		System.out.println();
		System.out.println("Max Grade");
		System.out.println();
		while(rs.next()) {
			System.out.println(rs.getString(1)+" - "+rs.getString(2));
		}
		
		
	}
}
