package controller;


import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;


/**
 * @author BabyYang
 *处理用户注销的servlet 
 */

public class LoginOutServlet extends HttpServlet {

	/**
	 * 这个字段是实现了java.io.Serializable接口需要的，但不必须
	private static final long serialVersionUID = -6004582198883561992L;
	*/
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		System.out.println("测试测试测试测试。");
		String message = request.getParameter("message");
		if(message.equals("admin")){
			 request.getSession().removeAttribute("userAdm");
			 request.getRequestDispatcher("/Login.jsp").forward(request, response);
			
		}
		else if(message.equals("teacher")){
			request.getSession().removeAttribute("userTea");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
	} 

	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	
	}
}
