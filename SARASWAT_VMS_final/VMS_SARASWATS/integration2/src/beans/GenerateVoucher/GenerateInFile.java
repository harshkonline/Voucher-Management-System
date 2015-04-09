package beans.GenerateVoucher;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;

import database.ConnectionPool;

public class GenerateInFile {
	//returns file name
	public String generateFile(String po_number) {
		
		//to establish database connection
		ConnectionPool connectionPool = new ConnectionPool();
		
		//declaration of database objects
		ResultSet resultSet = null;
		Statement statement = null;
		
		//string for holding query that is to be fired on database
		String query = "";
		String buffer = "";
		String filename = "";
		//vector to store the voucher serial numbers and pins
		Vector<String> voucher = new Vector<String>();
		
		//declaration of fields that are to be entered and retrieved from the database
		String vp_name = "", vp_quantity = "", vp_printMedia = "", vnd_id ="";
		String vnd_name = "";
		
		String vp_gracePeriod1 = "", vp_gracePeriod2 = "",vp_quartinePeriod = "",vp_shelflife ="";
		String vp_talktime = "",vp_adminFees = "",vp_serviceTax ="",vp_processingFees=""; 
		String vp_mrp="",vp_stateTax="",vp_misc="",vp_validityPeriod=""; 
		String transport_key = "";
		
		try {
			//to establish database connection
			Connection connection = connectionPool.fetchConnection();
			statement = connection.createStatement();
		
			//get transport key from sequence
			resultSet = statement.executeQuery("select transport_key_sequence.NEXTVAL from dual");
			resultSet.next();
			
			transport_key = resultSet.getString(1);
			
			//select voucher details from database
			query = "SELECT vp_name , vp_quantity , vp_printMedia , vnd_id " +
					" FROM PO_Details_300 WHERE po_number="+po_number;
		
			//JOptionPane.showMessageDialog(null, "first query"+query);
			resultSet = statement.executeQuery(query);
			resultSet.next();
			
			
			
			vp_name = resultSet.getString(1);
			vp_quantity = resultSet.getString(2);
			vp_printMedia = resultSet.getString(3);
			vnd_id = resultSet.getString(4);
			System.out.println("-----------------vp name"+vp_name);
			//JOptionPane.showMessageDialog(null, "vendor id:"+vnd_id);
			query = "SELECT vnd_name FROM Vendor_Details_300 WHERE vnd_id="+vnd_id;
			//JOptionPane.showMessageDialog(null, "vendor query:"+query);
			
			connection.close();
			connection = connectionPool.fetchConnection();
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery(query);
			resultSet.next();
			
			vnd_name = resultSet.getString(1);
			//JOptionPane.showMessageDialog(null, "vnd_name"+vnd_name);
			query = "SELECT * FROM Voucher_Profiles_300 WHERE vp_name='"+vp_name+"'";
			
			//JOptionPane.showMessageDialog(null, "voucher query"+query);
			connection.close();
			connection = connectionPool.fetchConnection();
			statement = connection.createStatement();
			
			
			resultSet = statement.executeQuery(query);
			resultSet.next();
			
			//set the values retrieved from the database
			vp_gracePeriod1 = resultSet.getString(1);
			vp_gracePeriod2 = resultSet.getString(2);
			vp_quartinePeriod = resultSet.getString(3);
			vp_shelflife = resultSet.getString(4);
			vp_talktime = resultSet.getString(5);
			vp_adminFees = resultSet.getString(6);
			vp_serviceTax = resultSet.getString(7);
			vp_processingFees = resultSet.getString(8);
			vp_mrp = resultSet.getString(9);
			vp_stateTax = resultSet.getString(10);
			vp_misc = resultSet.getString(11);
			vp_validityPeriod = resultSet.getString(12);
			System.out.println("--------------mrp"+vp_mrp);
			
			connection.close();
			connection = connectionPool.fetchConnection();
			statement = connection.createStatement();
			
			query = "SELECT  vch_serialNo ,vch_pincode FROM Voucher_Details_300 WHERE  po_number="+po_number;
			resultSet = statement.executeQuery(query);
			//add voucher serial no and pin in the vector
			while(resultSet.next()) {
				voucher.add(resultSet.getString(1));
				voucher.add(resultSet.getString(2));
			}
			try {
				
				//in file path with filename having vendor name and purchase order number
				filename = "E://File//infiles//INFILE_"+vnd_name+po_number+".txt";
				FileWriter writer = new FileWriter(filename);
				PrintWriter printWriter = new PrintWriter(writer);
				//details to write in file
				buffer = "\t\t\tIN FILE";
				printWriter.println(buffer);
				buffer = "\t*****************************************************************";
				printWriter.println(buffer);
				buffer = "\t\t\tHeader Description";
				printWriter.println(buffer);
				buffer = "\t*****************************************************************";
				printWriter.println(buffer);
				buffer = "\t\t\tCUSTOMER NAME : "+vnd_name;
				printWriter.println(buffer);
				buffer = "\t\t\tQuantity : "+vp_quantity;
				printWriter.println(buffer);
				buffer = "\t\t\tTYPE : "+vp_printMedia;
				printWriter.println(buffer);
				buffer = "\t\t\tPROFILE NAME : "+vp_name;
				printWriter.println(buffer);
				buffer = "\t\t\tMRP : "+vp_mrp;
				printWriter.println(buffer);
				buffer = "\t\t\tTALKTIME : "+vp_talktime;
				printWriter.println(buffer);
				buffer = "\t\t\tSERVICE TAX : "+vp_serviceTax;
				printWriter.println(buffer);
				buffer = "\t\t\tPROCESSING FEE : "+vp_processingFees;
				printWriter.println(buffer);
				buffer = "\t\t\tADMIN FEE : "+vp_adminFees;
				printWriter.println(buffer);
				buffer = "\t\t\tSTATE TAX : "+vp_stateTax;
				printWriter.println(buffer);
				buffer = "\t\t\tMISC : "+vp_misc;
				printWriter.println(buffer);
				buffer = "\t\t\tVALIDITY PERIOD : "+vp_validityPeriod;
				printWriter.println(buffer);
				buffer = "\t\t\tGRACE PERIOD 1 : "+vp_gracePeriod1;
				printWriter.println(buffer);
				buffer = "\t\t\tGRACE PERIOD 2 : "+vp_gracePeriod2;
				printWriter.println(buffer);
				buffer = "\t\t\tQUARANTINE PERIOD : "+vp_quartinePeriod;
				printWriter.println(buffer);
				buffer = "\t\t\tSHELF LIFE : "+vp_shelflife;
				printWriter.println(buffer);
				buffer = "\t\t\tTRANSPORT KEY : "+ transport_key;
				printWriter.println(buffer);
				buffer = "\t*****************************************************************";
				printWriter.println(buffer);
				buffer = "\t\t\t----Vouchers----";
				printWriter.println(buffer);
				//iterate through vector and print the voucher serial no and pins
				Iterator it = voucher.iterator();
				int i = 0;
				int count = voucher.size(); 
				while(i<count) {
					printWriter.print("\t\tSERIAL NO:"+voucher.get(i));
					i++;
					printWriter.println("\t\tPIN NO:"+voucher.get(i));
					i++;
				}
				//close open resources
				printWriter.close();
				writer.close();
				
			}catch(IOException ioException) {
				//JOptionPane.showMessageDialog(null, ioException.getMessage());
			}
			
			
			connection.close();
		}catch(SQLException sqlException) {
			//JOptionPane.showMessageDialog(null, sqlException.getMessage());
		}
			
			
		return filename;
	}
}
