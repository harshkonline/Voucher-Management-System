<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

<jsp:include page="/VoucherProfile/VoucherProfileMenu.jsp"></jsp:include>

<s:form action="vouchermenu" theme="simple">
	<table width="90%" align="center" cellpadding="10" cellspacing="10" border="1">
		<tr>
			<td class="bold"><s:text name="ManagerVoucherProfile.proName"></s:text></td>
			<td >:</td>
			<td class="italic"><s:property value="vp_name" /></td>
			<td class="bold"><s:text name="ManagerVoucherProfile.validityPeriod"></s:text>
			</td>
			<td >:</td>
			<td class="italic"><s:property value="vp_validityPeriod" /></td>
			<td class="bold"><s:text name="ManagerVoucherProfile.gp1"></s:text></td>
			<td >:</td>
			<td class="italic"><s:property value="vp_gracePeriod1" /></td>
		</tr>
		<tr>
			<td class="bold"><s:text name="ManagerVoucherProfile.gp2"></s:text></td>
			<td >:</td>
			<td class="italic"><s:property value="vp_gracePeriod2" /></td>
			<td class="bold"><s:text name="ManagerVoucherProfile.qp"></s:text></td>
			<td >:</td>
			<td class="italic"><s:property value="vp_quaratinePeriod" /></td>
			<td class="bold"><s:text name="ManagerVoucherProfile.sl"></s:text></td>
			<td >:</td>
			<td class="italic"><s:property value="vp_shelflife" /></td>
		</tr>
		<tr>
			<td class="bold"><s:text name="ManagerVoucherProfile.tt"></s:text></td>
			<td >:</td>
			<td class="italic"><s:property value="vp_talktime" /></td>
			<td class="bold"><s:text name="ManagerVoucherProfile.af"></s:text></td>
			<td >:</td>
			<td class="italic"><s:property value="vp_adminFees" /></td>
			<td class="bold"><s:text name="ManagerVoucherProfile.svt"></s:text></td>
			<td >:</td>
			<td class="italic"><s:property value="vp_serviceTax" /></td>
		</tr>
		<tr>
			<td class="bold"><s:text name="ManagerVoucherProfile.pf"></s:text></td>
			<td >:</td>
			<td class="italic"><s:property value="vp_processingFees" /></td>
			<td class="bold"><s:text name="ManagerVoucherProfile.st"></s:text></td>
			<td >:</td>
			<td class="italic"><s:property value="vp_stateTax" /></td>
			
			<td class="bold"><s:text name="ManagerVoucherProfile.misc"></s:text></td>
			<td >:</td>
			<td class="italic"><s:property value="vp_misc" /></td>
		</tr>
		<tr align="center">
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td class="bold"><s:text name="ManagerVoucherProfile.mrp"></s:text></td>
			<td >:</td>
			<td class="italic"><s:property value="vp_mrp" /></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="9"  align="center"> 
				<s:submit key="ok" ></s:submit>
			</td>
		</tr>
	</table>
</s:form>
</body>
</html>