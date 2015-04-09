<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generate Vouchers BY PURCHASE ORDER</title>
</head>
<body >
	<jsp:include page="generateVoucherHome.jsp"></jsp:include>

<s:form action="generateByPurchaseOrder" theme="simple">
	
	
	
	<table width="90%" align="center" cellpadding=10" cellspacing="10" border="1">
		<tr>
			<td align="center">No approved orders found.</td>
		</tr>
	</table>
	
	
</s:form>
</body>
</html>