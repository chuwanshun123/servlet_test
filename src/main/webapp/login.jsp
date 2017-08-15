<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户操作</title>
</head>
<body>

    <p>添加</p>
	<br />
	<form action="Testmysql1?action=login_mysql" method="post">
		ID:<input type="text" name="id" /> Name:<input type="text"
			name="name" /> url1:<input type="text" name="url" /> alexa1:<input
			type="text" name="alexa" /> 国家:<input type="text" name="country" />

		<input type="submit" value="提交" />
	</form>
	<br />
	<p>删除</p>
	<br />
	<form action="Testmysql1?action=login_mysql_delete" method="post">
		删除超过ID:<input type="text" name="id1" /> <input type="submit"
			value="提交" />
	</form>
	
		<br />
			<br />
	h1>文件上传实例 - 菜鸟教程</h1>
<form method="post" action="Uploadfiles1" enctype="multipart/form-data">
	选择一个文件:
	<input type="file" name="uploadFile" />
	<br/><br/>
	<input type="submit" value="上传" />
</form>
	
</body>
</html>