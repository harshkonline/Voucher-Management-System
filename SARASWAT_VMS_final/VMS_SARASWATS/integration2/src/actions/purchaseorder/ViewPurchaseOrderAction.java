package actions.purchaseorder;

import java.util.Vector;


import beans.purchaseorder.ViewPurchaseOrderBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ViewPurchaseOrderAction extends ActionSupport{
	Vector<PurchaseOrderData> list=new Vector<PurchaseOrderData>();
	
	@Override	
	public String execute() throws Exception {
		// TODO Auto-generated method stub		
		
		if(ActionContext.getContext().getSession().get("username") == null) {
			addActionMessage("Session expired. Please login again.");
			return "notLoggedIn";
		}

		ViewPurchaseOrderBean bean=new ViewPurchaseOrderBean();
		//String query="select * from PO_Details_300 where vnd_id != 0";
		String query="SELECT PO.po_number,VD.vnd_name,PO.VP_QUANTITY,PO.VP_NAME,PO.VP_DATEOFORDER,PO.VP_STATUS"+
					 " FROM Vendor_Details_300 VD,PO_Details_300 PO"+
					 " WHERE PO.vnd_id=VD.vnd_id"+
					 " ORDER BY PO.vp_status";
		System.out.println("\n\n\n\n\nQuery="+query);
		setList(bean.getData(query));
		return SUCCESS;
	}

	public Vector<PurchaseOrderData> getList() {
		return list;
	}

	public void setList(Vector<PurchaseOrderData> list) {
		this.list = list;
	}
}