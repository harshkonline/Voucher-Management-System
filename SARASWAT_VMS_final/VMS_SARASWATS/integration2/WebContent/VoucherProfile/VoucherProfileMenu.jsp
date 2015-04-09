<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<STYLE type="text/css">
a {
	color: black;
	text-decoration: none;
}

a:HOVER {
	color: blue;
	text-decoration: none;
}
</STYLE>
<link rel="stylesheet" href="table.css">

</head>
<body>
<jsp:include page="/admin_header_include.jsp"></jsp:include>
<br/>
<center>
	<table width="90%" class="menu" border="1">
	  <tr>
		<td><a href="<s:url action='manageVoucherProfile'/>"><s:text
			name="ManagerVoucherProfile.cv"></s:text></a></td>
		<td><a href="<s:url action='populateList'/>"><s:text
			name="ManagerVoucherProfile.uv"></s:text></a></td>
		<td><a href="<s:url action='populateListView'/>"><s:text
			name="ManagerVoucherProfile.vv"></s:text></a></td>
		<td><a href="<s:url action='populateListRemove'/>"><s:text
			name="ManagerVoucherProfile.rv"></s:text></a></td>
	  </tr>
	</table>
</center>

<h4 align="center"> <s:actionmessage tabindex="none" /> </h4>
<h4 align="center"> <s:actionerror /> </h4>
</body>
</html>