package com.mohsenj.module.user.event;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.mohsenj.module.user.model.User;
import com.mohsenj.module.user.service.UserService;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
    @Autowired
    private UserService service;

    @Autowired
    private MessageSource messages;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Environment env;

    // API

    @Override
    public void onApplicationEvent(final OnRegistrationCompleteEvent event) {
    	System.out.println("send email1: ");
        this.confirmRegistration(event);
    }

    private void confirmRegistration(final OnRegistrationCompleteEvent event) {
        final User user = event.getUser();
        final String token = UUID.randomUUID().toString();
        service.createVerificationTokenForUser(user, token);
        System.out.println("send email2: ");
        final SimpleMailMessage email = constructEmailMessage(event, user, token);
        
        mailSender.send(email);
        
       // mailSender.send();
    }

    //

    private final SimpleMailMessage constructEmailMessage(final OnRegistrationCompleteEvent event, final User user, final String token) {
    	final String recipientAddress = user.getEmail();
        final String subject = "Registration Confirmation";
        final String confirmationUrl = event.getAppUrl() + "/registrationConfirm?token=" + token;
      //  final String message = messages.getMessage("message.regSucc", null, event.getLocale());
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(/*message + */" \r\n" + confirmationUrl);
        email.setFrom(env.getProperty("support.email"));
        return email;
    }

}