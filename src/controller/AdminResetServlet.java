package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import domain.User;

/**
 * Servlet implementation class AdminResetServlet
 */
@WebServlet("/AdminResetServlet")
public class AdminResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminResetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		System.out.println("测试测试测试测试，，，");
		String message = request.getParameter("message");
		String path = request.getParameter("dqljpath");
		//System.out.println("message="+message);
		//System.out.println("path="+path);
		String pathnew = "";
		for(int i =13;i<path.length();i++){
			pathnew +=path.charAt(i); 
		}
		
		UserService service = new UserService();
		boolean user = service.resetPassword(message);
		if(user==true){
			//System.out.println("修改成功！");
			request.getRequestDispatcher(pathnew).forward(request, response);
		}
		else{
			System.out.println("修改失败！");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
