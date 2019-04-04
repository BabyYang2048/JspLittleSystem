package controller;


import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import service.UserService;
import domain.User;
import util.MD5;


/**
 * @author BabyYang
 *处理用户注册的servlet 
 */

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//System.out.println("测试测试测试！");
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password1 = request.getParameter("password1");
		String classno = request.getParameter("classno");
		String schoolno = request.getParameter("schoolno");
		String type = request.getParameter("register");
		UserService service = new UserService();
		User user;
		
		boolean isOK=true;
			//情况 1：用户名为空
			if(username==null||username.trim().equals("")){
				isOK = false;
				request.setAttribute("usernametip","用户名不能为空");
			}
			//情况2a：密码为空
			//情况2b：密码不是3-8位的数字	
			if(password==null||password.trim().equals("")){
				isOK = false;
				request.setAttribute("passwordtip","密码不能为空");
			
			}
			else{
				if(!password.matches("\\d{3,10}")){
					isOK = false;
					request.setAttribute("passwordtip","密码必须是3-10位数字");
				
				}
			}
			//情况3：确认密码和第一次密码不一致
			if(password1.trim().toString()==(password.trim().toString())){
				isOK = false;
				request.setAttribute("password1tip","两次密码要一致");
			}
			if(classno==null||classno.trim().equals("")){
				isOK = false;
				request.setAttribute("classnotip","班级不能为空");
			}
			if(schoolno==null||classno.trim().equals("")){
				isOK = false;
				request.setAttribute("schoolnotip","学号不能为空");
			}
			else{
				//System.out.println("schoolno=:"+schoolno);
				user = service.findUser(schoolno);
				if(user!=null){
					isOK = false;
					request.setAttribute("schoolnotip","学号已存在");
				}
				//System.out.println("user:="+user);
			}
			if(type==null){
				isOK = false;
				request.setAttribute("typetip","类型不能为空");
			}
		
		if(isOK==false){
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		else{
			String pwd = MD5.getResult(password);
			System.out.println("pwd="+pwd);
			user = service.registerUser(username, pwd, type,classno,schoolno);
			if(user!=null){
				request.getRequestDispatcher("/registerSuccess.jsp").forward(request, response);
			}
			else if(user==null){
				System.out.println("注册失败了（一会我写这块！）");
			}
		}
		
		
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	
	}
}
