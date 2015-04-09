<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:head theme="ajax"></s:head>
<jsp:include page="/admin_header_include.jsp"></jsp:include>
<br/>
<h2 align="center">Change Password </h2>
<br/>

	<s:form action="changepwdprocess">
		<table width="90%" align="center" cellpadding=10" cellspacing="10" border="1">
			
			<s:textfield key="username" name="#session.username" readonly="true"></s:textfield>
			<s:password key="oldpwd" required="true"></s:password>
			<s:password key="newpwd" required="true"></s:password>
			<s:password key="repwd" required="true"></s:password>
			<tr><td colspan="2"><s:text name="note1"></s:text></td></tr>
			
			<s:submit align="center" value="Change Password"></s:submit>
		</table>
	</s:form>

</body>
</html>
