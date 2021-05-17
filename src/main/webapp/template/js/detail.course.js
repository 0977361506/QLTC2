function loadUserJoin(courseId){
    var data={};
    data['courseId'] = courseId;
    $.ajax({
        type: "PUT",
        url: "/api/admin/courseJoin",
        data: JSON.stringify(data),
        dataType: "json",
        contentType: "application/json",
        beforeSend:function(){
            $('.loader').css("display","block");
        },
        success: function (response) {
            console.log(response);
            getUserJoin(response,courseId);
            $('.loader').css("display","none");
        },
        error: function (response) {
            console.log(response);
            $('.loader').css("display","none");
        }
    });

}
function getUserJoin(data,courseId) {
    $('#tableUserJoin').empty();
    $.each(data,function (i,v) {
        var status = '';
        if (v.status==0){
            status +='<span class="badge badge-warning">Khóa</span>';
        } else {
            status+='<span class="badge badge-success">Đã duyệt</span>';
        }
        var process = '';
        switch (v.join) {
            case 0:
                process+='<span class="badge badge-danger"><i class="fa fa-warning"></i>Chưa học</span>';
                break;
            case 1:
                process+='<span class="badge badge-warning">Chưa đạt</span>';
                break;
            case 2:
                process+='<span class="badge badge-success">Đạt</span>';
                break;
        }
       var row='';
    row+='<tr>';
        row+='<td>'+(i+1)+'</td>';
        row+='<td>'+v.user.username+'</td>';
        row+='<td>'+v.user.fullName+'</td>';
        row+='<td>';
        row+=status;
        row+='</td>';
        row+='<td>';
        row+=process;
        // row+='</td>';
        // row+='<td><a href="/admin/courseJoin/progress/'+courseId+'/'+v.user.id+'" class=" badge badge-success "><i class="fa fa-eye"></i>chi tiết</a></td>';
        // row+='</tr>';
       $('#tableUserJoin').append(row);
    });
}