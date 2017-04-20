package com.hisd.common.utility;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
/*
	
	@RequestMapping(value = { "/sendMessage" }, method = RequestMethod.POST)
	public void loginSubmit(HttpServletResponse response,HttpServletRequest request) throws IOException, ParseException {
		String redirectPage = null;
		redirectPage = "/";
		Map<String,String> map = commonFunc.generateMessageMap(request);
		String name = map.get("name");
		String email  = map.get("email");
		String phone  = map.get("phone");
		String message  = map.get("message");
		String content = " name : "+name+" </br>Phone : "+phone+" </br>Email : "+email+" </br>Message : "+message;
		springMailSender.setEmailTemplate(springMailSender.simpleMailMessage(email,message));
		springMailSender.setJavaMailSender(springMailSender.javaMailService());
		springMailSender.sendMail(name, content);
		response.sendRedirect(redirectPage);
	}

*/
@Component
public class SpringMailSender { 

	@Autowired
    private Environment environment;

	private SimpleMailMessage emailTemplate;

	private JavaMailSenderImpl javaMailSender;

	public void setEmailTemplate(SimpleMailMessage emailTemplate) {
		this.emailTemplate = emailTemplate;
	}

	public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
		this.javaMailSender = javaMailSender;
	}


    public JavaMailSenderImpl javaMailService() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("nirav90up@gmail.com");
        javaMailSender.setPassword("");
        javaMailSender.setJavaMailProperties(getMailProperties());
        return javaMailSender;
    }

    public SimpleMailMessage simpleMailMessage(String from,String text) {
    	SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    	simpleMailMessage.setFrom(from);
    	simpleMailMessage.setTo(environment.getRequiredProperty("mail.userid"));
    	simpleMailMessage.setSubject("Mail form Website.. Look urgent ");
    	simpleMailMessage.setText("Mail for Test");
        return simpleMailMessage;
    }

    private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtps.ssl.enable", "true");
        properties.setProperty("mail.debug", "false");
        
        return properties;
    }

    @Autowired
    @Qualifier("mailSender")
    public void init(JavaMailSenderImpl javaMailSenderImpl) {
        this.javaMailSender = javaMailSenderImpl;
    }
    
	public boolean sendMail(String dear, String content,String fromEmail,String toEmail,String subject) {
		String emailBody = "Hi"+" <br/>"+ dear+"  <br/>"+ content;
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		boolean isSent = false;
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom(fromEmail);
			helper.setTo(toEmail);
			helper.setSubject(subject);
			helper.setText(emailBody);

			/*
			  uncomment the following lines for attachment FileSystemResource
			  file = new FileSystemResource("attachment.jpg");
			  helper.addAttachment(file.getFilename(), file);
			 */

			javaMailSender.send(mimeMessage);
			isSent = true;
			System.out.println("Mail sent successfully.");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return isSent;
	
	}


}
