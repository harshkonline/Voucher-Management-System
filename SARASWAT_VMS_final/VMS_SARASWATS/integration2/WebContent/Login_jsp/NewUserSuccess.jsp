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
		<s:action name="newuser" executeResult="true"></s:action>
		
		<hr width="100%" color="red"/>
		<p class="errormsg"><s:text name="newusersuccess.msg"></s:text></p>
		User id :<s:property value="user_id"/>
		<br></br>
		Role Type :<s:property value="role_name"/>
		
	</center>
</body>
</html>