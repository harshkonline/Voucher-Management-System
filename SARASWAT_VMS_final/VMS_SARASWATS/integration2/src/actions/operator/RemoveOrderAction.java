package actions.operator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import database.ConnectionPool;

public class RemoveOrderAction extends ActionSupport{
	
	
	int po_number;
	public int getPo_number() {
		return po_number;
	}
	public void setPo_number(int poNumber) {
		po_number = poNumber;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		if(ActionContext.getContext().getSession().get("username") == null) {
			addActionMessage("Session expired. Please login again.");
			return "notLoggedIn";
		}
		
		String query=null,query1=null;
		ResultSet rs;
		
		
		Connection conn= ConnectionPool.fetchConnection();
		Statement stmt=conn.createStatement();
		query="Delete from PO_Details_300 where po_number='"+po_number+"'";
		stmt.executeUpdate(query);
		conn.close();
		return SUCCESS;
	}
}
