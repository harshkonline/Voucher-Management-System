<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<STYLE type="text/css">
a {	
	color:black;
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
<jsp:include page="/admin_header_include.jsp"></jsp:include>
<center>
<br/>
	
	<table width="50%" class="menu" border="1">
	
	<tr>
		<td><a href="<s:url action="newuser" />">Register new User </a></td>
		<td><a href="<s:url action="newvendor" />"> Register new Vendor</a></td>
	</tr>
	</table>
</center>
</body>
</html>