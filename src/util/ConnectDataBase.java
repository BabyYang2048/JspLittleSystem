package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDataBase {
	private Connection conn = null;
	public ConnectDataBase(){
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/xuyang?user=root&password=root&useUnicode=true&characterEncoding=UTF-8"; 
//		String url = "jdbc:mysql://127.0.0.1:3306/xuyang";
//		String username = "root";
//		String password = "root";
//		String encoding = "useUnicode=true&characterEncoding=UTF-8";
		try {
				System.out.println("正在连接数据库...");
				Class.forName(driverName);
				//conn = DriverManager.getConnection(url,username,password);
				conn = DriverManager.getConnection(url);
				System.out.println("数据库连接成功！");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("数据库连接失败");
			}	
	}
	
	public Connection getConn(){
		return conn;
	}
	
}
