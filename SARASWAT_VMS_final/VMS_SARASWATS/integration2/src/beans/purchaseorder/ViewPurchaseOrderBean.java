package beans.purchaseorder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import actions.purchaseorder.PurchaseOrderData;

import database.ConnectionPool;


public class ViewPurchaseOrderBean {
	
	Vector<PurchaseOrderData> list=new Vector<PurchaseOrderData>();
	ConnectionPool pool;
	Connection conn;
	Statement statement ;
	ResultSet resultset=null;
	ResultSet resultSet2=null;
	public Vector<PurchaseOrderData> getData (String query) {
			
		pool=new ConnectionPool();		
		conn=ConnectionPool.fetchConnection();		
		
		
		String po_number,summary,date,status;
		PurchaseOrderData data;
		try {
			statement=conn.createStatement();
			resultset=statement.executeQuery(query);
			
			while(resultset.next()) {				
				data=new PurchaseOrderData();
				po_number=resultset.getString(1);
				summary=resultset.getString(2)+" , " + //vendor name
						resultset.getString(3)+" , " + //quantity
						resultset.getString(4);//voucher profile name
				date=resultset.getString(5);//date of order
				date=date.substring(0, 10);
				status=resultset.getString(6); //vp_status
				
				data.setPo_number(po_number);
				data.setSummary(summary);
				data.setPrepared_date(date);
				data.setStatus(status);
				
				list.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
		
	
	
	public Vector<PurchaseOrderData> searchByStatus(String status) {
		return list;
	}
	
}
