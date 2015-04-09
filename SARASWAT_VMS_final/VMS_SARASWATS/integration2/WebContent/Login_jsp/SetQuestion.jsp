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
<span>
<img alt="Voucher Management System" src="images/head.bmp" width="100%" /> 
</span> 
<hr/>
	<s:form action="addQuestion">
		<s:select list="#session.arrlist" key="question"></s:select>
		
		<s:textfield key="answer" required="true"></s:textfield>
		
		<s:textfield key="reanswer" required="true"></s:textfield>
		
		<s:submit align="center" value="Submit"></s:submit>
	</s:form>
</center>
</body>

</html>