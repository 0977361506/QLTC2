$(document).ready(function(){
	$("#newsletter_form .newsletter_button").click(function(){
		var s = $("#newsletter_form .newsletter_input").val();
       
		$.ajax({
			 url:'/api/registration/'+s,
  	       success:function(res){
  	    	if(res==true){
  	    		alert("dang ki mail thành công !");
  	    		$("#newsletter_form .newsletter_input").val("");
  	    	
  	    	}
  	    	else{
  	    		alert("đăng kí mail thất bại !");
  	    		$("#newsletter_form .newsletter_input").val("");
  	    	
  	    	}
  	     }

		})
	});
});