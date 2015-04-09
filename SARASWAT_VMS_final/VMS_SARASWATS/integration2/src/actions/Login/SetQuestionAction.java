package actions.Login;

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

public class SetQuestionAction extends ActionSupport implements SessionAware{
	
	List list;
	Map<String,Object> session=null;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		Connection connection = ConnectionPool.fetchConnection();
		Statement stmt;
		String query;
		ResultSet rs;
		List arrlist = new ArrayList ();
		try {
			
			stmt = connection.createStatement();
			query = " select * from questions_300";
			System.out.println(query);
			
			rs = stmt.executeQuery(query);
			while(rs.next()){
				arrlist.add( rs.getString(1) );
				System.out.println(rs.getString(1));
			}
			setList(arrlist);
			session.put("arrlist", arrlist);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return SUCCESS;
	}
	
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		session=arg0;
	}	
	
	
	
}
