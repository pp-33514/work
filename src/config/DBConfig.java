package config;
 
import java.sql.*;
 
public class DBConfig {
	private final String CONNECTION = "jdbc:mysql://localhost:3306/applicant";
	private final String USERNAME = "root";
	private final String PASSWORD = "";
	private static Connection con = null;
 
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws SQLException{
		if(con == null || con.isClosed()) {
			con = (Connection) DriverManager.getConnection(CONNECTION,USERNAME,PASSWORD);
		}
		return con;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DBConfig dbconfig = new DBConfig();
			Connection connection =  dbconfig.getConnection();
			if(connection != null) {
				System.out.println("Connection established successfully.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
 
	}
}