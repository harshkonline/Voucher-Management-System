package testcases.junit;
import static org.junit.Assert.*; 

import java.util.ArrayList;

import org.junit.*;

import beans.purchaseorder.ViewDetailsBean;

      
public class TestViewDetailsBean {
	@Test
	public void testViewDetails(){
	ArrayList<String > exepected = new ArrayList<String>();
	
		exepected.add("night101");
		exepected.add("1");
		exepected.add("50");
		exepected.add("1");
		exepected.add("2");
		exepected.add("2011-03-07 00:00:00.0");
		exepected.add("to print");
		exepected.add("Demo");
		exepected.add("Jammu Kashmir");
		
		ArrayList<String> actual = new ArrayList<String>();
		ViewDetailsBean bean = new ViewDetailsBean();
		actual = bean.getDetails(10180);
		assertEquals(exepected, actual);
	}
}
