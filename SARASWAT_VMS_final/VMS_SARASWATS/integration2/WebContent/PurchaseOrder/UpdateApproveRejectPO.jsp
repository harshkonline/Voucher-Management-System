<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Update Purchase Order</title>
<jsp:include page="/PurchaseOrder/ViewPurchaseOrder.jsp"></jsp:include>

</head>
<body>
<s:head theme="ajax"></s:head>

<h1 align="center">Purchase Order Details</h1>


<s:form action="UpdateApproveReject">
	<table width="90%" align="center" cellpadding=10" cellspacing="10" border="1">
		
				<s:textfield name="po_number" label="Purchase Order Number" readonly="true"></s:textfield>	
						
				<s:textfield name="vnd_name" label="Vendor Name" readonly="true"></s:textfield>				
			
		
				
					<s:textarea id="vnd_address" label="Vendor Address" name="vnd_address" readonly="true"></s:textarea>
				
			
			<s:textfield name="vp_name"  label="Voucher Profile Name" readonly="true" ></s:textfield>
						
			<s:if test="vp_status !='pending'">
				<s:textfield id="printmedium" label="Print Medium" name="printmedium" readonly="true"></s:textfield>
			</s:if>
			<s:else>
				<s:select name="printmedium" label="Print Medium"
				list="#{'plastic':'Plastic','paper':'Paper'}"></s:select>
			</s:else>
			
				<s:textfield name="vp_unitPrice" key="UnitPrice.Rs" label="Unit Price"	readonly="true"></s:textfield>
			
			
		
			<s:if test="vp_status !='pending'">
			<s:textfield name="vp_quantity" key="Quantity" label="Quantity" readonly="true"></s:textfield>
			</s:if>
			<s:else>
				<s:textfield name="vp_quantity" key="Quantity" label="Quantity" required="true" ></s:textfield>
			</s:else>
			
		
			<s:if test="vp_status !='pending'">
			<s:textfield name="vp_discount" key="vp_discount" label="Discount(%)" readonly="true"></s:textfield>
			</s:if>
			<s:else>
				<s:textfield name="vp_discount" key="vp_discount" label="Discount(%)" required="true" ></s:textfield>
			</s:else>
			
			<s:if test="vp_status !='pending'">
			<s:textfield name="deliverydate" label="Delivery Date" readonly="true"></s:textfield>			
			</s:if>
			<s:else>
			<s:datetimepicker name="deliverydate" label="Delivery Date"	displayFormat="dd-MMM-yyyy"></s:datetimepicker>
			</s:else>
				
		  	<s:textfield label="Status" name="vp_status" readonly="true"></s:textfield>
		

		
		<tr align="center">
			<s:if test="vp_status=='pending'">
			<td colspan="4" align="center">
								
					<s:submit name="button" value="Update" theme="simple"></s:submit>
					<s:submit name="button" value="Approve" theme="simple"></s:submit>
					<s:submit name="button" value="Reject" theme="simple"></s:submit>
			</td>
			</s:if>		
		</tr>
	</table>
</s:form>

<s:form action="purchaseOrder">
<center>
	<table width="90%" align="center" cellpadding=10" cellspacing="10" border="1" >
		<s:submit align="center" name="button" value ="    OK    "></s:submit>
	</table>

</center>
</s:form>
 

</body>
</html>