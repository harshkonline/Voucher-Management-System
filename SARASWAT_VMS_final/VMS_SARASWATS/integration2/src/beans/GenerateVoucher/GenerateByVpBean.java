package beans.GenerateVoucher;

import java.sql.Connection;
import logging.log4j;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.opensymphony.xwork2.ActionSupport;

import database.ConnectionPool;

public class GenerateByVpBean {
	
	//function that generates vouchers by voucher profiles 
	public String generateVoucher(String vp_name,int vp_quantity) {
		ConnectionPool connectionPool = new ConnectionPool();
		//to establish database connection
		Connection connection = connectionPool.fetchConnection();
		
		//declaration of database objects
		ResultSet resultSet = null;
		Statement statement = null;
		ResultSet resultSet1 = null;
		Statement statement1 = null;
		
		//string for holding query that is to be fired on database
		String query = "";
		String temp = "";
		String test = "";
		String pon = "";
		
		//declaration of fields that are to be entered and retrieved from the database
		int vch_id = 0;
		int po_number = 0;
		int vp_netAmount = 0;
		int vp_discount = 0;
		int vp_unitPrice = 0;
		String vch_pincode = "";
		String vch_serialNo = "";
		String vp_dateOfDelivery = "SYSDATE + 7";
		String vp_printMedia = "plastic";
		String dateOfOrder = "SYSDATE";
		String dateOfDelivery = "SYSDATE + 7";
		String status = "approved";
		int vch_quantity = 1; 
		int vnd_id = 0;
		Integer integer = null; 
		String filename = "";
		//for generation of random voucher pin number which is further encrypted and 
		//checked for uniqueness
		Random random =  new Random(1000000000);
		
		//generate two numbers for bigger length of number and to achieve more
		//randomness
		Integer randomNo = random.nextInt();
		Integer randomNo1 = random.nextInt();
		
		try {
			
			statement = connection.createStatement();
			//get id of voucher from sequence to generate serial no
			resultSet = statement.executeQuery("select po_number_sequence.NEXTVAL from dual");
			resultSet.next();
			
			po_number = resultSet.getInt(1);
			
			query = "SELECT vp_mrp FROM Voucher_Profiles_300 WHERE vp_name='"+vp_name+"'";
			resultSet = statement.executeQuery(query);
			resultSet.next();
			
			vp_unitPrice = resultSet.getInt(1);
			vp_netAmount = vp_unitPrice * vp_quantity;
			
			
			query = "INSERT INTO PO_Details_300 VALUES("+po_number+",'"+vp_name+"',"+vp_quantity;
			query +=  ","+dateOfOrder+","+dateOfDelivery+",'"+vp_printMedia+"',"+vnd_id+","+vp_netAmount+","+vp_discount+","+vp_unitPrice+",'"+status+"'"+")";
			
			System.out.println("-----------"+query);
			statement.executeUpdate(query);
			
			//loop that iterates quantity times and generates vouchers
			for(int i=0;i<vp_quantity;i++) {
				
				resultSet = statement.executeQuery("select vch_id_sequence.NEXTVAL from dual");
				resultSet.next();
				
				vch_id = resultSet.getInt(1); // to be changed
				
				integer = new Integer(vch_id);  // to be changed
				vch_serialNo = "100" + vp_name.substring(0,2).toUpperCase() + "7921" + vp_name.substring(2,3).toUpperCase() + integer.toString(); // to be changed
				Connection connection1 = connectionPool.fetchConnection();
				statement1 = connection.createStatement();
				
				//loop that checks duplication of voucher and generates the
				//voucher pin which is then encrypted
				do {
					temp = randomNo.toHexString(randomNo) + randomNo.toHexString(randomNo1);
				
					while(temp.length()<=16) {
						temp += "0"+temp;
					}
					temp = temp.substring(0, 16);
					//encrypt the generated pin
					vch_pincode = encrypt(temp); 
					
					//generated next number for pin generation
					randomNo = random.nextInt();
					randomNo1 = random.nextInt();
					
					//query to check the duplication of voucher
					query = "SELECT vch_pincode FROM Voucher_Details_300 WHERE vch_pincode='"+vch_pincode+"'";
					resultSet1 = statement1.executeQuery(query);
					resultSet1.next();
					test = resultSet.getString(1);
				}while(vch_pincode.equals(test));
				
				connection1.close();	
				
				//query to insert the voucher in voucher table
				query = "INSERT INTO Voucher_Details_300 VALUES(" + vch_id + ",'" + vp_name + "','" + vch_pincode+"','";
				query += vch_serialNo + "',"+vp_dateOfDelivery + ",'"+vp_printMedia + "',"+vch_quantity + ","+vp_netAmount + ",";
				query += +vp_discount+","+vp_unitPrice + "," + po_number+")"; 
				
				System.out.println("-----------"+query);
				statement.executeUpdate(query);
				
			}
			
			//log4j for VP
			log4j log = new log4j();
			String message="Voucher Created By VP(Voucher Profile name="+vp_name+",Quantity ="+vp_quantity+")";
			log.newlog(message);	
			//in file writing
			GenerateInFile inFile = new GenerateInFile();
			//generates in file and stores it in local machine  
			 Integer ipo= new Integer(po_number);
			 pon = ipo.toString();
			filename = inFile.generateFile(pon);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return filename;
	}
public String encrypt(String no) {
		
		String odd = "";
		String even = "";
		String result = "";
		int value = 0;
		for (int i = 0; i < no.length(); i++) {
			if(i%2==0)
				even += no.charAt(i);
			else
				odd += no.charAt(i);
		}
		for (int i = 0; i < no.length(); i++) {
			
				if(odd.length()>=(i+1))
					result += odd.charAt(i);
				if(even.length()>=(i+1))
					result += even.charAt(i);
		}
		if((no.length()%2) == 0)
			value = no.length()/2;
		else 
			value = ((no.length()+1)/2);
		char[] array = new char[no.length()];
		System.out.println(result);
		for (int start = 0 , end = (no.length()-1); start < value; start++ , end--) {
			
			array[start] = result.charAt(end);
			array[end] = result.charAt(start);
			
		}
		result = array.toString();
	
		return new String(array);
	}
	
}
