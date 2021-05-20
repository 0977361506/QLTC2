$(document ).ready(function() {
	var dataArray={};
	var number_page = 1;  
	getList(dataArray,number_page);
});



function getList(dataArray,number_page){
	 dataArray["page"]=number_page;
	 dataArray["maxPageItems"]=13;
	 $.ajax({
         url: '/api/admin/competition/list',
         type: 'POST',
         data: JSON.stringify(dataArray),
         dataType:'json',
         contentType: "application/json",
         success: function (res) {
        	 var row = '';
        	 $(res).each(function (i, items) {
			
				row+='<tr>'
					row+='<td>'
					 if (items.statusCompetition == 0){
						 row+='<i class="text-success fa fa-circle"></i>&nbsp'+items.nameCompetition+'<br/>';
					 }
					 else{
						 row+='<i class="text-warning   fa fa-circle"></i>&nbsp;'+items.nameCompetition+'<br/>'; 
					 }
					row+='<i class="fa fa-building-o icon_building"></i>&nbsp'+items.poscodeVnpost.unitVnpost.name;
					row+=' </td>';
					row+='<td>Bob Doe</td>';
					row+='<td>11-7-2014</td>';
					row+='<td>';
					row+='<div class="input-group-prepend">';
					row+='<div   class="label label-info"  data-toggle="dropdown">';
					row+='<i class="fas fa-th icon-th"></i>';
					row+='</div>';
					row+='<ul class="dropdown-menu item-drop-competition">';
					row+='<li class="dropdown-item"><a href="/admin/competition/edit/'+items.id+'"><i class="fas fa-cog"></i>&nbsp;Thiết lập</a></li>';
					row+='<li class="dropdown-item"><a id_competition="'+items.id+'" onclick="removeCompetition(this)" href="#"><i class="far fa-trash-alt"></i>&nbsp;Xóa</a></li>';
					row+=' <li class="dropdown-item"><a href="#"><i class="far fa-chart-bar"></i>&nbsp;Thống kê</a></li>' ;          
					row+='</ul>';
					row+='</div>';
					row+='</td>';
					row+='</tr>';
			

        	 });
        	 
        	 $('#data_list_competition').html(row);
         }
     });
}

function removeCompetition(btn){
	 var idCompe=$(btn).attr('id_competition');
	 var dataArray = [];
	 dataArray.push(idCompe);
	 
	    $.ajax({
	        url: '/api/admin/competition/delete',
	        type: 'DELETE',
	        data: JSON.stringify(dataArray),
	        dataType:'json',
	        contentType: "application/json",
	        success: function (res) { 
	        	if(res){
	        		 alert("Xóa thành công");
	        		 window.location="/admin/competition/list";
	        	}else{
	        		 alert("Hệ thống không cho phép xóa khóa học này"); 
	        	}
	        },
	        error: function(res){
	        	   console.log(res);
	               alert("Xóa thất bại"); 
	        }       
	    }); 
	
}


function showChildRoot(btn) {

    var idPerRoot=$(btn).attr('id_pers_root');
    $.ajax({
        url: '/api/admin/treeunit/'+idPerRoot+'/child',
        type: 'POST',
        dataType: 'json',
        success: function (res) { 
        	 var row='';
        	   $(res).each(function (index, items)  {
        		   row+='<li>'
        		   row+='<span  id_pers_root='+items.id+'  id="id_pers_root_'+items.id+'"   onclick="showChildRoot(this)"  class="carett"><i class="fas fa-home text-warning"></i>&nbsp;'+items.name+'</span>'
         		   row+='<ul id="detail_item_'+items.id+'" class="nested"  >'
        		   
        		   row+='</ul>'
        		   row+='</li>'
        		    
        		   
        	   });
           

        	  $('#detail_item_'+idPerRoot).html(row);  
        	
        	  checkRoot(idPerRoot);
        	  $(btn).removeAttr("onclick");
        	  $(btn).attr('onClick', 'OnOffRoot(this);');
        	  setValueUnit(btn);
        		 
        	
        },
        error: function(res){
        	 console.log(res);
               alert(console.log(res)); 
        }       
    }); 
   
}



