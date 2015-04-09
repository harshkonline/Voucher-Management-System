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
<span>
<img alt="Voucher Management System" src="images/head.bmp" width="100%" /> 
</span> 
<table class="menu" width="90%" style=" border-collapse: collapse;"  >
	<tr>
		<td align="center"><a href="<s:url action="Login" />">Login Page</a></td>
	</tr>
</table>
<center>
<s:form action="forgetPassword_AL">
	<s:hidden key="user_id"></s:hidden>
	<s:hidden key="question"></s:hidden>
	<table width="50%" align="center" cellpadding=10" cellspacing="10" border="1">
		<tr>
			<td align="right"><s:text name="question"></s:text></td>
			<td><s:property  value="question"/></td>
		</tr>
		
			<s:textfield  key="answer"></s:textfield>
	
			<s:submit align="center" value="Submit"></s:submit>	
	</table>
	
</s:form>

</center>
</body>
</html>