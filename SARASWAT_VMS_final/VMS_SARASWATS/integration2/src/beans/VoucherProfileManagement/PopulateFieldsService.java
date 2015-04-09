package beans.VoucherProfileManagement;

import java.sql.Connection;
import logging.log4j;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionPool;
/**** bean for populating field****/
public class PopulateFieldsService {
	public PopulateFieldsService() {
		// TODO Auto-generated constructor stub
	}
	//object of log4j class
	log4j log = new log4j();
	/***set field to the the forms***/
	public void setUpdateFields(SetVoucherProfileDetails svpd,String selected_profile){
		String query="";
		List feeList=new ArrayList();
		/**create connection**/
		ConnectionPool cp=new ConnectionPool();//create object of connection pool
		Connection conn=cp.fetchConnection();//call method from connection pool usingits objects
		
		/***select all the field from table voucher_profiles_300 where profile name is equal to the selected profile name ***/
		
		
		query="select * from voucher_profiles_300 where vp_name='"+selected_profile+"'";
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(query);
			log.newlog(query);
			while(rs.next()){
				/***setting the field values***/
				svpd.setVp_name(rs.getString(1));
				svpd.setVp_gracePeriod1(rs.getInt(2));
				svpd.setVp_gracePeriod2(rs.getInt(3));
				svpd.setVp_quaratinePeriod(rs.getInt(4));
				svpd.setVp_shelflife(rs.getInt(5));
				svpd.setVp_talktime(rs.getDouble(6));
				svpd.setVp_adminFees(rs.getDouble(7));
				svpd.setVp_serviceTax(rs.getDouble(8));
				svpd.setVp_processingFees(rs.getDouble(9));
				svpd.setVp_mrp(rs.getDouble(10));
				svpd.setVp_stateTax(rs.getDouble(11));
				svpd.setVp_misc(rs.getDouble(12));
				svpd.setVp_validityPeriod(rs.getInt(13));
				feeList.add("Misc.,"+rs.getDouble(12));
				feeList.add("State Tax,"+rs.getDouble(11));
				svpd.setFee_list(feeList);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
