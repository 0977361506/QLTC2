 $(document).ready(function(){ 
	
	 $(".has_children .dropdown_item .dropdown_item_title").hover(function(){// đề cương cho khóa học
		
		 var a =  $(this).attr("data-id");

		 $.ajax({
			 url : '/api/outline/'+a,
			 success: function(res){
				 var s = '';
				  var b = a ;
				 $(res).each(function(index,news){
                     if(res!=null){
    					 s+= `

    						 <li>
    						 <div class="dropdown_item">
    						 <div class="dropdown_item_title"><span>`+news.name+`</span></div>
    						 <div class="dropdown_item_text">
    						 <p>`+news.courseWareType.name+`</p>
    						 </div>
    						 </div>
    						 </li>
    						 `;
                     }
                     
				 });
	
				 $(`.has_children ul#`+b+``).html(s);
			
				 if(Object.keys(res).length===0){
                	 s+=`<div class="alert alert-warning"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i> Chưa có học liệu nào</div>`;
                	 $(`.has_children ul#`+b+``).html(s);
                 }
				 
				 
			

			 }
			 
		 });
	 });
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
//	 $("ul.mt-5 li a").click(function(){
//		
//		 $.ajax({
//			 url : '/api/myCourses',
//			
//			 success:function(res){
//				 var x = `<form action="/home/search/mycourses" id="courses_search_form" class="courses_search_form d-flex flex-row align-items-center justify-content-start">
//						<input type="search" value="${param.key}" name="mykey" class="courses_search_input" placeholder="Key Search" required="required" style="width: 480px;">
//					
//					   <button action="submit" class="courses_search_button ml-auto">Tìm Kiếm</button>
//				      </form>`;
//				 
//				 var s ='';
//				  var ss =`<li>
//				  	<a href="#"><span>Khóa học của tôi</span></a>
//											
//			             </li>
//			             <li>
//				  	<a href="#"><span>Khóa học đang học</span></a>
//											
//			             </li>
//			             <li>
//				  	<a href="#"><span>Khóa học khuyến nghị</span></a>
//											
//			             </li>
//			                  <li>
//				  	<a href="#"><span>Khóa học kế hoạch</span></a>
//											
//			             </li>
//			                  <li>
//				  	<a href="#"><span>Khóa học đã kết thúc</span></a>
//											
//			             </li>`;
//				  
//				 var sss =` <a href="/home/courses" style="color: white;">Tất Cả Khóa Học <i class="fa fa-circle pull-right" style="position: relative; top: 4px"></i></a>`;
//				$(res).each(function(index,news){
//					s+=`<div class="col-lg-4 course_col">
//									<div class="course" style="width: 100%">
//										<div class="course_image"><img src="/images/`+news.avatar+`" alt=""></div>
//										<div class="course_body">
//											<h3 class="course_title"><a href="/home/courses/detail/`+news.id+`">`+news.name+`</a></h3>
//										<div class="course_teacher">GV : `+news.createdBy+`</div>
//											<div class="course_text">`
//									  if(news.courseConfig.approveAuto == 1){
//										  s+=`<p>Đăng kí tự do</p>`}
//									  
//									  if(news.courseConfig.approveAuto == 0){
//										  s+=`<p>Không được đăng kí tự do</p>`
//										  
//										  }
//									  
//										  s+=`</div>
//										</div>
//										<div class="course_footer">
//											<div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
//												<div class="course_info">
//													<i class="fa fa-book" aria-hidden="true"></i>
//													<span>20 chương mục</span>
//												</div>
//												<div class="course_info">
//													<i class="fa fa-star" aria-hidden="true"></i>
//													<span>5</span>
//												</div>
//												<div class="course_price ml-auto">`+news.price+`</div>
//											</div>
//										</div>
//									</div>
//					</div>`;
//					
//					
//				});
//				
//				
//				$(".courses_row").html(s);
//				 $(".sidebar_categories ul > li > ul").hide(); // ẩn 
//				 $(".sidebar_categories ul").html(ss); // thay đoi danh muc
//				 $("ul.list-group li") .html(sss); // thanh ddoooir nut
//				 $("div.courses_search_container").append(x);
//			 }
//		 });
//	 });
//	 
//	
	
	  // hien thi danh sach danh mục con theo danh mucjk khoa hoc cha
		

	 $(".sidebar_categories ul > li a").hover(function(){
			var a = $(this).attr("data-id");
			
		 $.ajax({
			 url : '/api/courseCategory/'+a,
			 
			 success:function(res){
					
					var s= '';
					if(res.length>0){
						
						 $(res).each(function(index,news){
							  s+=`<li><a id=`+news.id+` href="/home/detail/course/`+news.id+`">`+news.name+`</a></li>`;
							  
						 });
						 
						
								
								 $(".sidebar_categories ul > li > ul ").html(s);
							
		
					}
//				if(res.length==0)){
//						s='';
//						 $(".sidebar_categories ul > li > ul ").html(s);
//					}
//					   
//					 $(".sidebar_categories ul > li > ul ").append(s);
					
			 }, error:function(res){
				 
			 }
		 });
	 });

	 
	 // tim kiem khoa học theo tưng danh mục cha /detail/mycourses/${c.id}

//	 $(".sidebar_categories ul > li a").click(function(){
//			var a = $(this).attr("id");
//			
//		  search(a);
//           
//	 });
	 
	 // tim kiem khóa học theo danh mục con
	 
	
	 
	 
//	 
//      
//	function search(a){ // hàm xử lí tim kiem khó hcoj theo danh muc
//		 $.ajax({
//			 url : '/api/detail/mycourses/'+a,
//			 
//			 success:function(res){
//					if(res!=null){
//						var s= '';
//						$(res).each(function(index,news){
//							s+=`<div class="col-lg-4 course_col">
//											<div class="course" style="width: 100%">
//												<div class="course_image"><img src="/images/`+news.avatar+`" alt=""></div>
//												<div class="course_body">
//													<h3 class="course_title"><a href="/home/courses/detail/`+news.id+`">`+news.name+`</a></h3>
//												<div class="course_teacher">GV : `+news.createdBy+`</div>
//													<div class="course_text">`
//											  if(news.courseConfig.approveAuto == 1){
//												  s+=`<p>Đăng kí tự do</p>`}
//											  
//											  if(news.courseConfig.approveAuto == 0){
//												  s+=`<p>Không được đăng kí tự do</p>`
//												  
//												  }
//											  
//												  s+=`</div>
//												</div>
//												<div class="course_footer">
//													<div class="course_footer_content d-flex flex-row align-items-center justify-content-start">
//														<div class="course_info">
//															<i class="fa fa-book" aria-hidden="true"></i>
//															<span>20 chương mục</span>
//														</div>
//														<div class="course_info">
//															<i class="fa fa-star" aria-hidden="true"></i>
//															<span>5</span>
//														</div>
//														<div class="course_price ml-auto">`+news.price+`</div>
//													</div>
//												</div>
//											</div>
//							</div>`;
//							
//							
//						});
//						
//						
//						$(".courses_row").html(s);
//					}
//					if(Object.keys(res).length===0){
//						var k = `<div class="alert alert-warning text-center w-100 mt-3" style="color: #f6821f;  background-color: #fff3cd; border-color: #ffeeba; margin-top: 200px;">
//                        <i class="fa fa-exclamation-triangle"></i>không tìm thấy khóa học nào ! 
//                        <a class="" href="/home/courses">Tất cả khóa học</a>
//                         </div>`;
//						$(".courses_row").html(k);
//					}
//
//					
//			 }, error:function(res){
//				 
//			 }
//		 });
//	}

	 
	 
 });
 