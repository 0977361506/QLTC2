
function OnOffRootCategoryQuestion(btn){

    var id = $(btn).attr('id_pers_root');

    //alert('clear');
    setValueUnitCategoryQuestion(btn);

    checkRootCategoryQuestion(id);

}

function OnOffRoot2CategoryQuestion(btn){

    var id = $(btn).attr('id_pers_root');

    //alert('clear');


    checkRootCategoryQuestion(id);

}
function checkRootCategoryQuestion(id){
    if( $('#detail_item_CategoryQuestion'+id).hasClass('activee')){
        $('#detail_item_CategoryQuestion'+id).removeClass('activee');


    }else{
        $('#detail_item_CategoryQuestion'+id).addClass('activee');

    }

}

function  getCategoryByUnit(idPerRoot) {
    $.ajax({
        url: '/api/admin/questioncategory/'+idPerRoot,
        type: 'POST',
        dataType: 'json',
        success: function (res) {
            row=' <option disabled selected="selected" value="0">[Chọn thư mục]</option>';
            if (res !=null){
            $(res).each(function (index, items) {
                row+='<option   value="'+items.id+'">'+items.nameCategory+'</option>';
            });



            }
            $('#select_question_category').html(row);


        },
        error: function(res){
            console.log(res);
            alert(console.log(res));
        }
});

}


function OnOffChildCategoryQuestion(btn){
    // alert('clear');
    var id = $(btn).attr('id_detail_pers_root');
    checkChild(id);

}

function checkChildCategoryQuestion(id){
    if( $('#action_item_CategoryQuestion'+id).hasClass('activee')){
        $('#action_item_CategoryQuestion'+id).removeClass('activee');

    }else{
        $('#action_item_CategoryQuestion'+id).addClass('activee');
    }
}

function showPoscodeRootCategoryQuestion(btn){

    var id = $(btn).attr('id_poscode_root');
    getCategoryByUnit(id);
    var name = $(btn).text();
    $('#name_unitCategoryQuestion').attr("id_unitCategoryQuestion",id);
    $('#name_positionCategoryQuestion').val(name);
    $('#name_unit_formCategoryQuestion').text(name);
}

function setValueUnitCategoryQuestion(btn) {
    var id = $(btn).attr('id_pers_root');
    var name = $(btn).text();
    $('#name_unitCategoryQuestion').attr("id_unitCategoryQuestion",id);
    $('#name_positionCategoryQuestion').val(name);
    $('#name_unit_formCategoryQuestion').text(name);
}