function showChildRoot(btn) {

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
        		   row+='<span  id_pers_root='+items.id+'  id="id_pers_root_'+items.id+'"   onclick="showChildRoot(this)"  class="carett"><i class="fas fa-home text-warning"></i>&nbsp;'+items.name+'</span>'
         		   row+='<ul id="detail_item_'+items.id+'" class="nested"  >'
         		 
         		   row+='</ul>'	   
        		   row+='</ul>'
        		   row+='</li>'
        	   });
        	   
        	   
      		  if(res.lisPoscodeVnposts!=null){
              	 $(res.lisPoscodeVnposts).each(function (index, item)  {
              		row+='<li style="cursor:pointer;">'	 
	      			row+='<span  id_poscode_root='+item.id+'  id="id_poscode_root_'+item.id+'"   onclick="showPoscodeRoot(this)"  ><i class="far fa-dot-circle"></i>&nbsp;<i class="fas fa-campground  text-warning"></i></i>&nbsp;'+item.name+'</span>'
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
/*
function showChildRootCategoryQuestion(btn) {

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
					row+='<span  id_pers_root='+items.id+'  id="id_pers_root_'+items.id+'"   onclick="showChildRoot(this)"  class="carett"><i class="fas fa-home text-warning"></i>&nbsp;'+items.name+'</span>'
					row+='<ul id="detail_item_'+items.id+'" class="nested"  >'

					row+='</ul>'
					row+='</ul>'
					row+='</li>'
				});


				if(res.lisPoscodeVnposts!=null){
					$(res.lisPoscodeVnposts).each(function (index, item)  {
						row+='<li style="cursor:pointer;">'
						row+='<span  id_poscode_root='+item.id+'  id="id_poscode_root_'+item.id+'"   onclick="showPoscodeRoot(this)"  ><i class="far fa-dot-circle"></i>&nbsp;<i class="fas fa-campground  text-warning"></i></i>&nbsp;'+item.name+'</span>'
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
