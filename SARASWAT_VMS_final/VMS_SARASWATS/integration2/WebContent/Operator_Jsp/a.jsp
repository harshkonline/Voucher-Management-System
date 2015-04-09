<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Opening Form</title>
</head>
<body>
	<s:form action="openAcc">
	<s:textfield key="firstname"></s:textfield>
	<s:textfield name="lastname" label="Last Name"></s:textfield>
	
	<s:textfield name="username" label="username"></s:textfield>
	<s:password name="password" label="password"></s:password>
	<s:textfield name="age" label="Age"></s:textfield>
	<s:radio name="gender" label="Gender" list="{'M','F'}" />
	<s:textarea label="Address" name="address" cols="30" rows="4"></s:textarea>
	
	
	<s:select name="accType" label="select Account type" list="{'Savings','Current'}"  />
	
	
	<s:textfield name="tele_no" label="Telephone"></s:textfield>
	<s:textfield name="balance" label="Initial Opening Amount"></s:textfield>
	
	<s:submit></s:submit>
	</s:form>
</body>
</html>