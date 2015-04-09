package actions.VoucherProfileManagement;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import logging.log4j;

import org.apache.struts2.interceptor.SessionAware;
import beans.VoucherProfileManagement.CreateVoucherProfileService;
import beans.VoucherProfileManagement.SetVoucherProfileDetails;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.ConversionErrorFieldValidator;
/***action class for Create Voucher Profile***/
public class CreateVoucherProfile extends ActionSupport implements ModelDriven,SessionAware{
	SetVoucherProfileDetails svpd=new SetVoucherProfileDetails();
	String cancel;
	String msg1="voucher created successfully";
	String msg2="voucher creation fail";
	String msg3="voucher is allready exist";
	//object of log4j class
	log4j log = new log4j();
	//setter and getter for cancel
	public String getCancel() {
		return cancel;
	}

	public void setCancel(String cancel) {
		this.cancel = cancel;
	}

	public CreateVoucherProfile() {
		// TODO Auto-generated constructor stub
	}
	
	public SetVoucherProfileDetails getSvpd() {
		return svpd;
	}
	public void setSvpd(SetVoucherProfileDetails svpd) {
		this.svpd = svpd;
	}
	/****check logic where voucher profile is created or not successfully ****/
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(ActionContext.getContext().getSession().get("username") == null) {
			addActionMessage("Session expired. Please login again.");
			return "notLoggedIn";
		}
		CreateVoucherProfileService cvps=new CreateVoucherProfileService();
		String result=cvps.isCreateSuccess(getSvpd());
		/***check the voucher profile is created successfully or not***/
		if(getCancel()!=null){
			return SUCCESS;
		}
		else{
		if(result.equals("success")){
			addActionMessage(getText("vpcreate.success"));
					log.newlog(msg1);
			
		}
		else if(result.equals("error")){
			addActionError(getText("vpcreate.error"));
			log.newlog(msg2);
		}
		else if(result.equals("exists"))
		{
			/**check the voucher profile is already exist or not**/
			addFieldError("vp_name",getText("profilename.exists"));
			log.newlog(msg3);
		}
		return result;
		}
	}
	
	
	
	public Object getModel() {
		// TODO Auto-generated method stub
		return svpd;
	}
	/*** function for validating the required fields  ****/
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if(getCancel()==null){
		//validation for voucher name
		if (svpd.getVp_name().length() == 0 ){
			addFieldError( "vp_name", getText("profilename.required") );
		}
		//validation for GracePeriod 1
		if (svpd.getVp_gracePeriod1()==0 ){
			addFieldError( "vp_gracePeriod1", getText("gracePeriod1.required") );
		}
		//validation for GracePeriod 2
		if (svpd.getVp_gracePeriod2()== 0  ){
			addFieldError( "vp_gracePeriod2", getText( "gracePeriod2.required" ));
		}
		//validation for talktime
		if (svpd.getVp_talktime()== 0 ){
			addFieldError( "vp_talktime", getText("talktime.required"));
		}
		//validation for Quarantine period
		if (svpd.getVp_quaratinePeriod()== 0 ){
			addFieldError( "vp_quaratinePeriod", getText("quarantine.required"));
		}
		//validation for validity period
		if (svpd.getVp_validityPeriod()== 0  ){
			addFieldError( "vp_validityPeriod", getText("validityPeriod.required"));
		}
		}
	}

	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		
	}
}
