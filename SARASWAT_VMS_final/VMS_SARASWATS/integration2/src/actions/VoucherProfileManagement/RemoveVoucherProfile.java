package actions.VoucherProfileManagement;

import java.sql.Connection;
import com.opensymphony.xwork2.ActionContext;
import logging.log4j;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import database.ConnectionPool;
/****action class for remove voucher profile ****/
public class RemoveVoucherProfile extends ActionSupport implements SessionAware {
	String vp_name;
	String cancel;
	String msg1="selected profile is successfully removed";
	String msg2="selected profile is not successfully removed";
	
	//object of log4j class
	log4j log = new log4j();
	
	//setter and getter for cancel
	public String getCancel() {
		return cancel;
	}

	public void setCancel(String cancel) {
		this.cancel = cancel;
	}
	public String getVp_name() {
		return vp_name;
	}
	public void setVp_name(String vpName) {
		vp_name = vpName;
	}
	/***logic for removing the voucher profile from database and also check whether it is successfully removed or not ***/
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(ActionContext.getContext().getSession().get("username") == null) {
			addActionMessage("Session expired. Please login again.");
			return "notLoggedIn";
		}
		/***create connection***/
	
		ConnectionPool cp=new ConnectionPool();//create object of connection pool
		Connection conn=cp.fetchConnection();//call method from connection pool usingits objects
		Statement st=conn.createStatement();
		//query for deleting the entry from database
		 String query1="delete from voucher_profiles_300 where vp_name='"+vp_name+"' and vp_name not in(select vp_name from po_details_300) and vp_name not in(select vp_name from Voucher_Details_300)";
		int i=st.executeUpdate("delete from voucher_profiles_300 where vp_name='"+vp_name+"' and vp_name not in(select vp_name from po_details_300) and vp_name not in(select vp_name from Voucher_Details_300)");
		log.newlog(query1);
		conn.close();
		if(getCancel()!=null){
			return SUCCESS;
		}
		else{
		if(i!=0)
		{
			//check whether the Removal happen successfully or not
			addActionMessage(getText("profile")+"  "+vp_name+"  "+getText("deletevp.success") );
			log.newlog(msg1);
			return SUCCESS;
		}
		else
		{
			addActionMessage(getText("profile")+"  "+vp_name+"  "+getText("deletevp.error"));
			log.newlog(msg2);
			return INPUT;
		}
		}
		
	}

	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		
	}


	

}
