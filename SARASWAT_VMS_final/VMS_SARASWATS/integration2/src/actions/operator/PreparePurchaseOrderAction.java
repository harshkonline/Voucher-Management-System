package actions.operator;

import java.util.ArrayList;
import java.util.Map;


import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import database.ConnectionPool; 

public class PreparePurchaseOrderAction extends ActionSupport implements SessionAware{
	List vnd_name_list;
	String vnd_address;
	List vp_name_list;
	Double vp_discount;
	Map<String, List> session = null;
	
	public void setVnd_name_list(List vndNameList) {
		vnd_name_list = vndNameList;
	}

/*	String vp_unitPrice;
	String vp_quantity;
	String vp_discount;*/
	
	
	public List getVnd_name_list() {
		return vnd_name_list;
	}

	public String getVnd_address() {
		return vnd_address;
	}

	public void setVnd_address(String vndAddress) {
		vnd_address = vndAddress;
	}



	public List getVp_name_list() {
		return vp_name_list;
	}

	public void setVp_name_list(List vpNameList) {
		vp_name_list = vpNameList;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		if(ActionContext.getContext().getSession().get("username") == null) {
			addActionMessage("Session expired. Please login again.");
			return "notLoggedIn";
		}
		
		String query=null,query1=null;
		ResultSet rs;
		
		List list=new ArrayList();
		List list2=new ArrayList();
	
		Connection conn= ConnectionPool.fetchConnection();
		Statement stmt=conn.createStatement();
		query="select vnd_name from Vendor_Details_300";
		rs=stmt.executeQuery(query);
		 
		while(rs.next()){
			list.add(rs.getString(1));
			System.out.println("----------------"+rs.getString(1));
		}
		setVnd_name_list(list);
		
		query1="select vp_name from Voucher_Profiles_300";
		rs=stmt.executeQuery(query1);
		
		
		while(rs.next()){
			list2.add(rs.getString(1));
			System.out.println("----------------"+rs.getString(1));
		}
		setVp_name_list(list2);
		System.out.println("kolhapur"+vp_name_list);
		                                                              
		session.put("vndname", list);
		session.put("vpname", list2);
		conn.close();
		return SUCCESS;
	}

	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}
	
}
