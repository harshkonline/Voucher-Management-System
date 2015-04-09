package beans.VoucherProfileManagement;

import java.sql.Connection;
import logging.log4j;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.ConnectionPool;
/***bean for create voucher profile ***/
public class CreateVoucherProfileService {
	public CreateVoucherProfileService() {
		// TODO Auto-generated constructor stub
	}
	//object of log4j class
	log4j log = new log4j();
	
	
	/***check voucher successfully create or not****/
	public String isCreateSuccess(SetVoucherProfileDetails svpd){
		String query="";
	
		/***create connection***/
		ConnectionPool cp=new ConnectionPool();//create object of connection pool
		Connection conn=cp.fetchConnection();//call method from connection pool usingits objects
		
		/** database query for inserting values in database**/
		  query="insert into Voucher_Profiles_300 values('"+svpd.getVp_name()+"',"+svpd.getVp_gracePeriod1()+","+svpd.getVp_gracePeriod2()+","+svpd.getVp_quaratinePeriod()+","+svpd.getVp_shelflife()+","+svpd.getVp_talktime()+","+svpd.getVp_adminFees()+","+svpd.getVp_serviceTax()+","+svpd.getVp_processingFees()+","+svpd.getVp_mrp()+","+svpd.getVp_stateTax()+","+svpd.getVp_misc()+","+svpd.getVp_validityPeriod()+")";
		 
		 String send= "";
		Statement st=null;
		try {
			st=conn.createStatement();
			ResultSet rs=st.executeQuery("select vp_name from voucher_profiles_300 where vp_name='"+svpd.getVp_name()+"'");
			//log.newlog("select vp_name from voucher_profiles_300 where vp_name='"+svpd.getVp_name()+"'");
			if(rs.next())
			{
			
				send="exists";
			}
			else
			{
				st.execute(query);
				log.newlog(query);
				send="success";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			send="error";
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return send;
	}
}
