package testcases.junit;
import static org.junit.Assert.*; 

import org.junit.*;

import beans.purchaseorder.GetDetails;
      
public class TestGetDetails {
	@Test
	
	public void testGetEmailId(){
		GetDetails bean = new GetDetails();
		String exepected = "user1@pace.com";
		String actual = null;
		actual= bean.getEmailId("Icon");
		assertEquals(exepected, actual);

	}
	@Test
	public void testGetdateOfDelivery(){
		GetDetails date = new GetDetails();
		String expected = "2011-03-11 00:00:00.0";
		String actual = null;
		actual = date.getdateOfDelivery("10183");
		assertEquals(expected, actual);
		
	
	}
}
