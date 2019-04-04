<%@ page language="java" import="java.util.*,domain.*,dao.*,java.sql.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>result</title>
		<style type="text/css">
			div{
				margin:0 auto;
				text-align:center;
				background-color:#FFFFF4;
				}
			.div1{
				width:500px;
				height:300px;
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
		<jsp:useBean id="question" class="dao.QuestionDao" scope="session" />
		<jsp:setProperty name="question" property="*" />
		<% 
			int num=0;
			List<Question> new_questionView = question.QList();
			String s1="",s2="";
			boolean flag=true; //true： 题答完  false： 题未答完
			/*
			for(int i=0;i<new_questionView.size();i++){
				String[] sall = request.getParameterValues(new_questionView.get(i).id.toString());
				System.out.println("s="+sall);
			}
			*/
			///*
			for(int i=0;i<new_questionView.size();i++){
				String s=request.getParameter(new_questionView.get(i).id.toString());
				System.out.println("s="+s);
				if(s==null){
					s=" ";
					flag=false;
				}
				if(new_questionView.get(i).type.toString().equals("多选题")){
					String[] str1=request.getParameterValues(new_questionView.get(i).id.toString());
					String str2="";
					if(str1!=null){
						for(int j=0;j<str1.length;j++){
							if(str1[j]!=null){
								str2+=str1[j];
							}
						}
					}
					else{
						
					}
					s = str2;
					s1+="'";
					s2+="'";
				}
				s1+=s;
				s2+=new_questionView.get(i).trueAnswer.toString();	
				if(new_questionView.get(i).type.toString().equals("多选题")){
					s1+="'";
					s2+="'";
				}
			}
			//*/
			num = question.getScore(s1,s2);
			System.out.println("s1="+s1+"   s2="+s2);
			//System.out.println("num="+num);
			if(flag==false){
				out.println("<script>alert('题未答完！');</script>");
			}
			
		%>	
		
		<% 
			//System.out.println("result:session.getId()="+session.getId());
			String Login = (String)session.getAttribute("user");
			if(Login!=null){
				//System.out.println("exam:session.getId()="+session.getId());
				session.invalidate();
			}
			else{
				out.println("<script>alert('请先登录，谢谢！经过1秒之后，将会自动返回登录界面~');</script>");
				response.setHeader("Refresh","1;URL=login.jsp");
			}
		%>
		
		<div class="div1">
			<div class="div2"><br/>成绩</div>
			<div class="div3">	</div>
			<form  method=post name=form>
				
				<p><%=Login %> 您的得分为：<%=num%>分
				<br><br><br>
				<input type="button" value="退出" onclick="javascript:window.location.href ='/LittleSystem/Login.jsp';">
			</form>
		</div>	
		
	</body>
</html>