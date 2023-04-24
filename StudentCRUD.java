package com.org.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentCRUD {

				// TO SAVE STUDENT DATA
	
	public static boolean saveStudent(int roll, String name, int age, String email, String gender) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/jdbc_school_1?user=root&password=root");
			String sql = "INSERT INTO student VALUES(?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, roll);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setString(4, email);
			ps.setString(5, gender);

			ps.execute();
			con.close();

			return true;
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void displayStudentDetails() { // for retriving student data

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/jdbc_school_1?user=root&password=root");
			String sql = "SELECT * FROM student";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			// creating table columns

			System.out.printf("%-5s", "roll");
			System.out.printf("%-25s", "name");
			System.out.printf("%-5s", "age");
			System.out.printf("%-30s", "email");
			System.out.println("gender");
			System.out.println("--------------------------------------------------------------------------------------------------");

			// retriving table data

			while (rs.next()) {
				System.out.printf("%-5s", rs.getInt(1));
				System.out.printf("%-25s", rs.getString(2));
				System.out.printf("%-5s", rs.getInt(3));
				System.out.printf("%-30s", rs.getString(4));
				System.out.println( rs.getString(5) );
			}
			con.close();
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int deleteStudentData(int roll) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/jdbc_school_1?user=root&password=root");
			String sql = "DELETE FROM student WHERE roll = " + roll;
			Statement st = con.createStatement();

			int res = st.executeUpdate(sql);
			con.close();

			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roll;
	}

	public static int updateName(int roll, String name) {

		try { // with preparedstatement
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/jdbc_school_1?user=root&password=root");
			String sql = "UPDATE student SET name = ? WHERE roll = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, name);
			ps.setInt(2, roll);
			int res = ps.executeUpdate();
			con.close();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int updateAge(int roll, int age) {

		try { // with preparedstatement
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/jdbc_school_1?user=root&password=root");
			String sql = "UPDATE student SET age = ? WHERE roll = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, age);
			ps.setInt(2, roll);
			int res = ps.executeUpdate();
			con.close();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int updateEmail(int roll, String email) {

		try { // with preparedstatement
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/jdbc_school_1?user=root&password=root");
			String sql = "UPDATE student SET age = ? WHERE roll = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, email);
			ps.setInt(2, roll);

			int res = ps.executeUpdate();
			con.close();

			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int updateStudent(int roll, String name, int age, String email, String gender) {

		try { // with preparedstatement
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/jdbc_school_1?user=root&password=root");
			String sql = "UPDATE student SET name = ?, age = ?, email = ?, gender = ? WHERE roll = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, email);
			ps.setString(4, gender);
			ps.setInt(5, roll);

			int res = ps.executeUpdate();
			con.close();

			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
