<%@ page language="java"  import="java.util.*,domain.*,dao.QuestionDao" contentType="text/html;  charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>exam</title>
		<style>
			th.thsize{width:200px;height:35px;}
		</style>
	</head>
	<body bgcolor="lightpink">
		<% request.setCharacterEncoding("UTF-8"); %>
		<% String login = (String)session.getAttribute("user"); %>
		<br/><h1 align="center"><font face="楷体">欢迎<%=login %>来到考试中心</font></h1>
		<br/><h2 align="center"><font face="楷体">试题集</font></h2>
		<form  action="" method=post name=form>
			<table border="1" align="center" rules="rows" frame="hsides">
				<thead>
					<tr>
						<th class="thsize"><font face="宋体" size="4">试题编号</font></th>
						<th class="thsize"><font face="宋体" size="4">题目</font></th>
						<th class="thsize"><font face="宋体" size="4">题型</font></th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th class="thsize"> </th>
						<th class="thsize"><font face="宋体" size="4"><a href="./QuestionViewServlet?method=view">点击查看全部试题</a></font></th>					
						<th class="thsize"> </th>
					</tr>
					
				</tfoot> 	
				<tbody>
					<% request.setCharacterEncoding("UTF-8"); %>
					<jsp:useBean id="question" class="dao.QuestionDao" scope="session"/>
					<jsp:setProperty name="question" property="*" />
					<% 
						List<Question> new_question = question.QList();
						int j=1;
						for(int i=0;i<new_question.size();i++){
							out.print("<tr>");
							out.print("<th class="+"thsize"+">"+j+"</th>");
							out.print("<th>"+new_question.get(i).title.toString()+"</th>");
							out.print("<th>"+new_question.get(i).type.toString()+"</th>");
							out.print("</tr>");
							j++;
						}
					%>
				
				</tbody>
			</table>
		</form>		
		

		<% 
			String Login = (String)session.getAttribute("user");
			//System.out.println("Login="+Login);
			if(Login!=null){
				//System.out.println("exam:session.getId()="+session.getId());
				out.println("<script>alert('欢迎你！');</script>");
			}
			else{
				out.println("<script>alert('请先登录，谢谢！经过3秒之后，将会自动返回登录界面~');</script>");
				response.setHeader("Refresh","3;URL=/LittleSystem/Login.jsp");
			}
		%>
	</body>
</html>