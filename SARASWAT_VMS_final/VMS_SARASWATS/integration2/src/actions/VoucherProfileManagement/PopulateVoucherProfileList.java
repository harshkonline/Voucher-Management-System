package actions.VoucherProfileManagement;

import java.sql.Connection;
import com.opensymphony.xwork2.ActionContext;
import logging.log4j;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import database.ConnectionPool;
/***action class  for populating voucher profile list ***/
public class PopulateVoucherProfileList extends ActionSupport implements SessionAware{
	List<String> profileList= new ArrayList<String>();
	//object of log4j class
	log4j log = new log4j();
	public List<String> getProfileList() {
		return profileList;
	}
	public void setProfileList(List<String> profileList) {
		this.profileList = profileList;
	}
	/***logic for selecting all voucher profile names from database table voucher_profiles_300 ***/
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//query for selecting all the field from database table voucher_profiles_300;
		if(ActionContext.getContext().getSession().get("username") == null) {
			addActionMessage("Session expired. Please login again.");
			return "notLoggedIn";
		}
		String query="select vp_name from voucher_profiles_300";
		
		/***create connection***/
		ConnectionPool cp=new ConnectionPool();//create object of connection pool
		Connection conn=cp.fetchConnection();//call method from connection pool using its objects
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(query);
		log.newlog(query);
		//profileList.add("--- Select Profile ---");
		while(rs.next()){
			//populating the list
			profileList.add(rs.getString(1));
		}
		conn.close();
		return SUCCESS;
	}
	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
