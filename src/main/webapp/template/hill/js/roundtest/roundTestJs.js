$(document).ready(function(){
	//var i=$('#sum_group').attr('index_group');
	$('#add').click(function(){
		var i=$('.table_question_group tr').length;
		i++;
		var row='';	 
				row+='<tr  id="row'+i+'">'
				row+='<td>'
				row+='<div class="btn_remove_class_round">'
				row+='<button type="button" name="remove" id="'+i+'" class="btn_small_100_px btn_remove btn btn-block btn-danger btn-sm">Xóa vòng thi</button>'
				row+='</div>'
				row+='<label style="font-size: 14px" >Nhóm câu hỏi số '+i+'</label>'
				row+='<div class="row">'
				row+='<div class="col-md-2">'
				row+='<label style="font-size: 14px" class="label-normal">Phân loại câu hỏi</label>'
				row+='</div>'
				row+='<div class="col-md-10">'
				row+='<div class="type_goup_test">'
				row+='<div class="form_small_round_test">'
				row+='<a onclick="showmodelTypeQuestion(this)" id="id_row_'+i+'" class="label-normal a_round_test">Lựa chọn danh mục&nbsp;<i class="fas fa-edit"></i></a>'
				row+='<input type="hidden" name="name_unit_category[]"  id="id_row_'+i+'id_row_'+i+'" class="form-control name_list" />';
				row+='</div>'
				row+='<div class="form_small_round_test">'
				row+='<div class="form-group">  '
				row+='<select onclick="loadlevell(this)" onchange="onChangeSelect(this)" id="selectLevel'+i+'" class="select_type_groud" >'
				row+='<option selected  disabled="disabled">[Mức độ]</option>'
				row+='<option>option 2</option>'
				row+='<option>option 3</option>'
				row+='<option>option 4</option>'
				row+='<option>option 5</option>'
 				row+='</select>'
				row+='</div>'
				row+='</div>'
				row+='<div class=" form_small_round_test">'
				row+='<div class="form-group"> '

				row+='<select  onclick="loadKindQuestion(this)" onchange="onChangeSelect(this)" id="selectType'+i+'"  class="select_type_groud" >'
				row+='<option selected disabled>[Loại câu hỏi]</option>'
				row+='<option>option 2</option>'
				row+='<option>option 3</option>'
				row+='<option>option 4</option>'
				row+='<option>option 5</option>'
 				row+='</select>'
				row+='</div>'
				row+='</div>'
				row+='<div class="dropdown form_small_round_test">'
				row+='<div class="form-group keyUpinput">'
				row+='<input onmouseover="showlistTags(this)"  onkeyup="searchTagThis(this)"  style="height: 24px; width: 171px; margin-top: 5px;font-size: 15px" type="text"  class="list_tag_show'+i+'" id_input_hiden="list_tag_show'+i+'"   id="exampleInputEmail1" placeholder="[tag]">'
                row+='<input   type="hidden"   id="list_tag_show'+i+'" class="list_tag_show'+i+'list_tag_show'+i+'"  id="idtaghiden" placeholder="[tag]">'
                row+='</div>'
				row+='<div class="dropdown-content_category list_tag_show'+i+'" style="width: 241px;">'
				row+='</div>'
				row+='</div>'
				row+='</div>'			
				row+='</div>'
				row+='</div>'
				row+='<div class="row class_input_count_question'+i+'"  style="display: none">'
				row+='<div class="col-md-2">'
				row+='<label class="label-normal">Số lượng câu hỏi</label>'
				row+='</div>'
				row+='<div class="col-md-10 ">'
				row+='<div class="row">'
				row+='<div class="col-md-2" style="margin-left: 30px;">'
				row+='<div class="form-group keyUpinput">'
				row+='<input min="0" value="0"  name="nameInputQuestion[]" onkeyup="checkNumberMaxQuesstion(this)"     max_value=""  id="countid_row_'+i+'"  style="height: 24px; width: 101px; margin-top: 5px;" type="number" class="form-control"   ">'
				row+='</div>'
				row+='</div>'
				row+='<div class="col-md-6" style="margin-left: 25px;">'
				row+='<div class="form-group keyUpinput">'
				row+='<label  id="textcountid_row_'+i+'" class=" label-normal label_normal_blue " style="color: #3f51b5 !important;">Số lượng câu hỏi lớn nhất có thể là</label>'
				row+='</div>'
				row+='</div>'
				row+='</div>'
				row+='<div class="row" id="textWarning_'+i+'" style="display: none;">'
				row+='<span class="text_warning_size" >Bạn đã nhập quá số lượng câu hỏi tối đa</span>'
				row+='</div>'
				row+='</div>'
				row+='</div>'
				row+='</td>'

				row+='</tr>'
		 
		
		
		$('#dynamic_field').append(row);
		 $('#sum_group').attr('index_group',parseInt($('#sum_group').attr('index_group'))+1)
       $('#sum_group').text('Tổng số nhóm câu hỏi trong đề thi là '+i)
	});
	
	$(document).on('click', '.btn_remove', function(){
		var button_id = $(this).attr("id"); 
		$('#row'+button_id+'').remove();
		var index_now=$('#sum_group').attr('index_group');
		$('#sum_group').attr('index_group',parseInt(index_now)-1);
		 $('#sum_group').text('Tổng số nhóm câu hỏi trong đề thi là '+(parseInt(index_now)-1));
	});
	 
	
	
});


$('#customRadio2').on('click',function(){
	$('.input_time').css('display','block');
	
});
$('#customRadio1').on('click',function(){
	$('.input_time').css('display','none');
	$('#input_time_start').val("");
	$('#input_time_end').val("");
});

$('#customRadio_work_1').on('click',function(){
	$('.label_max_work_round_test').css('display','none');
	
});
$('#customRadio_work_2').on('click',function(){
	$('.label_max_work_round_test').css('display','block');
	
});


$('#result_show_1').on('click',function(){
	$('#id_answer_show').css('display','block');
	
	
});

$('#result_show_2').on('click',function(){
	$('#id_answer_show').css('display','none');
	$('#id_explain_show').css('display','none');
	$('#answer_show_2').prop( "checked", true );
	$('#explain_show_2').prop( "checked", true );
	
});
$('#answer_show_1').on('click',function(){
	$('#id_explain_show').css('display','block');
});
$('#answer_show_2').on('click',function(){
	$('#id_explain_show').css('display','none');
	$('#explain_show_2').prop( "checked", true );
});

$('#select_question_source').on('change', function() {
	
	if($('#select_question_source').val()==1){
		   $('#test_choose').css('display','block');
		   $('#test_kit_choose').css('display','block');
		   $('#struct_test_round').css('display','none');
	}else{
		 $('#test_choose').css('display','none');
		 $('#test_kit_choose').css('display','none');
		 $('#struct_test_round').css('display','block');
 }
	
	

    
});

 function  countQuestion(btn){
 	var id =btn.substring(btn.length-1, btn.length);
 	var dataArray={}
	 if($('#id_row_' + id + 'id_row_' + id).val()!="") {
		 if ($('.list_tag_show' + id).val() != '') {
			 dataArray["id_tag"] = $('.list_tag_show' + id + 'list_tag_show' + id).val();
		 }
		 if ($('#selectLevel' + id).val() != null) {
			 dataArray["id_levell"] = $('#selectLevel' + id).val();
		 }
		 if ($('#id_row_' + id + 'id_row_' + id).val() != null) {
			 dataArray["id_question_category"] = $('#id_row_' + id + 'id_row_' + id).val();
		 }
		 if ($('#selectType' + id).val() != null) {
			 dataArray["id_type_question"] = $('#selectType' + id).val();
		 }


		 $.ajax({
			 url: '/api/admin/question/count',
			 type: 'POST',
			 data: JSON.stringify(dataArray),
			 dataType: 'json',
			 contentType: "application/json",
			 success: function (res) {
				 var count = '';
				 count = res;


				 $('.class_input_count_question' + id).css('display', 'block');
				 //$('.class_input_count_question'+id).remove('style');
				 $('.class_input_count_question' + id).css('display', 'flex');
				 $('#countid_row_' + id).val(count);
				 $('#textcountid_row_' + id).text("Số lượng câu hỏi lớn nhất có thể là " + count);

				 $('#countid_row_' + id).attr('max_value', count);
				 countQuestionRoundTest();
			 },
			 error: function (res) {
			 }
		 });

	 }
 };
function checkNumberMaxQuesstion(btn) {
	var max_value = $(btn).attr('max_value');
	var val_input = $(btn).val();
	var id_hover =  $(btn).attr('id');

	var id =id_hover.substring(id_hover.length-1, id_hover.length);

	if(val_input > max_value){
	    $('#'+id_hover).val(0);
		$('#textWarning_'+id).css('display','block');
	}else{
		$('#textWarning_'+id).css('display','none');
	}
	countQuestionRoundTest();
}
function  countQuestionRoundTest() {

   var arr= $("input[name='nameInputQuestion[]']").map(function(){return $(this).val();}).get();
    var count=0;
    $(arr).each(function (index, item) {
        count= parseInt(count)+ parseInt(item);
    });
    $('#sum_count_question').text("Tổng số câu hỏi trong đề thi là "+count)
	$('#sum_count_question').attr('index_count',count);

}
function loadlevell(btn){

	$.ajax({
		url: '/api/admin/levell/list',
		type: 'POST',
		dataType: 'json',
		success: function (res) {
			var row='<option selected value="0"  disabled="disabled">[Mức độ]</option>';
			$(res).each(function (index, item)  {
				row+='<option value="'+item.id+'">'+item.nameLevell+'</option>'


				$(btn).html(row);

			});
		},
		error: function (res) {
			alert('Có lỗi sảy ra');
		}
	});

	$(btn).removeAttr("onclick");
}

function loadKindQuestion(btn){

	$.ajax({
		url: '/api/admin/typequestion/list',
		type: 'POST',
		dataType: 'json',
		success: function (res) {
			var row='<option selected value="0"  disabled="disabled">[loai câu hỏi]</option>';
			$(res).each(function (index, item)  {
				row+='<option value="'+item.id+'">'+item.nameType+'</option>'


				$(btn).html(row);

			});
		},
		error: function (res) {
			alert('Có lỗi sảy ra');
		}
	});

	$(btn).removeAttr("onclick");

}

function showlistTags(btn) {
    var class_show_list = $(btn).attr('id_input_hiden');
	$.ajax({
		url: '/api/admin/tag/list',
		type: 'POST',
		dataType: 'json',
		success: function (res) {
			var row='';
			$(res).each(function (index, items)  {
				row+='<p onclick="clickTags(this)"  style="text-align: left; "  tag_class="'+class_show_list+'"  name_tag="'+items.name+'" id_tag="'+items.id+'">'+items.name+'</p>';
			});
			$('.'+class_show_list).html(row);
		},
		error: function (res) {
			alert('Có lỗi sảy ra');
		}
	});
};

 function  searchTagThis(btn) {

	 var class_show_list = $(btn).attr('id_input_hiden');
	 var name = $(btn).val();
	 if(name==''){
	 	name = 'all';
	 }
	 $.ajax({
		 url: '/api/admin/tag/search/'+name,
		 type: 'POST',
		 dataType: 'json',
		 success: function (res) {
			 var row='';
			 if(res!=null){

			 $(res).each(function (index, items)  {
				 row+='<p onclick="clickTags(this)"  style="text-align: left; "  tag_class="'+class_show_list+'"  name_tag="'+items.name+'" id_tag="'+items.id+'">'+items.name+'</p>';
			 });
             }
			 $('.'+class_show_list).html(row);

		 },
		 error: function (res) {
			 alert('Có lỗi sảy ra');
		 }
	 });
 }

function clickTags(btn) {
     var class_and_id_input = $(btn).attr('tag_class');
     var name_tag = $(btn).attr('name_tag');
     var id_tag = $(btn).attr('id_tag');
     $('.'+class_and_id_input).val(name_tag);
    $('#'+class_and_id_input).val(id_tag);

	countQuestion(class_and_id_input);

}

function onChangeSelect(btn) {
 	var id = $(btn).attr("id");


	countQuestion(id);
}
function selectTestKits(btn) {
	$.ajax({
		url: '/api/admin/test-kit/list',
		type: 'POST',
		dataType: 'json',
		success: function (res) {
			var row='<option disabled selected="selected" value="0">--Chọn bộ đề--</option>';
			if(res!=null){

				$(res).each(function (index, item)  {

					row+='<option class="selectTestRounds" value="'+item.id+'">'+item.nameTest+'</option>'

				});
			}
			$('#select_list_test_kit_round').html(row);

			$('#select_list_test_kit_round').removeAttr("onclick");


		},
		error: function (res) {
			alert('Có lỗi sảy ra');
		}
	});


};
 $('#select_list_test_kit_round').on('change',function () {
	 selectTestRounds();
 });
 function  selectTestRounds() {
 	var id_test_kit = $('#select_list_test_kit_round').val();
 	if(id_test_kit!=null){
	 $.ajax({
		 url: '/api/admin/test/list/'+id_test_kit,
		 type: 'POST',
		 dataType: 'json',
		 success: function (res) {
			 var row='<option disabled selected="selected" value="0">--Chọn đề thi--</option>';
			 if(res!=null){

				 $(res).each(function (index, item)  {

					 row+='<option value="'+item.id+'">'+item.name+'</option>'

				 });
			 }
			 $('#select_test_round_test').html(row);

			 //$('#select_test_round_test').removeAttr("onclick");
		 },
		 error: function (res) {
			 alert('Có lỗi sảy ra');
		 }
	 })
	}
 }
$('#btn_save_all').on('click',function () {
	var dataArray = {};
	if(validateFormRoundTest() && checkChooseQuestionSource() && checkChooseTimeRound() && checkChooseQuestionSourceValue0()){
		dataArray["nameRound"]=$('#input_name_round_test').val();
		dataArray["describes"]=CKEDITOR.instances.content.getData();
		dataArray["statusRound"]= $('#text_status_round_test').val();
		dataArray["codeRoundTest"]=$('#text_code_round_test').val();
		dataArray["id_unit"]=$('#name_unit').attr('id_unit');

		if($('input[name="customRadio"]:checked').val()=='1'){
			dataArray["timeEnd"]=$('#input_time_start').val();
			dataArray["timeStart"]=$('#input_time_end').val();
		}
		dataArray["timeStart"]=$('#input_time_end').val();
		dataArray["timeRound"]=$('#time_round_test_count').val();
		dataArray["condition_id"]=$('input[name="customRadio_condi"]:checked').val();
		dataArray["giveCertificate"]=$('input[name="customRadio2"]:checked').val();
		dataArray["id_competition"]=$('#input_id_competion').val();

		if($('#select_question_source').val()=='1'){
			dataArray["test_id"] = $("#select_test_round_test").select2('val');
		}
		if($('#rundomRound').is(":checked")){
			dataArray["auto_create_question"] =0;
		}else{
			dataArray["auto_create_question"] =1;
		}


		dataArray["sourceQuestion"] =$('#select_question_source').val();
		dataArray["maxPoint"] =$('#max_point_round_test').val();
		dataArray["minPoint"] =$('#min_point_round_test').val();



		//dataArray["timeRound"]=('#time_round_test_count').val();

		var add = [];
		add.push($('#value_kho_add_id').val());
		add.push($('#value_tb_add_id').val());
		add.push($('#value_de_add_id').val());
		add.push($('#value_rk_add_id').val());

		dataArray["add"]=add;

		var sub = [];
		sub.push($('#value_kho_sub_id').val());
		sub.push($('#value_tb_sub_id').val());
		sub.push($('#value_de_sub_id').val());
		sub.push($('#value_rk_sub_id').val());

		dataArray["sub"]=sub;
		/*if (){

		}*/

		var listStructTest = [];
		var countGroup =$('#sum_group').attr('index_group');
		var listCount = $("input[name='nameInputQuestion[]']").map(function(){if($(this).val()!=0){return $(this).val();}}).get();

		var count = $("input[name='nameInputQuestion[]']").map(function(){if($(this).val()!=0){return $(this).val();}}).get().length;
		for (var i=0 ;i<count;i++){
			listStructTest.push($('.list_tag_show' + i + 'list_tag_show' + i).val());
			listStructTest.push($('#selectLevel' + i).val());
			listStructTest.push($('#id_row_' + i + 'id_row_' + i).val());
			listStructTest.push($('#selectType' + i).val());
			listStructTest.push(listCount[i]);


			/*if ($('.list_tag_show' + id).val() != '') {
				dataArray["id_tag"] = $('.list_tag_show' + id + 'list_tag_show' + id).val();
			}
			if ($('#selectLevel' + id).val() != null) {
				dataArray["id_levell"] = $('#selectLevel' + id).val();
			}
			if ($('#id_row_' + id + 'id_row_' + id).val() != null) {
				dataArray["id_question_category"] = $('#id_row_' + id + 'id_row_' + id).val();
			}
			if ($('#selectType' + id).val() != null) {
				dataArray["id_type_question"] = $('#selectType' + id).val();
			}*/
		}

		dataArray["listStructTest"] = listStructTest;
		dataArray["doAgain"]=$('input[name="customRadio_work"]:checked').val();
		dataArray["maxWork"]=$('#input_max_work_round').val();



		dataArray["mixQuestion"]=$('input[name="question_mix"]:checked').val();
		dataArray["mixAnswer"]= $('input[name="mix_answer"]:checked').val();

		dataArray["showResutl"]=  $('input[name="result_show"]:checked').val();
		dataArray["showAnswer"]=  $('input[name="answer_show"]:checked').val();
		dataArray["showExplain"]=  $('input[name="explain_show"]:checked').val();


		dataArray["fullTickAnswer"]=  $('input[name="all_check"]:checked').val();
		dataArray["id"]=  $('#id_round_test').val();





	$.ajax({
		url: '/api/admin/roundtest/edit',
		type: 'POST',
		data: JSON.stringify(dataArray),
		dataType:'json',
		contentType: "application/json",
		success: function (res) {
			console.log(res);
			alert("Thanh cong");

		},
		error :function (res) {
			console.log(res);
			alert("That bai");
		}
	});
	}


});


 function validateFormRoundTest() {

		 if($('#input_name_round_test').val()==''
			 ||$('#name_unit').attr('id_unit')==''

			 || $('#time_round_test_count').val()==''
			 || $('#max_point_round_test').val()==''
			 || $('#min_point_round_test').val()==''
			  ){

			 if($('#input_name_round_test').val()=='' ){
				 $('#name_check_round').css("display", "block");

			 }else{
				 $('#name_check_round').css("display", "none");

			 }

			 if($('#name_unit').attr('id_unit')==''){
				 $('#unit_check_round').css("display", "block");

			 }else{
				 $('#unit_check_round').css("display", "none");

			 }


			 if($('#time_round_test_count').val()==''){
				 $('#time_check_round').css("display", "block");

			 }else{
				 $('#time_check_round').css("display", "none");

			 }

			 if($('#max_point_round_test').val()==''){
				 $('#max_point_check_round').css("display", "block");

			 }else{
				 $('#max_point_check_round').css("display", "none");

			 }

			 if($('#min_point_round_test').val()==''){
				 $('#min_point_check_round').css("display", "block");
			 }else{
				 $('#min_point_check_round').css("display", "none");

			 }
			 return false;
		 }else {

			 return true;
		 }

		 return false;

 };

 function  checkChooseQuestionSource() {
 	if($('#select_question_source').val()=='1'){
		if($("#select_test_round_test").val() ==null){
			$('#choose_test_one').css("display", "block");
			return false;
		}else{
			$('#choose_test_one').css("display", "none");
			return true;
		}

		return false;
	}

	 return true;

 }


function  checkChooseQuestionSourceValue0() {
	if($('#select_question_source').val()=='0'){
		if($("#sum_count_question").attr('index_count') =='0'){
			$('#check_group_question').css("display", "block");
			return false;
		}else{
			$('#check_group_question').css("display", "none");
			return true;
		}

		return false;
	}

	return true;

}

function  checkChooseTimeRound() {
	if($('input[name="customRadio"]:checked').val()=='1') {
		if ($("#input_time_start").val() == '' || $("#input_time_end").val() == '') {

			if ($("#input_time_start").val() == '') {
				$('#time_start_check_round').css("display", "block");

			} else {
				$('#time_start_check_round').css("display", "none");

			}

			if($("#input_time_end").val() == ''){
				$('#time_end_check_round').css("display", "block");

			}else{
				$('#time_end_check_round').css("display", "none");

			}


			return false;

		}else{
			return true;
		}







		return true;
	}

	return true;

}


