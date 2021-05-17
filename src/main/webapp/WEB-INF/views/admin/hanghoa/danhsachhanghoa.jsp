<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8"%>
<div class="content-wrapper" style="min-height: 222px;">
   <section class="content">
      <div class="row  margin_top">
         <div class="col-12">
            <div class="card">
               <div class="card-header">
                  <div class="caption"><i class="fas fa-layer-group font-green"></i>
                     <span class="caption-subject font-green sbold uppercase">
                     <a href="/admin/document/category/" style="text-align: center">Quản lý hàng hóa</a> </span>
                  </div>
               </div>
               <div class="col-md">
                  <input hidden="" id="posName">
                  <br>
                  <div>
                     <form id="search" method="get">
                        <div class="row">
                           <div class="col-md-3">
                              <div class="d-flex">
                                 <input id="namehanghoa" class="form-control " placeholder="Nhập tên hàng hóa ..." type="text">
                                 <div class="input-group-btn">
                                    <button class="btn btn-default"  onClick="timkiem()"
                                    style="margin: 0px" id="btnSearch" type="button"><i class="fas fa-search "></i>
                                    </button>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </form>


                  </div>
                  <br>
                  <div class="col-md-12">
                     <table class="table table-striped table-hover " id="table_id">
                        <thead>
                           <tr>
                              <th style="width: 10%">
                                 STT
                              </th>
                              <th style="width: 10% ;">
                                 Mã hàng hóa
                              </th>
                              <th style="width: 10% ;text-align: left ">
                                 Tên hàng hóa
                              </th>
                              <th style="width: 10% ;text-align: left ">
                                 Giá
                              </th>
                              <th style="width: 10% ;text-align: left ">
                                 Ảnh
                              </th>
                              <th style="width: 8% ;text-align: left ">
                                 Miêu tả
                              </th>
                              <th style="width: 9% ;text-align: left " class="text-center">
                                 Chức năng
                              </th>
                           </tr>
                        </thead>
                        <tbody id="danhsachhanghoa">
                        </tbody>
                     </table>
                     <div class="d-flex justify-content-end">
                        <div class="col-auto">
                           <select class="form-control" name="size" id="size" style="margin-top :5% !important;">
                              <option value="10">10</option>
                              <option value="20">25</option>
                              <option value="50">50</option>
                           </select>
                        </div>
                        <div id="pagination" class="pagination justify-content-end align-items-center">
                           <ul class="pagination">

                              <li class="page-item prev disabled"><a href="#" class="page-link">&lt;</a></li>
                              <li class="page-item active"><a href="#" class="page-link">1</a></li>

                              <li class="page-item next"><a href="#" class="page-link">&gt;</a></li>

                           </ul>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </section>
</div>
<div class="modal" id="Modalthemhanghoa">
   <div class="modal-dialog modal-xl">
      <div class="modal-content">
         <!-- Modal Header -->
         <div class="modal-header">
            <h4 class="modal-title">Thêm mới hàng hóa</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
         </div>
         <!-- Modal body -->
         <div class="modal-body">
           <form id="suahanghoa1" enctype="multipart/form-data">
                          <div class="row">
                             <div class="col col-sm-4">
                                <label>Mã hàng hóa :</label>
                                <input name="mahh1" class="form-control " type="text" >
                                <label>Tên hàng hóa : </label>
                                <input name="tenhh1" class="form-control " type="text" >
                                <label>Hàng hóa mới : </label>
                                <select id="mhmoi1" name="moi1" class="form-control">
                                   <option value="0">Mới</option>
                                   <option value="1">Cũ</option>
                                </select>
                             </div>
                             <div class="col col-sm-4">
                                <label>Danh mục hàng hóa : </label>
                                <select id="danhmuc1" name="danhmuc1" class="form-control">
                                </select>
                             </div>
                             <div class="col col-sm-4">
                                <label>Giá :</label>
                                <input name="gia1" class="form-control "  type="number" >
                                <label>Giảm giá :</label>
                                <input name="giamgia1" class="form-control "  type="number" >
                                <label>image :</label>
                                <img id="anh" src="" style=" max-height: 85px; margin-bottom :10px ; margin-top:10px">
                                <input name="anh" id="imageUpload" class="form-control " type="file" onchange="uploadFile(this)" >
                             </div>
                             <div class="col col-sm-12" style="margin-top:15px;width:100%">
                                <label>Miêu tả:</label>
                                <textarea id="mieutamh1" name="mieuta1" cols="50" class="form-control " style="width: 1105px !important;
                                   height: 100px;"></textarea>
                             </div>
                          </div>
                       </form>
         </div>
         <!-- Modal footer -->
         <div class="modal-footer">
            <button type="button" class="btn btn-success" onClick="them()" >Thêm</button>
            <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
         </div>
      </div>
   </div>
</div>
</div>
<div class="modal" id="Modalsuahanghoa">
   <div class="modal-dialog modal-xl">
      <div class="modal-content">
         <!-- Modal Header -->
         <div class="modal-header">
            <h4 class="modal-title">Cập nhật hàng hóa</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
         </div>
         <!-- Modal body -->
         <div class="modal-body">
            <form id="suahanghoa" enctype="multipart/form-data">
               <div class="row">
                  <div class="col col-sm-4">
                     <label>Mã hàng hóa :</label>
                     <input name="mahh" class="form-control " type="text" readonly>
                     <label>Tên hàng hóa : </label>
                     <input name="tenhh" class="form-control " type="text" >
                     <label>Hàng hóa mới : </label>
                     <select id="mhmoi" name="moi" class="form-control">
                        <option value="0">Mới</option>
                        <option value="1">Cũ</option>
                     </select>
                  </div>
                  <div class="col col-sm-4">
                     <label>Danh mục hàng hóa : </label>
                     <select id="danhmuc" name="danhmuc" class="form-control">
                     </select>
                  </div>
                  <div class="col col-sm-4">
                     <label>Giá :</label>
                     <input name="gia" class="form-control "  type="number" >
                     <label>Giảm giá :</label>
                     <input name="giamgia" class="form-control "  type="number" >
                     <label>image :</label>
                     <img id="anh" src="" style=" max-height: 85px; margin-bottom :10px ; margin-top:10px">
                     <input name="anh" id="imageUpload" class="form-control " type="file" onchange="uploadFile(this)" >
                  </div>
                  <div class="col col-sm-12" style="margin-top:15px;width:100%">
                     <label>Miêu tả:</label>
                     <textarea id="mieutamh" name="mieuta" cols="50" class="form-control " style="width: 1105px !important;
                        height: 100px;"></textarea>
                  </div>
               </div>
            </form>
         </div>
         <!-- Modal footer -->
         <div class="modal-footer">
            <button type="button" class="btn btn-success btnsua"  idp="" onClick="suamh(this)" >Sửa</button>
            <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
         </div>
      </div>
   </div>
</div>
</div>
<script type="text/javascript" src="//js.nicedit.com/nicEdit-latest.js"></script>
<script>
   $(document).ready(function () {

           $.ajax({
                       url: '/api/hanghoa',
                       type:'GET',
                       dataType:'json',
                       contentType: "application/json",
                       success: function (res){
                       var row = ``;
                           $.each(res, function (i, v) {
                                row+=`<tr id="question_20338">
                                                                    <td width="10px">`+(i+1)+`</td>
                                                                    <td>
                                                                      `+v.maHH+`
                                                                    </td>

                                                                    <td>`+v.tenHH+`</td>
                                                                     <td>`+v.gia+`</td>

                                                                    <td>
                                                                      <img src="/image/`+v.image+`" style="max-width: 58px; max-height: 50px;">
                                                                    </td>
                                                                    <td>`+v.mieuta+`</td>
                                                                    <td>  <a class="btn btn-info btn-sm" href="#" id="`+v.maHH+`" onClick="suahh(this)">Sửa</a>

                                                                       <button class="btn btn-warning btn-sm" id="`+v.maHH+`"
                                                                             onClick="showmodal()"
                                                                       >Thêm</button>
                                                                    </td>
                                                                 </tr>`
                           })

                           $("#danhsachhanghoa").html(row)
                       },
                       error: function (res) {
                          console.log(res)
                       }
                   })



   })

       function suahh(e){
                var id = $(e).attr("id");
                   $.ajax({
                                         url: '/api/hanghoa/'+id,
                                         type:'GET',
                                         dataType:'json',
                                         contentType: "application/json",
                                         success: function (res){
                                            $("input[name='mahh']").val(res.maHH);
                                            $("input[name='tenhh']").val(res.tenHH);
                                            $("input[name='gia']").val(res.gia);
                                            $("input[name='giamgia']").val(res.giamgia);
                                            var srcimage = `/image/`+res.image
                                            $("#anh").attr("src",srcimage);
                                            $("#mieutamh").val(res.mieuta);
                                            var option =``;
                                            if(res.new1==1)  option+=`<option value="1" selected>Mới</option>
                                                                      <option value="0" >Cũ</option>`;
                                            else
                                            option+=`<option value="1" >Mới</option>
                                                      <option value="0" selected >Cũ</option>`;

                                            $("#mhmoi").html(option);
                                            getCategory(res.danh_muc_hang_hoaid)
                                          //  $(".btnsua").attr("idp",)
                                            $("#Modalsuahanghoa").modal("show")
                                         },
                                         error: function (res) {
                                            console.log(res)
                                         }
                                     })
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





   function suamh(e){
                                              var mamh = $("input[name='mahh']").val();
                                              var tenmh = $("input[name='tenhh']").val();
                                              var gia = $("input[name='gia']").val();
                                              var giamgia = $("input[name='giamgia']").val();
                                              var filename =  $("#anh").attr("src")
                                              var new1 = $("#mhmoi").val();
                                              var mieuta = $("#mieutamh").val() ;
                                              var maDM = $("#danhmuc").val();
                                              var data = {
                                                "maHH" : mamh,
                                                "tenHH" : tenmh,
                                                "gia" : gia,
                                                "giamgia" : giamgia,
                                                "new1" : new1 ,
                                                "image" : filename ,
                                                "mieuta" : mieuta,
                                                "danh_muc_hang_hoaid" : maDM

                                              }
                                              console.log(data)
                                              $.ajax({
                                                                 url: '/api/hanghoa/update',
                                                                 type:'POST',
                                                                 data : JSON.stringify(data) ,
                                                                 dataType:'json',

                                                                 contentType: "application/json",
                                                                 success: function (res){
                                                                 alert("Cập nhật thanh công")
                                                                    location.reload()
                                                                 },
                                                                 error: function (res) {
                                                                    console.log(res)
                                                                 }
                                                             })

   }



   function getCategory(id){
        $.ajax({
                       url: '/api/category',
                       type:'GET',
                       dataType:'json',
                       contentType: "application/json",
                       success: function (res){
                       var row = ``;
                            $.each(res, function (i, v) {
                              if(v.id==id) row+=`<option value="`+v.id+`" selected>`+v.tenDM+`</option>`
                              else row += `<option value="`+v.id+`">`+v.tenDM+`</option>`

                            })
                            $("#danhmuc").html(row);

                          // $("#danhsachhanghoa").html(row) <option value="0">Mới</option>
                       },
                       error: function (res) {
                          console.log(res)
                       }
                   })


   }

function getCategory1(id){
        $.ajax({
                       url: '/api/category',
                       type:'GET',
                       dataType:'json',
                       contentType: "application/json",
                       success: function (res){
                       var row = ``;
                            $.each(res, function (i, v) {
                              if(v.id==id) row+=`<option value="`+v.id+`" selected>`+v.tenDM+`</option>`
                              else row += `<option value="`+v.id+`">`+v.tenDM+`</option>`

                            })
                            $("#danhmuc1").html(row);

                          // $("#danhsachhanghoa").html(row) <option value="0">Mới</option>
                       },
                       error: function (res) {
                          console.log(res)
                       }
                   })


   }



   function showmodal(){

   getCategory1(1)
   $("#Modalthemhanghoa").modal("show")

   }

function them(){
                                                 var mamh = $("input[name='mahh1']").val();
                                                 var tenmh = $("input[name='tenhh1']").val();
                                                 var gia = $("input[name='gia1']").val();
                                                 var giamgia = $("input[name='giamgia1']").val();
                                                 var filename =  $("#anh").attr("src")
                                                 var new1 = $("#mhmoi1").val();
                                                 var mieuta = $("#mieutamh1").val() ;
                                                 var maDM = $("#danhmuc1").val();
                                                 var data = {
                                                   "maHH" : mamh,
                                                   "tenHH" : tenmh,
                                                   "gia" : gia,
                                                   "giamgia" : giamgia,
                                                   "new1" : new1 ,
                                                   "image" : filename ,
                                                   "mieuta" : mieuta,
                                                   "danh_muc_hang_hoaid" : maDM

                                                 }

                                                 $.ajax({
                                                                    url: '/api/hanghoa/add',
                                                                    type:'POST',
                                                                    data : JSON.stringify(data) ,
                                                                    dataType:'json',

                                                                    contentType: "application/json",
                                                                    success: function (res){
                                                                    alert("Thêm mới thành công !")
                                                                       location.reload()
                                                                    },
                                                                    error: function (res) {
                                                                       console.log(res)
                                                                    }
                                                                })

}


function timkiem(){
  var name = $("#namehanghoa").val()
          $.ajax({
                         url: '/api/hanghoa/timkiem/'+name,
                         type:'GET',
                         dataType:'json',
                         contentType: "application/json",
                         success: function (res){
                         var row = ``;
                             $.each(res, function (i, v) {
                                  row+=`<tr id="question_20338">
                                                                      <td width="10px">`+(i+1)+`</td>
                                                                      <td>
                                                                        `+v.maHH+`
                                                                      </td>

                                                                      <td>`+v.tenHH+`</td>
                                                                       <td>`+v.gia+`</td>

                                                                      <td>
                                                                        <img src="/image/`+v.image+`" style="max-width: 58px; max-height: 50px;">
                                                                      </td>
                                                                      <td>`+v.mieuta+`</td>
                                                                      <td>  <a class="btn btn-info btn-sm" href="#" id="`+v.maHH+`" onClick="suahh(this)">Sửa</a>

                                                                         <button class="btn btn-warning btn-sm" id="`+v.maHH+`"
                                                                               onClick="showmodal()"
                                                                         >Thêm</button>
                                                                      </td>
                                                                   </tr>`
                             })

                             $("#danhsachhanghoa").html(row)
                         },
                         error: function (res) {
                            console.log(res)
                         }
                     })
}
</script>