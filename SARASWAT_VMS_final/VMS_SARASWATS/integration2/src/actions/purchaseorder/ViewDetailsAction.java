package actions.purchaseorder;

import java.util.ArrayList;


import beans.purchaseorder.ViewDetailsBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class ViewDetailsAction  extends ActionSupport{
	String vnd_name,vnd_address,vp_name,printmedium,vp_unitPrice,vp_quantity,
	vp_discount,deliverydate,vp_status;
	
	
	String po_number;
	

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		if(ActionContext.getContext().getSession().get("username") == null) {
			addActionMessage("Session expired. Please login again.");
			return "notLoggedIn";
		}

		ArrayList<String> list=new ArrayList<String>();		
		ViewDetailsBean bean=new ViewDetailsBean();
		
		list=bean.getDetails(Integer.parseInt(po_number));		
		//set fields
		setVp_name(list.get(0));
		setPrintmedium(list.get(1));
		setVp_unitPrice(list.get(2));
		setVp_quantity(list.get(3));
		setVp_discount(list.get(4));
		setDeliverydate(list.get(5));
		setVp_status(list.get(6));
		setVnd_name(list.get(7));
		setVnd_address(list.get(8));				
		return SUCCESS;
	}
	
	public String getPo_number() {
		return po_number;
	}
	public void setPo_number(String poNumber) {
		po_number = poNumber;
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
	public String getVp_name() {
		return vp_name;
	}
	public void setVp_name(String vpName) {
		vp_name = vpName;
	}
	public String getPrintmedium() {
		return printmedium;
	}
	public void setPrintmedium(String printmedium) {
		this.printmedium = printmedium;
	}
	public String getVp_unitPrice() {
		return vp_unitPrice;
	}
	public void setVp_unitPrice(String vpUnitPrice) {
		vp_unitPrice = vpUnitPrice;
	}
	public String getVp_quantity() {
		return vp_quantity;
	}
	public void setVp_quantity(String vpQuantity) {
		vp_quantity = vpQuantity;
	}
	public String getVp_discount() {
		return vp_discount;
	}
	public void setVp_discount(String vpDiscount) {
		vp_discount = vpDiscount;
	}
	public String getDeliverydate() {
		return deliverydate;
	}
	public void setDeliverydate(String deliverydate) {
		this.deliverydate = getdate(deliverydate);
	}
	public String getVp_status() {
		return vp_status;
	}

	public void setVp_status(String vpStatus) {
		vp_status = vpStatus;
	}	
	
public static String getdate(String st) {
		
		String year = "";
		String date = "";
		String mon = "";
		year = st.substring(0 ,4);
		mon = st.substring(5,7 );
		date = st.substring(8,10);
		int dd = Integer.parseInt(mon);
		switch(dd) {
		case 1: mon = "JAN"; break;
		case 2:	mon = "FEB"; break;
		case 3: mon = "MAR"; break;
		case 4: mon = "APR"; break;
		case 5: mon = "MAY"; break;
		case 6: mon = "JUN"; break;
		case 7: mon = "JUL"; break;
		case 8: mon = "AUG"; break;
		case 9: mon = "SEP"; break;
		case 10: mon = "OCT"; break;
		case 11: mon = "NOV"; break;
		case 12: mon = "DEC"; break;
			
		}
		return (date+"-"+mon+"-"+year);
			
	}
}
