package testcases.junit;
import static org.junit.Assert.*; 
import java.util.ArrayList;
import org.junit.*;

import actions.VoucherProfileManagement.CheckName;

public class TestCheckName {
	@Test
	public void testCheckName() {
		CheckName bean=new CheckName();
		bean.setVp_name("prat-dig");
		String expected="success";
		String actual=null;
		try {
			actual=bean.execute();
		} catch (Exception e) {			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(expected, actual);
	}
}
