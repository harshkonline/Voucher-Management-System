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
<s:head theme="ajax" />
<h1 align="center"> Update Voucher Profile </h1>

<table width="30%" align="center" cellpadding="1" cellspacing="1" border="1">
	<tr><th>Voucher Profile</th></tr>
	<tr align="center">
	<td>
		<s:form name="form1" action="updateVoucherProfile">
			<s:select name="selected_profile" list="#session['list']" 
					headerKey="---Select Profile---" headerValue="---Select Profile---" 
					onchange="submitForm()">
			</s:select>
		</s:form>
	</td>
	</tr>
</table>
<hr></hr>
<s:form action="updateVP">

<table width="115%" align="center" cellpadding="20" cellspacing="0" border="1" >
<tr>
	<td>
		<table>
				<s:textfield  key="ManagerVoucherProfile.proName" name="vp_name" readonly="true" />
				<s:textfield key="ManagerVoucherProfile.tt" name="vp_talktime" required="true"/>
				<s:textfield key="ManagerVoucherProfile.pf" name="vp_processingFees"/>
				<s:textfield key="ManagerVoucherProfile.st" name="vp_stateTax"/>
		</table>
	</td>
	<td>
		<table>
				<s:textfield  key="ManagerVoucherProfile.gp1" name="vp_gracePeriod1" required="true"/>
				<s:textfield  key="ManagerVoucherProfile.validityPeriod" name="vp_validityPeriod" required="true"/>
				<s:textfield key="ManagerVoucherProfile.af" name="vp_adminFees"/>
				<s:textfield key="ManagerVoucherProfile.mrp" name="vp_mrp"/>	
		</table>
	</td>
	<td>
		<table>
				<s:textfield key="ManagerVoucherProfile.gp2" name="vp_gracePeriod2" required="true"/>
				<s:textfield key="ManagerVoucherProfile.qp" name="vp_quaratinePeriod" required="true"/>
				<s:textfield key="ManagerVoucherProfile.sl" name="vp_shelflife" />
				<s:textfield key="ManagerVoucherProfile.svt" name="vp_serviceTax"/>	
		</table>
	</td>
</tr>
	<tr><td colspan="4" align="center" >
	<table >
			<s:textfield key="ManagerVoucherProfile.misc" name="vp_misc"/>
	</table>
	</td>
	</tr>
</table>

<br></br>
<b>Note:</b><br>
1.Enter the values for validity period,graceperiod1,graceperiod2,quarantine period and shelf life in days.<br>
2.* marked fields are mandatory.
<br/><br/><br/>
<table align="center">
<tr>
	<td>
		<table>
		<tr>
		<s:submit key="submit" name="submit" ></s:submit>
		</tr>
		</table>
	</td>
	<td>
		<table>
		<tr>
		<td><s:reset key="reset" name="reset"></s:reset></td>
		</tr>
		</table>	
	</td>
	
</tr>
</table>
</s:form>
</body>
</html>