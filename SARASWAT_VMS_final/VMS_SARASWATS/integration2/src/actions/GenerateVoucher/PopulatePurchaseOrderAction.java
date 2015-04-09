package actions.GenerateVoucher;

import java.util.ArrayList;
import java.util.Vector;

import beans.GenerateVoucher.PopulatePurchaseOrderBean;
import beans.GenerateVoucher.PurchaseOrderDataBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//to populate the approved orders to the user
public class PopulatePurchaseOrderAction extends ActionSupport {
	
	
	Vector<PurchaseOrderDataBean> list_of_orders = null;
	ArrayList<String> check = new ArrayList<String>();
	
	
	public String execute() {
		
		//check whether user has logged in
		if(ActionContext.getContext().getSession().get("username") == null) {
			addActionMessage("Session expired. Please login again.");
			return "notLoggedIn";
		}
		
		//object of class to populate the approved orders to the user
		PopulatePurchaseOrderBean purchaseOrderBean = new PopulatePurchaseOrderBean();
		
		//call the method that retrieves the approved orders and returns the list of orders
		setList_of_orders(purchaseOrderBean.getPurchaseOrders());
		//check if no approved order is present
		if(list_of_orders.size() == 0) {
			return "empty";
		}
		//add the orders in the arraylist to populate in table through iterator
		for (int i = 0; i < list_of_orders.size(); i++) {
			check.add(((PurchaseOrderDataBean)list_of_orders.get(i)).getPo_number());
		}
		return SUCCESS;
	}
	
	//getters and setters
	public ArrayList<String> getCheck() {
		return check;
	}

	public void setCheck(ArrayList<String> check) {
		this.check = check;
	}
	
	
	public Vector<PurchaseOrderDataBean> getList_of_orders() {
		
		return list_of_orders;
		
	}

	public void setList_of_orders(Vector<PurchaseOrderDataBean> listOfOrders) {
		
		list_of_orders = listOfOrders;
		
	}

}
