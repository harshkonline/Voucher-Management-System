<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>View Purchase Order</title>
</head>
<body>

	<jsp:include page="/PurchaseOrder/ViewPurchaseOrder.jsp"></jsp:include>
	
	<h2  align="center">
	Request for purchase order id : <s:property value="po_number"/> Rejected Successfully
	</h2>

</body>
</html>
