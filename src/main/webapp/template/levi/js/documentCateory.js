
function postCourse(data) {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/admin/document/list",
        data: JSON.stringify(data),
        dataType: "json",
        contentType:"application/json",
        success: function (response) {
            console.log("add success");
            alert("add success");
            console.log(response);
            window.location.href="/admin/document/list";
           // alert('Add Success !');

        },
        error: function(response){
            console.log("fail");
            alert("Add fail !");
          //  console.log(response);
        }
    });
}

function editCategory(){
    var data = {};
    var formData = $('#formEdit').serializeArray();
    console.log(formData);
    $.each(formData,function (i,v) {
        data[""+v.name+""]=v.value;
    });
    console.log(data);
    var id = $('#id').val();
    if(id==""){
        postCourse(data);
    }else{

    }
}

