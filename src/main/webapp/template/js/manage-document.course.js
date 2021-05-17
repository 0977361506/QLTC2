function openModel() {
    $('#myModal').modal();
    var data = getData();
    getDocument(data);
    console.log(data);
}

function getData() {
    var data = {};
    var formData = $('#formSearch').serializeArray();
    $.each(formData,function (i,v) {
        data[''+v.name+''] = v.value;
    });

    return data;
}
function getDocument(data) {

    $.ajax({
        type: "PUT",
        url: "/api/admin/document",
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

            loadDocument(response);
        },
        error: function(response){
            console.log("fail");
            console.log(response);
        }
    });

}
function loadDocument(data) {
    $('#documentList').empty();
    $.each(data,function (i,v) {
        var row='';
            row+='<tr>';
                row+='<td>';
                row+='<p>'+v.name+'</p>'
                 row+='<i class="fa fa-building-o icon"></i>';
                    row+=v.poscodeName;
                    row+='</td>';
                    row+='<td>';
                    row+='Tên: '+v.originName;
                    row+='<br>';
                    row+='Loại:<span class="badge badge-info">'+v.type+' </span>';
                    row+='<br>';
                    row+='Người tạo:'+v.createdBy;
                    row+='</td>';
        row+='<td>';
        row+='<a class="btn btn-xs btn-danger" onclick="addDocument('+v.id+')"><i class="fa fa-plus" aria-hidden="true" style="color: white"></i></a>';
        row+='</td>';
       row+=' </tr>';
        $('#documentList').append(row);
    });
}
$(document).ready(function () {
    $('#myModal').on('shown.bs.modal',function () {
        console.log('tét');
        openModel();
    })
});
$('#btnSearch').click(function () {
    var data = getData();
    getDocument(data);

});
function addDocument(idDocument) {
    var data ={}
    var idCourse = $('#courseId').val();
    data['courseId'] = idCourse;
    data['id'] = idDocument;
    $.ajax({
        type: "POST",
        url: "/api/admin/document/course",
        data: JSON.stringify(data),
        dataType: "json",
        contentType:"application/json",
        beforeSend:function(){
            $('.loader').css("display","block");
            $('.loader').css("background")
        },
        success: function (response) {
            console.log(response);
            alert("Thêm thành công")
            $('.loader').css("display","none");
            var data = getData();
            getDocument(data);
        },
        error: function(response){
            alert("Thêm không thành công")
            $('.loader').css("display","none");
            console.log("fail");
            console.log(response);
        }
    });
}
function deleteDocument(idDocument,courseId) {
    var data ={}

    data['courseId'] = courseId;
    data['id'] = idDocument;
    $.ajax({
        type: "DELETE",
        url: "/api/admin/document/course",
        data: JSON.stringify(data),
        dataType: "json",
        contentType:"application/json",
        beforeSend:function(){
            $('.loader').css("display","block");
            $('.loader').css("background")
        },
        success: function (response) {
            console.log(response);
            alert("Xóa thành công");
            window.location.reload(true);
        },
        error: function(response){
            alert("Xóa không thành công")
            $('.loader').css("display","none");
            console.log("fail");
            console.log(response);
        }
    });
}