package com.ncu.controller;


import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

import com.ncu.model.EmailModel;
import com.ncu.model.Customer;



@Controller
public class WelcomeController {
	
	
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
	static String emailToRecipient,emailSubject, emailMessage,emailFileName;
	static final String emailFromRecipient = "anishspring506@gmail.com";
	
//	static ModelAndView modelViewObj;
	
	@Autowired
	private JavaMailSender mailSenderObj;
	@RequestMapping(value ="index")
	public String showEmailForm( ) {
		
		return "index";
	}
	@RequestMapping(value ="/login2")
	public String showEmailForm(Model m , @ModelAttribute("email") EmailModel email ) {
		String name = "anish";
		m.addAttribute("name", name);
		return "emailForm";
	}
	
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public String send(Model m , @ModelAttribute("email") EmailModel email) {
		
		System.out.println(email);
		System.out.println(email.getSubject());
		System.out.println(email.getMessage());
		System.out.println(email.getMailTo());
		
		emailSubject = email.getSubject();
		emailMessage = email.getMessage();
		emailToRecipient = email.getMailTo();
		emailFileName = "/Users/anishgogia/Downloads/anish19csu029@ncuindia.edu.jpg";
		mailSenderObj.send(new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				// TODO Auto-generated method stub
				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				mimeMessageHelper.setTo(emailToRecipient);
				mimeMessageHelper.setFrom(emailFromRecipient);
				mimeMessageHelper.setText(emailMessage);
				mimeMessageHelper.setSubject(emailSubject);
				if(emailFileName != null && emailFileName !="" ) {
				DataSource datasource = new FileDataSource(emailFileName);  
				mimeMessageHelper.addAttachment(emailFileName, datasource);
				
				}
				
			}
		});
		System.out.println("email sent successfully");
		m.addAttribute("email", email);
		return "send";
	}
	
	

	@RequestMapping("/hello")
	public String welcomemsg(Model model) {
		model.addAttribute("msg", "anish");
		return "welcome";
	}
	@RequestMapping("/login")
	public String doLogin(HttpServletRequest request, Model model) {
		String userId=request.getParameter("userId");
		model.addAttribute("msg", "anish gogia "+userId);
		return "login";
	}
	@RequestMapping("/hello2")
	public String Home() {

		
		return "index";
	}
	
	@RequestMapping("/customer")
	public String showForm(Model theModel) {
		
		theModel.addAttribute("customer", new Customer());
		
		return "customerform";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,BindingResult theBindingResult) {
		
		System.out.println("Last name: |" + theCustomer.getLname() + "|");
		
		if (theBindingResult.hasErrors()) {
			return "customerform";
		}
		else {
			return "customerconfirmation";
		}
	}

}
	
