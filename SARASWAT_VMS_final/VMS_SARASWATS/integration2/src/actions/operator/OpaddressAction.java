package actions.operator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import beans.Operator.OperatorBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import database.ConnectionPool;

public class OpaddressAction extends ActionSupport  implements ModelDriven,SessionAware,ServletRequestAware{

	HttpServletRequest req;
	String vnd_name;
	String vp_name;
	String vnd_address;
	int vp_quantity;
	String button;
	
	double vp_discount;
	String deliverydate;
	double vp_unitPrice;
	String printmedium;
	Map<String, List> session = null; 
	String date=null;
	OperatorBean obj=new OperatorBean();
	
	public OperatorBean getObj() {
		return obj;
	}

	public void setObj(OperatorBean obj) {
		this.obj = obj;
	}

	@Override
	public String execute() throws Exception {
		
		if(ActionContext.getContext().getSession().get("username") == null) {
			addActionMessage("Session expired. Please login again.");
			return "notLoggedIn";
		}
		
		String result = "";
		Connection  conn =ConnectionPool.fetchConnection();
		System.out.println("button :" +req.getParameter("button"));
		if(req.getParameter("button")!=null){
			
				// TODO Auto-generated method stub
				System.out.println("vp_quantity:"+ obj.getVp_quantity());
				System.out.println("vp_discount:"+ obj.getVp_discount());
				System.out.println("deliverydate:"+obj.getDeliverydate());
				printmedium=obj.getPrintmedium();
				vp_quantity=obj.getVp_quantity();
				vp_discount=obj.getVp_discount();
				vp_name=obj.getVp_name();
				vp_unitPrice=obj.getVp_unitPrice();
				deliverydate=obj.getDeliverydate();
				vnd_name=obj.getVnd_name();
			Boolean flag=false;
				if(obj.getVp_quantity()==0 )
				{
					flag=true;
					addFieldError("vp_quantity", "Enter the quantity");
				}else if(obj.getVp_quantity() > 500 ){
					flag=true;
					addFieldError("vp_quantity", "Maximum quantity limit is 500");
				}
				if(obj.getDeliverydate().length()<=0)
				{
					flag=true;
					addFieldError("deliverydate", "Enter the Delivery Date");
				}else{
					
					
				}
			if(flag==true){
				result=INPUT;
		
			}
			else {
			Integer vnd_id=null;
			Double net_amount;
		//	System.out.println("");
			
			String query=null,query1=null;
			ResultSet rs;
			
			Statement stmt=conn.createStatement();
			query="select vnd_id from Vendor_Details_300 where vnd_name='"+vnd_name+"'";
			System.out.println(query);
			rs=stmt.executeQuery(query);
			 
			if(rs.next()){
				vnd_id=rs.getInt(1);
				System.out.println("----------------"+rs.getInt(1));
			}
			
			
			//String date="";
			//date=""+deliverydate.getDate()+"-"
			Double discount=(vp_quantity*vp_unitPrice)*(0.01*vp_discount);
			net_amount=(vp_quantity*vp_unitPrice)-discount;
			
			query1="insert into PO_Details_300 values (po_number_sequence.NEXTVAL,'"+
			vp_name+"',"+vp_quantity+",SYSDATE,'"+deliverydate+"','"+printmedium+"',"+vnd_id+","+
			net_amount+","+vp_discount+","+vp_unitPrice+",'pending')";
			
			System.out.println(query1);
			int i=stmt.executeUpdate(query1);
			
			System.out.println("---------------line updated ="+i);
			
			result = "done";
			}
		}
		else
		{

		String addr=OperatorService.populateAddress( obj.getVnd_name(),obj);
		System.out.println("Addr in action:" +addr);
		obj.setVnd_address(addr);
		
		Double unit=OperatorService.populateUnitPrice( obj.getVp_name(),obj);
		System.out.println("Addr in action:" +unit);
		obj.setVp_unitPrice(unit);
		obj.setDeliverydate(null);
		obj.setButton(null);
		//session.put("vnd", vnd_name);
		result = SUCCESS;
	    
		}
	conn.close();
	
		return result;
	}

	public Object getModel() {
		// TODO Auto-generated method stub
		return obj;
	}

	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		
		this.session=arg0;
		
	}

	public void setServletRequest(HttpServletRequest arg0) {
				req=arg0;
		}
}
