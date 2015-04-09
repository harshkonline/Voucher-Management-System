<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="table.css">
</head>
<body>
<span>
<img alt="Voucher Management System" src="images/head.bmp" width="100%" /> 
</span> 

<h3 align="center">Login Page</h3>
	<h2 align="center"> <s:actionmessage/> </h2>
<s:form action="checkLogin">
	<table width="50%" align="center" cellpadding="10" cellspacing="10" border="1">
		
		<s:textfield key="user_id"></s:textfield>

		<s:password key="password"></s:password>

		<s:submit align="center" value="Login"></s:submit>		

		<tr>
			<td colspan="2"><a href="<s:url action="forgetPassword_U" />">
			Forgot Password ?</a></td>
		</tr>
		
	</table>
	
</s:form>
</body>
</html>