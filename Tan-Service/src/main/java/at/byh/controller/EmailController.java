package at.byh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import at.byh.tan.TAN;

@Controller
public class EmailController {

    @Autowired
    public JavaMailSender emailSender;
 
    @ResponseBody
    @RequestMapping("/email")
    public String sendSimpleEmail() {
 
        // Create a Simple MailMessage
        SimpleMailMessage message = new SimpleMailMessage();
         
        message.setFrom("gru18163@spengergasse.at");
        message.setTo("gru18163@spengergasse.at");
        message.setSubject("Angeforderte TAN-Nummer");
        message.setText("Ihre TAN-Nummer lautet: " + TAN.getTan());
 
        // Send Message
        this.emailSender.send(message);
 
        return "Email Sent!";
    }
}
