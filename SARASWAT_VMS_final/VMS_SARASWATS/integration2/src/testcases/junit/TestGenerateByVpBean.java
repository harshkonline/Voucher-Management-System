package testcases.junit;
import static org.junit.Assert.*; 
import java.util.ArrayList;
import org.junit.*;

import beans.GenerateVoucher.GenerateByVpBean;
public class TestGenerateByVpBean {
	
	@Test
	public void testVoucherbyVP(){
		String exepected="E://File//infiles//INFILE_administrator10196.txt";
		GenerateByVpBean bean = new GenerateByVpBean();
		String  actual = bean.generateVoucher("SMS1",3);
		assertEquals(exepected, actual);
		}
}
