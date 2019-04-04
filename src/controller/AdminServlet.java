package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import service.UserService;
import domain.User;


public class AdminServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//System.out.println("测试测试测试测试...");
		request.setCharacterEncoding("UTF-8");
		String message = request.getParameter("message");
		String path = request.getParameter("dqljpath");
		//System.out.println("message="+message);
		//System.out.println("path="+path);
		String pathnew = "";
		for(int i =13;i<path.length();i++){
			pathnew +=path.charAt(i); 
		}
		//System.out.println("pathnew="+pathnew);
		UserService service = new UserService();
		User user = service.deleteUser(message);
		if(user==null){
			System.out.println("删除成功！");
			request.getRequestDispatcher(pathnew).forward(request, response);
		}
		else{
			System.out.println("删除失败！");
		}
		
	} 

	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	
	}


}
