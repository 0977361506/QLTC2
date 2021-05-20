$('#btnEdit').click(function () {
   var data = {};
   var dataAnser=[];

   var formData = $('#formTrueFalse').serializeArray();
   var formAnswer = $('#formAnswer').serializeArray();
   $.each(formData,function (i,v) {
       data[v.name] = v.value;
   });

   var answers = [];
    $.each(formAnswer,function (i,v) {
        if (v.name.startsWith("answer")){
            answers.push(v.value);
        }
    });
    for (var i in answers){
        var answer = {};
        answer['contents'] = answers[i];
        var check = $("input[name=checkRadio]:checked").val();
        if (check==i){
            answer['answerCode'] =0;
        } else {
            answer['answerCode'] =1;
        }
        dataAnser.push(answer);
    }
    data['answers'] = dataAnser;
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