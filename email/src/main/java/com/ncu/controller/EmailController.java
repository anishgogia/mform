package com.ncu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.ncu.model.*;

import java.util.Random;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

@Controller
public class EmailController {
	static String emailToRecipient,emailSubject, emailMessage,emailFileName;
	static final String emailFromRecipient = "walechai019@gmail.com";
	
	
	Random rand = new Random();
	 int low =0;
	 int high=9999;
	int randomNum = rand.nextInt((high - low) + low) + 1;
	String msg=Integer.toString(randomNum);
	
//	static ModelAndView modelViewObj;
	
	@Autowired
	private JavaMailSender mailSenderObj;
	
	@RequestMapping(value ="/login")
	public String showEmailForm(Model m , @ModelAttribute("email") EmailModel email ) {
		String name = "sameer";
		m.addAttribute("name", name);
		return "login";
	}
	
	@RequestMapping(value = "/sumbit", method = RequestMethod.POST)
	public String send(Model m , @Valid @ModelAttribute("email") EmailModel email,BindingResult br) {
		if(br.hasErrors()) {
			String name = "sameer";
			m.addAttribute("name", name);
			return "login";
		}
		System.out.println(email);
		
		emailSubject = email.getSubject();
		emailMessage = email.getMessage();
		emailToRecipient = email.getMailTo();
		emailFileName = email.getFileName();
		mailSenderObj.send(new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				// TODO Auto-generated method stub
				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				mimeMessageHelper.setTo(emailToRecipient);
				mimeMessageHelper.setFrom(emailFromRecipient);
				mimeMessageHelper.setText(emailMessage);
				mimeMessageHelper.setSubject(emailSubject);
				if(emailFileName !="") {
				DataSource datasource = new FileDataSource(emailFileName);  
				mimeMessageHelper.addAttachment(emailFileName, datasource);
				
				}
				
			}
		});
		System.out.println("email sent successfully");
		m.addAttribute("email", email);
		return "sumbit";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@RequestMapping(value = "/id", method = RequestMethod.POST)
//	public String ids(Model m , @ModelAttribute("signup") firstmodel sign) {
//		
//			String name = "ishaan";
//			m.addAttribute("name", name);
//			return "id";
//		}
//		
	
	
	
	
	
	
//	@RequestMapping(value = "/otp", method = RequestMethod.POST)
//	public String ids(Model m , @Valid @ModelAttribute("signup") firstmodel sign,BindingResult br) {
//		if(br.hasErrors()) {
//			String name = "ishaan";
//			m.addAttribute("name", name);
//			return "id";
//		}
//		
//
//		// nextInt as provided by Random is exclusive of the top value so you need to add 1 
//		
//	      System.out.println(msg);
//	      
//		emailSubject = "otp for ishaan first application";
//		emailMessage = msg;
//		emailToRecipient = sign.getEid();
//		
//		mailSenderObj.send(new MimeMessagePreparator() {
//			
//			@Override
//			public void prepare(MimeMessage mimeMessage) throws Exception {
//				// TODO Auto-generated method stub
//				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
//				mimeMessageHelper.setTo(emailToRecipient);
//				mimeMessageHelper.setFrom(emailFromRecipient);
//				mimeMessageHelper.setText(emailMessage);
//				mimeMessageHelper.setSubject(emailSubject);
////				if(emailFileName !="") {
////				DataSource datasource = new FileDataSource(emailFileName);  
////				mimeMessageHelper.addAttachment(emailFileName, datasource);
////				
////				}
//				
//			}
//		});
//		System.out.println("email sent successfully");
//		
//		return "otp";
//	}
//	
//
//	@RequestMapping(value = "/verify", method = RequestMethod.POST)
//	public String verification(Model m , @Valid @ModelAttribute("onetimepass") onetime onet,BindingResult br) {
//		String done=onet.getOne();
//		int i=Integer.parseInt(done);  
//		System.out.println(i);
//		if(br.hasErrors()) {
//			String name = "ishaan";
//			m.addAttribute("name", name);
//			return "otp";
//		}
//		
//		else if(i!=randomNum){
//			
//			return "otp";
//		}
//		else {
//			return"verify";
//		}
//
//}
}