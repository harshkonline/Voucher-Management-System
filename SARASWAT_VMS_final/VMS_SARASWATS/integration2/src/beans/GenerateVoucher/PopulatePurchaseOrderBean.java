package beans.GenerateVoucher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import database.ConnectionPool;
//class to retrieve the purchase orders that are approved
public class PopulatePurchaseOrderBean {
	
	//function that returns the vector of purchase orders that are approved with 
	//the data holder class PurchaseOrderDataBean
	public Vector<PurchaseOrderDataBean> list_of_orders = new Vector<PurchaseOrderDataBean>();
	public PurchaseOrderDataBean dataBean = null;
	@SuppressWarnings("static-access")
	public Vector<PurchaseOrderDataBean> getPurchaseOrders() {
		
		//establish connection with database
		ConnectionPool connectionPool = new ConnectionPool();
		
		Connection connection = connectionPool.fetchConnection();
		
		//declare the database  objects
		ResultSet resultSet = null;
		Statement statement = null;
		String query = "";
		
		try {
			statement = connection.createStatement();
			
			query = "SELECT * FROM PO_Details_300 WHERE vp_status ='approved' AND vnd_id!=0";
			resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				
				//class to hold data of particular order
				dataBean = new PurchaseOrderDataBean();
				
				//set the entities of particular order in the bean
				dataBean.setPo_number(resultSet.getString(1));
				dataBean.setVp_name(resultSet.getString(2));
				dataBean.setVp_quantity(resultSet.getString(3));
				dataBean.setVp_dateOfOrder(resultSet.getString(4).substring(0,10));
				dataBean.setVp_dateOfDelivery(resultSet.getString(5).substring(0,10));
				dataBean.setVp_printMedia(resultSet.getString(6));
				dataBean.setVp_netAmount(resultSet.getString(8));
				dataBean.setVp_unitPrice(resultSet.getString(10));
				
				//add the bean to vector  
				list_of_orders.add(dataBean);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage()+" is the error---------");
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return the vector having the details of approved orders
		return list_of_orders;
	}
}
