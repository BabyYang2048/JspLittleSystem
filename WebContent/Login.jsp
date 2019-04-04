<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
    <head>
    
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>Login</title>
        <%
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			
		%>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/supersized.css">
        <link rel="stylesheet" href="css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body oncontextmenu="return false">
		<% request.setCharacterEncoding("UTF-8"); %>
        <div class="page-container">
            <h1>Login</h1>
            <form action="/LittleSystem/servlet/LoginServlet" method="post">
				<div>
					<input type="text" name="username" class="username" placeholder="Username" autocomplete="off"/>
				</div>
                <div>
					<input type="password" name="password" class="password" placeholder="Password" oncontextmenu="return false"/>
                </div>
                <div>
              		  登录身份：&nbsp;
              		<input type="radio" name="login" value="0" style="width:25px;height:25px;">管理员
                	<input type="radio" name="login" value="1" style="width:25px;height:25px;">教师
					<input type="radio" name="login" value="2" style="width:25px;height:25px;">学生
				</div>
				<div>
                	<button id="submit" type="submit"  style="width:140px;height:40px;">Sign in</button>
                	<button id="register" type="button" style="width:140px;height:40px;" onClick="javascript:window.location.href='/LittleSystem/register.jsp'">Sign up</button>
                </div>
            </form>
            <div class="connect">
                <p>欢迎来到在线考试平台！</p>
				<p style="margin-top:20px;">测试中...如有不足请多多提出我们共同进步</p>
            </div>
        </div>
		<div class="alert" style="display:none">
			<h2>消息</h2>
			<div class="alert_con">
				<p id="ts"></p>
				<p style="line-height:70px"><a class="btn">确定</a></p>
			</div>
		</div>

        <!-- Javascript -->
        <script src="http://apps.bdimg.com/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
        <script src="js/supersized.3.2.7.min.js"></script>
        <script src="js/supersized-init.js"></script>
		
		
    </body>

</html>
