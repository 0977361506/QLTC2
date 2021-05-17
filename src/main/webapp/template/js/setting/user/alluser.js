$('#disable').click(function () {
    var status = 0;
    updateStatus(status);
});
$('#enable').click(function () {
    var status = 1;
    updateStatus(status);
});

function updateStatus(status) {
    // console.log(status);
    var data = {};
    var ids = [];
    $.each($('input[name=ids]:checked'),function (item,v) {
        ids.push(v.value);
        // console.log();
    });
    data['ids'] = ids;
    data['status'] = status
    // console.log(data);
    $.ajax({
        url : '/api/user/status',
        type : 'PUT',
        contentType : 'application/json',
        data : JSON.stringify(data),
        dataType : 'json',
        success : function(result) {
            location.reload(true);

        },
        error : function(error) {
            console.log(error);
            if (error.status < 300) {
                location.reload(true);
            }
        }
    });
}