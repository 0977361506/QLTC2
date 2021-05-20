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
function enable(courseId) {
    var ids = [];
    ids = getIds();
    if (ids.length==0){
        alert("Chưa người dùng nào được chọn");
    }else {
        var data = {};
        data['ids'] = ids;
        data['courseId'] = courseId;
        $.ajax({
            type: "PUT",
            url: "/api/admin/courseJoin/enable",
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
function disable(courseId) {
    var ids = [];
    ids = getIds();
    if (ids.length==0){
        alert("Chưa người dùng nào được chọn");
    }else {
        var data = {};
        data['ids'] = ids;
        data['courseId'] = courseId;
        $.ajax({
            type: "PUT",
            url: "/api/admin/courseJoin/disable",
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
function deleteUser(courseId) {
    var ids = [];
    ids = getIds();
    if (ids.length==0){
        alert("Chưa người dùng nào được chọn");
    }else {
        if (confirm("Xác nhận xóa")){
            var data = {};
            data['ids'] = ids;
            data['courseId'] = courseId;
            $.ajax({
                type: "DELETE",
                url: "/api/admin/courseJoin",
                data: JSON.stringify(data),
                dataType: "json",
                contentType: "application/json",
                beforeSend: function () {

                },
                success: function (response) {
                    console.log(response);

                    alert("Xóa thành công")
                    window.location.reload(true);
                },
                error: function (response) {
                    console.log("fail");
                    alert("Xóa không thành công");
                }
            });
        }
    }
}
