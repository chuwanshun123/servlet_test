<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>用户登陆</p>
		<br />
	
<form action="Testmysql1?action=login_input" method="post">  
       用户名:<input type="text" name="name" />  
       密码:<input type="password" name="password" />  
              
        <input type="submit" value="提交" />  
    </form> 
	<br />
	
<form action="demo?action=login_sign" method="post">  
       用户注册:<input type="submit" value="提交" />  
    </form> 


</body>
</html>