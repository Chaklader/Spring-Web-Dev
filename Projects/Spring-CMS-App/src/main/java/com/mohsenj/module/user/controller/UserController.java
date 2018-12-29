package com.mohsenj.module.user.controller;

import com.mohsenj.module.user.event.OnRegistrationCompleteEvent;
import com.mohsenj.module.user.model.User;
import com.mohsenj.module.user.model.VerificationToken;
import com.mohsenj.module.user.service.SecurityService;
import com.mohsenj.module.user.service.UserService;
import com.mohsenj.module.user.validator.UserValidator;

import java.util.Calendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Autowired
    private MessageSource messages;
    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(HttpServletRequest request, @ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        User registered= userService.registerNewUserAccount(userForm);
        
        try {
            String appUrl = request.getContextPath();
            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), appUrl));
        } catch (Exception me) {
        	return "error/error";
        }

      //  securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }
    
    @RequestMapping(value = "/registrationConfirm", method = RequestMethod.GET)
    public String confirmRegistration
      (WebRequest request, Model model, @RequestParam("token") String token) {
      
        Locale locale = request.getLocale();
         
        VerificationToken verificationToken = userService.getVerificationToken(token);
        if (verificationToken == null) {
            String message = messages.getMessage("auth.message.invalidToken", null, locale);
            model.addAttribute("message", message);
            return "redirect:/badUser.html?lang=" + locale.getLanguage();
        }
         
        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            String messageValue = messages.getMessage("auth.message.expired", null, locale);
            model.addAttribute("message", messageValue);
            return "redirect:/badUser.html?lang=" + locale.getLanguage();
        } 
         
        user.setEnabled(true); 
        userService.saveRegisteredUser(user); 
        return "redirect:/?lang=" + request.getLocale().getLanguage(); 
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = { "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        
        return "redirect:/welcome";
    }
    
}
