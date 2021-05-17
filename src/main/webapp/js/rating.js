$(document).ready(function() {
    /*
     * Hiệu ứng khi rê chuột lên ngôi sao
     */
  var checked =0;  // lưu vết đnáh giá
    $('a.star').mouseenter(function() {
        if ($('#cate-rating').hasClass('rating-ok') == false) {
            var eID = $(this).attr('id');
            eID = eID.split('-').splice(-1);
        
            $('a.star').removeClass('vote-active');
            for (var i = 1; i <= eID; i++) {
                $('#star-' + i).addClass('vote-hover');
            }
        }
    }).mouseleave(function() {
        if ($('#cate-rating').hasClass('rating-ok') == false) {
            $('a.star').removeClass('vote-hover');
        }
    });

    /*
     * Sự kiện khi cho điểm
     */
    $('a.star').click(function() {
       checked++; // tăng lần click
     
    	 var eID = $(this).attr('id');
    	var m = $(".review_rating_container").attr("id");
    	 
    	$.ajax({
    		url:  "/check/role/user/"+m,
    		success: function(res){
    			
    			if(res.length>0){
    				 if(checked == 1){
    	    		        if ($('#cate-rating').hasClass('rating-ok') == false) {
    	     		           
    	    		            var sl = $(".review_rating_bars .star1").attr("alt");
    	    		            eID = eID.split('-').splice(-1).toString();
    	    		        	
    	    		            for (var i = 1; i <= eID; i++) {
    	    		                $('#star-' + i).addClass('vote-active');
    	    		            }
    	    		            $("#vote-desc").html("Thank you so much !");
    	    		           
    	    		          
    	    		            $('#cate-rating').addClass('rating-ok');
    	    		            $.ajax({
    	    		            	url:`/rating/star/${eID}/${m}`,
    	    		            	success: function(res){  // thành công gọi api sử lí
    	    		              var index =  $(".review_rating_num").html();
    	    		             
    	    		            	 $(".review_rating_num").html(String(res[2]));
    	    		            	 
    	    		            	 var ss= res[0];
    	    		            	 $(".review_rating_text").html(``+ss+` bình chọn`);
    	    		            	 var long = res[1].length;
    	    		            	 
    	    		            		if(res[0]==1){
    	    		            			$('.voted-'+eID).css("width","100%");
    	    		            	
    	    		            		}
    	    		            		else if(res[0] > 1){
    	    		            			
    	    		            			for (var j = 1; j < 6; j++) {
    	    									var count = res[1].filter(i => i === j).length;
    	    									var rate = count / long * 100;
    	    									$('.voted-'+ j).css("width",``+rate+`%`);
    	    								
    	    								}
//    	    		            			for(var i = 0 ; i < res[1].length ;i++){
//    	    		            				var x = ((res[1][i])/ss)*10;
//    	    		            				
//    	    		            				$('.voted-'+ res[1][i]).css("width",``+x+`%`);
//    	    		            			}
    	    		            			
    	    		            		res[1].splice(0,long); // xóa hêt phần tử của 1 khóa học sau khi đã lấy.
    	    		            		   // lấy các giá trị của đánh giá truyền về cho server lưu hiển thị đánh giá kháo học
    	    		            		
    	    		            		    var starOne = $(".voted-1").attr("style");
    	    		            		    var starTwo = $(".voted-2").attr("style");
    	    		            		    var starThree = $(".voted-3").attr("style");
    	    		            		    
    	    		            		    var starFor = $(".voted-4").attr("style");
    	    		            		    
    	    		            		    var starFive = $(".voted-5").attr("style");
    	    		            		    dataPUT = {};
    	    		          			  dataPUT['starOne'] = starOne;
    	    		          			  dataPUT['starTwo'] =  starTwo;
    	    		          			  dataPUT['starThree'] = starThree ;
    	    		          			 dataPUT['starFor'] =starFor;
    	    		          			 dataPUT['starFive'] =starFive;
    	    		          			 dataPUT['idRate'] = res[3];
    	    		            		   $.ajax({
    	    		            			   url: '/show/review',
    	    		       					method: 'POST',
    	    		       			        data: JSON.stringify(dataPUT),
    	    		       			        dataType: 'json',
    	    		       			        contentType: "application/json",
    	    		       			        success: function (res) {
    	    		                          if(res==true){
    	    		                        	  
    	    		                          }
    	    		       			         
    	    		       			        },
    	    		       			        error: function(res){

    	    		       			        	 
    	    		       			        	  alert("show đánh giá thất bại");
    	    		       			        }
    	    		            		   });
    	    		            		}
    	    		            	}
    	    		            })
    	    		        }
    				 }
    				 else{
    					 alert("Bạn đã đánh giá khóa học này !");
    				 }

    			}
    			else{
    				alert("bạn cần đăng kí khóa học để có thể đánh giá !");
    			}
    		}
    	})

    });
    

    /*
     * kết thúc đánnh giá
     */
});