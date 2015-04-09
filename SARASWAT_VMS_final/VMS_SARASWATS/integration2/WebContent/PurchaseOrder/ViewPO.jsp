<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Purchase Order</title>
<jsp:include page="/PurchaseOrder/ViewPurchaseOrder.jsp"></jsp:include>
</head>
<body>
<s:head theme="ajax"></s:head>

	<h1 align="Center">View Purchase Order</h1>
	
<s:form action="viewDetails" theme="simple">


	<center>
	
	<table  width="90%" align="center" cellpadding=10" cellspacing="10" border="1">
		<tr style="font-size: medium;">
			<th>PO Number</th>
			<th>Summary <br/> (Vendor,Quantity,Product type)</th>
			<th>Prepare Date</th>
			<th>Status</th>
			
		</tr>

		<s:iterator value="list">

			<tr>
				<td><s:radio name="po_number" list="po_number" /></td>
				<td><s:property value="summary"></s:property></td>
				<td><s:property value="prepared_date"></s:property></td>
				<td><s:property value="status"></s:property></td>
			</tr>
		</s:iterator>
		
		<tr>
			<td colspan="4">
				<s:submit align="center" value="See Details" />
			</td>
		</tr>
	</table>
	
	</center>
</s:form>
</body>
</html>