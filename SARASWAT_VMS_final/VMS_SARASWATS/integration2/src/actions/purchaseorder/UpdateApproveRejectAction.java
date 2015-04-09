package actions.purchaseorder;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import logging.log4j;
import mailing.SendMailBean;

import beans.purchaseorder.ApprovePurchaseOrderBean;
import beans.purchaseorder.GetDetails;
import beans.purchaseorder.RejectPurchaseOrderBean;
import beans.purchaseorder.UpdatePurchaseOrderBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.validator.Validator;

public class UpdateApproveRejectAction extends ActionSupport implements SessionAware {
	String button,vnd_name,vnd_address,vp_name,printmedium,deliverydate,po_number,vp_status;
	Map sessionmap;
	String username,emailid,from,mail_body,subject;
	String message;
	int vp_unitPrice,vp_quantity,vp_discount;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		if(ActionContext.getContext().getSession().get("username") == null) {
			addActionMessage("Session expired. Please login again.");
			return "notLoggedIn";
		}

		SendMailBean mail_bean=new SendMailBean();
		log4j logbean=new log4j();
		if("Update".equals(button)) {			
			UpdatePurchaseOrderBean bean=new UpdatePurchaseOrderBean();
			bean.updatePurchaseOrder(vnd_name, vnd_address, vp_name, printmedium, vp_unitPrice, vp_quantity, vp_discount, deliverydate);
			
			//log4j code			
			message="PURCHASE ORDER UPDATED ("+vnd_name+","+vnd_address+","+vp_name+","+","+printmedium+","+vp_unitPrice+","+vp_quantity+
					","+vp_discount+","+deliverydate+")";
			logbean.newlog(message);			
			
			return "update_success";
		}
		else if("Approve".equals(button)) {
			UpdatePurchaseOrderBean bean=new UpdatePurchaseOrderBean();
			bean.updatePurchaseOrder(vnd_name, vnd_address, vp_name, printmedium, vp_unitPrice, vp_quantity, vp_discount, deliverydate);			
			ApprovePurchaseOrderBean bean2=new ApprovePurchaseOrderBean();
			bean2.approve(po_number);
			
			sessionmap=ActionContext.getContext().getSession();
			
			//Javamail code
						
			//username=sessionmap.get("username").toString();			
			emailid=(new GetDetails()).getEmailId(vnd_name);
			from="user1@pace.com";
			mail_body="Hello Sir,\n" +
					"Your Order Request for Order Number "+po_number+
					" has been Approved\n\n" +
					"Your date of Delivery is: "+(new GetDetails()).getdateOfDelivery(po_number)+
					"\n\n--------------------------------------------------------"+
					"				Reminder Mail						" +
					"\n\n--------------------------------------------------------";
			subject="Purchase Order Request Approved";
			SendMailBean mailbean=new SendMailBean();		
			mailbean.sendMail(emailid, from, mail_body, subject);
			
			//log4j code
			message="PURCHASE ORDER APPROVED, PO_Number="+po_number;
			logbean.newlog(message);
			
			return "approve_success";
		}
		
		else if("Reject".equals(button)) {
			RejectPurchaseOrderBean bean=new RejectPurchaseOrderBean();
			bean.reject(po_number);
			
			//javamail code			
			emailid=(new GetDetails()).getEmailId(vnd_name);
			from="user1@pace.com";
			mail_body="Hello Sir,\n" +
					"Your Order Request for Order Number "+po_number+
					" has been Rejected\n\n";					
			subject="Purchase Order Request Rejected";
			SendMailBean mailbean=new SendMailBean();		
			mailbean.sendMail(emailid, from, mail_body, subject);
			
			
			//log4j code
			message="PURCHASE ORDER REJECTED, PO_Number="+po_number;
			logbean.newlog(message);
			return "reject_success";
		}		
		return SUCCESS;
	}	
	
	public String getButton() {
		return button;
	}
	public void setButton(String button) {
		this.button = button;
	}
	public String getVnd_name() {
		return vnd_name;
	}
	public void setVnd_name(String vndName) {
		vnd_name = vndName;
	}
	public String getVnd_address() {
		return vnd_address;
	}
	public void setVnd_address(String vndAddress) {
		vnd_address = vndAddress;
	}
	public String getPrintmedium() {
		return printmedium;
	}
	public void setPrintmedium(String printmedium) {
		this.printmedium = printmedium;
	}
	
	
	public int getVp_unitPrice() {
		return vp_unitPrice;
	}

	public void setVp_unitPrice(int vpUnitPrice) {
		vp_unitPrice = vpUnitPrice;
	}

	public int getVp_quantity() {
		return vp_quantity;
	}

	public void setVp_quantity(int vpQuantity) {
		vp_quantity = vpQuantity;
	}

	public int getVp_discount() {
		return vp_discount;
	}

	public void setVp_discount(int vpDiscount) {
		vp_discount = vpDiscount;
	}

	public String getDeliverydate() {
		return deliverydate;
	}
	public void setDeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
	}

	public String getVp_name() {
		return vp_name;
	}

	public void setVp_name(String vpName) {
		vp_name = vpName;
	}
	public String getPo_number() {
		return po_number;
	}

	public void setPo_number(String poNumber) {
		po_number = poNumber;
	}		
	
	public String getVp_status() {
		return vp_status;
	}

	public void setVp_status(String vpStatus) {
		vp_status = vpStatus;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if(getVnd_address().length()==0) {
			addFieldError("vnd_address", "Please Enter Address");
		}
		if(getVp_unitPrice()==0) {
			addFieldError("vp_unitPrice", "Please Enter unit price");
		}
		if(getVp_quantity()==0) {
			addFieldError("vp_quantity", "Please Enter Quantity");
		}
		/*if(getVp_discount()==0) {
			addFieldError("vp_discount", "Please Enter Discount");
		}*/
	}

	

	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		sessionmap=arg0;
	}	
}

