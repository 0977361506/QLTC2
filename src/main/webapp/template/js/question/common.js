jQuery(function ($) {
    $(document).ready(function () {
        $(document).on('click','.btn_remove' , function () {

            if (confirm("Xác nhận xóa")) {
                var button_id = $(this).attr("id");
                $('#item_' + button_id + '').remove();
            }

        });
    })
});


