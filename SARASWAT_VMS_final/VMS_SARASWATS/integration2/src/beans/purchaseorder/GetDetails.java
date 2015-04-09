package beans.purchaseorder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.ConnectionPool;

public class GetDetails {
	public String getEmailId(String vendor_name) {
		String emailid=null;
		Statement statement ;
		ResultSet resultSet;
		String query="select VND_EMAIL from Vendor_Details_300 where VND_NAME='"+vendor_name+"'";
		
		
		//conn = (new ConnectionPool().getConnection());
		
		Connection conn=ConnectionPool.fetchConnection(); //first
		try {
			statement=conn.createStatement();//first code
		
			resultSet=statement.executeQuery(query);
			resultSet.next();
			emailid=resultSet.getString(1);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return emailid;
	}
	
	public String getdateOfDelivery(String po_number) {
		String date=null;
		Statement statement ;
		ResultSet resultSet;
		String query="select  VP_DATEOFDELIVERY from PO_Details_300 where PO_NUMBER="+po_number;
		Connection conn=ConnectionPool.fetchConnection();
		try {
			statement=conn.createStatement();
			resultSet=statement.executeQuery(query);
			resultSet.next();
			date=resultSet.getString(1);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return date;
	}
}
