<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Purchase Order</title>
<jsp:include page="/PurchaseOrder/ViewPurchaseOrder.jsp"></jsp:include>
</head>
<body>
<s:head theme="ajax"></s:head>


<h1 align="center">Search Purchase Order</h1><br/>
<s:form action="search" name="searchForm">
<center>
<table  width="90%" align="center" cellpadding=10" cellspacing="10" border="1">
	<s:select list="#{'vname':'Vendor Name','ponumber':'PO Number','pending':'Pending Requests','approved':'Approved Requests','rejected':'Rejected Requests'}"
          name="SearchBy"  label="Select Search Criteria"></s:select>
	<s:textfield name="SearchText" label="Enter Search Criteria"></s:textfield>
	
	<s:submit align="center" value="Search"/>

<tr><td colspan="2">Note : If you select status(pending,approved, rejected) then leave TextField blank</td></tr>
</table>
</center>
</s:form>
</body>
</html>