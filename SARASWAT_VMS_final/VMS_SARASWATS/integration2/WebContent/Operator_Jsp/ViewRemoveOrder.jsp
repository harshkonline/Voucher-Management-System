<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/operator_header.jsp"></jsp:include>
<s:form theme="simple" action="removeorder">
	<h2 align="center">View / Remove Order</h2>
	<br />
	
	<table width="90%" align="center" cellpadding=10 " cellspacing="10"
		border="1">
		<tr>
			<th>Purchase Order No</th>
			<th>Vendor Name</th>
			<th>Quantity</th>
			<th>Product Type</th>
			<th>Prepared Date</th>
			<th>Status</th>
		</tr>
		<s:iterator value="list">
			<tr>
				<td><s:radio list="po_number" key="po_number" id="po_number"></s:radio>
				</td>
				<td><s:property value="vnd_name" /></td>

				<td><s:property value="vp_quantity" /></td>
				<td><s:property value="vp_name" /></td>
				<td><s:property value="prepareddate" /></td>
				<td><s:property value="vp_status" /></td>
			</tr>
		</s:iterator>
		<tr>
			<td align="center" colspan="6"><s:submit value="Remove"></s:submit>
			</td>
			
		</tr>

	</table>
</s:form>

</body>
</html>