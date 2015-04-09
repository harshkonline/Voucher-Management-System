<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="/struts-tags" prefix="s" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Voucher Profile</title>
<script type="text/javascript">
	function submitForm(){
		document.form1.submit();
	}
</script>
</head>
<body>

<jsp:include page="/VoucherProfile/VoucherProfileMenu.jsp"></jsp:include>

<h1 align="center"> Remove Voucher Profile </h1>

<table width="30%" align="center" cellpadding="1" cellspacing="1" border="1">

<tr><th>Select a Voucher Profile to View</th></tr>

<tr >
	<td>
		<s:set name="list" value="profileList" scope="session"></s:set>
		<s:form name="form1" action="viewRemoveVoucherProfile">
		<s:select name="selected_profile" list="#session.list" 
				headerKey="---Select Profile---" headerValue="---Select Profile---" 
				onchange="submitForm()">
		</s:select>
		</s:form>
	</td>
</tr>
</table>
<hr></hr>
</body>
</html>