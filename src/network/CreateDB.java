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
			System.out.println("����̹��ε� ����.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error ����̹� �ε� ����.");
			e.printStackTrace();
		}
		
		Properties properties = new Properties();
		properties.setProperty("user","root");
		properties.setProperty("password", "root");
		properties.setProperty("useSSL", "true");	//Connecting Securely Using SSL
		properties.setProperty("autoReconnect", "true");
		properties.setProperty("serverTimezone",  "UTC");//The server time zone
		
		try {
			//DB�� Ŀ�ؼ��� �����ϰ� Ŀ�ؼ� ��ü�� ��ȯ.
			conn = DriverManager.getConnection(jdbc_url, properties); //DB�� Ŀ�ؼ��� �����ϰ�, Ŀ�ؼ� ��ü�� ��ȯ.
			//conn = DriverManager.getConnection(jdbc_url, "root", "iotiot");
			System.out.println("Ŀ�ؼ� ���� ����.");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error. Ŀ�ؼ� ���� ����.");
			e.printStackTrace();
		}
		
		try {
			stmt = conn.createStatement();								
			System.out.println("statement�� ��ü ����.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error.statement��ü ���� ����.");
			e.printStackTrace();
		}		
	
		
		try {
			String sql="";
			sql = "create database if not exists addr2db;";//DB����.
			stmt.executeUpdate(sql);
			sql = "use addr2db;";
			stmt.executeUpdate(sql);
			sql = "create table if not exists addr2( num int ) ";//���̺� ����
			stmt.executeUpdate(sql);
			sql = "insert into addr2 (num) values (5);"; //���ڵ� �ϳ� ����.
			stmt.executeUpdate(sql);
			
			System.out.println("sql�� ����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sql�� ����");
			e.printStackTrace();
			
		}		
		
		try {
			conn.close();
			System.out.println("connection��ü ��������");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("connection��ü ���� ����.");
			e.printStackTrace();
		}		
						
		
	}

}
