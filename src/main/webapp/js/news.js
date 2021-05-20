  $(document).ready(function(){ 
	  var c = 0;
	  $("nav.main_nav_contaner  ul.main_nav li.ccs").click(function(){
		 
		  $.ajax({
    		  url:'/api/courses',
    	       success:function(res){
    	    	   var s ='';
        	    	 $(res).each(function(index,news){
           	    		s+= `<div class="col-lg-6 course_col">
									<div class="course">
										<div class="course_image"><img src="images/course_4.jpg" alt=""></div>
										<div class="course_body">
											<h3 class="course_title"><a href="course.html">Software Training</a></h3>
											<div class="course_teacher">Mr. John Taylor</div>
											<div class="course_text">
												<p>anh hieu dep trai</p>
											</div>
										</div>
										<div class="course_footer">
											<div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
												<div class="course_info">
													<i class="fa fa-book" aria-hidden="true"></i>
													<span>20 chương mụct</span>
												</div>
												<div class="course_info">
													<i class="fa fa-star" aria-hidden="true"></i>
													<span>5</span>
												</div>
												<div class="course_price ml-auto">$130</div>
											</div>
										</div>
									</div>
								</div>`;

     				 });
        	    	
        	    	 console.log(s);
        	    	 $(".courses_container .courses_row").html(s);
        	    	
        	    	 
    	     }

    	  });
		 
		});
	  
	  
	  
	  //hien thi chi tiet noi dung bai viet
        $(".latest_content .latest_title a[data-id]").click(function(){
           var a = $(this).attr("data-id");
          
           $.ajax({
        		  url:`/news/detail/${a}`,
        	       success:function(res){
        	    	   var title = res.title;
        	    	   var timeCreate =res.timeCreate;
        	    	   var idUnit = res.content;
        	    	   var content = 
        	    	  $("div.blog_title").text(title);
        	    	  $("div.blog_meta ul li a").text(timeCreate);
        	    	  $("p.content").text(idUnit);
        	     }
        	  });
        });
       
  	  

         
        
//        $(".clearfixs").click(function(){ // danh sach bài viet theo chuyen mục
//            var a = $(this).attr("data-id");
//           
//            $.ajax({
//         		  url:`/news/category/${a}`,
//         	       success:function(res){
//         	    	 var a =   $(".blog_post_image").html('<img src="/images/`+news.images+`" >');
//         	    	 var b =     $(".blog_post_title").html('<a href="/new/chitiet/`+news.id+`">`+news.title+`</a>');
//         	    	 var c =    $(".blog_post_meta ul").html('<li><a href="#">`+news.title+`</a></li> <li><a href="#">`+news.title+`</a></li>');
//         	    	  alert(a);
//         	    	  $(res).each(function(index,news){
//         	    		 $(".blog_post_image").html(a);
//           	           $(".blog_post_title").html(b);
//           	           $(".blog_post_meta ul").html(c);
//           	         
//         	    	  });
//         	    
//         	     }
//         	  });
//         });
        
        
        // hien thi danh sach tin tuc
        
        $("div.aa").click(function(){
        	c++;
        	   $.ajax({
          		  url: '/news/lists/'+c,
          	       success:function(res){
          	    	  
          	    	
          	    	  // lay ra danh sach tu api
          	    	 var s ='';
          	    
          	    	 $(res).each(function(index,news){
          	    		s+= `<div class="col-lg-4 event_col">
							<div class="event event_left">
								<div class="event_image"><img src="/images/`+news.images+`" alt=""></div>
								<div class="event_body d-flex flex-row align-items-start justify-content-start">
									<div class="event_date">
										<div class="d-flex flex-column align-items-center justify-content-center trans_200">
											<div class="event_day trans_200">21</div>
											<div class="event_month trans_200">Aug</div>
										</div>
									</div>
									<div class="event_content">
										<div class="event_title"><a href="/new/chitiet/`+news.id+`">
											`+news.title+`</a></div>
										<div class="event_info_container">
											<div class="event_info"><i class="fa fa-clock-o" aria-hidden="true"></i><span>Tác Giả : `+news.user+`</span></div>
											<div class="event_info"><i class="fa fa-map-marker" aria-hidden="true"></i><span>`+news.timeCreate+`</span></div>
											<div class="event_text">
												<p>`+news.tomtat+`</p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>`;
          	    		
          	    		
          	    		
          	    		 
    				 });
          	        
     	    		 $("div.events_rows").append(s);
     	    		 $(".sidebar_categories ul.cate > ul")
          	     }
        	     
          	  }); 
         });
        
       
        
    });
 