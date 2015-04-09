package mailing;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMailBean 
{	
	public void sendMail(String to_mailid,String from_mailid,String body_text,String heading) {
		// SUBSTITUTE YOUR EMAIL ADDRESSES HERE!!!    	
    	String host = "192.168.224.26";
		String username = "user1@pace.com";
		String password = "passwd@12";
		//String to = "user2@pace.com";
		//String from = "user1@pace.com";
		
		String to=to_mailid;
		String from = from_mailid;
		System.out.println("\n\nCame in sendMail user="+to_mailid+", book_name="+heading);
		
    	// Create properties, get Session
        Properties props = new Properties();

        // If using static Transport.send(),
        // need to specify which host to send it to
        props.put("mail.smtp.host",host);
        
        // To see what is going on behind the scene
        props.put("mail.debug", "true");
          //Obtain the session object
	    Session session = Session.getInstance(props);

        try {
            // Instantiatee a message
            Message msg = new MimeMessage(session);

            //Set message attributes
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(heading);
            msg.setSentDate(new Date());

            // Set message content
            msg.setText(body_text);

            //Send the message
			msg.saveChanges(); // implicit with send()
			Transport transport = session.getTransport("smtp");

			transport.connect(host,username,password);

			transport.sendMessage(msg,msg.getAllRecipients());
			
			System.out.println("\n\nYour mail has been sent to "+to+"...");
			transport.close();
        }
        catch (MessagingException mex) {
            // Prints all nested (chained) exceptions as well
            mex.printStackTrace();
        }

	}
	
	
	/*public static void main(String[] args) {
	 
	}*/

}
