<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Register</title>
		<script type="text/javascript" src="js/jquery.md5.js"></script>
		<style type="text/css">
			div{
				margin:0 auto;
				text-align:center;
				background-color:#FFFFF4;
				}
			.div1{
				text-align:center;
				width:400px;
				height:auto;
				border-color:black;
				border-style:solid;
				broder-width:2px;
				margin-top:100px;
				}	
			.div2{
				width:auto;
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
	<body bgcolor="lightPink">
		<%request.setCharacterEncoding("UTF-8"); %>
		<div class="div1" align="center">
			<div class="div2"><br/>用户注册</div>
			<div class="div3"></div>
			<form action="/LittleSystem/servlet/RegisterServlet" method="post">
				<table>
					<%	
						String usernametip = (String)request.getAttribute("usernametip"); 
						String passwordtip = (String)request.getAttribute("passwordtip");
						String password1tip = (String)request.getAttribute("password1tip");
						String typetip = (String)request.getAttribute("typetip");
						String schoolnotip = (String)request.getAttribute("schoolnotip");
						String classnotip = (String)request.getAttribute("classnotip");
					%>
					<tr><td>用户名</td><td><input type="text" name="username"></td><td><%if(usernametip!=null) %><%=usernametip %></td></tr>
					<tr><td>输入密码</td><td><input type="password" name="password"></td><td><%if(passwordtip!=null) %><%=passwordtip %></td></tr>
					<tr><td>再次输入密码 </td><td><input type="password" name="password1"></td><td><%if(password1tip!=null) %><%=password1tip %></td></tr>
					<tr><td>班级</td><td><input type="text" name="classno"></td><td><%if(classnotip!=null) %><%=classnotip %></td></tr>
					<tr><td>学号</td><td><input type="text" name="schoolno"></td><td><%if(schoolnotip!=null) %><%=schoolnotip %></td></tr>
					<tr><td>类型</td><td><input type="radio" name="register" value="1">教师
										<input type="radio" name="register" value="2">学生</td><td><%if(typetip!=null) %><%=typetip %></td></tr>
					<tr><td></td><td><input type="submit" name="submit" value="提交">
									
									 <input type="button" name="back" value="取消" onclick="javascript:window.location.href ='/LittleSystem/Login.jsp';">
									 </td></tr>
					
				</table>	
			</form>
		</div>
		
		
	</body>	
</html>