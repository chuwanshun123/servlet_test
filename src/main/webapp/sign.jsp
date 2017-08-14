<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
	<p>用户注册</p>
		<br />
	
<form action="Testmysql1?action=login_sign_complete" method="post">  
       用户名:<input type="text" name="name" />  
       邮箱:<input type="text" name="email" />  
       密码:<input type="password" name="password" />      
        <input type="submit" value="提交" />  
    </form> 
	<br />
	
</body>
</html>