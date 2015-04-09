<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<center>
		<s:action name="Login" executeResult="true"></s:action>
		<br/>

		<hr width="100%" color="red"/>		
		<p><s:text name="alter_pwd.msg"></s:text></p>
		<hr width="100%" color="red"/>
		
	</center>
</body>
</html>