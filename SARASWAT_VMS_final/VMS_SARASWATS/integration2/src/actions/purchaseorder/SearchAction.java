package actions.purchaseorder;

import java.lang.annotation.Annotation;
import java.util.Vector;

import org.omg.PortableServer.POA;


import beans.purchaseorder.ViewPurchaseOrderBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;

public class SearchAction extends ActionSupport{
	String SearchBy,SearchText,status,query;
	Vector<PurchaseOrderData> list=new Vector<PurchaseOrderData>();
	ViewPurchaseOrderBean bean=new ViewPurchaseOrderBean();
	
	@Override
	public String execute() throws Exception {

		if(ActionContext.getContext().getSession().get("username") == null) {
			addActionMessage("Session expired. Please login again.");
			return "notLoggedIn";
		}

		if("vname".equals(SearchBy)) {			
			query="select PO.po_number,VD.vnd_name,PO.VP_QUANTITY,PO.VP_NAME,PO.VP_DATEOFORDER,PO.VP_STATUS"+ 
				  " from Vendor_Details_300 VD,PO_Details_300 PO "+ 
				  " WHERE PO.vnd_id=ANY(select VD2.vnd_id from Vendor_Details_300 VD2 where lower(VD.vnd_name) like '%"+SearchText.toLowerCase()+"%' " +
				  " AND VD2.vnd_id=VD.vnd_id)";
		}
		else if("ponumber".equals(SearchBy)) {
			query="select PO.po_number,VD.vnd_name,PO.VP_QUANTITY,PO.VP_NAME,PO.VP_DATEOFORDER,PO.VP_STATUS"+ 
			  " from Vendor_Details_300 VD,PO_Details_300 PO "+ 
			  " WHERE PO_NUMBER="+Integer.parseInt(SearchText)+
			  " AND PO.vnd_id=VD.vnd_id";			
		}
		else if( ("pending".equals(SearchBy)) || ("approved".equals(SearchBy))|| ("rejected".equals(SearchBy))) {			
			query="select PO.po_number,VD.vnd_name,PO.VP_QUANTITY,PO.VP_NAME,PO.VP_DATEOFORDER,PO.VP_STATUS"+ 
			  " from Vendor_Details_300 VD,PO_Details_300 PO "+ 
			  "WHERE vp_status='"+SearchBy+"'"+
			  " AND PO.vnd_id=VD.vnd_id";
		}
		System.out.println("\n\n\n\n---- Query="+query);
		setList( bean.getData(query));
		return SUCCESS;
	}
	public String getSearchBy() {
		return SearchBy;
	}
	public void setSearchBy(String searchBy) {
		SearchBy = searchBy;
	}
	public String getSearchText() {
		return SearchText;
	}
	public void setSearchText(String searchText) {
		SearchText = searchText;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Vector<PurchaseOrderData> getList() {
		return list;
	}
	public void setList(Vector<PurchaseOrderData> list) {
		this.list = list;
	}	
	public void validate() {	
		
		if(SearchBy.equals("ponumber") && (getSearchText().length()==0)) {
			addFieldError("SearchText", "Please Enter PO Number");						
		}
		else if(SearchBy.equals("ponumber")) {
			try {
				int i=Integer.parseInt(SearchText);
			} catch(Exception ex) {
				addFieldError("SearchText", "PO Number must be numeric");
			}
		}
	}
}