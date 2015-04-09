package beans.purchaseorder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.ConnectionPool;

public class UpdatePurchaseOrderBean {
	public void updatePurchaseOrder(String vnd_name, String vnd_address, String vp_name, String printmedium,
									int vp_unitPrice, int vp_quantity, int vp_discount, String deliverydate) {
		int vnd_id;
		Connection conn=null;
		Statement statement=null;
		ResultSet resultSet=null;
		String query="update Vendor_Details_300 set vnd_address='"+vnd_address+"' where vnd_name='"+vnd_name+"'"; 
		ConnectionPool pool=new ConnectionPool();
		conn=pool.fetchConnection();
		System.out.println("\n\n\nUpdate Query="+query);
		try {
			statement=conn.createStatement();
			statement.executeUpdate(query);
			
			query="select vnd_id from Vendor_Details_300 where vnd_name='"+vnd_name+"'";
			System.out.println("\n\n\nSelect Query="+query);
			resultSet=statement.executeQuery(query);
			resultSet.next();
			vnd_id=resultSet.getInt(1);
			System.out.println("\n\n\t\tVendor Id="+vnd_id);
			query="update PO_Details_300 set vp_name='"+vp_name+"',vp_printMedia='"+printmedium+"',vp_unitPrice=" +
				  vp_unitPrice+",vp_quantity="+vp_quantity+",vp_discount="+vp_discount+",vp_dateOfDelivery='"+deliverydate+"' where " +
				  "vnd_id="+vnd_id;
			System.out.println("\n\n\nUpdate Query="+query);
			statement.executeUpdate(query);
			
			
			System.out.println("\n\n\n.................Updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}			
	}
}
