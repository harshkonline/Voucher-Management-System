<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GENERATE VOUCHERS BY PURCHASE ORDER</title>
</head>
<body >
	<jsp:include page="generateVoucherHome.jsp"></jsp:include>

	<%-- <h4 >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a class="none" href="<s:url action='generateVoucherHome'/>">
		Go Back  </a>
	</h4>--%>
	<s:form action="generateByPurchaseOrder" theme="simple">
	 <table width="100%" align="center" cellpadding="10" cellspacing="0" border="1">
		<tr>
			<th>PO No</th>
			<th>VP name</th>
			<th>Quantity</th>
			<th>Date of order</th>
			<th>Date of delivery</th>
			<th>Print media</th>
			<th>Net amount</th>
			<th>Unit Price</th>
			<th>Select</th>
		</tr>
		<s:iterator value="list_of_orders">
			<tr>
				<td><s:property id="po_id" value="po_number" /> <%--<s:hidden name="po_number"></s:hidden>--%>
				</td>
				<td><s:property value="vp_name" /></td>
				<td><s:property value="vp_quantity" /></td>
				<td><s:property value="vp_dateOfOrder" /></td>
				<td><s:property value="vp_dateOfDelivery" /></td>
				<td><s:property value="vp_printMedia" /></td>
				<td><s:property value="vp_netAmount" /></td>
				<td><s:property value="vp_unitPrice" /></td>
				<td><s:checkbox name="check" value="false"
					fieldValue="%{po_number}"></s:checkbox></td>
			</tr>

		</s:iterator>
		<tr>
			<td colspan="9">
				<s:submit align="center" value="Generate" />
			</td>
		</tr>
	
</s:form>

</body>
</html>