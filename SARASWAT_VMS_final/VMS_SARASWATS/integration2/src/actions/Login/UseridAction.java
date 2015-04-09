package actions.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import beans.ForgetPasswordBean;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import database.ConnectionPool;

public class UseridAction extends ActionSupport implements ModelDriven {
	
	ForgetPasswordBean obj=new ForgetPasswordBean();
	
	public ForgetPasswordBean getObj() {
		return obj;
	}

	public void setObj(ForgetPasswordBean obj) {
		this.obj = obj;
	}
	
	@Override
	public String execute() throws Exception{
		// TODO Auto-generated method stub
		
		Connection connection = ConnectionPool.fetchConnection();
		Statement stmt;
		String query;
		ResultSet rs;
		try {
			stmt=connection.createStatement();
			query="select * from User_extraDetails_300 where user_id='"+obj.getUser_id()+"'";
			rs=stmt.executeQuery(query);
			System.out.println("\n\n\n2222222222222222222222222222222");
			if (rs.next()) {				
				System.out.println(rs.getString(1)+"-"+rs.getString(2)+"-"+rs.getString(3));
				obj.setQuestion(rs.getString(2));
			}else{
				addFieldError("user_id" , "Username doesnot exists , try again with correct Username");
				connection.close();
				return INPUT;
			}
			System.out.println("\n "+obj.getUser_id());
		} finally{
			connection.close();
		}
		return SUCCESS;
	}
 
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if (obj.getUser_id().length() == 0) {
			addFieldError("user_id", "Enter User id ");
		}
	}

	public Object getModel() {
		// TODO Auto-generated method stub
		return obj;
	}
}