package com.ncu.controller;


import java.util.List;
	import java.util.Map;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.razorpay.*;


import com.ncu.dao.Blooddao;
import com.ncu.model.firstmodel;




	@Controller
	public class WelcomeController {

		@Autowired
		private Blooddao blooddao;
		
		@RequestMapping("/hello")
	
		public String welcomemsg(Model model) {
			System.out.println("jiijijkii");
			model.addAttribute("msg", "vaishali");
			return "corona";
		}
		
	
		@RequestMapping(path="/home")
		public String logindone(@ModelAttribute("userModel") firstmodel user , Model model) {
			
//			 System.out.println(user.getPhn());
			if (user.getPhn()!=null) {
				 blooddao.add(user);
				 System.out.println(user.getPhn());
			}
		
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
			  public String someAction(@ModelAttribute("userm") firstmodel user , Model model) {
			        List<firstmodel> first = blooddao.listalldonation();
			        System.out.println(first);
			        model.addAttribute("donorList", first);
			        
		            	 return "done"; 
		             }
			  
			  @RequestMapping(value="/nav")
			  public String nav() {
			 
		            	 return "nav"; 
		             }
			  
//			  @RequestMapping(value = "/donation")
//			    public String dona(Model theModel)
//			    {
//				  theModel.addAttribute("resources", new secondmodel());
//			        return "blood";
//			    }
//			  @RequestMapping(value = "/blood", method=RequestMethod.POST)
//			    public String saveInfo(@ModelAttribute("bloodon") secondmodel secm, Model model)
//			    {
//			        blooddao.add(secm);
//			        return "hello";
//			    }
			  
			  @RequestMapping(value = "/delete/{phn}")
			    public String deletedonor(@PathVariable("phn") String phn, @ModelAttribute("userm") firstmodel user , Model model)
			    {
			        blooddao.delete(phn);
			        
			        return ("redirect:/done");
			    }
			  
			  
			  @RequestMapping(value = "/edit/{phn}")
			  public String editdonor(@PathVariable("phn") String phn, @ModelAttribute("userm") firstmodel user , Model model)
			    {
			       
			      
			        blooddao.find(phn);
			       
			        List<firstmodel> first = blooddao.listalldonation();
			        System.out.println(first);
			        model.addAttribute("donorList", first);
			        model.addAttribute("employee",user);  
			        return "done";
			    }
}
