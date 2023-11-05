package com.pratham;
import java.sql.*;
public class StudentLoginDAO {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	int count;
	
	public StudentLoginModel checkLogin(StudentLoginModel m) {
		String name = m.getUsername();
		String pwd = m.getPassword();
		System.out.println(name + " " + pwd);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sem-5-java", "root", "");
			stmt = conn.createStatement();
			
			String sql = "SELECT COUNT(*) FROM login_details WHERE username = '" + name + "' AND password = '" + pwd + "'";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				count = rs.getInt(1);
				System.out.println(count);
			}
			if(count==1) {
				m.setValid(true);
			}
			else {
				m.setValid(false);
			}
		}
		catch(ClassNotFoundException e) {
			System.out.println(e);
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		return m;
	}
}
