package testcases.junit;
import beans.GenerateVoucher.GenerateInFile;
import static org.junit.Assert.*; 
import java.util.ArrayList;
import org.junit.*;
public class TestGenerateInFile {

	@Test
	public void TestINFileGeneration(){
		String expected,actual;
		expected="E://File//infiles//INFILE_administrator10189.txt";
		GenerateInFile bean = new GenerateInFile();
		actual = bean.generateFile("10189");
		assertEquals(expected, actual);
		}
}
