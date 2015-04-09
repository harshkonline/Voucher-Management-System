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
<center>
<jsp:include page="/operator_header.jsp"></jsp:include>
<h1>Purchase Order Addedd</h1>
</center>

<s:form>
<center>
	<table width="90%" align="center" cellpadding=10" cellspacing="10" border="1">
		<thead>
			<tr><th colspan="3"><h2>Order Placed</h2></th></tr>
		</thead>
		<tr>
			<td>Vendor Name</td>
			<td>:</td>
			<td><s:property value="vnd_name"/><br/></td>
		</tr>
		<tr>
			<td>Vendor Address</td>
			<td>:</td>
			<td><s:property value="vnd_address"/><br/></td>
		</tr>
		<tr>
			<td>Voucher Profile Name</td>
			<td>:</td>
			<td><s:property value="vp_name"/><br/></td>
		</tr>
		<tr>
			<td>Print Medium</td>
			<td>:</td>
			<td><s:property value="printmedium"/><br/></td>
		</tr>
		<tr>
			<td>Unit Price</td>
			<td>:</td>
			<td><s:property value="vp_unitPrice"/><br/></td>
		</tr>
		<tr>
			<td>Quantity</td>
			<td>:</td>
			<td><s:property value="vp_quantity"/><br/></td>
		</tr>
		<tr>
			<td>Discount</td>
			<td>:</td>
			<td><s:property value="vp_discount"/><br/></td>
		</tr>
		<tr>
			<td>Delivery Date</td>
			<td>:</td>
			<td><s:property value="deliverydate"/><br/></td>
		</tr>
	</table>
</center>
</s:form>	
	
</body>
</html>