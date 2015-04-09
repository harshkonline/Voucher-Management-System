package beans.GenerateVoucher;

//data holder class that holds data about the particular  order
public class PurchaseOrderDataBean {
	String po_number,vp_name,vp_quantity,vp_dateOfDelivery , vp_dateOfOrder
	,vp_printMedia,vnd_id ,	vp_netAmount ,	vp_discount ,vp_unitPrice;

	//getters and setters
	public String getVp_dateOfOrder() {
		return vp_dateOfOrder;
	}

	public void setVp_dateOfOrder(String vpDateOfOrder) {
		vp_dateOfOrder = vpDateOfOrder;
	}

	public String getPo_number() {
		return po_number;
	}

	public void setPo_number(String poNumber) {
		po_number = poNumber;
	}

	public String getVp_name() {
		return vp_name;
	}

	public void setVp_name(String vpName) {
		vp_name = vpName;
	}

	public String getVp_quantity() {
		return vp_quantity;
	}

	public void setVp_quantity(String vpQuantity) {
		vp_quantity = vpQuantity;
	}

	public String getVp_dateOfDelivery() {
		return vp_dateOfDelivery;
	}

	public void setVp_dateOfDelivery(String vpDateOfDelivery) {
		vp_dateOfDelivery = vpDateOfDelivery;
	}

	public String getVp_printMedia() {
		return vp_printMedia;
	}

	public void setVp_printMedia(String vpPrintMedia) {
		vp_printMedia = vpPrintMedia;
	}

	public String getVnd_id() {
		return vnd_id;
	}

	public void setVnd_id(String vndId) {
		vnd_id = vndId;
	}

	public String getVp_netAmount() {
		return vp_netAmount;
	}

	public void setVp_netAmount(String vpNetAmount) {
		vp_netAmount = vpNetAmount;
	}

	public String getVp_discount() {
		return vp_discount;
	}

	public void setVp_discount(String vpDiscount) {
		vp_discount = vpDiscount;
	}

	public String getVp_unitPrice() {
		return vp_unitPrice;
	}

	public void setVp_unitPrice(String vpUnitPrice) {
		vp_unitPrice = vpUnitPrice;
	} 
}
