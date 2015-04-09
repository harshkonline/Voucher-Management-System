package actions.VoucherProfileManagement;

import java.sql.Connection;


import logging.log4j;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import database.ConnectionPool;

public class CheckName extends ActionSupport implements SessionAware {
	String vp_name;
	String msg1="voucher name is all ready exit";
	public String getVp_name() {
		return vp_name;
	}
	//object of log4j class
	log4j log = new log4j();
	
	public void setVp_name(String vpName) {
		vp_name = vpName;
	}
	/***logic for selecting voucher profile name from database and check whether name is exist in database or not***/
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		/*if( ActionContext.getContext().getSession().get("username") == null) {
			addActionMessage("Session expired. Please login again.");
			return "notLoggedIn";
		}*/
		//database query for selecting voucher profile name from database table voucher_profiles_300
		String query="select vp_name from voucher_profiles_300 where vp_name='"+vp_name+"'";
		/***create connection***/
		ConnectionPool cp=new ConnectionPool();//create object of connection pool
		Connection conn=cp.fetchConnection();//call method from connection pool usingits objects
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(query);
		log.newlog(query);
		//profileList.add("--- Select Profile ---");
		if(rs.next()){
			/**check the name is allready exit or not**/
			addFieldError("vp_name","Profile Name already exists");
			log.newlog(msg1);
			return "fail";
		}
		conn.close();
		return SUCCESS;
	}

	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		
	}

	


}
