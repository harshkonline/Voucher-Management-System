package beans.purchaseorder;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.ConnectionPool;

public class ApprovePurchaseOrderBean {
	public void approve(String po_number) {
		Connection conn=ConnectionPool.fetchConnection();
		Statement statement;
		String query="update PO_Details_300 set vp_status='approved' where po_number="+Integer.parseInt(po_number);
		try {
			 statement=conn.createStatement();
			 statement.executeUpdate(query);
			 conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
