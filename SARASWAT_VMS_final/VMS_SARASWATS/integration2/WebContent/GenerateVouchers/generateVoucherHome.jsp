<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VOUCHER MANAGEMENT SYSTEM</title>
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

<body >
	
<jsp:include page="/admin_header_include.jsp"></jsp:include>
		<br/>
  <center>
	<table width="70%" class="menu" border="1">
	  <tr>
		<td><a href="<s:url action='showVoucherProfiles'/>">Generate By voucher profile </a></td>
	  	<td><a href="<s:url action='showApprovedOrders'/>">Generate By purchase order </a></td>
  	  </tr>  	  
	</table>
  </center>
  
   <h2 align="center">Generate Voucher</h2>
   <br/><br/>
  
 
  
</body>
</html>