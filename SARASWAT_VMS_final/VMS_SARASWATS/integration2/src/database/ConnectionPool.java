package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionPool {
	/*static DataSource ds=null;
	static{
		InitialContext initContext;
		try{
			
			if(ds==null){
				initContext = new InitialContext();
				ds=(DataSource)initContext.lookup("java:/OracleDS");
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}*/
	public static Connection fetchConnection() {
		Connection connection=null;
		/*try{
			connection=ds.getConnection();
		}
		catch(Exception e){
			System.out.println(e.getMessage());;
		}*/
		try {
			DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
			connection=DriverManager.getConnection (
					"jdbc:oracle:thin:@127.0.0.1:1521:XE", "SYSTEM", "USER1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		return connection;
		
	}
	
}
