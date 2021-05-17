$(document).ready(function(){
	var i=1;
	$('#add').click(function(){
		i++;
		$('#dynamic_field').append('<tr  id="row'+i+'"><td><i class="text-warning   fa fa-circle"></i></td><td><input type="text" name="name[]" placeholder="Nhập vòng thi" class="form-control name_list" /></td><td>Nháp</td><td><button type="button" name="remove" id="'+i+'" class="btn_small_40 btn btn-block btn-outline-danger btn-sm btn_remove">Xóa vòng thi</button></td></tr>');
	});
	
	$(document).on('click', '.btn_remove', function(){
		var button_id = $(this).attr("id"); 
		$('#row'+button_id+'').remove();
	});
	 
	
	
});

$(document).ready(function(){
	
	

	
});

$('#btn_save_all').on('click',function(){
	
	if(validateForm()){
		
	
	var dataArray = {};
	var values =[];
	$("input[name='name[]'").each(function() {
		if($(this).val()!=''){
			 values.push($(this).val());
		}
	});
	
    var id = $('#input_id_competition').val();
    
    dataArray["nameCompetition"]=$('#input_name_competition').val();
    
    if($('#input_id_competition').val() !=""){
    	 dataArray["id"]=id;
    }else{
    	
    }
    
   
    dataArray["imageCompetition"] = $('#xImagePath').text();
    dataArray["status_search_value"] = $('#select_status_competition').val();
    dataArray["category_value"] = $('#select_category_competition').val();
    dataArray["id_unit"] = $('#name_unit').attr('id_unit');
    dataArray["describe"] = CKEDITOR.instances.content.getData();
    if(values.length>0){
    	dataArray["listArray"] = values;
    }
    
    dataArray["highlight"] = $("input[name='customRadio3']:checked").val();

    if ($('#input_id_competition').val() !="") {

		dataArray["timeEnd"] = $("#input_time_end2").val();
		dataArray["timeStart"] = $("#input_time_start2").val();
    	editCompotition(dataArray, $('#input_id_competition').val());
    }
    else {
		dataArray["timeEnd"] = $("#input_time_end").val();
		dataArray["timeStart"] = $("#input_time_start").val();
        addCompotition(dataArray);
    }

    }
 	
	
});	

$('#customRadio2').on('click',function(){
	$('.input_time').css('display','block');
	
});
$('#customRadio1').on('click',function(){
	$('.input_time').css('display','none');
	$('#input_time_start').val("");
	$('#input_time_end').val("");
});
function  addCompotition(dataArray) {
	 $.ajax({
         url: '/api/admin/competition/add',
         type: 'POST',
         dataType: 'json',
         contentType: 'application/json',
         data: JSON.stringify(dataArray),
         success: function (res) {
        	 $('#input_id_competition').val(res.id);
            alert('Thêm thành công');
            showRoundTest(res.id);
         },
         error: function (res) {
        	 alert('Có lỗi sảy ra');
         }
     });
}
function  editCompotition(dataArray,id) {
	 $.ajax({
        url: '/api/admin/competition/edit',
        type: 'PUT',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(dataArray),
        success: function (res) {
           alert('Sửa thành công');
           showRoundTest(res.id);
        },
        error: function (res) {
       	 alert('Có lỗi sảy ra');
        }
    });
}
 
function  showRoundTest(id) {
	$.ajax({
        url: '/api/admin/roundtest/'+id,
        type: 'POST',
        dataType: 'json',
        success: function (res) {
        	var row = '';	
		     $(res).each(function (index, item)  {
		    	 row+='<tr>'
		    	 if(item.statusRound ==1){
		    		 row+='<td><i class="text-warning   fa fa-circle"></i> ' 
		    	 }else{
		    		 row+='<td><i class="text-success   fa fa-circle"></i> '
		    	 }
				
				 row+='<td><input type="text" readonly placeholder="Nhập vòng thi" value="'+item.nameRound+'"  class="form-control name_list" /></td>'
				 if(item.statusRound ==0){
					 row+='<td><span>Duyệt</span></td>'
				 }else{
					 row+='<td><span>Nháp</span></td>'
				 }
				 row+='<td>'
				 row+='<div>'
					 row+=' <div >'
				 row+='<a type="button" href="/admin/roundtest/'+item.id+'/edit"  id="'+item.id+'" class="btn_small_40 btn btn-block btn-info btn-sm"><i class="fas fa-cog"></i>&nbsp; Cấu hình</a>';
				 row+='</div>'
				 row+='<div>'
				 row+='<button onclick="removeRoundTest(this)" id_competition="'+item.competition.id+'" type="button" id_round="'+item.id+'" class="btn_remove_round btn_small_40 btn btn-block btn-outline-danger btn-sm">Xóa vòng thi</button>';
				 row+='</div>'
				 row+='<div> '
				 row+='</td> '
				 row+='</tr>'
		     });
		     
		     $('#body_round_test').html(row);
		     
        
        },
        error: function (res) {
       	 alert('Có lỗi sảy ra');
        }
    });
}

function removeRoundTest(btn){
	var id_round=$(btn).attr('id_round');
	var id_competition=$(btn).attr('id_competition');	
	 $.ajax({
         url: '/api/admin/roundtest/'+id_round+'/'+id_competition+'/off',
         type: 'PUT',
         dataType: 'json',
         success: function (res) {
        	 alert('Xóa thành công');
        	 showRoundTest(res);
         },
         error: function (res) {
        	 alert('Có lỗi sảy ra');
         }
     });
	
	
	
}

function validateForm(){
	        if($('input[name="name[]').val()=='' ||CKEDITOR.instances.content.getData()==='' ||$('#xImagePath').text()=='' || $('#input_name_competition').val()=='' ||  $('#select_category_competition').val()==null || $('#name_unit').attr('id_unit')==''   ){
	        	
	            if($('input[name="name[]').val()=='' ){
	                $('input[name="name[]').css("border", "1px solid red");

	            }else{
	                $('input[name="name[]').css("border", '1px solid #ced4da');

	            }

	            if($('#content').val()==''){
	                $('#content').css("border", "1px solid red");

	            }else{
	                $('#content').css("border", 'none');

	            }

	            if($('#input_name_competition').val()==''){
	                $('#input_name_competition').css("border", "1px solid red");

	            }else{
	                $('#input_name_competition').css("border", 'none');

	            }
	            
	            if($('#xImagePath').text()==''){
	                $('.image_upload').css("border", "1px solid red");

	            }else{
	                $('.image_upload').css("border", 'none');

	            }
	            
	            if($('#select_category_competition').val()==null){
	            	$('#select_category_competition').css("border", "1px solid red");
	            }else{
	                $('#select_category_competition').css("border", '1px solid #ced4da');

	            }
	            
	            if($('#name_unit').attr('id_unit')==''){
	            	$('.form_unit').css("border", "1px solid red");
	            }else{
	                $('.form_unit').css("border", '1px solid #ced4da');

	            }
	            
	            
	            return false;
	        }else {

	            return true;
	        }
	    }
 



/*function showChildRoot(btn) {

    var idPerRoot=$(btn).attr('id_pers_root');
    $.ajax({
        url: '/api/admin/treeunit/'+idPerRoot+'/childRound',
        type: 'POST',
        dataType: 'json',
        success: function (res) { 
        	 var row='';
        	 
        		 
        		 
        	 
        	 if(res.listUnitVnpostDTOs!=null){
        	   $(res.listUnitVnpostDTOs).each(function (index, items)  {
        		   row+='<li>'
        		   row+='<span  id_pers_root='+items.idUnit+'  id="id_pers_root_'+items.idUnit+'"   onclick="showChildRoot(this)"  class="carett"><i class="fas fa-home text-warning"></i>&nbsp;'+items.name+'</span>'
         		   row+='<ul id="detail_item_'+items.idUnit+'" class="nested"  >' 
         		 
         		   row+='</ul>'	   
        		   row+='</ul>'
        		   row+='</li>'
        	   });
        	   
        	   
      		  if(res.lisPoscodeVnposts!=null){
              	 $(res.lisPoscodeVnposts).each(function (index, item)  {
              		row+='<li style="cursor:pointer;">'	 
	      			row+='<span  id_poscode_root='+item.posCode+'  id="id_poscode_root_'+item.posCode+'"   onclick="showPoscodeRoot(this)"  ><i class="far fa-dot-circle"></i>&nbsp;<i class="fas fa-campground  text-warning"></i></i>&nbsp;'+item.name+'</span>'
	      			row+='</li>'
      					   
              		   });
              		   
              	   }
        	 }
        	   
        	 
        	  $('#detail_item_'+idPerRoot).html(row);  
        	  checkRoot(idPerRoot);
        	  $(btn).removeAttr("onclick");
        	  $(btn).attr('onClick', 'OnOffRoot2(this);');
        },
        error: function(res){
        	 console.log(res);
               alert(console.log(res)); 
        }       
    }); 
    
    
    
   
}
*/