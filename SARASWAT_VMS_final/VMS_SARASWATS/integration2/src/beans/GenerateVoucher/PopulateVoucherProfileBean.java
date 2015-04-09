package beans.GenerateVoucher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.ConnectionPool;

//populates the names of voucher profiles
public class PopulateVoucherProfileBean {
	//function that returns the names of voucher profiles
	public ArrayList<String> getVoucherProfileNames() {
		ArrayList<String> vp_name_list = new ArrayList<String>();
		
		ConnectionPool pool=new ConnectionPool();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		connection = pool.fetchConnection();
		
		try {
			statement = connection.createStatement();
			//select the profile names from database
			resultSet = statement.executeQuery("SELECT vp_name FROM Voucher_Profiles_300");
			
			while(resultSet.next()) {
				vp_name_list.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return vp_name_list;
	}
}
