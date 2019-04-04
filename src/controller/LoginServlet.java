package controller;


import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import domain.User;
import service.UserService;
import util.MD5;


/**
 * @author BabyYang
 *处理用户登录的servlet 
 */

public class LoginServlet extends HttpServlet {

	/**
	 * 这个字段是实现了java.io.Serializable接口需要的，但不必须
	private static final long serialVersionUID = -6004582198883561992L;
	*/
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("login");
		String pwd = "";	
		UserService service = new UserService();
		if(password.toString().equals("000000")){
			pwd="000000";
		}else{
			pwd = MD5.getResult(password);
			//System.out.println("pwd="+pwd);
		}
		User user = service.loginUser(username, pwd,type);
		//System.out.println("身份="+type);		
		if(user==null){		
			request.getRequestDispatcher("/Message.jsp").forward(request, response);
		}
		else{
			if(type.equals("0")){
				request.getSession().setAttribute("userAdm", user.username.toString());
				request.getRequestDispatcher("/adminIndex.jsp").forward(request, response);
			}
			else if(type.equals("1")){
				request.getSession().setAttribute("userTea", user.username.toString());
				request.getRequestDispatcher("/teacherIndex.jsp").forward(request, response);
			}
			else if(type.equals("2")){
				request.getSession().setAttribute("user", user.username.toString());
				request.getRequestDispatcher("/index.jsp").forward(request, response);	
			}
		}
	} 

	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	}
	
	
}
