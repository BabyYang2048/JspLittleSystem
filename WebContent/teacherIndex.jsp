<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>教师管理界面</title>
		<%
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		%>
	 	<base href="<%=basePath%>">
		<link href="css/jq22.css" rel="stylesheet" type="text/css">
		<script src="js/jquery-1.7.2.min.js"></script>
		<script src="js/jquery.movebg.js"></script>
	</head>
	<body>
		<%request.setCharacterEncoding("UTF-8"); %>
		<% String login = (String)session.getAttribute("userTea"); %>
		<!-- 代码 开始 -->
		<div class="wraper">
			<h1 align="center"><font size=6px>欢迎 <%=login %> 来到在线考试系统  --教师界面</font></h1>
			&nbsp;
		    <div class="nav" style="background:#87CEFF;">
		        <ul>
		            <li class="nav-item"><a></a></li>
		            <li class="nav-item cur"><a href="./Question.jsp">试题管理</a></li>
		            <li class="nav-item"><a>学生成绩管理</a></li>
		            <li class="nav-item"><a></a></li>
		        </ul>
		        <!--移动的滑动-->
		        <div class="move-bg"></div>
		        <!--移动的滑动 end-->	
		    </div>
		     
		</div>
		
		<script>
		$(function(){
			$(".nav").movebg({width:120/*滑块的大小*/,extra:40/*额外反弹的距离*/,
				speed:300/*滑块移动的速度*/,rebound_speed:400/*滑块反弹的速度*/});
		})
		</script>
	
		<!-- 代码 结束 -->
		<% 
			//System.out.println("Login="+login);
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

