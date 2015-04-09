package beans.VoucherProfileManagement;

import java.sql.Connection;
import logging.log4j;
import java.sql.SQLException;
import java.sql.Statement;

import database.ConnectionPool;
/**** Bean for Updating voucher profile ****/
public class UpdateVoucherProfileService {
	public String isUpdateSuccess(SetVoucherProfileDetails svpd,String selected_profile){
		String query="";
		
		//object of log4j class
		log4j log = new log4j();
		
		/***create connection***/
		ConnectionPool cp=new ConnectionPool();//create object of connection pool
		Connection conn=cp.fetchConnection();//call method from connection pool usingits objects
		System.out.println("------------------FROM UPDATEVPSERVICE--------------------");
		System.out.println("Profile name----"+selected_profile);
		System.out.println("Misc----"+svpd.getVp_misc());
		/**database query for updating the table Voucher_Profiles_300**/
		query="update Voucher_Profiles_300 set vp_name='"+svpd.getVp_name()+"',vp_graceperiod1="+svpd.getVp_gracePeriod1()+",vp_graceperiod2="+svpd.getVp_gracePeriod2()+",vp_quartineperiod="+svpd.getVp_quaratinePeriod()+",vp_shelflife="+svpd.getVp_shelflife()+",vp_talktime="+svpd.getVp_talktime()+",vp_adminfees="+svpd.getVp_adminFees()+",vp_servicetax="+svpd.getVp_serviceTax()+",vp_processingfees="+svpd.getVp_processingFees()+",vp_mrp="+svpd.getVp_mrp()+",vp_statetax="+svpd.getVp_stateTax()+",vp_misc="+svpd.getVp_misc()+",vp_validityperiod="+svpd.getVp_validityPeriod()+"where vp_name='"+svpd.getVp_name()+"'";
		try {
			Statement st=conn.createStatement();
			st.executeUpdate(query);
			log.newlog(query);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
}
