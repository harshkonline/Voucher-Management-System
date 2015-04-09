package actions.operator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Operator.OperatorBean;

import database.ConnectionPool;

public class OperatorService {
		
	
	static public OperatorBean populateDetails() throws SQLException
	{
		OperatorBean ob=new OperatorBean();
		String query=null,query1=null;
		ResultSet rs;
		
		List list=new ArrayList();
		List list2=new ArrayList();
	
		Connection conn= ConnectionPool.fetchConnection();
		Statement stmt=conn.createStatement();
		query="select vnd_name from Vendor_Details_300";
		rs=stmt.executeQuery(query);
		 
		while(rs.next()){
			list.add(rs.getString(1));
			System.out.println("----------------"+rs.getString(1));
		}
		ob.setVnd_name_list(list);
		
		query1="select vp_name from Voucher_Profiles_300";
		rs=stmt.executeQuery(query1);
				
		while(rs.next()){
			list2.add(rs.getString(1));
			System.out.println("----------------"+rs.getString(1));
		}
		ob.setVp_name_list(list2);
		conn.close();	
		return ob;
	}
	
	static public String populateAddress( String vnd_name,OperatorBean obj) throws SQLException
	{
		String query;
		//OperatorBean ob = new OperatorBean(); 
		ResultSet rs;
		String addr ="";
		//String vnd=ob;
		
		Connection conn= ConnectionPool.fetchConnection();
		Statement stmt=conn.createStatement();
		
		obj=populateDetails();
	//	String vnd_name=obj.getVnd_name_list();
		query="select vnd_address from Vendor_Details_300 where vnd_name='"+vnd_name+"'";
		rs=stmt.executeQuery(query);
		System.out.println(query);
		if(rs.next()){
			obj.setVnd_address(rs.getString(1));
			addr= rs.getString(1);
			System.out.println("Vendor adrress"+rs.getString(1));
		}
		conn.close();
		return addr;
	}
	
	
	

	static public Double populateUnitPrice( String vp_name,OperatorBean obj) throws SQLException
	{
		String query;
		//OperatorBean ob = new OperatorBean(); 
		ResultSet rs;
		Double unit =null;
		//String vnd=ob;
		
		Connection conn= ConnectionPool.fetchConnection();
		Statement stmt=conn.createStatement();
		
		
	//	String vnd_name=obj.getVnd_name_list();
		query="select vp_mrp from Voucher_Profiles_300 where vp_name='"+vp_name+"'";
		rs=stmt.executeQuery(query);
		System.out.println(query);
		if(rs.next()){
			obj.setVp_unitPrice(rs.getDouble(1));
			unit= rs.getDouble(1);
			System.out.println("Vendor adrress"+unit);
		}
		conn.close();
		return unit;
	}

}