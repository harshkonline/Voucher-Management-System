package beans.Operator;

import java.util.Date;
import java.util.List;

public class OperatorBean {
	
	List vnd_name_list;
	String vnd_address;
	List vp_name_list;
	String printmedium;
	int po_number;
	public int getPo_number() {
		return po_number;
	}
	public void setPo_number(int poNumber) {
		po_number = poNumber;
	}
	double vp_unitPrice;
	int vp_quantity;
	int vnd_id;
	String prepareddate;
	String vp_status;
	
	public String getVp_status() {
		return vp_status;
	}
	public void setVp_status(String vpStatus) {
		vp_status = vpStatus;
	}
	public String getPrepareddate() {
		return prepareddate;
	}
	public void setPrepareddate(String prepareddate) {
		this.prepareddate = prepareddate;
	}
	double vp_discount;
	String deliverydate;
	String button;
	String vnd_name;
	String vp_name;
	
	public int getVnd_id() {
		return vnd_id;
	}
	public void setVnd_id(int vndId) {
		vnd_id = vndId;
	}
	public List getVnd_name_list() {
		return vnd_name_list;
	}
	public void setVnd_name_list(List vndNameList) {
		vnd_name_list = vndNameList;
	}
	public String getVnd_address() {
		return vnd_address;
	}
	public void setVnd_address(String vndAddress) {
		vnd_address = vndAddress;
	}
	public List getVp_name_list() {
		return vp_name_list;
	}
	public void setVp_name_list(List vpNameList) {
		vp_name_list = vpNameList;
	}
	
	public double getVp_unitPrice() {
		return vp_unitPrice;
	}
	public String getPrintmedium() {
		return printmedium;
	}
	public void setPrintmedium(String printmedium) {
		this.printmedium = printmedium;
	}
	public void setVp_unitPrice(double vpUnitPrice) {
		vp_unitPrice = vpUnitPrice;
	}
	public int getVp_quantity() {
		return vp_quantity;
	}
	public void setVp_quantity(int vpQuantity) {
		vp_quantity = vpQuantity;
	}
	public double getVp_discount() {
		return vp_discount;
	}
	public void setVp_discount(double vpDiscount) {
		vp_discount = vpDiscount;
	}
	public String getDeliverydate() {
		return deliverydate;
	}
	public void setDeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
	}
	public String getButton() {
		return button;
	}
	public void setButton(String button) {
		this.button = button;
	}
	public String getVnd_name() {
		return vnd_name;
	}
	public void setVnd_name(String vndName) {
		vnd_name = vndName;
	}
	public String getVp_name() {
		return vp_name;
	}
	public void setVp_name(String vpName) {
		vp_name = vpName;
	}
		
}