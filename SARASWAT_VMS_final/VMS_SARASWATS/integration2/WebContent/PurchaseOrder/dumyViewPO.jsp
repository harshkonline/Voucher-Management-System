<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META HTTP-EQUIV="Refresh" CONTENT="0;URL=purchaseOrder.action">
<title>View Purchase Order</title>
</head>
<body>
<s:form action="viewDetails" theme="simple">
	<h1 align="Center">View Purchase Order</h1>

	<table border="2">
		<tr bgcolor="beige">
			<td align="center">PO Number</td>
			<td align="center">Summary<br>
			(Vendor,Quantity,Product type)</td>
			<td align="center">Prepare Date</td>
			<td align="center">Status</td>
		</tr>

		<s:iterator value="list">

			<tr>
				<td><s:radio name="po_number" list="po_number" /></td>
				<td><s:property value="summary"></s:property></td>
				<td><s:property value="prepared_date"></s:property></td>
				<td><s:property value="status"></s:property></td>
			</tr>
		</s:iterator>
	</table>
	<br>
	<br>
	<s:submit align="center" value="Submit" />
</s:form>
</body>
</html>