package com.sid.schedulers;

import java.time.LocalDate;
import java.util.Properties;
import java.util.Set;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sid.beans.Louer;
import com.sid.dao.LouerDao;

@Component
public class ScheduledTasks {
	
	@Autowired
	LouerDao louerDao;
	
	@Scheduled(cron="0 0 0 * * *")
	public void outOfTimeRent() {
		Set<Louer> louers = louerDao.findOutTimeRent(LocalDate.now().plusDays(20));
		for(Louer louer : louers) {
			String from = "mohamedhousni1996@gmail.com";
	        String pass = "ilgudzesgwxomxaw";
	        String[] to = { "fati.el.fadil123@gmail.com" }; // list of recipient email addresses
	        String subject = "Rent out of time";
	        String body = louer.getClient().getNomClt()+" rahe mabghache iraje3 tomobile "+louer.getVoiture().getMatVoiture();

	        sendFromGMail(from, pass, to, subject, body);
		}
	}
	
	
	 private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
	        Properties props = System.getProperties();
	        String host = "smtp.gmail.com";
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.user", from);
	        props.put("mail.smtp.password", pass);
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");

	        Session session = Session.getDefaultInstance(props);
	        MimeMessage message = new MimeMessage(session);

	        try {
	            message.setFrom(new InternetAddress(from));
	            InternetAddress[] toAddress = new InternetAddress[to.length];

	            // To get the array of addresses
	            for( int i = 0; i < to.length; i++ ) {
	                toAddress[i] = new InternetAddress(to[i]);
	            }

	            for( int i = 0; i < toAddress.length; i++) {
	                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	            }

	            message.setSubject(subject);
	            message.setText(body);
	            Transport transport = session.getTransport("smtp");
	            transport.connect(host, from, pass);
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();
	        }
	        catch (AddressException ae) {
	            ae.printStackTrace();
	        }
	        catch (MessagingException me) {
	            me.printStackTrace();
	        }
	    }
}
