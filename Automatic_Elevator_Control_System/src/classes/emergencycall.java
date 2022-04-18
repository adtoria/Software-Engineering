package classes;

/**
 *
 * @author Group8
 */

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;  
import com.sun.mail.smtp.SMTPTransport;
import java.security.Security;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class emergencycall extends Thread {
    //mails and related stuff
    
    protected String mail=main.get_mail();
    protected String sub="POWER BACKUP NEEDED";
    protected String sos;
    
    
    public void run(){
        alert();
    }
    
    public void alert()
    {
        Properties p= new Properties();
        p.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        p.put("mail.smtp.port", "587"); //TLS Port
        p.put("mail.smtp.auth", "true"); //enable authentication
        p.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        
        p.put("mail.smtp.user", "iit2020119@iiita.ac.in");
        p.put("mail.smtp.password", "Abhinandan@2003");
        
        Session session = Session.getDefaultInstance(p,
        new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("iit2020119@iiita.ac.in","Abhinandan@2003");
            }
        });
        
        try {
        	MimeMessage msg=new MimeMessage(session);
        	msg.setFrom(new InternetAddress("iit2020119@iiita.ac.in"));
        	msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
        	msg.setSubject("POWER BACKUP NEEDED");
        	msg.setText("Power backup Needed For Elevator in CC3 building");
        	Transport.send(msg);
        	System.out.println("Message Sent successfully");
        	
		} catch (Exception e) {
			
			System.out.println("Error In Sending Mail!!!");
			// TODO: handle exception
		}
        
    }
    
}