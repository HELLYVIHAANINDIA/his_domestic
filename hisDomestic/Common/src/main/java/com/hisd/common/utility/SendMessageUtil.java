package com.hisd.common.utility;

import java.io.Serializable;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;

import com.hisd.common.services.ExceptionHandlerService;
@Service
public class SendMessageUtil implements Serializable {

    private JavaMailSenderImpl mailSender;

    public void setMailSender(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    
    private @Value("#{projectProperties['mail.host']}")
    String host;
    private @Value("#{projectProperties['mail.port']}")
    String port;
    private @Value("#{projectProperties['mail.from']}")
    String from;
    private String emailMessage;
    private String emailTo[];
    private String emailCc;
    private String emailSub;

    public String getEmailCc() {
        return emailCc;
    }

    public void setEmailCc(String emailCc) {
        this.emailCc = emailCc;
    }

    
    public String getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(String emailMessage) {
        this.emailMessage = emailMessage;
    }

    public String getEmailSub() {
        return emailSub;
    }

    public void setEmailSub(String emailSub) {
        this.emailSub = emailSub;
    }

    public String[] getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String[] emailTo) {
        this.emailTo = emailTo.clone();
    }

    public void sendEmail() {
        try {
            mailSender.setHost(host);
            mailSender.setPort(Integer.parseInt(port));
            mailSender.setProtocol("smtp");
            MimeMessage msg = mailSender.createMimeMessage();
            String toEmail[] = emailTo;
            for (String toAddr : toEmail) {
                /*  Mail sending through Spring - Starts */
                msg.setContent(getEmailMessage(), "text/html");
                MimeMailMessage message = new MimeMailMessage(msg);
                String toAddress = toAddr;
                message.setTo(toAddress);
                if(emailCc!=null && !emailCc.isEmpty()){
                    message.setCc(emailCc.split(","));
                }
                message.setFrom(from);
                message.setSubject(getEmailSub());
                mailSender.send(message.getMimeMessage()); //By Spring
            }
        } catch (Exception e) {
            ExceptionHandlerService exceptionHandlerService = new ExceptionHandlerService(true, e);
            exceptionHandlerService.logToFile(e);
            exceptionHandlerService = null;
        }
    }
}
