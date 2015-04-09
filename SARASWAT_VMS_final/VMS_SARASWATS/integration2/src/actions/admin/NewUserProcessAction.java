package actions.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.opensymphony.xwork2.ActionSupport;

import database.ConnectionPool;

public class NewUserProcessAction extends ActionSupport {

	String user_id;
	String role_name;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String userId) {
		user_id = userId;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String roleName) {
		role_name = roleName;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		Connection connection = ConnectionPool.fetchConnection();
		Statement stmt;
		String query;
		ResultSet rs,rs1;
		int role_id = 0;
		
		try {
			stmt = connection.createStatement();
			query = "select user_id from User_Details_300 where user_id='"
					+ user_id + "'";
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				addFieldError("user_id",
						"User alredy present, choose another one");
				return INPUT;
			} else {

				query = "select role_id " +
						"from Role_Details_300 " +
						"where role_name='"+ role_name + "'";
				System.out.println(query);
				rs1=stmt.executeQuery(query);
				if(rs1.next()){
					System.out.println("\n roleid:"+rs1.getInt(1));
					role_id=rs1.getInt(1);
				}
				
				/*query = "insert into User_Details_300 " + "values ( '"
						+ user_id + "','" + user_id + "'," + role_id + ",'n')";*/
				query = "insert into User_Details_300 " + "values ( '"
				+ user_id + "','" + role_id+" )";
				System.out.println("###"+query);
				int i = stmt.executeUpdate(query);
				System.out.println("\n\n\n2222222222222222222222222222222");
				if (i > 0){
					System.out.println("Line updated: " + i);
				}
				
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
		if (user_id.length() == 0) {
			addFieldError("user_id", "Enter User Name");
		}
	}

}
