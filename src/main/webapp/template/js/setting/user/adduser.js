// function loadImg(event) {
//     var imageFile = event.target.files[0];
//     console.log('originalFile instanceof Blob', imageFile instanceof Blob); // true
//     console.log(`originalFile size ${imageFile.size / 1024 / 1024} MB`);
//
//     var options = {
//         maxSizeMB: 1,
//         maxWidthOrHeight: 1920,
//         useWebWorker: true
//     }
//     imageCompression(imageFile, options)
//         .then(function (compressedFile) {
//             console.log('compressedFile instanceof Blob', compressedFile instanceof Blob); // true
//             console.log(`compressedFile size ${compressedFile.size / 1024 / 1024} MB`); // smaller than maxSizeMB
//
//             return blobToBase64(compressedFile); // write your own logic
//         })
//         .catch(function (error) {
//             console.log(error.message);
//         });
// }
// function blobToBase64(compressedFile) {
//     var reader = new FileReader();
//     reader.onload = function() {
//         var dataUrl = reader.result;
//         var base64 = dataUrl.split(',')[1];
//         base64 = 'data:image/jpeg;base64,' + base64;
//         // console.log(base64);
//         $('#Thumb-img').attr("src",base64);
//         $('#Thumb-img-src').val(base64);
//     };
//     reader.readAsDataURL(compressedFile);
// }
$('#add-user-form').on('submit',function (e) {
    var formdata = $(this).serializeArray();
    var data = {};
    console.log(formdata);
    $.each(formdata,function (i,v) {
        data[v['name']] = v['value'];
    })
    data['status'] = "1";
    // console.log(data);
    $.ajax({
        url : '/api/user',
        type : 'POST',
        contentType : 'application/json',
        data : JSON.stringify(data),
        dataType : 'json',
        success : function(result) {
            // console.log(result);
            window.location.href = "/admin/setting/user";
        },
        error : function(jqXHR, textStatus, errorThrown) {
            console.log( 'The following error occured: ' + textStatus, errorThrown );
        }
    });
    e.preventDefault();
})
$('#provine').on('change',function () {

    if($(this).val() != '') {
        $.ajax({
            url : '/api/district?provine-id='+$(this).val(),
            type : 'GET',
            contentType : 'application/json',
            // data : JSON.stringify($(this).val()),
            dataType : 'json',
            success : function(result) {
                // console.log(result);
                var str = '';
                $.each(result, function (i,v) {
                    str += '<option value="'+v['id']+'">'+v['name']+'</option>';
                });
                $('#district').html(str);
                // console.log(result[0]['id']);
                updateWard(result[0]['id'])
            },
            error : function(jqXHR, textStatus, errorThrown) {
                console.log( 'The following error occured: ' + textStatus, errorThrown );
            }
        });
    }

})
function updateWard(districtId) {
    if (districtId != '') {
        $.ajax({
            url: '/api/ward?district-id=' + districtId,
            type: 'GET',
            contentType: 'application/json',
            // data : JSON.stringify($(this).val()),
            dataType: 'json',
            success: function (result) {
                // console.log(result);
                var str = '';
                $.each(result, function (i, v) {
                    str += '<option value="' + v['id'] + '">' + v['name'] + '</option>';
                });
                $('#ward').html(str);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log('The following error occured: ' + textStatus, errorThrown);
            }
        });
    }
}

$('#Thumb-input').on('change',function () {
    var formData = new FormData();
    formData.append('image', $('#Thumb-input')[0].files[0]);
    $.ajax({
        url : '/api/user/image',
        type : 'POST',
        enctype: 'multipart/form-data',
        data : formData,
        processData: false,  // Important!
        contentType: false,
        cache: false,
        success : function(result) {
            // console.log(result);
            console.log(result);
            $('#Thumb-img').attr("src",result);
            $('#Thumb-img-src').val(result);
        },
        error : function(jqXHR, textStatus, errorThrown) {
            console.log( 'The following error occured: ' + textStatus, errorThrown );
        }
    });
});