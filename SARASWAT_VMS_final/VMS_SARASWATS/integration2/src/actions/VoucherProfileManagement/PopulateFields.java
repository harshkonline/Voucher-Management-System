package actions.VoucherProfileManagement;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import logging.log4j;

import org.apache.struts2.interceptor.SessionAware;

import beans.VoucherProfileManagement.PopulateFieldsService;
import beans.VoucherProfileManagement.SetVoucherProfileDetails;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*** action class for populating field for selected voucher propfile name***/

public class PopulateFields extends ActionSupport implements ModelDriven,SessionAware{
	String selected_profile;
	SetVoucherProfileDetails svpd=new SetVoucherProfileDetails();
	
	//object of log4j class
	log4j log = new log4j();
	
	public PopulateFields() {
		// TODO Auto-generated constructor stub
	}
	//getter and setter forselected_profile 
	public String getSelected_profile() {
		return selected_profile;
	}
	public void setSelected_profile(String selectedProfile) {
		selected_profile = selectedProfile;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(ActionContext.getContext().getSession().get("username") == null) {
			addActionMessage("Session expired. Please login again.");
			return "notLoggedIn";
		}
		PopulateFieldsService puf = new PopulateFieldsService();
		if(getSelected_profile().equals("---Select Profile---")){
			return "same";
		}else{
			puf.setUpdateFields(svpd,getSelected_profile());
			return SUCCESS;
		}
		
		
	}
	
	public Object getModel() {
		// TODO Auto-generated method stub
		return svpd;
	}
	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
