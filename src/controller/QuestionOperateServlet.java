package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import domain.*;

/**
 * Servlet implementation class QuestionOperate
 */
@WebServlet("/QuestionOperate")
public class QuestionOperateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionOperateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("c测试测试！！！");
		request.setCharacterEncoding("UTF-8");
		String message = request.getParameter("message");
		//System.out.println("message="+message);
		
		UserService service = new UserService();
		
		if(message.equals("add")){
			String title = request.getParameter("title");
			String optionA = request.getParameter("optionA");
			String optionB = request.getParameter("optionB");
			String optionC = request.getParameter("optionC");
			String optionD = request.getParameter("optionD");
			String trueAnswer = request.getParameter("trueAnswer");
			String type = request.getParameter("type");
			Question question = service.addQuestion(title, optionA, optionB, optionC, optionD, trueAnswer, type);

			String id1 = request.getParameter("id");
			//System.out.println("!!!!!!!id1="+id1);
			if(id1!=null){
				service.deleteQuestion2(id1);
			}
			
			if(question!=null){
				System.out.println("添加成功！");
				System.out.println("当前路径="+request.getRequestURI());
				request.getRequestDispatcher("/Question.jsp").forward(request, response);
			}
			else{
				System.out.println("添加失败！");
			}
		}
		
		else if(message.equals("delete")){
			String path = request.getParameter("dqljpath");
			String pathnew = "";
			for(int i =13;i<path.length();i++){
				pathnew +=path.charAt(i); 
			}
			System.out.println("pathnew="+pathnew);
			String title = request.getParameter("id");
			System.out.println("title="+title);
			Question question = service.deleteQuestion2(title);
			if(question==null){
				System.out.println("删除成功！");
				request.getRequestDispatcher(pathnew).forward(request, response);
			}
			else{
				System.out.println("删除失败！");
			}
			
		}
		
		else{
			System.out.println("其他操作！");
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
