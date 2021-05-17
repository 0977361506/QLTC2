function openAddCourseWare(){
    openModalCourseWare();
    var data = getData();
    getChapter(data);


}
function openAddPowerPoint() {

    $('#modalPowerPoint').modal();
}
function openModalCourseWare(){
    $('#myModal').modal();

}

function getData() {
    var data={};
    var formData = $('#formSearch').serializeArray();
    $.each(formData,function (index,v) {
        data[""+v.name+""] = v.value;
    });
    //console.log(data);
    return data;
}
$('#btnSearch').click(function () {
    var data = getData();
    getChapter(data);

});
function getChapter(data) {

    $.ajax({
        type: "PUT",
        url: "/api/admin/courseWare",
        data: JSON.stringify(data),
        dataType: "json",
        contentType:"application/json",
        beforeSend:function(){
            $('.loader').css("display","block");
        },
        success: function (response) {
            console.log(response);
            loadData(response);
            $('.loader').css("display","none");

        },
        error: function(response){
            console.log("fail");
            console.log(response);

        }
    });
}
function loadData(data) {

    $('#courseWareList').empty();
    $.each(data,function (i,v) {
        var createdDate = new Date(v.createdDate);
        var row= '';
        var type= '';
        var code = v.courseWareType.code;
        switch (code) {
            case 'homework':
                type='<i class="lesson homework"></i>';
                break;
            case 'scorm':
                type='<i class="lesson scorm"></i>';
                break;
            case 'freedomlecture':
                type='<i class="lesson freedom"></i>';
                break;
            case 'powerpoint':
                type='<i class="lesson powerpoint"></i>';
                break;
            case 'video':
                type='<i class="lesson video"></i>';
                break;
            case 'interactive':
                type='<i class="lesson interactive"></i>';
                break;
            default:
                type = '<i class="lesson homework"></i>';
                break;
        }
        row+='<tr role="row" id="'+v.id+'">';
        row+='<td>'+v.name;
        row+='<p class="text_info font-blue-steel">';
        row+='<i class="fa fa-building-o icon"></i>';
        row+=v.poscodeVnpost.name;
        row+='</p>';
        row+='</td>';
        row+=type;
        row+='<td>';
        row+=type;
        row+='</td>';
        row+='<td>'
        row+='Ngày tạo:'+createdDate.toLocaleTimeString()+' '+ createdDate.toLocaleDateString();
        row+='<br>';
        row+='Người tạo:'+v.createdBy;
        row+='</td>';

        row+='<td>' ;
        row+='<a class="btn btn-xs btn-danger" onclick="addCourseWare('+v.id+')"><i class="fa fa-plus" aria-hidden="true" style="color: white"></i></a>';
        row+='</td>';
        row+='</tr>';
        $('#courseWareList').append(row);

    });
}
function addCourseWare(idCoursWare) {
    var id = idCoursWare;
    var courseId = $('#courseId').val();
    var chapterId = $('#chapterId').val();
    var data ={};
    data['courseWareId'] = idCoursWare;
    data['chapterId'] = chapterId;
    data['courseId'] = courseId;
    add(data);

}
function add(data) {
    $.ajax({
        type: "POST",
        url: "/api/admin/chapterCourseWare",
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
            var data = getData();
            getChapter(data);
        },
        error: function(response){
            console.log("fail");
            alert("Thêm không thành công") ;
        }
    });
}
$('.up,.down').click(function () {
    var row = $(this).parents('tr:first');

    if ($(this).is('.up')) {
        $('#btnSavePosition').removeClass("disabled");
        row.insertBefore(row.prev());

    }
    else {
        $('#btnSavePosition').removeClass("disabled");
        row.insertAfter(row.next());

    }

});

function savePosition(chapterId) {
    if (!$('#btnSavePosition').hasClass("disabled")){
        var ids = [];
        var data = {};
        data['chapterId'] = chapterId;
        $('#listCourseWare').find('tr').each(function () {
            // console.log();
            ids.push($(this).attr("id"));
        });
        data['ids'] = ids;
        $.ajax({
            type: "PUT",
            url: "/api/admin/chapterCourseWare",
            data: JSON.stringify(data),
            dataType: "json",
            contentType:"application/json",
            beforeSend:function(){

            },
            success: function (response) {
                console.log(response);
                alert("Lưu vị trí thành công");
                window.location.reload(true) ;
            },
            error: function(response){
                console.log("fail");
                console.log(response);
                alert("Lưu vị trí không thành công");
            }
        });
    }

}
function menuFunction(btn) {
    var id = $(btn).attr("idItem");
}
function deleteCourseWare(btn,chapterId) {
    if (confirm("Xác nhận xóa học liệu")){
        var id = $(btn).attr("idItem");
        var data ={};
        data['courseWareId'] = id;
        data['chapterId'] = chapterId;

        $.ajax({
            type: "DELETE",
            url: "/api/admin/chapterCourseWare",
            data: JSON.stringify(data),
            dataType: "json",
            contentType:"application/json",
            beforeSend:function(){

            },
            success: function (response) {
                console.log(response);
                alert("Xóa thành công");
                window.location.reload(true);
            },
            error: function(response){
                console.log("fail");
                console.log(response);

            }
        });
    }

}