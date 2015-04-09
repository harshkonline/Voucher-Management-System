<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GENERATE VOUCHER BY VOUCHER PROFILE</title>
</head>
<body >
	<s:head theme="ajax"/>
	<jsp:include page="generateVoucherHome.jsp"></jsp:include>
	
	<s:form action="generateByVp" >
	
	<table width="40%" align="center" cellpadding=10" cellspacing="10" border="1">
		<s:select label="Select Profile" name="vp_name" 
				list="#session.vp_name_list">
		</s:select>
		<s:textfield name="vp_quantity" label="Quantity" 
				required="true"></s:textfield>
				
		<s:submit align="center" value="Generate"></s:submit>
	</table>
		
	</s:form>
</body>
</html>