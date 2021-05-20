function postDocument(dataArray) {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/api/admin/document/category/create',
        data: JSON.stringify(dataArray),
        dataType: 'JSON',
        contentType: 'application/json',
        success: function (response) {
            console.log('Thêm mới thành công');
            alert('add success');
            console.log(response);
            window.location.href = 'http://localhost:8080/admin/document/category';
        },
        error: function (response) {
            console.log("thaats bai");
            alert("add fail");
            console.log(response);

        }
    });
    // $.ajax({
    //     url: '/api/admin/document/category/create',
    //     type: 'POST',
    //     dataType: 'json',
    //     contentType: 'application/json',
    //     data: JSON.stringify(dataArray),
    //     success: function (res) {
    //         $('#input_id_competition').val(res.id);
    //         alert('Thêm thành công');
    //         showRoundTest(res.id);
    //     },
    //     error: function (res) {
    //         alert('Có lỗi sảy ra');
    //     }
    // });

}

function editDocument(){


    var dataArray = {};
    var values = [];

    dataArray["name"] = $('#input_name_document').val();
    //  dataArray["id_unit"] = $('#name_unit').attr('id_unit');
  //  dataArray["limitDocument"] = $('#select_limit_document').val();
    dataArray["status"] = $('#input_status_document').val();
  //  dataArray["prioritize"] = $('#select_prioritize').val();
  //  dataArray["documentCategory"] = $('#select_document_category').val();
    dataArray["shares"] = $('#select_share_document').val();


    postDocument(dataArray);

}
;
