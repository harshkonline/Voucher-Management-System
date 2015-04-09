package actions.operator;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import beans.Operator.OperatorBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import database.ConnectionPool;

public class ViewRemoveAction extends ActionSupport implements ModelDriven{
		
	ArrayList list;
	OperatorBean obj= new OperatorBean();
	
	public ArrayList getList() {
		return list;
	}
	public void setList(ArrayList list) {
		this.list = list;
	}
	public OperatorBean getObj() {
		return obj;
	}
	public void setObj(OperatorBean obj) {
		this.obj = obj;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public String execute() throws Exception {
		
		if(ActionContext.getContext().getSession().get("username") == null) {
			addActionMessage("Session expired. Please login again.");
			return "notLoggedIn";
		}
		
		// TODO Auto-generated method stub
		//JOptionPane.showMessageDialog(null, "Un Dos Tres");
		ArrayList<OperatorBean> list1=new ArrayList();
		String query=null;
		ResultSet rs;
		Connection conn=ConnectionPool.fetchConnection();
		Statement stmt=conn.createStatement();
		query="select po_number,vnd_name,vp_quantity,vp_name,vp_dateOfOrder,vp_status " +
				"from PO_Details_300  p, Vendor_Details_300 v " +
				"where p.vnd_id=v.vnd_id and p.vp_status='pending'" +
				"order by po_number";
		System.out.println(query);
		rs=stmt.executeQuery(query);
		
		
		while(rs.next()){
			
			/*String d="";
			d+=( rs.getDate(5).getDate()+"-" );
			d+=( rs.getDate(5).getMonth()+"-" );
			d+=( rs.getDate(5).getYear()+"" );
			System.out.println("date : " + d);
			*/
			
			obj=new OperatorBean();
			obj.setPo_number(rs.getInt(1));
			obj.setVnd_name(rs.getString(2));
			obj.setVp_quantity(rs.getInt(3));
			obj.setVp_name(rs.getString(4));
			obj.setPrepareddate( rs.getDate(5).toString() );
			obj.setVp_status(rs.getString(6));
			
			System.out.println(obj.getPrepareddate());
			list1.add(obj);
		}
		setList(list1);
		conn.close();
		return SUCCESS;
	
	}
	public Object getModel() {
		return obj;
	}
}