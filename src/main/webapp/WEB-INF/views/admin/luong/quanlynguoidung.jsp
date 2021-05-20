<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8"%>
<div class="content-wrapper">
   <div class="py-2 px-2">
      <h4 class="page-title">
         <b>Quản lý người dùng</b>
      </h4>
   </div>
   <div class="row">
      <div class="col col-sm-5">
         <div class="row">
                    <div class=" col col-sm-6 d-flex add-on">
                                  <input name="key" id="key" class="form-control " placeholder="Tìm kiếm" type="text">
                                   <div class="input-group-btn">
                                       <button class="btn btn-default" onClick="timkiem()"
                                        style="margin: 0px" id="btnSearch" type="button"><i class="fas fa-search "></i></button>
                                   </div>


                    </div>

                    <div class="col col-sm-6" style="top:-6px" ><button class="btn btn-primary"
                    data-toggle="modal" data-target="#Modalthem"   >
                                                            Thêm
                                                       </button></div>
         </div>

      </div>
      <div class="col col-sm-4"></div>
      <div class="col col-sm-2" style="margin-bottom:10px ;">
         <select id="select_honnor" onchange="chonloai(this)" name="select_honnor" class="form-control">
            <option value="1">Nhân Viên</option>
            <option value="2">Khách hàng</option>
            <option value="3">Nhà cung cấp</option>
            <option value="4">Đại lý</option>
         </select>
      </div>
      <div class="col col-sm-1" >
      </div>
      <div class="col col-sm-12">
         <table class="table table-striped table-hover " id="table_document2">
            <thead>
               <tr>
                  <th style="width: 5%;"><input id="btnCheckAll" type="checkbox"></th>
                   <th style="width: 10%;">
                                       STT
                                    </th>
                   <th style="width: 10%;">
                                      Trạng thái
                                    </th>

                  <th style="width: 10% ;">
                     Mã
                  </th>
                  <th style="width: 10% ;text-align: left ">
                     Tên
                  </th>
                  <th style="width: 10% ;text-align: left ">
                     Email
                  </th>
                  <th style="width: 10% ;">
                     Chức danh
                  </th>

                  <th style="width: 15% ;text-align: left " >
                     Chức năng
                  </th>
               </tr>
            </thead>
            <tbody id="nguoidungs">

            </tbody>
         </table>
      </div>
   </div>
</div>
<div class="modal" id="Modalxemchitiet">
   <div class="modal-dialog modal-xl">
      <div class="modal-content">
         <!-- Modal Header -->
         <div class="modal-header">
            <h4 class="modal-title">Cập nhật thông tin người dùng</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
         </div>
         <!-- Modal body -->
         <div class="modal-body">
            <form enctype="multipart/form-data" method="POST">
                          <div class="row">
                             <div class="col col-sm-4">
                                <label>Mã người dùng :</label>
                                <input name="maND" class="form-control " type="text" >
                                <label>Tên người dùng : </label>
                                <input name="tenND" class="form-control " type="text" >
                                <label>Email : </label>
                                <input name="email" class="form-control " type="text" >
                             </div>
                             <div class="col col-sm-4">
                                <label>Số điện thoại :</label>
                                <input name="sdt" class="form-control "  type="number" >

                                <label>Chức danh :</label>
                                <input name="chucdanh" class="form-control "  type="text" >
                             </div>
                             <div class="col col-sm-4">
                                <label>Quyền :</label>
                                <select id="role" name="role" class="form-control">
                                   <option value="1">Nhân Viên</option>
                                   <option value="2">Khách hàng</option>
                                   <option value="3">Nhà cung cấp</option>
                                   <option value="4">Đại lý</option>
                                </select>
                                <label>Trạng thái :</label>
                                 <select id="trangthai" name="trangthai" class="form-control">
                                                                   <option value="0">Đã khóa</option>
                                                                   <option value="1">Đã mở</option>

                                                                </select>
                                <label>Image :</label>
                                <img id="anh" src="" style=" max-height: 85px; margin-bottom :10px ; margin-top:10px">
                                <input name="anh" id="imageUpload" class="form-control " type="file" onchange="uploadFile(this)" >
                             </div>
                          </div>
                       </form>
         </div>
         <!-- Modal footer -->
         <div class="modal-footer">
            <button type="button" class="btn btn-success capnhat" id="" onclick="capnhap(this)">Cập nhật</button>
            <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
         </div>
      </div>
   </div>
</div>
</div>
<div class="modal" id="Modalthem">
   <div class="modal-dialog modal-xl">
      <div class="modal-content">
         <!-- Modal Header -->
         <div class="modal-header">
            <h4 class="modal-title">Thêm mới người dùng</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
         </div>
         <!-- Modal body -->
         <div class="modal-body">
          <form enctype="multipart/form-data" method="POST">
                                  <div class="row">
                                     <div class="col col-sm-4">
                                        <label>Mã người dùng :</label>
                                        <input name="maND1" class="form-control " type="text" >
                                        <label>Tên người dùng : </label>
                                        <input name="tenND1" class="form-control " type="text" >
                                        <label>Email : </label>
                                        <input name="email1" class="form-control " type="text" >
                                     </div>
                                     <div class="col col-sm-4">
                                        <label>Số điện thoại :</label>
                                        <input name="sdt1" class="form-control "  type="number" >

                                        <label>Chức danh :</label>
                                        <input name="chucdanh1" class="form-control "  type="text" >
                                     </div>
                                     <div class="col col-sm-4">
                                        <label>Quyền :</label>
                                        <select id="role1" name="role1" class="form-control">
                                           <option value="1">Nhân Viên</option>
                                           <option value="2">Khách hàng</option>
                                           <option value="3">Nhà cung cấp</option>
                                           <option value="4">Đại lý</option>
                                        </select>
                                        <label>Trạng thái :</label>
                                         <select id="trangthai1" name="trangthai1" class="form-control">
                                                                           <option value="0">Đã khóa</option>
                                                                           <option value="1">Đã mở</option>

                                                                        </select>
                                        <label>Image :</label>
                                        <img id="anh" src="" style=" max-height: 85px; margin-bottom :10px ; margin-top:10px">
                                        <input name="anh" id="imageUpload" class="form-control " type="file" onchange="uploadFile(this)" >
                                     </div>
                                  </div>
                               </form>
         </div>
         <!-- Modal footer -->
         <div class="modal-footer">
            <button type="button" class="btn btn-success"  onclick="themmoi()">Thêm mới</button>
            <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
         </div>
      </div>
   </div>
</div>
</div>

<script>
    $(document).ready(function () {
       $.ajax({
                               url: '/api/nguoidung',
                               type:'GET',
                               dataType:'json',
                               contentType: "application/json",
                               success: function (res){

                                var row = ``;
                                $.each(res,function(i,v){
                                   row+=`  <tr id="question_20338">
                                                           <td width="10px"><input id="btnCheckAll" type="checkbox"></td>
                                                           <td>`+(i+1)+`</td> ` ;
                                                           if(v.trangthai==1) row+=`    <td> <i class="text-success fa fa-circle"></i></td>`
                                                           else row+=`    <td> <i class="text-danger fa fa-circle"></i></td>` ;

                                                        row+=`<td>
                                                              `+v.maND+`
                                                           </td>
                                                           <td>`+v.fullName+`</td>
                                                           <td>`+v.email+`</td>
                                                           <td>`+v.chucdanh+`</td>

                                                           <td>  <a class="btn btn-info btn-sm" href="#" id="`+v.id+`" onclick="suanguoidung(this)">Sửa</a>
                                                              <button id="`+v.id+`" status = "`+v.trangthai+`"
                                                              onclick="khoa(this)" class="btn btn-danger btn-sm delete "> Khóa </button>

                                                           </td>
                                                        </tr>`
                                  })

                                  $("#nguoidungs").html(row)

                                },
                               error: function (res) {
                                  console.log(res)
                               }
                           })
    })

function chonloai(e){
   var role = $(e).val()
    $.ajax({
                                 url: '/api/filterNguoidung/'+role,
                                 type:'GET',
                                 dataType:'json',
                                 contentType: "application/json",
                                 success: function (res){

                                  var row = ``;
                                  $.each(res,function(i,v){
                                     row+=`  <tr id="question_20338">
                                                             <td width="10px"><input id="btnCheckAll" type="checkbox"></td>
                                                             <td>`+(i+1)+`</td> ` ;
                                                             if(v.trangthai==1) row+=`    <td> <i class="text-success fa fa-circle"></i></td>`
                                                             else row+=`    <td> <i class="text-danger fa fa-circle"></i></td>` ;

                                                          row+=`<td>
                                                                `+v.maND+`
                                                             </td>
                                                             <td>`+v.fullName+`</td>
                                                             <td>`+v.email+`</td>
                                                             <td>`+v.chucdanh+`</td>

                                                             <td>  <a class="btn btn-info btn-sm" href="#" id="`+v.id+`" onclick="suanguoidung(this)">Sửa</a>
                                                                <button id="`+v.id+`"  status = "`+v.trangthai+`"
                                                                onclick="khoa(this)" class="btn btn-danger btn-sm delete "> Khóa </button>

                                                             </td>
                                                          </tr>`
                                    })

                                    $("#nguoidungs").html(row)

                                  },
                                 error: function (res) {
                                    console.log(res)
                                 }
                             })

 }


 function timkiem(){
  var ten = $("#key").val()
     $.ajax({
                                  url: '/api/searchNguoiDung/'+ten,
                                  type:'GET',
                                  dataType:'json',
                                  contentType: "application/json",
                                  success: function (res){

                                   var row = ``;
                                   $.each(res,function(i,v){
                                      row+=`  <tr id="question_20338">
                                                              <td width="10px"><input id="btnCheckAll" type="checkbox"></td>
                                                              <td>`+(i+1)+`</td> ` ;
                                                              if(v.trangthai==1) row+=`    <td> <i class="text-success fa fa-circle"></i></td>`
                                                              else row+=`    <td> <i class="text-danger fa fa-circle"></i></td>` ;

                                                           row+=`<td>
                                                                 `+v.maND+`
                                                              </td>
                                                              <td>`+v.fullName+`</td>
                                                              <td>`+v.email+`</td>
                                                              <td>`+v.chucdanh+`</td>

                                                              <td>  <a class="btn btn-info btn-sm" href="#" id="`+v.id+`" onclick="suanguoidung(this)">Sửa</a>
                                                                 <button id="`+v.id+`" status = "`+v.trangthai+`"
                                                                  onclick="khoa(this)" class="btn btn-danger btn-sm delete "> Khóa </button>

                                                              </td>
                                                           </tr>`
                                     })

                                     $("#nguoidungs").html(row)

                                   },
                                  error: function (res) {
                                     console.log(res)
                                  }
                              })


 }

 function khoa(e){

 var id = $(e).attr("id");
 var status = $(e).attr("status");

if(confirm("Bạn muốn khóa tài khoản này?")){
$.ajax({
                                  url: '/api/updateTrangthai/'+id+"/"+status,
                                  type:'GET',
                                  dataType:'json',
                                  contentType: "application/json",
                                  success: function (res){

                                     alert("Cập nhật tài khoản này ? ")

                                     location.reload()
                                   },
                                  error: function (res) {
                                     console.log(res)
                                  }
                              })
}


 }


 function suanguoidung(e){
  var id = $(e).attr("id");
  // Modalxemchitiet
                             $.ajax({
                                   url: '/api/nguoidung/'+id,
                                   type:'GET',
                                   dataType:'json',
                                   contentType: "application/json",
                                   success: function (res){


                                      $("input[name='maND']").val(res.maND);
                                       $("input[name='tenND']").val(res.fullName);
                                        $("input[name='email']").val(res.email);
                                         $("input[name='sdt']").val(res.phone);
                                          $("input[name='chucdanh']").val(res.chucdanh);
                                            $("#role").html(getRole(res.role))

                                            $(".capnhat").attr("id",res.id)
                                            var trangthai = res.trangthai ;

                                            if(trangthai==0) {
                                              $("#trangthai").html('<option value="0" selected>Đã khóa</option><option value="1" >Mở</option>')
                                            }else $("#trangthai").html('<option value="0">Đã khóa</option><option value="1" selected >Mở</option>')

                                          // image

                                          $("#Modalxemchitiet").modal("show")


                                    },
                                   error: function (res) {
                                      console.log(res)
                                   }
                               })

 }

 function capnhap(e){


                                         var maND =  $("input[name='maND']").val();
                                        var fullName =  $("input[name='tenND']").val();
                                         var email =  $("input[name='email']").val();
                                         var phone =   $("input[name='sdt']").val();
                                          var chucdanh =   $("input[name='chucdanh']").val();
                                          var image ;
                                          if( document.getElementById("imageUpload").files[0]) image = document.getElementById("imageUpload").files[0].name
                                          else image= "khoahoc.jpg"

                                          var role =   $("#role").val()
                                         var trangthai = $("#trangthai").val();
                                          var id = $(e).attr("id")
                                         var data ={
                                           "maND" : maND,
                                           "fullName" : fullName,
                                           "email" : email ,
                                           "phone" : phone ,
                                           "chucdanh" : chucdanh ,
                                           "role" : role ,
                                           "trangthai" : trangthai,
                                           "image" : image,
                                           "id" : id

                                         }
                                         console.log(data)



                              $.ajax({
                                    url: '/api/nguoidung/capnhat',
                                     type:'POST',
                                    data : JSON.stringify(data) ,
                                    dataType:'json',
                                    contentType: "application/json",
                                    success: function (res){
                                    alert("Cập nhật thành công !")
                                    location.reload();
                                     },
                                    error: function (res) {
                                       console.log(res)
                                    }
                                })


 }

 function themmoi(){


                                         var maND =  $("input[name='maND1']").val();
                                        var fullName =  $("input[name='tenND1']").val();
                                         var email =  $("input[name='email1']").val();
                                         var phone =   $("input[name='sdt1']").val();
                                          var chucdanh =   $("input[name='chucdanh1']").val();
                                          var image ;
                                           if( document.getElementById("imageUpload").files[0]) image = document.getElementById("imageUpload").files[0].name
                                           else image= "khoahoc.jpg"

                                          var role =   $("#role1").val()
                                         var trangthai = $("#trangthai1").val();

                                         var data ={
                                           "maND" : maND,
                                           "fullName" : fullName,
                                           "email" : email ,
                                           "phone" : phone ,
                                           "chucdanh" : chucdanh ,
                                           "role" : role ,
                                           "trangthai" : trangthai,
                                           "image" : image,


                                         }
                                         console.log(data)



                              $.ajax({
                                    url: '/api/nguoidung/themmoi',
                                     type:'POST',
                                    data : JSON.stringify(data) ,
                                    dataType:'json',
                                    contentType: "application/json",
                                    success: function (res){
                                    alert("Thêm mới thành công !")
                                     location.reload();
                                     },
                                    error: function (res) {
                                       console.log(res)
                                    }
                                })



 }
//  var filename =  document.getElementById("imageUpload").files[0].name
 function getRole(value){
   var role = ``;
    if(value==1) role+=`<option value="1" selected>Nhân Viên</option><option value="2" >Khách hàng</option>
    <option value="3" >Nhà cung cấp</option><option value="4" >Đại lý</option>`
    else if(value==2) role+=`<option value="1" >Nhân Viên</option><option value="2" selected>Khách hàng</option>
        <option value="3" >Nhà cung cấp</option><option value="4" >Đại lý</option>`
    else if(value==3) role+=`<option value="1">Nhân Viên</option><option value="2" >Khách hàng</option>
        <option value="3"  selected>Nhà cung cấp</option><option value="4" >Đại lý</option>`
    else if(value==4) role+=`<option value="1" >Nhân Viên</option><option value="2" >Khách hàng</option>
        <option value="3" >Nhà cung cấp</option><option value="4" selected>Đại lý</option>`

    return role ;
 }



   function uploadFile(e){

           var formData = new FormData();
           formData.append('multipartFile',  document.getElementById("imageUpload").files[0]);
           console.log(formData);

           $.ajax({
               url : '/api/upload/images',
               type : 'POST',
               enctype: 'multipart/form-data',
               data : formData,

               processData: false,  // Important!
               contentType: false,
               cache: false,

               success : function(result) {
                   // console.log(result);
                   var srcimage = `/image/`+result
                   $("#anh").attr("src",srcimage);

               },
               error : function(jqXHR, textStatus, errorThrown) {

                   console.log( 'The following error occured: ' + textStatus, errorThrown );
               }
           });
   }

</script>