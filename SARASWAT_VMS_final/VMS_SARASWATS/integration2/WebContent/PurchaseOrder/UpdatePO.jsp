<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<jsp:include page="/PurchaseOrder/ViewPurchaseOrder.jsp"></jsp:include>
<title>Update Purchase Order</title>
</head>
<body>
<s:head theme="ajax"></s:head>


<s:head theme="ajax"></s:head>
<h1>Purchase Order Details</h1>
<s:form action="UpdatePO">
	<table border="5">
		<tr>
			<td><s:select name="vnd_name" list="vnd_name_list"
				key="VendorName" disabled="true"></s:select></td>
		</tr>
		<tr>
			<td><s:textarea name="vnd_address"></s:textarea></td>
		</tr>
		<tr>
			<td><s:select name="vp_name" list="vp_name_list"></s:select></td>
		</tr>
		<tr>
			<td><s:select name="printmedium"
				list="#{'1':'Plastic','2':'Paper'}"></s:select></td>
		</tr>
		<tr>
			<td><s:textfield name="vp_unitPrice" key="UnitPrice.Rs"
				disabled="true"></s:textfield></td>
		</tr>
		<tr>
			<td><s:textfield name="vp_quantity" key="Quantity"></s:textfield>
			</td>
		</tr>
		<tr>
			<td><s:textfield name="vp_discount" key="vp_discount"></s:textfield></td>
		</tr>
		<tr>
			<td><s:datetimepicker name="deliverydate"
				displayFormat="dd--MMM--yyyy"></s:datetimepicker></td>
		</tr>
		<tr>
			<td><s:text name="note1"></s:text></td>
		</tr>
		<tr>
			<td></td>
		</tr>
		<tr>
			<td></td>
		</tr>
		<tr align="center">
			<s:if test="vp_status='pending'">
				<td><s:submit key="Update"></s:submit></td>
				<td><s:reset key="Approve"></s:reset></td>
				<td><s:reset key="Reject"></s:reset></td>
			</s:if>
			<s:else>
			<td align="center"><s:reset key="OK"></s:reset></td></s:else>
			
		</tr>
	</table>
</s:form>
</body>
</html>