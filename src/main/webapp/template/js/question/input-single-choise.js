$('#btnEdit').click(function () {
    var data = {};
    var dataAnswer = [];
    var formData = $('#formMultiChoise').serializeArray();
    var formAnswer = $('#formAnswer').serializeArray();
    var answers = [];
    var answersIds = [];

    $.each(formData,function (i,v) {
        data[v.name] = v.value;
    });

    $.each(formAnswer,function (i,v) {
        if (v.name.startsWith("answer"))  {
            answers.push(v.value);
        }
        if (v.name.startsWith("id_"))  {
            answersIds.push(v.value);
        }
    });
    for (var i in answers){
        var answer = {};
        answer['contents'] = answers[i];
        answer['id'] = answersIds[i];
        var check = $("input[name=checkRadio]:checked").val();
        if (check==i){
            answer['answerCode'] =0;
        } else {
            answer['answerCode'] =1;
        }
        dataAnswer.push(answer);
    }

    data['answers'] = dataAnswer;
    data['question'] = CKEDITOR.instances.question.getData();
    data['explain'] = CKEDITOR.instances.explain.getData();

    if (data['question']==''){
        alert("Câu hỏi không được để trống")
        throw "Câu hỏi không được để trống";

    }
    for (var i in answers){
        if (answers[i]==''){
            alert("Đáp án không được để trống")
            throw "Đáp án không được để trống";
        }
    }
    console.log(data);
    if (data.id==''){
        add(data);
    } else if (data.id!='') {
        update(data)
    }
});
$('#btnAddAnswer').click(function () {
    var formData = $('#formAnswer').serializeArray();
    var lenght = 0;
    $.each(formData,function (i,v) {
        if (v.name.startsWith("answer")){
            lenght+=1;
        }
    });

    console.log(formData);
    console.log(lenght);
    var row = '';

    row+='<div class="col-md-6" id="item_'+lenght+'">';
    row+='<label>Đáp án '+(lenght+1)+'</label>';
    row+='<input type="hidden" name="id_'+lenght+'" value="">';
    row+='<input type="radio" name="checkRadio"   id="checkAnswer_'+lenght+'" value="'+lenght+'">';
    row+='<button class="btn btn-icon btn_remove btn-danger" type="button" id="'+lenght+'"\n' +
        '                                            title="xóa"><i class="fa fa-trash-o">Xóa</i></button>';
    row+='<textarea name="answer_'+lenght+'" required class="form-control" rows="3"></textarea>';
    row+='</div>';


    $('#formAnswer').append(row);
});
function add(data) {
    $.ajax({
        type: "POST",
        url: "/api/admin/question",
        data: JSON.stringify(data),
        dataType: "json",
        contentType:"application/json",
        beforeSend:function(){
            $('.loader').css("display","block");
            $('.loader').css("background")
        },
        success: function (response) {
            console.log(response);
            $('.loader').css("display","none");
            alert("Thêm thành công")
            window.location.href="/admin/question/list";
        },
        error: function(response){
            console.log("fail");
            alert("Thêm không thành công") ;
        }
    });
}
function update(data) {
    $.ajax({
        type: "PUT",
        url: "/api/admin/question",
        data: JSON.stringify(data),
        dataType: "json",
        contentType:"application/json",
        beforeSend:function(){
            $('.loader').css("display","block");
            $('.loader').css("background")
        },
        success: function (response) {
            console.log(response);
            $('.loader').css("display","none");
            alert("Cập nhật thành công")
            window.location.href="/admin/question/list";
        },
        error: function(response){
            console.log("fail");
            alert("Cập nhật không thành công") ;
        }
    });
}