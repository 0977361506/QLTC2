$('#checkAll').click(function () {
    if($(this).is(':checked')) {

        $('#userList').find('input[type=checkbox]'). prop("checked", true);
        console.log($('#orderList').find('input[type=checkbox]'));
    }else {
        $('#userList').find('input[type=checkbox]').prop("checked",false);
    }

});
function getIds() {
    var ids = [];
    $('#userList').find('input[type=checkbox]:checked').each(function () {
        // console.log();
        ids.push($(this).val())
    });

    return ids;
}
function enable() {
    var ids = [];
    ids = getIds();
    if (ids.length==0){
        alert("Chưa người dùng nào được chọn");
    }else {
        var data = {};
        data['ids'] = ids;

        $.ajax({
            type: "PUT",
            url: "/api/admin/courseMember/managerUser/enable",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            beforeSend: function () {

            },
            success: function (response) {
                console.log(response);

                alert("Duyệt thành công")
                window.location.reload(true);
            },
            error: function (response) {
                console.log("fail");
                alert("Duyệt không thành công");
            }
        });
    }
}
function disable() {
    var ids = [];
    ids = getIds();
    if (ids.length==0){
        alert("Chưa người dùng nào được chọn");
    }else {
        var data = {};
        data['ids'] = ids;

        $.ajax({
            type: "PUT",
            url: "/api/admin/courseMember/managerUser/disable",
            data: JSON.stringify(data),
            dataType: "json",
            contentType: "application/json",
            beforeSend: function () {

            },
            success: function (response) {
                console.log(response);

                alert("Khóa thành công")
                window.location.reload(true);
            },
            error: function (response) {
                console.log("fail");
                alert("Khóa không thành công");
            }
        });
    }
}
function deleteUser() {

    var ids = [];
    ids = getIds();
    if (ids.length==0){
        alert("Chưa người dùng nào được chọn");
    }else {
        if (confirm("Xác nhận xóa")){
            var data = {};
            data['ids'] = ids;

            $.ajax({
                type: "DELETE",
                url: "/api/admin/courseMember/managerUser",
                data: JSON.stringify(data),
                dataType: "json",
                contentType:"application/json",
                beforeSend:function(){

                },
                success: function (response) {
                    console.log(response);
                    window.location.reload(true);
                    alert("Xóa thành công")

                },
                error: function(response){
                    console.log("fail");
                    alert("Xóa không thành công") ;
                }
            });
        }

    }
}
$('#btnSearch').click(function () {
    var data= getData();
    search(data);
});
function getData() {
    var data ={};
    var formData= $('#formSearch').serializeArray();
    $.each(formData,function (i,v) {
        data[''+v.name+''] = v.value;
    });
    return data;
}
function openModal() {
    var data = getData();
    search(data);
}
function search(data) {
    $.ajax({
        type: "PUT",
        url: "/api/user/manager-user-course",
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
            $('#users').append('Không tìm thấy tài khoản')
            $('.loader').css("display","none");
        }
    });
}
function loadData(data) {

    $('#users').empty();

    $.each(data,function (i,v) {
        var row='';
        row+='<tr role="row" id="'+v.id+'">';
        row+='<td>'+v.fullName;
        row+='</td>';
        row+='<td>';
        row+=v.username;
        row+='</td>';
        row+='<td>' ;
        row+='<a class="btn btn-xs btn-danger" onclick="addUser('+v.id+')"><i class="fa fa-plus" aria-hidden="true" style="color: white"></i></a>';
        row+='</td>';
        row+='</tr>';
        $('#users').append(row);

    });
}
function addUser(idUser) {
    var idCourse= $('#courseId').val();
    var idRole = $('#roleId').val();
    var data= {};
    data['courseId'] = idCourse;
    data['roleId'] = idRole;
    data['userId'] = idUser;
    $.ajax({
        type: "POST",
        url: "/api/admin/courseMember/managerUser",
        data: JSON.stringify(data),
        dataType: "json",
        contentType:"application/json",
        beforeSend:function(){
            $('.loader').css("display","block");
        },
        success: function (response) {
            console.log(response);

            $('.loader').css("display","none");
        },
        error: function(response){
            console.log("fail");
            console.log(response);
            alert("Thêm không thành công")
            $('.loader').css("display","none");
        }
    });
}
function update(data) {
    $.ajax({
        type: "PUT",
        url: "/api/admin/courseMember/managerUser",
        data: JSON.stringify(data),
        dataType: "json",
        contentType:"application/json",
        beforeSend:function(){
            $('.loader').css("display","block");
        },
        success: function (response) {
            console.log(response);

            $('.loader').css("display","none");
        },
        error: function(response){
            console.log("fail");
            console.log(response);

            $('.loader').css("display","none");
        }
    });
}
function openModalUpdate(id){
    $('#modalUpdate').modal();
    findById(id);

}
$('#btnEdit').click(function () {
    var data= {};
    var formData = $('#formEdit').serializeArray();
    $.each(formData,function (i,v) {
        data[''+v.name+''] = v.value;
    });
    data['id'] = $('#id').val();
    console.log(data);
    update(data);

});
function findById(id) {
    $.ajax({
        type: "GET",
        url: "/api/admin/courseMember/managerUser/"+id,
        contentType:"application/json",
        beforeSend:function(){

        },
        success: function (response) {
            $('#id').val(response.id);
            $('#score').val(response.score);
            $('#evaluate').val(response.evaluate);
        },
        error: function(response){
            console.log("fail");
            console.log(response);
        }
    });
}
