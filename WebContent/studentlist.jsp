<%@ page language="java" import="java.util.*,domain.*,dao.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>管理员管理界面</title>
		<%
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		%>
	 	<base href="<%=basePath%>">
		<link href="css/jq22.css" rel="stylesheet" type="text/css">
		<script src="js/jquery-1.7.2.min.js"></script>
		<script src="js/jquery.movebg.js"></script>
		
		<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
    	<link rel="stylesheet" href="css/jqTable.css">
    	<style>
	      .p20{padding:20px;}

	    </style>
	</head>
	<body>
		<%request.setCharacterEncoding("UTF-8"); %>
		<% String login = (String)session.getAttribute("userAdm"); %>
		<!-- 代码 开始 -->
		<div class="wraper">
			<h1 align="center"><font size=6px>欢迎 <%=login %> 来到在线考试系统  --管理员界面</font></h1>
			&nbsp;
		    <div class="nav">
		        <ul>
		            <li class="nav-item"><a></a></li>
		            <li class="nav-item cur"><a href="teacherlist.jsp">教师系统管理</a></li>
		            <li class="nav-item"><a></a></li>
		            <li class="nav-item"><a href="studentlist.jsp">学生系统管理</a></li>
		            <li class="nav-item"><a></a></li>
		        </ul>
		    </div>
		    &nbsp;
		    <div class="p20">
		        <div class="c-table c-table--border J-table-height">
		          <br>
		          <p align="center">学生系统管理</p>
		          <table cellspacing="0" cellpadding="0" border="0">
		            <colgroup>
		              <col name="" width="50">
		              <col name="" width="100">
		              <col name="" width="100">
		              <col name="" width="100">
		              <col name="" width="50">
		            </colgroup>
		            <thead>
		              <tr>
		              	<th class=""><div class="cell">编号</div></th>
		                <th class=""><div class="cell">姓名</div></th>
		                <th class=""><div class="cell">班级</div></th>
		                 <th class=""><div class="cell">学号</div></th>
		                <th class=""><div class="cell">操作</div></th>
		              </tr>
		            </thead>
		            <tbody>
		              <% request.setCharacterEncoding("UTF-8"); %>
				      <jsp:useBean id="user" class="dao.UserDao" scope="application"/>
					  <jsp:setProperty name="user" property="*" />
					  <% 
						List<User> new_user = user.UList();
					  	String dqljpath = request.getRequestURI();
						//System.out.println("questionList.size()="+new_question.size());
						int j=1;
						for(int i=0;i<new_user.size();i++){
							if(new_user.get(i).type.toString().equals("2")){
								
								out.print("<tr>");
								out.print("<td class="+""+">"+"<div class="+"'cell'"+">"+j+"</div>"+"</td>");
								out.print("<td class="+""+">"+"<div class="+"'cell'"+">"+new_user.get(i).username.toString()+"</div>"+"</td>");
								out.print("<td class="+""+">"+"<div class="+"'cell'"+">"+new_user.get(i).classno.toString()+"</div>"+"</td>");
								out.print("<td class="+""+">"+"<div class="+"'cell'"+">"+new_user.get(i).schoolno.toString()+"</div>"+"</td>");
								out.print("<td class="+""+">"+"<div class="+"'cell'"+">"+
									"<button type="+"'button'"+"class="+"'c-button'"+"onclick="+
										"'javascript:window.location.href=&apos;./servlet/AdminServlet?message="+new_user.get(i).schoolno+"&"+"dqljpath="+dqljpath+"&apos;'"+">"+"移除"+"</button>"+
									"<button type="+"'button'"+"class="+"'c-button'"+"onclick="+
										"'javascript:window.location.href=&apos;./AdminResetServlet?message="+new_user.get(i).schoolno+"&"+"dqljpath="+dqljpath+"&apos;'"+">"+"重置"+"</button>"+"</div>"+"</td>");
								out.print("</tr>");
								j++;
							}
							
						}
					 %>
		            </tbody>
		          </table>
		          <!-- "javascript:window.location.href ='./servlet/LoginOutServlet?message=admin'" -->
		          <br><p align="right"><input type="button" name="exit" value="退出" onClick="javascript:window.location.href ='/LittleSystem/Login.jsp';">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
		        </div>
		        <br>
		    </div>     
		</div>
		<!-- 代码 结束 -->
		<% 
			System.out.println("Login="+login);
			if(login!=null){
				//System.out.println("exam:session.getId()="+session.getId());
				//out.println("<script>alert('欢迎你！');</script>");
			}
			else{
				out.println("<script>alert('请先登录，谢谢！经过3秒之后，将会自动返回登录界面~');</script>");
				response.setHeader("Refresh","3;URL=/LittleSystem/Login.jsp");
			}
		%>
	</body>

</html>

