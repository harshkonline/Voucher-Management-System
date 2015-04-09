<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VOUCHERS GENERATED</title>
</head>
<body>

	<s:action name="generateVoucherHome" executeResult="true"></s:action>

	<h3 align="center">
		vouchers of orders
	   <s:iterator value="list_of_generated_order_no" ><s:property />
	   </s:iterator> are successfully generated.
	</h3>
	<h3 align="center">The Generated IN FILES are:</h3>
	<s:iterator value="data">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<s:property/><br/>
	</s:iterator>
	
</body>
</html>