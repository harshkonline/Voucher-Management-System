package actions.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import database.ConnectionPool;

public class LoginAction extends ActionSupport implements SessionAware{

	String user_id;
	String password;
	int role;
	Map<String,Object> session=null;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		Connection connection = ConnectionPool.fetchConnection();
		Statement stmt;
		String query;
		ResultSet rs;
		String status= "";
		
		try {
			
			stmt = connection.createStatement();
			query = "select r.role_id,u.user_id " +
					"from Role_Details_300 r,User_Details_300 u " +
					"where u.user_id='"+user_id+"' and u.password='"+password+"'" +
					"and u.role_id=r.role_id";
			System.out.println(query);
			rs = stmt.executeQuery(query);
			
			if(rs.next()){
				role=rs.getInt(1);
				if(role==1){
					status= "administrator";
					
				}else if (role==2) {
					status= "operator";
					
				}
				session.put("username", user_id);
				session.put("status", status);
				if(rs.getString(2).equals("n")){
					status="first";
				}
			}else{
				addFieldError("user_id", "Login Failed User Name or Password is Incorrect");
				status= INPUT;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		System.out.println("username : " + ActionContext.getContext().getSession().get("username"));
		
		return status;
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if(user_id.length() == 0){
			addFieldError("user_id", "Enter User name");
		}
		if(password.length() == 0){
			addFieldError("password", "Enter Password");
		}
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String userId) {
		user_id = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		session=arg0;
	}
	
	
}