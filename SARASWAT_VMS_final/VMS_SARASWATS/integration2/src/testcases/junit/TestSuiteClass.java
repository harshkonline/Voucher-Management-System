package testcases.junit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*
 * Assignment-2.4
 * Use of TestSuite for checking TestArrayHelp, TestEmploye, ExceptCheck
 * Name: Digambar Shashikant Banne
 * Empno: 76103
 * Date: 22-12-2010
 */


@RunWith(Suite.class)
@Suite.SuiteClasses({TestCheckName.class,TestGenerateByVpBean.class,TestGenerateInFile.class,
	TestGenerateVbyPO.class,TestGetDetails.class,TestViewDetailsBean.class,})
public class TestSuiteClass {
	/*
	 *This class will remain completely empty
	 *as it is going to be used as a holder for above annotations
	 */

}
