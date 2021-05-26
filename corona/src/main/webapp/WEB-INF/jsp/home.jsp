<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>  
<html>
<head>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
 <script src="https://checkout.razorpay.com/v1/checkout.js"></script>
 <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<script>

const paymentStart = () => {
	
	console.log("payment started..");
	var amount=$("#payment_feild").val();
	console.log(amount);
	
	if(amount==""||amount==null)
		{
		 swal("Failed", "Amount is required", "error");
		return;
		}
	
	 $.ajax(
			 { 
				 headers: { 
			        'Accept': 'application/json',
			        'Content-Type': 'application/json' 
			    },
		 
                 url: "create",
                 data: JSON.stringify({amount: amount ,info: "order_request" }),
                
                 dataType: "json",
                 type: "POST",
                 success: function (response)
                 
                 {
                     console.log(response);
                    
                     if(response.status=='created')
                     
                  
                     {
                    	 let options={
                    	  key:'rzp_test_TPGnIh1LBfeSKD',
                    	  amount:response.amount,
                    	  currency:'INR',
                    	  name:'Mahavir International',
                    	  description:'Donation',
                    	  image:'resources/img/rplogo.png',
                    	  order_id:response.id,
                    	  handler:function(response){
                    		  console.log(response.razorpay_payment_id);
                    		  console.log(response.razorpay_order_id);
                    		  console.log(response.razorpay_signature);
                    			console.log('payment sucessful');
                    			
                    			swal("Thank you", "You have saved a life", "success");
                    	  },
                    	  prefill: {
                    	        "name": "",
                    	        "email": "",
                    	        "contact": "",
                    	    },
                    	    notes: {
                    	        "address": "Razorpay Corporate Office"
                    	    },
                    	    theme: {
                    	        "color": "#3399cc",
                    	    },
                    	};
                    	 let rzp = new Razorpay(options);
                    	 rzp.on('payment.failed', function (response){
                    	       console.log(response.error.code);
                    	       console.log(response.error.description);
                    	       console.log(response.error.source);
                    	       console.log(response.error.step);
                    	       console.logalert(response.error.reason);
                    	       console.log(response.error.metadata.order_id);
                    	       console.log(response.error.metadata.payment_id);
                    	      
                                 swal("Failed", "Oops payment failed", "error");
                    	});
                    	 rzp.open();
                    	 }
                     },
                
                 error:function (error) {
                     console.log(error);
                     alert("something went wrong!!");
                 },
             });
         
	
};
</script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
 <body>
<h1>Welcome Please Enter  details here</h1>
 <form:form action="success" method="post" modelAttribute="userModel">

Enter Amount(*):<form:input id="payment_feild" path="amount" />



</form:form>
<button onclick="paymentStart()">Submit</button>
</body>

</html>