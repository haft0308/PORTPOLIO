package network;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CreateDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";//"org.gjt.mm.mysql.Driver";
														//"com.mysql.jdbc.Driver"
		String jdbc_url = "jdbc:mysql://localhost:3306";//jdbc:subprotocol:subname
		Statement stmt=null;
		
		try {
			Class.forName(jdbc_driver);
			System.out.println("드라이버로드 성공.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error 드라이버 로드 실패.");
			e.printStackTrace();
		}
		
		Properties properties = new Properties();
		properties.setProperty("user","root");
		properties.setProperty("password", "root");
		properties.setProperty("useSSL", "true");	//Connecting Securely Using SSL
		properties.setProperty("autoReconnect", "true");
		properties.setProperty("serverTimezone",  "UTC");//The server time zone
		
		try {
			//DB에 커넥션을 수립하고 커넥션 객체를 반환.
			conn = DriverManager.getConnection(jdbc_url, properties); //DB에 커넥션을 수립하고, 커넥션 객체를 반환.
			//conn = DriverManager.getConnection(jdbc_url, "root", "iotiot");
			System.out.println("커넥션 수립 성공.");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error. 커넥션 수립 실패.");
			e.printStackTrace();
		}
		
		try {
			stmt = conn.createStatement();								
			System.out.println("statement의 객체 생성.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error.statement객체 생성 실패.");
			e.printStackTrace();
		}		
	
		
		try {
			String sql="";
			sql = "create database if not exists addr2db;";//DB생성.
			stmt.executeUpdate(sql);
			sql = "use addr2db;";
			stmt.executeUpdate(sql);
			sql = "create table if not exists addr2( num int ) ";//테이블 생성
			stmt.executeUpdate(sql);
			sql = "insert into addr2 (num) values (5);"; //레코드 하나 삽입.
			stmt.executeUpdate(sql);
			
			System.out.println("sql문 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sql문 실패");
			e.printStackTrace();
			
		}		
		
		try {
			conn.close();
			System.out.println("connection객체 해제성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("connection객체 해제 실패.");
			e.printStackTrace();
		}		
						
		
	}

}
