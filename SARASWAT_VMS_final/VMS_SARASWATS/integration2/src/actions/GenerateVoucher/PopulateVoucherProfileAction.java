package actions.GenerateVoucher;

import java.util.ArrayList;

import beans.GenerateVoucher.PopulateVoucherProfileBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//to populate the voucher profile names to the admin
public class PopulateVoucherProfileAction extends ActionSupport {
	ArrayList<String> vp_name_list = null;
	
	public ArrayList<String> getVp_name_list() {
		return vp_name_list;
	}

	public void setVp_name_list(ArrayList<String> vpName) {
		vp_name_list = vpName;
	}
	
	public String execute() {
		
		//ActionContext.getContext().getSession().put("username", "harsh");
		
		//check whether user has logged in
		if(ActionContext.getContext().getSession().get("username") == null) {
			addActionMessage("Session expired. Please login again.");
			return "notLoggedIn";
		}
		
		PopulateVoucherProfileBean bean = new PopulateVoucherProfileBean();
		setVp_name_list(bean.getVoucherProfileNames());
		ActionContext.getContext().getSession().put("vp_name_list",vp_name_list);
		return SUCCESS;
		
	}

}
