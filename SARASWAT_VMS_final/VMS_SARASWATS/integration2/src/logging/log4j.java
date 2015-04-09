package logging;
import java.io.IOException;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class log4j{
 static Logger log = Logger.getLogger("log4j");
 	public void newlog(String msg)
	 {
	  Logger log= Logger.getLogger("log4j");
	  //SimpleLayout layout=new SimpleLayout ();
	  HTMLLayout layout=new HTMLLayout();
	 
	 FileAppender appender=null;
	try {
			appender=new FileAppender(layout,"E:\\NEWVMS\\Voucher_Log.html",true); 
			log.addAppender(appender);
			log.setLevel(Level.DEBUG);
			log.info(msg);
			log.shutdown();
			System.out.println("\n\nLogged");
			} 
	catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
	 }



		
}
