package actions.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import database.ConnectionPool;

public class ChangePasswordAction extends ActionSupport{

	 String username;
	 String oldpwd;
	 String newpwd;
	 String repwd;
	 
	 @Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		 
		 Connection connection = ConnectionPool.fetchConnection();
			Statement stmt;
			String query;
			ResultSet rs;
			 
			username= (String) ActionContext.getContext().getSession().get("username");
			try {
				
				stmt = connection.createStatement();
				
				query = "select * from User_Details_300 " +
						"where user_id='"+ username +"'" +
						"and password = '"+ oldpwd +"'";
				System.out.println(query);
				rs = stmt.executeQuery(query);
				
				if(rs.next()){
					query= "update User_Details_300 " +
							"set password ='"+ newpwd+"'" +
							"where user_id='"+ username +"'";
					System.out.println(query);			
					int i = stmt.executeUpdate(query);
					System.out.println("Line updated : "+i);
					
				}else{
					addFieldError("username", "Usename or Old Password is wrong");
					return INPUT;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connection.close();
			}
		 
		return SUCCESS;
	}
	 
	 @Override
	public void validate() {
		// TODO Auto-generated method stub
		
		if(oldpwd.length()==0){
			addFieldError("oldpwd", " Enter Old Password");
		}
		if(newpwd.length()==0){
			addFieldError("newpwd", " Enter New Password");
		}
		if(repwd.length()==0){
			addFieldError("repwd", " Retype new Password");
		}
		if(! newpwd.equals(repwd) ){
			addFieldError("repwd", "New Password should match Re entred password");
		}
	}
	 
	 
	 
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOldpwd() {
		return oldpwd;
	}
	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getRepwd() {
		return repwd;
	}
	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}
	
}