<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.util.Date"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<%
	Date d = new Date();
%>
<hr style="color: #920A25;" width="100%"></hr>
<center>
<table>
	<tr>
		<td align="right"><a href="<% %>">Back</a></td>
		<td align="left"><a href="<% %>">Home</a></td>
	</tr>
	<tr>
		<td align="right">
		&copy;VMS 
		</td>
		<td align="left">
		<!--  <s:text name="project.today"></s:text> -->
		 <%=(d.getDate() + "-" + (d.getMonth() + 1) + "-" + (1900 + d.getYear())).toString()
		 %>
		</td>
	</tr>
</table>
</center>
</body>
</html>