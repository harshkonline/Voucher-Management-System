package beans.VoucherProfileManagement;

import java.util.ArrayList;
import java.util.List;
/****Bean for setting voucher profile detail ****/
public class SetVoucherProfileDetails {
	//declare variables
	String vp_name;
	int vp_gracePeriod1;
	int vp_gracePeriod2;
	int vp_quaratinePeriod ;
	int vp_shelflife;
	double vp_talktime;
	double vp_adminFees;
	double vp_serviceTax;
	double vp_processingFees;
	double vp_mrp;
	double vp_stateTax;
	double vp_misc;
	int vp_validityPeriod ;
	List fee_list=new ArrayList();
	
	//default constructor
	public SetVoucherProfileDetails() {
		// TODO Auto-generated constructor stub
	}
	
	//setter and getter method for declared variables
	public String getVp_name() {
		return vp_name;
	}
	public void setVp_name(String vpName) {
		vp_name = vpName;
	}
	public int getVp_gracePeriod1() {
		return vp_gracePeriod1;
	}
	public void setVp_gracePeriod1(int vpGracePeriod1) {
		vp_gracePeriod1 = vpGracePeriod1;
	}
	public int getVp_gracePeriod2() {
		return vp_gracePeriod2;
	}
	public void setVp_gracePeriod2(int vpGracePeriod2) {
		vp_gracePeriod2 = vpGracePeriod2;
	}
	public int getVp_quaratinePeriod() {
		return vp_quaratinePeriod;
	}
	public void setVp_quaratinePeriod(int vpQuaratinePeriod) {
		vp_quaratinePeriod = vpQuaratinePeriod;
	}
	public int getVp_shelflife() {
		return vp_shelflife;
	}
	public void setVp_shelflife(int vpShelflife) {
		vp_shelflife = vpShelflife;
	}
	public double getVp_talktime() {
		return vp_talktime;
	}
	public void setVp_talktime(double vpTalktime) {
		vp_talktime = vpTalktime;
	}
	public double getVp_adminFees() {
		return vp_adminFees;
	}
	public void setVp_adminFees(double vpAdminFees) {
		vp_adminFees = vpAdminFees;
	}
	public double getVp_serviceTax() {
		return vp_serviceTax;
	}
	public void setVp_serviceTax(double vpServiceTax) {
		vp_serviceTax = vpServiceTax;
	}
	public double getVp_processingFees() {
		return vp_processingFees;
	}
	public void setVp_processingFees(double vpProcessingFees) {
		vp_processingFees = vpProcessingFees;
	}
	public double getVp_mrp() {
		return vp_mrp;
	}
	public void setVp_mrp(double vpMrp) {
		vp_mrp = vpMrp;
	}
	public double getVp_stateTax() {
		return vp_stateTax;
	}
	public void setVp_stateTax(double vpStateTax) {
		vp_stateTax = vpStateTax;
	}
	public double getVp_misc() {
		return vp_misc;
	}
	public void setVp_misc(double vpMisc) {
		vp_misc = vpMisc;
	}
	public int getVp_validityPeriod() {
		return vp_validityPeriod;
	}
	public void setVp_validityPeriod(int vpValidityPeriod) {
		vp_validityPeriod = vpValidityPeriod;
	}
	public List getFee_list() {
		return fee_list;
	}
	public void setFee_list(List feeList) {
		fee_list = feeList;
	}
}
