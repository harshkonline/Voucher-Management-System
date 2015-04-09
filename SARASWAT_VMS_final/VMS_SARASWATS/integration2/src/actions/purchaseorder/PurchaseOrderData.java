package actions.purchaseorder;

public class PurchaseOrderData {
	private String po_number;
	private String summary;
	private String prepared_date;
	String status;
	public String getPo_number() {
		return po_number;
	}
	public void setPo_number(String poNumber) {
		po_number = poNumber;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getPrepared_date() {
		return prepared_date;
	}
	public void setPrepared_date(String preparedDate) {
		prepared_date = preparedDate;
	}
		public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}	
}
