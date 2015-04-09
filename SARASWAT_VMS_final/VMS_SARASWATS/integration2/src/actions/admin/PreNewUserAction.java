package actions.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import database.ConnectionPool;

public class PreNewUserAction extends ActionSupport implements SessionAware{
	
	Map<String, List> session = null;
	

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Connection connection = ConnectionPool.fetchConnection();
		Statement stmt;
		String query;
		ResultSet rs;
		
		List arrlist=new ArrayList();
		try {
			stmt=connection.createStatement();
			query="select role_name, role_id from Role_Details_300";
			System.out.println(query);
			
			rs=stmt.executeQuery(query);
			System.out.println("\n\n\n2222222222222222222222222222222");
			while(rs.next()){
				arrlist.add(rs.getString(1));
			}
			session.put("role", arrlist);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			connection.close();
		}
		
		return SUCCESS;
	}

	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}
	
}
