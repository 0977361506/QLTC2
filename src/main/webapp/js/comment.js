$(document).ready(function(){
	$(".comment_extras  .ans").click(function(){ // trả lời comment
		var b = $(this).attr("id");
		$(`.comment_extra a#`+b+` ~ div`).css("display","block");
		$.ajax({
			 url : '/api/recomment/'+b,
			 success: function(res){
		
				
					  var s = '';
					  $(res).each(function(index,news){
						
						     
                          s+=`	 <li>
							        <div class="comment_item d-flex flex-row align-items-start jutify-content-start">
								     <div class="comment_image">
									<div>
										<img src="/images/LeTheHieu.jpg" alt="Tuấn Anh">
											</div>
										</div>
										<div class="comment_content">
										<div class="comment_title_container d-flex flex-row align-items-center justify-content-start">
										<div class="comment_author"><a href="#">`+news.createdBy+`</a></div>
										<div class="comment_time ml-auto">
										`+new Date().getDate()+'-'+(new Date().getMonth()+1)+'-'+new Date().getFullYear() +`</div>
										</div>
										<div class="comment_text">
										<p>`+news.contents+`</p>
										</div>
										</div>
										</div>
								</li>`;

					  });
				         
                       
					  $(`ul .`+b+``).html(s);

				
			 }
			 
		});
		
	});
	
	
	$("button.sendAns").click(function(){ // trả lời comment
		var b = $(this).attr("id");
	var a = $(`input[data-id=`+b+`]`).val();
		 if(a.length===0){
			 alert("không được bỏ trống ! vui lòng nhập commnet");
		 }
	if(a!=null){
			$.ajax({
				 url : `/api/recomments/${a}/${b}`,
			 success: function(res){
			
					 if(Object.keys(res).length>0){
						 $(".retxtNewComment").val("");
				          var s = '';
         
		                                      s+=`	 <li>
												        <div class="comment_item d-flex flex-row align-items-start jutify-content-start">
													     <div class="comment_image">
														<div>
															<img src="/images/LeTheHieu.jpg" alt="Tuấn Anh">
																</div>
															</div>
															<div class="comment_content">
															<div class="comment_author"><a href="#">`+res.createdBy+`</a></div>
														<div class="comment_time ml-auto">
															`+new Date().getDate()+'-'+(new Date().getMonth()+1)+'-'+new Date().getFullYear() +` </div>
															</div>
															<div class="comment_text">
															<p>`+res.contents+`</p>
															</div>
															</div>
															</div>
													</li>`;
				
                            
		                          $(`ul .`+b+``).append(s);
	                 }
					
				 }
				 
			});
	}
	
});
	
	

	
	
	
	$(".btn-send-new-comment").click(function(){  // hiển thi list bình luân cha
		var a = $(".txtNewComment").val();
		var b = $(".txtNewComment").attr("id");
		 if(a.length===0){
			 alert("không được bỏ trống ! vui lòng nhập commnet");
		 }
		if(a!=null){
			$.ajax({
				 url : `/api/comment/${a}/${b}`,
				 success: function(res){
			
					 if(Object.keys(res).length>0){
					   $(".txtNewComment").val("");
					          var s = '';
          
						         s+=`					<li>
															<div class="comment_item d-flex flex-row align-items-start jutify-content-start">
																<div class="comment_image">
																	<div>
																		<img class="img-fluid" src="/images/teacher.jpg" alt="Nguyễn Ngọc Cảnh">
																	</div>
																</div>
																<div class="comment_content">
																	<div class="comment_title_container d-flex flex-row align-items-center justify-content-start">
																		<div class="comment_author"><a href="#">`+res.createdBy+`</a></div>
																		<div class="comment_time ml-auto">
																	 `+new Date().getDate()+'-'+(new Date().getMonth()+1)+'-'+new Date().getFullYear() +`  </div>
																	</div>
																	<div class="comment_text">
																		<p>`+res.contents+`</p>
																	</div>
																	<div class="comment_extras d-flex flex-row align-items-center justify-content-start">
																		<div class="comment_extra comment_reply">
																			<a type="button" href="#icon" class="ans"> 
																				<i class="fa fa-reply" aria-hidden="true"></i>
																				<span>Trả lời</span>
																			</a>
						             	 <!-- hiển thị form trả lời -->		<div  id="icon"  class="input_reply_comment form-group" style="display:none ; ">
				     <!-- hiển thị form trả lời -->								  <div>
			  <!-- hiển thị form trả lời -->										<div class="form-group">
																						<textarea class="form-control rounded-10 retxtNewComment" rows="2"></textarea>
																					</div>
																					<div class="form-group">
																						<div id="recaptcha-formcoursesComment5e195401815bc"></div>                                                    </div>
																						<div class="text-right">
																							<button type="button"><i class="fa fa-paper-plane"></i> gửi</button>
																						</div>
																					</div>
																			</div>
																	    </div>
																	</div>
																	</div>
																</div>
																
															</li>`;
				
                            
                            $(".comments_list").append(s);
	                 }
					
				 }
				 
			});
		}
	});
	
		
	
	
	
});