<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<script>
function populate(){
	
 vendor.submit();
}

</script>

<title>Prepare</title>

</head>
<body>
<s:head theme="ajax"></s:head>
<jsp:include page="/operator_header.jsp"></jsp:include>
<br/>
<h2 align="center">Prepare Purchase Order Page</h2>
<br/>

<s:form name="vendor" action="opaddress">
<table width="90%" align="center" cellpadding=10" cellspacing="10" border="1">
	
		<s:select  key="vnd_name" list="#session.vndname" onchange="populate()"></s:select>
		<s:textarea  key="vnd_address" readonly="true" ></s:textarea>
		<s:select key="vp_name" list="#session.vpname"  onchange="populate()"></s:select>
		<s:select key="printmedium" list="#{'1':'Plastic','2':'Paper'}"></s:select>
		<s:textfield key="vp_unitPrice" readonly="true"></s:textfield>
		<s:textfield key="vp_quantity" required="true"></s:textfield>
		<s:textfield key="vp_discount"></s:textfield>
		
		<s:datetimepicker name="deliverydate" key="deliverydate"
		 displayFormat="dd-MMM-yyyy" ></s:datetimepicker>
		
		<tr><td colspan="2"><s:text name="note1"></s:text></td></tr>
		<s:submit align="center" name="button" value="submit"></s:submit>
</table>	
</s:form>

</body>
</html>