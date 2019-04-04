package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;


public class QuestionViewServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//System.out.println("测试测试测试！");
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		if(method.equals("view")){
			request.getRequestDispatcher("/singleView.jsp").forward(request, response);
		}
		else if(method.equals("score")){
			//System.out.println("hhhhhhh");
			request.getRequestDispatcher("/result.jsp").forward(request, response);
		}
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	
	}
	
}
