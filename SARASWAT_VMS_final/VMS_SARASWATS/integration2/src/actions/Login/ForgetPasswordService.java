package actions.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.ConnectionPool;
import beans.ForgetPasswordBean;

public class ForgetPasswordService {
	
	public ForgetPasswordService() {
		// TODO Auto-generated constructor stub
	}
	public boolean alterPassword(ForgetPasswordBean obj) throws Exception {
		
		boolean result = false;
		Connection connection = ConnectionPool.fetchConnection();
		Statement stmt;
		String query;
		ResultSet rs;
		String newpwd=obj.getNewpwd();
		String user=obj.getUser_id();
		try {
			stmt=connection.createStatement();
			query="update User_Details_300 " +
				  "set password='"+newpwd+"' " +
				  "where user_id='"+user+"'";
			System.out.println(query);
			int i=0;
			i=stmt.executeUpdate(query);
			System.out.println("\n\n\n2222222222222222222222222222222");
			if (i > 0) {				
				result=true;
			}else{
				result=false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			connection.close();
		}
		
		return result;
	}
	public boolean chkAnswer(ForgetPasswordBean obj) throws Exception {
		
		boolean result = false;
		Connection connection = ConnectionPool.fetchConnection();
		Statement stmt;
		String query;
		ResultSet rs;
		try {
			stmt=connection.createStatement();
			query="select * from User_extraDetails_300 " +
					"where user_id='"+obj.getUser_id()+"' and " +
					"LOWER(answer) ='"+obj.getAnswer().toLowerCase()+"'";
			rs=stmt.executeQuery(query);
			System.out.println("\n\n\n2222222222222222222222222222222");
			if (rs.next()) {				
				System.out.println(rs.getString(1)+"-"+rs.getString(2)+"-"+rs.getString(3));
				result=true;
			}else{
				result=false;
			}
			System.out.println("\n "+obj.getUser_id());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			connection.close();
		}
		
		return result;
	}
}