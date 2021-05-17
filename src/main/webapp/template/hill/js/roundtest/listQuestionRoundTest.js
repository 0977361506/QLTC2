$('#content_round_test').on('click',function () {
    var idround = $('#id_round_test').val();
    $.ajax({

        url: '/api/admin/roundtest/question/show/'+idround,
        type: 'POST',
        data: JSON.stringify(dataArray),
        dataType: 'json',
        contentType: "application/json",
        success: function (res) {
            var count = '';
            
        },
        error: function (res) {
        }
    });
});