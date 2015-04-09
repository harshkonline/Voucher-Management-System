package actions.GenerateVoucher;

import java.util.ArrayList;

import beans.GenerateVoucher.GenerateByVpBean;
import beans.GenerateVoucher.displayInFileBean;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//to generate vouchers by profile name
public class GenerateByVpAction extends ActionSupport{
	
	//voucher profile name
	String vp_name;
	//quantity given by user
	int vp_quantity;
	String filename = "";
	ArrayList<String> data = new ArrayList<String>();
	String[] names = new String[1];

	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	public void setData(ArrayList<String> data) {
		this.data = data;
	}

	public ArrayList<String> getData() {
		return data;
	}

	public String execute() {
		
		//check whether user has logged in
		if(ActionContext.getContext().getSession().get("username") == null) {
			addActionMessage("Session expired. Please login again.");
			return "notLoggedIn";
		}
		
		GenerateByVpBean bean = new GenerateByVpBean();
		System.out.println(getVp_quantity()+"-----------------");
		int quantity = getVp_quantity();
		filename =  bean.generateVoucher(vp_name, quantity);
		displayInFileBean dBean = new displayInFileBean();
		names[0] = filename; 
		setData(dBean.show(names));
		//ActionContext.getContext().getSession().remove("vp_name_list");
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		
			//check if quantity is entered
			if(vp_quantity == 0) {
				addFieldError("vp_quantity", "Quantity is required");
			}
			else//check if quantity doesnt exceeds 500
				if(vp_quantity > 500)
					addFieldError("vp_quantity", "Quantity should be less than 500");
	}
		
	//getters and setters
	public int getVp_quantity() {
		return vp_quantity;
	}

	public void setVp_quantity(int vpQuantity) {
		vp_quantity = vpQuantity;
	}

	public String getVp_name() {
		return vp_name;
	}

	public void setVp_name(String vpName) {
		vp_name = vpName;
	}
	
	


	
}