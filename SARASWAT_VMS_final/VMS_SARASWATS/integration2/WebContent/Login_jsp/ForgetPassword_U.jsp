<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
a {	
	color:white;
	text-decoration: none;  
}

a:HOVER {
	color:#F4A993;
	text-decoration: none;
}
</style>
<link rel="stylesheet" href="table.css">
</head>
<body>
<center>
<span>
<img alt="Voucher Management System" src="images/head.bmp" width="100%" /> 
</span> 
<hr/>
<table class="menu" width="90%" style=" border-collapse: collapse;"  >
	<tr>
		<td align="center"><a href="<s:url action="Login" />">Login Page</a></td>
	</tr>
</table>

<s:form action="forgetPassword_Q">
	<table  width="40%" align="center" cellpadding=10" cellspacing="10" border="1">

		<s:textfield key="user_id"></s:textfield>
		
		<s:submit align="center" value="Submit"></s:submit>
	</table>
	
</s:form>

</center>

</body>
</html>