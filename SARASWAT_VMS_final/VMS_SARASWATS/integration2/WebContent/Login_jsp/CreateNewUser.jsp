<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register New user</title>

</head>
<body>
<s:head theme="ajax"></s:head>
<jsp:include page="/Enroll.jsp"></jsp:include>
<br/>
<h2 align="center">Register New user </h2>
<br/>

<s:form action="newuserprocess">
<table width="90%" align="center" cellpadding=10" cellspacing="10" border="1">
		
		<s:textfield key="user_id" required="true"></s:textfield>
		<s:select list="#session.role" key="role_name"></s:select>
						
		<tr><td colspan="2"><s:text name="note1"></s:text></td></tr>
		<s:submit align="center" value="Register"></s:submit>
</table>	
</s:form>
</body>
</html>