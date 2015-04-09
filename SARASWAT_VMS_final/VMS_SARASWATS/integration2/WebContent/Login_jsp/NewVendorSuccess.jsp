<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="table.css">
</head>
<body>
	<center>	
		<s:action name="newvendor" executeResult="true"></s:action>
		
		<hr width="100%" color="red"/>
		<p class="errormsg"><s:text name="newvendorsuccess.msg"></s:text></p>
		<table>
		<tr>
			<td>Vendor id :</td>
			<td><s:property value="vnd_id"/></td>
		</tr>
		<tr>
			<td>Vendor Name :</td>
			<td><s:property value="vnd_name"/></td>
		</tr>
		<tr>
			<td>Email Id :</td>
			<td><s:property value="vnd_email"/></td>
		</tr>
		<tr>
			<td>Address :</td>
			<td><s:property value="vnd_address"/></td>
		</tr>
		<tr>
			<td>Phone no. :</td>
			<td><s:property value="vnd_phone"/></td>
		</tr>	
		</table>
	</center>
</body>
</html>