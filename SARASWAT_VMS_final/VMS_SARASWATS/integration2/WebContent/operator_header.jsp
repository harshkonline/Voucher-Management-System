<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.util.Date"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<STYLE type="text/css">
a {	
	color:white;
	text-decoration: none;  
}

a:HOVER {
	color:#F4A993;
	text-decoration: none;
}
</STYLE>
<link rel="stylesheet" href="table.css">
</head>

<body>

<span>
<img alt="Voucher Management System" src="images/head.bmp" width="100%" /> 
</span> 
<center>

<table  class="menu"  width="100%" style=" border-collapse: collapse;"  >
	<tr>
		<td align="left"><a href="<s:url action="operatorHome" />">Home</a></td>
		<td align="right"><a href="<s:url action="logout" />">Logout</a></td>
	</tr>
</table>


<table width="100%" class="menu" border="1">
	<tr>
		<td><a href="<s:url action="perparepurchaseorder" />">Prepare Purchase Order </a></td>
		<td><a href="<s:url action="viewremoveorder" />">View / Remove Order</a></td>
		<td><a href="<s:url action="changepwdop" />">Change Password</a></td>
	</tr>
</table>
</center>


	
</body>
</html>