var aphabet=["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"];
var sub=[];
$('#btnAddAnswer').click(function () {
    console.log("check");

    var formData = $('#formAnswer').serializeArray();
    var lenght = 0;
    $.each(formData,function (i,v) {
        if (v.name.startsWith("id")){
            lenght+=1;
        }
    });
    var row='';
    row+='<div id="item_answer_'+lenght+'" class="input-group mb-2">';
        row+='<input type="hidden" name="id">';
        row+='<div class="input-group-prepend">';
        row+='<span class="input-group-text">';
        row+='<input name="answer" class="input-group-text" style="width: 40px;text-align: center;pointer-events: none;" value="'+aphabet[lenght]+'">';
        row+='</span>';
    row+='<span class="input-group-text">';
    row+='<input  name="answer_code" class="" value="1" style="width: 35px;text-align: right;height: 22px;" min="1" type="number">';
    row+='</span>';
        row+='</div>';
        row+='<textarea  type="text" name="contents" class="form-control" value=""></textarea>';

    row+='</div>';


   $('#formAnswer').append(row);
   console.log('check');
});

$('#btnAddQuestion').click(function () {
    var formData = $('#formQuestion').serializeArray();
    var lenght = 0;
    $.each(formData,function (i,v) {
        if (v.name.startsWith("id")){
            lenght+=1;
        }
    });

    var row='';
        row+='<div class="input-group mb-2" id="item_question_'+lenght+'">';
        row+='<input type="hidden" name="id">';
        row+='<input type="hidden" name="answer_code" value="'+(lenght+1)+'">';
        row+='<div class="input-group-prepend">';
        row+='<span class="input-group-text">'+(lenght+1)+'</span>';
        row+='</div>'
        row+='<textarea  name="contents" rows="2" cols="10"  class="form-control"></textarea>'

    row+='</div>';
    $('#formQuestion').append(row);
});


function removeAnswer(id){
    var formData = $('#formAnswer').serializeArray();
    var lenght = 0;
    if (formData.length==0){
        alert("Không có câu trả lời để xóa");
        throw "Không có trường để xóa";
    }
    $.each(formData,function (i,v) {
        if (v.name.startsWith("id")){
            lenght+=1;
        }
    });
    if (lenght>0){
        lenght-=1;
    }
        if (confirm("Xác nhận xóa")) {

            $('#item_answer_'+lenght).remove();

        }



}
function deleteAll() {
    $('#formAnswer').empty();
    aphabet=["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"];
    sub=[];
    $('#formQuestion').empty();
}
function removeQuestion(id){
    var formData = $('#formQuestion').serializeArray();
    if (formData.length==0){
        alert("Không có câu hỏi để xóa");
        throw "Không có trường để xóa";
    }
    var lenght = 0;
    $.each(formData,function (i,v) {
        if (v.name.startsWith("id")){
            lenght+=1;
        }
    });
    if (lenght>0){
        lenght-=1;
    }
    if (confirm("Xác nhận xóa")) {

        $('#item_question_'+lenght).remove();
    }
}
$('#btnEdit').click(function () {
   var data = {};

   var formData= $('#formMatching').serializeArray();
   var formAnswer = $('#formAnswer').serializeArray();
   var formQuestion = $('#formQuestion').serializeArray();

    var answers = [];
   var contentAnswers = [];
   var idAnswer = [];
   var answerCode = [];
   var answerValue = [];


   var idQuestion = [];
   var questionCode=[];
    var contentQuestions = [];


   $.each(formAnswer,function (i,v) {
       if (v.name=='contents'){
           contentAnswers.push(v.value);
       }
       if (v.name == 'id'){
           idAnswer.push(v.value);
       }
       if (v.name=='answer_code'){
           answerCode.push(v.value);
       }
       if (v.name=='answer'){
           answerValue.push(v.value);
       }
   });
   for (var i in contentAnswers){
       var answerItem = {};
       answerItem['contents'] = contentAnswers[i];
       answerItem['id'] = idAnswer[i];
       answerItem['answerCode']=answerCode[i];
       answerItem['answer'] = answerValue[i];
       answers.push(answerItem);
   }

    $.each(formQuestion,function (i,v) {
        if (v.name=='contents'){
            contentQuestions.push(v.value);
        }
        if (v.name=='id'){
            idQuestion.push(v.value);
        }
        if (v.name=='answer_code'){
            questionCode.push(v.value);
        }
    });
    for (var i in contentQuestions){
        var questionItem = {};
        questionItem['id'] = idQuestion[i];
        questionItem['answerCode'] = questionCode[i];
        questionItem['contents'] = contentQuestions[i];
        answers.push(questionItem);
    }



   $.each(formData,function (i,v) {
       data[v.name] = v.value;
   });
    data['question'] = CKEDITOR.instances.question.getData();
    data['explain'] = CKEDITOR.instances.explain.getData();
    data['answers'] = answers;
    if (data['question']==''){
        alert("Câu hỏi không được để trống")
        throw "Câu hỏi không được để trống";

    }
    for (var i in contentAnswers){
        if (contentAnswers[i]==''){
            alert("Đáp án không được để trống")
            throw "Đáp án không được để trống";
        }
    }
    for (var i in contentQuestions){
        if (contentQuestions[i]==''){
            alert("Câu hỏi không được để trống")
            throw "Câu hỏi không được để trống";
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


