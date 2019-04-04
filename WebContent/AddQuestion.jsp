<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>增加习题</title>
		<% 
		//System.out.println("question.jsp的当前路径="+request.getRequestURI());
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
			<div class="div2"><br/>增加习题</div>
			<div class="div3"></div>
			<Form action="./servlet/QuestionOperateServlet?message=add" method="post">
				<br>
				<table>
					<tr><td>题目</td><td><input type="text" name="title"></td></tr>
					<tr><td>选型A</td><td><input type="text" name="optionA"></td></tr>
					<tr><td>选项B</td><td><input type="text" name="optionB"></td></tr>
					<tr><td>选项C</td><td><input type="text" name="optionC"></td></tr>
					<tr><td>选项D</td><td><input type="text" name="optionD"></td></tr>
					<tr><td>正确答案</td><td><input type="text" name="trueAnswer"></td></tr>
					<tr><td>题型</td>
						<td><input type="radio" name="type" value="判断题">判断题
							<input type="radio" name="type" value="单选题">单选题
							<input type="radio" name="type" value="多选题">多选题</td>
					</tr>
					<tr><td></td><td><input type="submit" name="submit" value="提交"></td></tr>
				</table>
			</Form>
		</div>	
	</body>
</html>