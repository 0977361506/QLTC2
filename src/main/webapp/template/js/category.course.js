function loadCatgory(id) {
    $('#btnEditCourse').val("Cập nhật");


    var data={};
    data['id'] = id;
    var category={};
    console.log(data)
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/admin/courseCategory/detail/"+id,
        // data: JSON.stringify(data),
        // dataType: "json",
        contentType:"application/json",
        success: function (category) {

            $('#id2').val(category.id);
            $('#name2').val(category.name);
            $('#description2').val(category.description);

        },
        error: function(response){
            console.log("fail");
            console.log(response);
        }
    });


}
function reset() {
    var category={};
    $('#id2').val(category.id);
    $('#name2').val(category.name);
    $('#description2').val(category.description);
}
function edit() {
    var data = {};
    var id = $('#id2').val();
    var formEdit = $('#formEdit').serializeArray();
    $.each(formEdit,function (index,v) {
        data[""+v.name+""] = v.value;
    });
    if (id==""){
        post(data);
    } else {
        put(data);
    }
};
function deleteCategory() {
    var data = {};
    var staffs =$('#categoryList').find('tbody input[type=checkbox]:checked').map(function () {
        return $(this).val();
    }).get();
    data['ids'] = staffs;
    del(data);
}
function post(data) {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/admin/courseCategory",
         data: JSON.stringify(data),
         dataType: "json",
        contentType:"application/json",
        success: function (category) {
        alert("Add success!");
            window.location.href="http://localhost:8080/admin/courseCategory";

        },
        error: function(response){
           alert("Add fail!");
        }
    });

};
function put(data) {
    $.ajax({
        type: "PUT",
        url: "http://localhost:8080/api/admin/courseCategory",
        data: JSON.stringify(data),
        dataType: "json",
        contentType:"application/json",
        success: function (category) {
            alert("Update success!");
            window.location.href="http://localhost:8080/admin/courseCategory";

        },
        error: function(response){
            alert("Update fail!");
        }
    });

};
function del(data) {
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/admin/courseCategory",
        data: JSON.stringify(data),
        dataType: "json",
        contentType:"application/json",
        success: function (category) {
            alert("Delete success!");
            window.location.href="http://localhost:8080/admin/courseCategory";
        },
        error: function(response){
            alert("Delete fail!");
        }
    });
}