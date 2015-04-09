<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="/struts-tags" prefix="s" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!--<SCRIPT type="text/javascript">
	function addtoselection(){
			var a="dontexist";
			if(document.createform.vp_feevalue.value!="" && document.createform.vp_feename.value!="")
			{
				if(document.createform.feedetail.options.length==0)
				{
					a="dontexist";
				}
				for(var i=0;i<document.createform.feedetail.options.length;i++)
				{
					if(document.createform.feedetail.options[i].value==document.createform.vp_feename.value)
					{
						a="exists";	
					}
				}
				if(a=="exists")
				{
					alert("Fee Name already added");
				}
				else if(a=="dontexist")
				{
					var optn=document.createElement("OPTION");
					optn.value=document.createform.vp_feename.value;
					optn.text=document.createform.vp_feename.value+","+document.createform.vp_feevalue.value;
					document.createform.feedetail.add(optn);
					if(document.createform.vp_feename.value=="Misc.")
					{
						alert("Inside if for misc");
						document.createform.vp_misc.value=document.createform.vp_feevalue.value;
					}
					else if(document.createform.vp_feename.value=="State Tax")
					{
						alert("Inside if for ST");
						document.createform.vp_stateTax.value=document.createform.vp_feevalue.value;
					}
					document.createform.vp_feename.value="";
					document.createform.vp_feevalue.value="";
				}
			}
			else if(document.createform.vp_feename.value=="")
			{
				alert("Enter a value for Fee Name");
			}
			else if(document.createform.vp_feevalue.value=="")
			{
				alert("Enter a value for Fee Value");
			}
	}
	function removefromselection(){
		if(document.createform.feedetail.options.length!=0)
		{
			for(var i=0;i<document.createform.feedetail.options.length;i++)
			{
				if(document.createform.feedetail.options[i].selected && document.createform.feedetail.options[i].value!="")
				{
					document.createform.feedetail.remove(i);
				}
			}
		}
		else
		{
			alert("There is no value to be removed");	
		}
	}
</SCRIPT>-->
</head>
<body>
<s:head theme="ajax"/>

<jsp:include page="/VoucherProfile/VoucherProfileMenu.jsp"></jsp:include>

<h1 align="center">Add new Voucher Profile </h1>

<s:form action="createVP" name="createform">

<table width="115%" align="center" cellpadding="20" cellspacing="0" border="1" >
<tr>
	<td>
		<table>
				<s:textfield  key="ManagerVoucherProfile.proName" name="vp_name" required="true" />
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
<table align="center" >
<tr>
	<td>
		<table >
		
		<s:submit key="submit" name="submit" ></s:submit>
		
		</table>
	</td>
	<td>
		<table >
		
		<s:reset key="reset" name="reset"></s:reset>
		
		</table>	
	</td>
	<!--<td>
		<table>
		
		<s:form action="adminhome">
			<s:submit  key="cancel" name="cancel"></s:submit>
		</s:form>
		
		</table>
	</td>-->
</tr>
</table>
</s:form>

</body>
</html>