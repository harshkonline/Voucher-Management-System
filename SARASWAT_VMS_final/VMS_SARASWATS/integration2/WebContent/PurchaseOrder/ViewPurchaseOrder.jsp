<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Purchase Order</title>
<STYLE type="text/css">
a {	
	color:black;
	text-decoration: none;  
}

a:HOVER {
	color:blue;
	text-decoration: none;
}
</STYLE>
<link rel="stylesheet" href="table.css" type="text/css">
</head>
<body>   
  <jsp:include page="/admin_header_include.jsp"></jsp:include>
  <br>
  <center>
	<table width="50%" class="menu" border="1">
		<tr>
			<td><a href="<s:url action='purchaseOrder'/>">View All Purchase Orders</a></td>
			<td><a href="<s:url action='searchPurchaseOrder'></s:url>">Search Purchase Order</a></td>
		</tr>
	</table>
</center>
  
</body>
</html>