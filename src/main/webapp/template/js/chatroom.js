$('#add-btn').click(function () {
    var formData = $('#add-chatroom-form').serializeArray();
    var data = {};

    $.each(formData, function(key, value) {
        data[value.name] = value.value;
    });
    var userId = [];
    $.each($('input[name=username_id]:checked'),function () {
        userId.push($(this).val());
    });
    data['userId'] = userId;
    // console.log(data);
    $.ajax({
        url : '/api/admin/chatroom',
        type : 'POST',
        contentType : 'application/json',
        data : JSON.stringify(data),
        dataType : 'json',
        success : function(result) {
            location.reload(true);

        },
        error : function(error) {
            console.log(error);
        }
    });
})
$('#remove-btn').click(function () {
    var ids = [];
    $.each($('#remove-chatroom-form input[name="ids"]:checked'),function () {
        ids.push($(this).val()) ;
    }) ;
    var data = {};
    data["ids"] = ids;
    $.ajax({
        url : '/api/admin/chatroom',
        type : 'DELETE',
        contentType : 'application/json',
        data : JSON.stringify(data),
        dataType : 'json',
        success : function(result) {
            location.reload(true);

        },
        error : function(error) {
            location.reload(true);
        }
    });

})