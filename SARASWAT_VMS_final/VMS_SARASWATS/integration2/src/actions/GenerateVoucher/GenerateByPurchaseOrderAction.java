package actions.GenerateVoucher;

import java.util.ArrayList;

import beans.GenerateVoucher.GenerateByPurchaseOrderBean;
import beans.GenerateVoucher.displayInFileBean;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//to generate the vouchers by purchase order
public class GenerateByPurchaseOrderAction extends ActionSupport{
	//array to get selected check boxes
	String check[];
	String filenames[] ;
	
	ArrayList<String> data ;

	

	public ArrayList<String> getData() {
		return data;
	}


	public void setData(ArrayList<String> data) {
		this.data = data;
	}

	//list of  orders selected 
	String[] list_of_po_numbers;

	//order numbers of generated vouchers 
	ArrayList<String> list_of_generated_order_no = new ArrayList<String>();
	
	
	public String execute() {
		
		//check whether user has logged in
		if(ActionContext.getContext().getSession().get("username") == null) {
			addActionMessage("Session expired. Please login again.");
			return "notLoggedIn";
		}
		
		//object of bean to generate vouchers
		GenerateByPurchaseOrderBean bean = new GenerateByPurchaseOrderBean();
		
		//call method to generate vouchers by passing array of order numbers
		setList_of_generated_order_no(bean.generateVouchersByPurchaseOrder(check));
		//String add = "E://File//infiles//INFILE_vnd410127.txt";
		//list_of_generated_order_no.add(add);
		//add = "E://File//infiles//INFILE_Demo10069.txt";
		//list_of_generated_order_no.add(add);
		//add = "E://File//infiles//INFILE_Demo10055.txt";
		//list_of_generated_order_no.add(add);
		int max = list_of_generated_order_no.size();
		filenames = new String[check.length];
		for (int i = 0; i < check.length; i++) {
			System.out.println("--------"+max);
			filenames[i] = list_of_generated_order_no.remove(--max);
			System.out.println("--------"+filenames[i]);
		}
		displayInFileBean file = new displayInFileBean();
		
		data = file.show(filenames);
		//check if nothing is selected by user
		if(check[0].equals("false"))
			return "no_selection";
		
		return SUCCESS;
	}
	
	
	public void validate() {
	
		
		
	}
	//getters and setters
	public String[] getList_of_po_numbers() {
		return list_of_po_numbers;
	}

	public void setList_of_po_numbers(String[] listOfPoNumbers) {
		list_of_po_numbers = listOfPoNumbers;
	}

	public String[] getCheck() {
		return check;
	}
	
	public void setCheck(String[] check) {
		this.check = check;
	}
	
	public ArrayList<String> getList_of_generated_order_no() {
		return list_of_generated_order_no;
	}
	
	public void setList_of_generated_order_no(
			ArrayList<String> listOfGeneratedOrderNo) {
		list_of_generated_order_no = listOfGeneratedOrderNo;
	}

	

}
