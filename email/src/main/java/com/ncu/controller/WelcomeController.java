package com.ncu.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ncu.dao.UserDao;
import com.ncu.model.firstmodel;
import com.ncu.model.onetime;
@Controller
public class WelcomeController {
	static String emailToRecipient,emailSubject, emailMessage,emailFileName;
	static final String emailFromRecipient = "walechai019@gmail.com";
	
	@Autowired
	private JavaMailSender mailSenderObj;
	Random rand = new Random();
	 int low =0;
	 int high=9999;
	int randomNum = rand.nextInt((high - low) + low) + 1;
	String msg=Integer.toString(randomNum);
	
	@Autowired
	private UserDao userdao;
	@ModelAttribute("user")
	@RequestMapping( path = "/id")
	public String ids(Model m , @ModelAttribute("signup") firstmodel sign) {
		
		
			return "id";
		}
		
	@RequestMapping(path = "/otp")
	public String ids(Model r , @Valid @ModelAttribute("signup") firstmodel sign,BindingResult br) {
		if(br.hasErrors()) {
			
			return "id";
		}
		

		// nextInt as provided by Random is exclusive of the top value so you need to add 1 
		
	      System.out.println(msg);
	      
		emailSubject = "otp for ishaan first application";
		emailMessage = msg;
		emailToRecipient = sign.getEid();
		
		mailSenderObj.send(new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				// TODO Auto-generated method stub
				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				mimeMessageHelper.setTo(emailToRecipient);
				mimeMessageHelper.setFrom(emailFromRecipient);
				mimeMessageHelper.setText(emailMessage);
				mimeMessageHelper.setSubject(emailSubject);
//				if(emailFileName !="") {
//				DataSource datasource = new FileDataSource(emailFileName);  
//				mimeMessageHelper.addAttachment(emailFileName, datasource);
//				
//				}
				
			}
		});
		System.out.println("email sent successfully");
		System.out.println("this is first name"+sign.getFname());
	return "otp";
	}
	

	@RequestMapping(path = "/verify", method = RequestMethod.POST)
	public String verification(Model m , @Valid @ModelAttribute("signup") firstmodel onet,BindingResult br) {
		int i=0;
		System.out.println(onet.getOne());
		if(onet.getOne().isEmpty()) {
			i=2;
			if(i==2) {
				
				return "otp";
			}
		}
		else {
		String done=onet.getOne();
	     i=Integer.parseInt(done);  
		System.out.println("this is i"+i);
		
		
		 if(i!=randomNum){
			
			return "otp";
		}
		

}
		
			return"verify";
		
	}
	@RequestMapping( path = "/edit" )
	public String jdbc(Model m , @ModelAttribute("data") firstmodel data) {
		String eid= data.setEid("walechai019@gmail.com");
		 data = userdao.get(eid);
		m.addAttribute(data);
			return "jdbc";
		}
}
