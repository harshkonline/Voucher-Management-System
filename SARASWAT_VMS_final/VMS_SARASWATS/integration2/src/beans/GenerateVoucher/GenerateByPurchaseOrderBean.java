package beans.GenerateVoucher;

import java.sql.Connection;
import logging.log4j;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import database.ConnectionPool;
//to generate the vouchers by purchase order
public class GenerateByPurchaseOrderBean {
	
	
	//function that generates vouchers by purchase orders and returns the order nos
	//of generated vouchers
	public ArrayList<String> generateVouchersByPurchaseOrder(String po_numbers[]) {
		
		ArrayList<String> list_of_generated_order_no = new ArrayList<String>();
		
		//to establish database connection
		ConnectionPool connectionPool = new ConnectionPool();
		
		//declaration of database objects
		ResultSet resultSet = null;
		Statement statement = null;
		ResultSet resultSet1 = null;
		Statement statement1 = null;
		
		//string for holding query that is to be fired on database
		String query = "";
		String[] filenames = new String[po_numbers.length]; 
		
		//declaration of fields that are to be entered and retrieved from the database
		int vch_id = 0;
		int po_number = 0;
		int vp_netAmount = 0;
		int vp_discount = 0;
		int vp_unitPrice = 0;
		int vp_quantity = 0;
		String vp_name = "";
		String vch_pincode = "";
		String vch_serialNo = "";
		String vp_dateOfDelivery = null;
		String vp_printMedia = "plastic";
		String dateOfOrder = "SYSDATE";
		String dateOfDelivery = "SYSDATE + 7";
		String status = "approved";
		String temp = "";
		String test = "";
		int vch_quantity = 1; 
		int vnd_id = 0;
		Integer integer = null; 
		
		//for generation of random voucher pin number which is further encrypted and 
		//checked for uniqueness
		Random random =  new Random(1000000000);
		//generate two numbers for bigger length of number and to achieve more
		//randomness
		Integer randomNo = random.nextInt();
		Integer randomNo1 = random.nextInt();
		
		Connection connection = null;
		
		//loop that iterates over different orders and accordingly generates vouchers
		for (int i = 0; i < po_numbers.length; i++) {
			
			try {
				 connection = connectionPool.fetchConnection();
				statement = connection.createStatement();
				
				//query that selects voucher details
				query = "SELECT vp_name,vp_quantity,vp_dateOfDelivery,vp_printMedia,vp_netAmount," +
					"vp_discount,vp_unitPrice  FROM PO_Details_300 WHERE po_number="+po_numbers[i];
				
				resultSet = statement.executeQuery(query);
				resultSet.next();
				
				//set values fetched from database
				vp_name = resultSet.getString(1);
				vp_quantity = resultSet.getInt(2);
				vp_dateOfDelivery = getdate(resultSet.getString(3).substring(0,10));
				vp_printMedia = resultSet.getString(4);
				vp_netAmount = resultSet.getInt(5);
				vp_discount = resultSet.getInt(6);
				vp_unitPrice = resultSet.getInt(7);
				
				//loop that iterates quantity times and generates vouchers 
				for (int j = 0; j < vp_quantity; j++) {
					//get id of voucher from sequence to generate serial no
					resultSet = statement.executeQuery("select vch_id_sequence.NEXTVAL from dual");
					resultSet.next();
					
					vch_id = resultSet.getInt(1); 
					
					integer = new Integer(vch_id); 
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
					query += vch_serialNo + "','"+vp_dateOfDelivery + "','"+vp_printMedia + "',"+vch_quantity + ","+vp_netAmount + ",";
					query += +vp_discount+","+vp_unitPrice + "," + po_numbers[i]+")"; 
					
					System.out.println("-----------"+query);
					statement.executeUpdate(query);
					
					//Log4j for po
					log4j log = new log4j();
					String message="Voucher Created By PO(Purchase Order no. ="+po_numbers[i]+",Voucher Profile name="+vp_name+",Quantity ="+vp_quantity+")";
					log.newlog(message);
					System.out.println(message);
					
				}	
				
				//update ther status from approved to ready to print
				query = "UPDATE PO_Details_300 set vp_status='to print' where po_number="+po_numbers[i];
				statement.executeUpdate(query);
				
				//in file writing
				GenerateInFile inFile = new GenerateInFile();
				//generates in file and stores it in local machine 
				filenames[i] = inFile.generateFile(po_numbers[i]);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	finally{
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
			//add the order number of generated vouchers to the list  
			list_of_generated_order_no.add(po_numbers[i]);
			
		}
		
		//return the list of order numbers for which vouchers are generated
		int count = 0;
		while(count<filenames.length) {
			list_of_generated_order_no.add(filenames[count]);
			count++;
		}
		return list_of_generated_order_no;
	}
	
	public static String getdate(String st) {
		
		String year = "";
		String date = "";
		String mon = "";
		year = st.substring(0 ,4);
		mon = st.substring(5,7 );
		date = st.substring(8,10);
		int dd = Integer.parseInt(mon);
		switch(dd) {
		case 1: mon = "JAN"; break;
		case 2:	mon = "FEB"; break;
		case 3: mon = "MAR"; break;
		case 4: mon = "APR"; break;
		case 5: mon = "MAY"; break;
		case 6: mon = "JUN"; break;
		case 7: mon = "JUL"; break;
		case 8: mon = "AUG"; break;
		case 9: mon = "SEP"; break;
		case 10: mon = "OCT"; break;
		case 11: mon = "NOV"; break;
		case 12: mon = "DEC"; break;
			
		}
		return (date+"-"+mon+"-"+year);
			
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
	
	
	public String decrypt(String no) {
		int value = 0;
		String odd = "";
		String even = "";
		String result = no;
		
		if((no.length()%2) == 0)
			value = no.length()/2;
		else  
			value = ((no.length()+1)/2);
		char[] array = new char[no.length()];
		
		for (int start = 0 , end = (no.length()-1); start < value; start++ , end--) {
			
			array[start] = result.charAt(end);
			array[end] = result.charAt(start);
			
		}
		result = new String(array);
		
		
		for (int i = 0; i < no.length(); i++) {
			if(i%2==0)
				even += result.charAt(i);
			else
				odd += result.charAt(i);
		}
		result = new String();
		for (int i = 0; i < no.length(); i++) {
			
				if(odd.length()>=(i+1))
					result += odd.charAt(i);
				if(even.length()>=(i+1))
					result += even.charAt(i);
		}
	
		return result;
	}

	
}
