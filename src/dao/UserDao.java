package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.User;
import util.ConnectDataBase;


/*
 * dao层直接和数据库交互
 * 基本操作有增删改查
 * */
public class UserDao {

	
	/*
	 * 根据用户名和密码来查找用户
	 * @param username
	 * @param password
	 * @return 查找到的用户 
	 */
	public User match(String un,String pw,String type) {
		
		User user = null;
		
		ConnectDataBase cdb = new ConnectDataBase(); 
		Connection conn = cdb.getConn();
		
		//防止sql注入
		String sql ="select * from user where(username=? and password=? and type=?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,un);
			pstmt.setString(2,pw);
			pstmt.setString(3,type);
			ResultSet rs = pstmt.executeQuery();
		
			while(rs.next()){
				user = new User();
				user.username = rs.getString("username");
				user.password = rs.getString("password");
				user.type = rs.getString("type");
			}
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("这里好像不太对！");
		}
		return user;
	}
	
	
	public User add(String un,String pw,String type, String classno, String schoolno){
		User user = null;
		ConnectDataBase  cdb = new ConnectDataBase();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = cdb.getConn();
			String sql = "insert into user(username,password,type,classno,schoolno) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,un);
			pstmt.setString(2,pw);
			pstmt.setString(3,type);
			pstmt.setString(4, classno);
			pstmt.setString(5, schoolno);
			pstmt.executeUpdate();

			//user = userfind(un);
			user = match(un,pw,type);
			
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
		return user;
	}
	
	
	public List<User> UList() {
		
		User user = null;
		List<User> userList = new ArrayList<User>();
		ConnectDataBase cdb = new ConnectDataBase();
		Connection conn = cdb.getConn();
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;

		String sql1 = "select * from user";
		
		try{
			pstmt1=conn.prepareStatement(sql1);
			rs = pstmt1.executeQuery();
			
			while(rs.next()){
				user = new User();
				user.username = rs.getString("username");
				user.password = rs.getString("password");
				user.type = rs.getString("type");
				user.classno = rs.getString("classno");
				user.schoolno = rs.getString("schoolno");
				userList.add(user);
			}
			if(rs!=null) rs.close();
			if(pstmt1!=null) pstmt1.close();
			if(conn!=null)	conn.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return userList;
	}
	
	
	/**
	 * 管理员删除用户
	 */
	public User deleteUser(String message){
		User user = null;
		
		ConnectDataBase cdb = new ConnectDataBase();
		Connection conn = cdb.getConn();
		PreparedStatement pstmt = null;
		
		
		try {
			String sql = "delete from user where schoolno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,message);
			pstmt.executeUpdate();
			
			//user = match(un,pw,type);
			user = finduser(message);
			
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return user;
	}

	/**
	 * 根据编号查找返回用户
	 * 用户规则存储规则：所有人员编号不能一样 
	 */
	public User finduser(String message) {
		User user = null;
		ConnectDataBase cdb = new ConnectDataBase(); 
		Connection conn = cdb.getConn();
		
		//防止sql注入
		String sql ="select * from user where schoolno = ?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,message);
			ResultSet rs = pstmt.executeQuery();
		
			while(rs.next()){
				user = new User();
				user.username = rs.getString("username");
				
			}
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("这里好像不太对！");
		}
	
		return user;
	}
	
	/**
	 * 管理员重置用户密码
	 */
	public boolean resetPassword(String message){
		boolean flag = false;
		ConnectDataBase cdb = new ConnectDataBase(); 
		Connection conn = cdb.getConn();
		
		//防止sql注入
		String sql ="update user set password = '000000' where schoolno = ?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,message);
			pstmt.executeUpdate();
			flag = true;
		
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			flag = false;
		}
	
		
		return flag;
	}


}
