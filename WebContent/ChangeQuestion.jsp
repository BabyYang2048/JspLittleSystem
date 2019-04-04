<%@ page language="java" import="java.util.*,domain.*,dao.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>修改习题</title>
		<% 
		System.out.println("question.jsp的当前路径="+request.getRequestURI());
		%>
		<style type="text/css">
			div{
				margin:0 auto;
				text-align:center;
				background-color:#FFFFF4;
				}
			.div1{
				width:500px;
				height:400px;
				border-color:black;
				border-style:solid;
				broder-width:2px;
				margin-top:100px;
				}	
			.div2{
				width:500px;
				height:80px;
				border-bottom-color:black;
				border-bottom-style:solid;
				border-bottomwidth:2px;
				line-height:30px;
				}
			.div3{
				font-size:18px;
				}
		</style>
	</head>
	<body bgcolor="lightpink">
		<% request.setCharacterEncoding("UTF-8"); %>
		<div class="div1" align="center">
			<div class="div2"><br/>修改习题</div>
			<div class="div3"></div>
		<Form action="./servlet/QuestionOperateServlet?message=add" method="post">
		<% request.setCharacterEncoding("UTF-8"); %>
		<jsp:useBean id="question" class="dao.QuestionDao" scope="session"/>
		<jsp:setProperty name="question" property="*" />
		<% 
			List<Question> new_questionView = question.QList(); 
			String change = (String)request.getParameter("id");	
			int num=0;
			System.out.println("change="+change);
			for(int i=0;i<new_questionView.size();i++){
				if(new_questionView.get(i).id.toString().equals(change)){
				num = i;
				out.print("<table><tr><td>题目</td><td>");
				out.print("<input type="+"'text'"+" name=title"+" value="+new_questionView.get(i).title.toString()+">");
				out.print("</td></tr><tr><td>选项A</td><td>");
				out.print("<input type="+"'text'"+" name=optionA"+" value="+new_questionView.get(i).optionA.toString()+">");
				out.print("</td></tr><tr><td>选项B</td><td>");
				out.print("<input type="+"'text'"+" name=optionB"+" value="+new_questionView.get(i).optionB.toString()+">");
				out.print("</td></tr><tr><td>选项C</td><td>");
				out.print("<input type="+"'text'"+" name=optionC"+" value="+new_questionView.get(i).optionC.toString()+">");
				out.print("</td></tr><tr><td>选项D</td><td>");
				out.print("<input type="+"'text'"+" name=optionD"+" value="+new_questionView.get(i).optionD.toString()+">");
				out.print("</td></tr><tr><td>正确答案</td><td>");
				out.print("<input type="+"'text'"+" name=trueAnswer"+" value="+new_questionView.get(i).trueAnswer.toString()+">");
				out.print("</td></tr><tr><td>题型</td><td>");
				out.print("<input type="+"'text'"+" name=type"+" value="+new_questionView.get(i).type.toString()+">");
				out.print("</td></tr><tr><td>");
				out.print("<input type="+"'submit'"+" name=submit"+" value='提交'"+">");
				out.print("<input type="+"'hidden'"+" name='id'"+" value="+new_questionView.get(num).id.toString()+">");
				out.print("</td></tr></table>");
				}
			}
			//request.setAttribute("id", new_questionView.get(num).id.toString());
			//<input name="uid" type="hidden" value=“<%=u.getID()” />
			System.out.println("new_questionView.get(num).id.toString()="+new_questionView.get(num).id.toString());
		%>
		</Form>
		</div>
	</body>
</html>