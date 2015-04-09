package actions.VoucherProfileManagement;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import logging.log4j;

import org.apache.struts2.interceptor.SessionAware;

import beans.VoucherProfileManagement.CreateVoucherProfileService;
import beans.VoucherProfileManagement.SetVoucherProfileDetails;
import beans.VoucherProfileManagement.UpdateVoucherProfileService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/***action class for update validation profile***/

public class UpdateVoucherProfile extends ActionSupport implements ModelDriven,SessionAware{

	//object of log4j class
	log4j log = new log4j();
	
	SetVoucherProfileDetails svpd=new SetVoucherProfileDetails();
	String selected_profile;
	String cancel;
	String msg1="selected profile is successfully updated";
	String msg2="selected profile is not successfully updated";
	//setter and getter for cancel
	public String getCancel() {
		return cancel;
	}

	public void setCancel(String cancel) {
		this.cancel = cancel;
	}
	//getter and setter forselected_profile
	public String getSelected_profile() {
		return selected_profile;
	}
	public void setSelected_profile(String selectedProfile) {
		selected_profile = selectedProfile;
	}
	public SetVoucherProfileDetails getSvpd() {
		return svpd;
	}
	public void setSvpd(SetVoucherProfileDetails svpd) {
		this.svpd = svpd;
	}
	/***check whether the updation is done successfully or not**/
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(ActionContext.getContext().getSession().get("username") == null) {
			addActionMessage("Session expired. Please login again.");
			return "notLoggedIn";
		}
		UpdateVoucherProfileService cvps=new UpdateVoucherProfileService();
		String result=cvps.isUpdateSuccess(getSvpd(),getSelected_profile());
		//check whether the updation happen successfully
		if(getCancel()!=null){
			return SUCCESS;
		}
		else{
		if(result.equals("success")){
			addActionMessage(getText("vpupdate.success"));
			log.newlog(msg1);
			return "success";
		}
		else if(result.equals("error")){
			addActionError(getText("vpupdate.error"));
			log.newlog(msg2);
			return "error";
		}
		return INPUT;
		}
	}
	
	
	public Object getModel() {
		// TODO Auto-generated method stub
		return svpd;
	}

	
	
	//validation for the required field
	@Override
	public void validate() {
		//validation for Grace period1 
		if (svpd.getVp_gracePeriod1()==0 ){
			addFieldError( "vp_gracePeriod1", getText("gracePeriod1.required") );
		}
		//validation for Grace period2
		if (svpd.getVp_gracePeriod2()== 0  ){
			addFieldError( "vp_gracePeriod2", getText( "gracePeriod2.required" ));
		}
		//validation for talktime
		if (svpd.getVp_talktime()== 0 ){
			addFieldError( "vp_talktime", getText("talktime.required"));
		}
		//validation for Quaratine Period
		if (svpd.getVp_quaratinePeriod()== 0 ){
			addFieldError( "vp_quaratinePeriod", getText("quarantine.required"));
		}
		//validation for Validation period
		if (svpd.getVp_validityPeriod()== 0  ){
			addFieldError( "vp_validityPeriod", getText("validityPeriod.required"));
		}
	}

	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		
	}

}
