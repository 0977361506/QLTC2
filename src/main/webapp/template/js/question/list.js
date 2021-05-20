function deleteQuestion(id)
{
    if (confirm("Xác nhận xóa câu hỏi")){
        $.ajax({
            type: "DELETE",
            url: "/api/admin/question/"+id,
            //data: JSON.stringify(data),
            dataType: "json",
           // contentType:"application/json",
            beforeSend:function(){
                $('.loader').css("display","block");
                $('.loader').css("background")
            },
            success: function (response) {
                console.log(response);
                $('.loader').css("display","none");
                alert("Xóa thành công!")
                window.location.reload(true);
            },
            error: function(response){
                console.log("fail");
                alert("Xóa không thành công!") ;
            }
        });
    }
}