package com.ncu.controller;


	import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.razorpay.*;

import com.ncu.model.firstmodel;



	@Controller
	public class WelcomeController {

		@RequestMapping("/hello")
	
		public String welcomemsg(Model model) {
			System.out.println("jiijijkii");
			model.addAttribute("msg", "vaishali");
			return "corona";
		}
		
	
		@RequestMapping(path="/home")
		public String logindone(@ModelAttribute("userModel") firstmodel user , Model model) {
		model.addAttribute("msg", "ishaan");
		return "home";
		}
		
		
		@RequestMapping(path="/success")
		public String logindone( Model model) {
		model.addAttribute("msg", "ishaan");
		return "success";
		}
		
//		@RequestMapping(path="/create" , method=RequestMethod.POST)
		
//		public String createOrder(@RequestBody String data[]) {
//		public @ResponseBody String createOrder (@RequestBody Map<>) {
		     
		 @PostMapping("/create")
			@ResponseBody
			@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
			public String createOrder(@RequestBody Map<String, Object> data) throws RazorpayException {
			System.out.println(data);
			int amt=Integer.parseInt(data.get("amount").toString());
			RazorpayClient client=new RazorpayClient("rzp_test_TPGnIh1LBfeSKD","yWZZ3LhenLtvPYspDfrwmQ19");
			  JSONObject orderRequest = new JSONObject();
			  orderRequest.put("amount", amt*100); // amount in the smallest currency unit
			  orderRequest.put("currency", "INR");
			  orderRequest.put("receipt", "order_rcptid_11");
			  Order order=  client.Orders.create(orderRequest);
			  System.out.println(order);
			  return order.toString();
		}
		 
		
		  @RequestMapping(value="/admin", method=RequestMethod.GET)
		    public String privateHome() {  
				 
		        return "adminp";  
		    }   

			  @RequestMapping(value="/done")
			  public String someAction() {
			 
		            	 return "done"; 
		             }
}
