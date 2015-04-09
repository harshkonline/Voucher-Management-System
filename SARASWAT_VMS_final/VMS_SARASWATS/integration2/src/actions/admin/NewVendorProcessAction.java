package actions.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

import database.ConnectionPool;

public class NewVendorProcessAction extends ActionSupport {
	
	String vnd_name;
	String vnd_address;
	String vnd_email;
	String vnd_phone;
	int vnd_id;
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Connection connection = ConnectionPool.fetchConnection();
		Statement stmt;
		String query;
		ResultSet rs;
		 vnd_id = 0;
		
		try {
			
			stmt = connection.createStatement();
			
			
			query = " select * from Vendor_Details_300 where vnd_name='"+vnd_name+"'";
			System.out.println(query);
			rs = stmt.executeQuery(query);
			
			if(rs.next()){
				addFieldError("vnd_name", "Vendor name alredy exits ");
				connection.close();
				return INPUT;
			}
			else {

			
			query = " select max(vnd_id) from Vendor_Details_300 ";
			System.out.println(query);
			rs = stmt.executeQuery(query);
			
			if(rs.next()){
				vnd_id=rs.getInt(1);
				vnd_id+=1;
			}
			
			query="insert into Vendor_details_300 values(" + vnd_id +",'"
					+ vnd_name +"','" + vnd_address + "','" +
					vnd_email + "','" + vnd_phone + "' )";
			System.out.println(query);			
			int i = stmt.executeUpdate(query);
			System.out.println("Line inserted : "+i);
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
		if(vnd_name.length()==0){
			addFieldError("vnd_name", "Enter Vendor Name");
		}	
		if(vnd_address.length()==0){
			addFieldError("vnd_address", "Enter Vendor Address");
		}
		if(vnd_email.length()==0){
			addFieldError("vnd_email", "Enter Vendor E-Mail");
		}
			
	}

	public String getVnd_name() {
		return vnd_name;
	}

	public void setVnd_name(String vndName) {
		vnd_name = vndName;
	}

	public String getVnd_address() {
		return vnd_address;
	}

	public void setVnd_address(String vndAddress) {
		vnd_address = vndAddress;
	}

	public String getVnd_email() {
		return vnd_email;
	}

	public void setVnd_email(String vndEmail) {
		vnd_email = vndEmail;
	}

	public String getVnd_phone() {
		return vnd_phone;
	}

	public void setVnd_phone(String vndPhone) {
		vnd_phone = vndPhone;
	}

	public int getVnd_id() {
		return vnd_id;
	}

	public void setVnd_id(int vndId) {
		vnd_id = vndId;
	}
	
	
}
