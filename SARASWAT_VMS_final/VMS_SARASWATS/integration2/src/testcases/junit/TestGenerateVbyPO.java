package testcases.junit;
import static org.junit.Assert.*; 

import java.util.ArrayList;

import org.junit.*;

import beans.GenerateVoucher.GenerateByPurchaseOrderBean;

public class TestGenerateVbyPO {
	@Test
		public void testGenerateVoucherByPO(){
		ArrayList<String> exepected = new ArrayList<String>();
		
		exepected.add("10182");
		exepected.add("E://File//infiles//INFILE_vnd310182.txt");
		String exe[]= new String[1];
		exe[0]="10182";
		
		ArrayList<String> actual = new ArrayList<String>();
		GenerateByPurchaseOrderBean bean = new GenerateByPurchaseOrderBean();
		actual = bean.generateVouchersByPurchaseOrder(exe);
		assertEquals(exepected, actual);
		}
}
