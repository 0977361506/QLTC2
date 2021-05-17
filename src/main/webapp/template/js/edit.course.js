$(document).ready(function () {
    var index=0;
    $(document).on('click', '.btn_remove', function(){
        if (confirm("Xác nhận xóa")) {
            var button_id = $(this).attr("id");
            $('#row'+button_id+'').remove();
        }

    });
    $('#btnAddChapter').click(function() {
        var row='';
        index++;
        row+='<tr id="row'+index+'" >';
        row+='<td>'+index+'<input type="hidden" name="id" value=""></td>';
        row+='<td><input class="form-control" name="chapter" value="Chương '+index+'"> </td>';
        row+='<td></td>';
        row+='<td><a class="btn_remove font-blue-steel " id="'+index+'" '
            +'title="xóa"><i class="fa fa-trash-o"></i></a></td> ';
        row+="</tr>";
        $('#listchapter').append(row);
    });
    function changeApproveAuto(){
        var value= $( "#freedomRegister option:selected" ).val();
        console.log(value);
        var element = document.querySelector("#register")
        if(value=="1"){
            element.style.display="block";
        }else if(value=="0"){
            element.style.display="none";
        }
    }
    changeApproveAuto();

})
function changeApproveAuto(){
    var value= $( "#freedomRegister option:selected" ).val();
    console.log(value);
    var element = document.querySelector("#register")
    if(value=="1"){
        element.style.display="block";
    }else if(value=="0"){
        element.style.display="none";
    }
}



$('#start').clockpicker({
    placement: 'top',
    align: 'right',
    autoclose: true,
    'default': '20:48'
});
$('#end').clockpicker({
    placement: 'top',
    align: 'right',
    autoclose: true,
    'default': '20:48'
});
function changeApproveAuto(){
    var value= $( "#freedomRegister option:selected" ).val();
    console.log(value);
    var element = document.querySelector("#register")
    if(value=="1"){
        element.style.display="block";
    }else if(value=="0"){
        element.style.display="none";
    }
}
$('#btnEditCourse').click(function () {
 var data = {};
 var formData = $('#formEdit').serializeArray();
 var formChapter = $('#formChapter').serializeArray();
 var formConfig = $('#formConfig').serializeArray();

 var dataConfig = {};
 var dataChapter = {};

    $.each(formConfig,function (index,v) {

        dataConfig[""+v.name+""] = v.value;
    });
    // dataConfig['startLearning'] = $('#startLearning').val();
    // dataConfig['endLearning'] = $('#endLearning').val();
    // dataConfig['registerStart'] = $('#startRegister').val();
    // dataConfig['registerEnd'] = $('#endRegister').val();


var listChapterName = [];
var listChapterId = [];

    $.each(formChapter,function (index,v) {

        if (v.name=="idChapter"){
            listChapterId.push(v.value);

        }
        else if(v.name =="chapter"){
            listChapterName.push(v.value);
        }else {
            dataChapter[''+v.name+''] = v.value;
        }
        if (v.name=='id'){
            dataChapter['id'] = v.value;
        }


    });
    dataChapter['listChapterId'] = listChapterId;
    dataChapter['listChapterName'] = listChapterName;

    var chapters = [];
    for (var i in listChapterName){
        var chapter = {};
        chapter['name'] = listChapterName[i];
        chapters.push(chapter);
    }
    for (var i in listChapterId){
        chapters[i]['id'] = listChapterId[i];
    }

    dataChapter['chapters'] = chapters;
 $.each(formData,function (index,v) {
     if (v.name=="description"){
         data[""+v.name+""] = CKEDITOR.instances.description.getData();
     } else {
         data[""+v.name+""] = v.value;
     }

 });
dataChapter['id'] = $('#outlineId').val();
 data['courseConfig'] = dataConfig;
 data['outline'] = dataChapter;
 data['avatar'] = $('#Thumb-img-src').val();
 console.log(data);
 var id = $('#id').val();
    if (checkRegister() && checkTimelearn() && checkEndlearning()) {
        if (id==""){
            postCourse(data);
        } else {
            putCourse(data);
        }
    }
});


function postCourse(data) {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/admin/course",
        data: JSON.stringify(data),
        dataType: "json",
        contentType:"application/json",
        success: function (response) {
            console.log("add success");
            alert('Add Success !');
            console.log(response);
            window.location.href="/admin/course/index";
        },
        error: function(response){
            //console.log("fail");
            alert("Add fail !");
            console.log(response);
        }
    });
}
function putCourse(data) {
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/admin/course",
        data: JSON.stringify(data),
        dataType: "json",
        contentType:"application/json",
        success: function (response) {
            console.log("add success");
            alert('Cập nhật thành công!');
            window.location.href="http://localhost:8080/admin/course/index";
        },
        error: function(response){
            console.log("fail");
            alert("Cập nhật không thành công !");
            console.log(response);
        }
    });
}
function checkEndlearning() {
    var end=$('#endLearning').val();
    var start = $('#startLearning').val();
    if (end<start){
        alert("Thời gian bắt đầu khóa học không được lớn hơn thời gian kết thúc ")
        return false;
    } else {
        return true;
    }
}
function checkRegister() {
    var end = $('#endRegister').val();
    var start = $('#startRegister').val();
    var endLearn = $('#endLearning').val();
    if (start>end){
        alert("Thời gian kết thúc đăng ký khóa học không được lớn hơn thời gian bắt đầu đăng ký")
        document.getElementById("endRegister").focus();
        return false;
    } else if (end>endLearn){
        alert("thời gian kết thúc đăng ký không được lớn hơn thời gian kết thúc khóa học");
        document.getElementById("endRegister").focus();

        return false;

    } else {
        return true;
    }
}
function checkTimelearn() {
    var start =$('#start').val();
    var end=$('#end').val();
    if (start>end){
        alert("Thời gian kết thúc buổi học phải lớn hơn thời gian bắt đầu buổi học");
        document.getElementById("end").focus();
        return false;
    } else {
        return true;
    }
}
function deleteCourse(Data) {
    var object={};
    console.log(typeof Data);
    object['id'] = Data;
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/admin/course",
        data: JSON.stringify(object),
        dataType: "json",
        contentType:"application/json",
        success: function (response) {
            console.log("add success");
            alert('Delete Success !');
            console.log(response);
            window.location.href="/admin/course/index";
        },
        error: function(response){
            console.log("fail");
            alert("Delete fail !");
            console.log(response);
        }
    });

}