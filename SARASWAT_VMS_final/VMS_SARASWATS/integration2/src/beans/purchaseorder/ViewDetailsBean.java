package beans.purchaseorder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.ConnectionPool;

public class ViewDetailsBean {
	public ArrayList<String> getDetails(int po_number) {
		
		ArrayList<String> list=new ArrayList<String>();
		
		Connection conn= ConnectionPool.fetchConnection();
		Statement statement=null ;
		ResultSet resultSet=null;
		String query="select vnd_id,vp_name,vp_printMedia,vp_unitPrice,vp_quantity,vp_discount,vp_dateOfDelivery,vp_status from PO_Details_300 where po_number="+po_number;
		
		int vnd_id;
		
		try {
			statement=conn.createStatement();
			
			resultSet=statement.executeQuery(query);
			resultSet.next();
			vnd_id=resultSet.getInt(1);
			list.add(resultSet.getString(2));//vp_name
			list.add(resultSet.getString(3));//print media
			list.add(resultSet.getString(4));//unit price
			list.add(resultSet.getString(5));// quantity
			list.add(resultSet.getString(6));//discount
			list.add(resultSet.getString(7));//date of delivery
			list.add(resultSet.getString(8));//status
			
			//get vender name & address from vnd_id
			query="select vnd_name,vnd_address from Vendor_Details_300 where vnd_id="+vnd_id;
			resultSet=statement.executeQuery(query);
			resultSet.next();
			
			list.add(resultSet.getString(1));//vnd name
			list.add(resultSet.getString(2));//vnd address
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return list;
	}
}
