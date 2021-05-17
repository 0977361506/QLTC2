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
                     <a href="/admin/document/category/" style="text-align: center">Quản lỳ nhập hàng</a> </span>
                  </div>
               </div>
               <div class="col-md">
                  <input hidden="" id="posName">
                  <br>
        <div class="d-flex justify-content-between  mb-3">
              <div class="row " style="margin-left: 1.5px;">

                 <div class="col col-sm-8">
                    <div class="d-flex">
                       <input name="name" id="key" class="form-control " placeholder="tìm kiếm ..." type="text">
                       <div class="input-group-btn">
                          <button class="btn btn-default" style="margin: 0px"
                           onclick="timkiem()"
                           id="btnSearch" type="button"><i class="fas fa-search "></i>
                          </button>
                       </div>
                    </div>
                 </div>

                 <div class="col col-sm-4" style="top: -5px;">
                 <div class="row">

                          <div class="col-auto pl-0 Add">
                             <a class="btn btn-primary" href="#" onclick="showmodal()"
                              title="Thêm mới sản lượng không số">
                             <i class="fas fa-plus"></i>

                             </a>
                          </div>
                       </div>
                 </div>
              </div>
              <div>

              </div>
           </div>
                  <br>
                  <div class="col-md-12">
                     <table class="table table-striped table-hover " id="table_document2">
                        <thead>
                           <tr>
                              <th style="width: 10%;"><input id="btnCheckAll" type="checkbox"></th>
                              <th style="width: 10%;">
                                 STT
                              </th>
                              <th style="width: 10% ;">
                                 Mã phiếu
                              </th>
                              <th style="width: 10% ;text-align: left ">
                                 Người tạo
                              </th>
                              <th style="width: 10% ;text-align: left ">
                                 ghi chú
                              </th>
                              <th style="width: 10% ;">
                                 Thời gian
                              </th>
                              <th style="width: 10% ;text-align: left ">
                                 Trạng thái
                              </th>
                              <th style="width: 10% ;text-align: left " class="text-center">
                                 Chức năng
                              </th>
                           </tr>
                        </thead>
                        <tbody id="phieunhaps">

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
                              <li class="page-item first disabled"><a href="#" class="page-link">&lt;&lt;</a></li>

                              <li class="page-item active"><a href="#" class="page-link">1</a></li>

                              <li class="page-item last"><a href="#" class="page-link">&gt;&gt;</a></li>
                           </ul>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </section>

   <div class="modal" id="Modalxemchitiet">
      <div class="modal-dialog modal-xl">
         <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
               <h4 class="modal-title">Chi tiết phiếu nhập</h4>
               <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <!-- Modal body -->
            <div class="modal-body">
               <form id="formxem">
                  <div class="row">
                     <div class="col col-sm-4">
                        <label>Tên nhà cung cấp :</label>
                        <input name="tenncc" class="form-control " type="text" disabled>
                        <label>Tên người tạo : </label>
                        <input name="tennguoitao" class="form-control " type="text" disabled>
                        <label>Địa chỉ nhận : </label>
                        <input name="diachi" class="form-control "  type="text" disabled>
                     </div>
                     <div class="col col-sm-4"></div>
                     <div class="col col-sm-4">
                        <label>Mã phiếu :</label>
                        <input name="maCode" class="form-control "  type="text" disabled>
                        <label>Ngày tạo :</label>
                        <input name="ngaytao" class="form-control "  type="text" disabled>
                        <label>Ghi chú :</label>
                        <input name="ghichu" class="form-control " type="text" disabled>
                     </div>
                     <div class="col col-sm-12" style="margin-top:15px">
                        <table class="table table-bordered">
                           <thead>
                              <tr>
                                 <th>STT</th>
                                 <th>Mã hàng hóa</th>
                                 <th>Tên hàng hóa</th>
                                 <th>Số lượng</th>
                                 <th>Giá</th>
                                 <th>Thành tiền</th>
                              </tr>
                           </thead>
                           <tbody id="danhsachhanghoa">

                           </tbody>
                        </table>
                     </div>
                  </div>
               </form>
            </div>
            <!-- Modal footer -->
            <div class="modal-footer">
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
               <h4 class="modal-title">Tạo phiếu nhập</h4>
               <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <!-- Modal body -->
            <div class="modal-body">
               <form>
                  <div class="row">
                     <div class="col col-sm-4">
                        <label>Tên nhà cung cấp :</label>
                         <select id="nhacungcap" class="form-control " name="state">

                                                </select>
                        <label>Tên người tạo : </label>
                      <select id="nguoidung" class="form-control " name="state">

                                             </select>
                        <label>Địa chỉ nhận : </label>
                        <input name="diachi1" class="form-control "  type="text" >
                     </div>
                     <div class="col col-sm-4">
                      <label>Chọn mặt hàng : </label>
                         <select id="hanghoa1" class="js-example-basic-single" name="state" onchange="chonmathang(this)">

                         </select>
                     </div>
                     <div class="col col-sm-4">
                        <label>Mã phiếu :</label>
                        <input name="maCode1" class="form-control "  type="number" >
                        <label>Ngày tạo :</label>
                        <input name="ngaytao1" class="form-control "  type="date" >
                        <label>Ghi chú :</label>
                        <input name="ghichu1" class="form-control " type="text" >
                     </div>
                     <div class="col col-sm-12" style="margin-top:15px">
                        <table class="table table-bordered">
                           <thead>
                              <tr>
                                 <th>STT</th>
                                 <th>Mã hàng hóa</th>
                                 <th>Tên hàng hóa</th>
                                 <th style="width: 10% ;">Số lượng</th>
                                 <th>Giá</th>
                                 <th>Thành tiền</th>
                                 <th style="width: 10% ;"></th>
                              </tr>
                           </thead>
                           <tbody id="addtophieu">

                           </tbody>
                        </table>
                     </div>
                  </div>
               </form>
            </div>
            <!-- Modal footer -->
            <div class="modal-footer">

            <button type="button" class="btn btn-primary" onclick="taophieu()">Tạo</button>
               <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
            </div>
         </div>
      </div>
   </div>
</div>

<script>
 $(document).ready(function() {
      $('.js-example-basic-single').select2();
  });

  </script>



<script>
$(document).ready(function () {
   // getAllPhieuNhap

var index = 0 ;
           $.ajax({
                       url: '/api/getAllPhieuNhap',
                       type:'GET',
                       dataType:'json',
                       contentType: "application/json",
                       success: function (res){
                       var row = ``;
                          $.each(res, function (i, v) {

                            row+=`
                            <tr id="question_20338">
                                                          <td width="10px"><input id="btnCheckAll" type="checkbox"></td>
                                                          <td>`+(i+1)+`</td>
                                                          <td>
                                                             `+v.maphieu+`
                                                          </td>
                                                          <td>`+v.nguoitao+`</td>
                                                          <td>`+v.ghichu+`</td>
                                                          <td>`+v.ngaytao+`</td> ` ;
                                                          if(v.trangthai==1) row+=`<td>Đã duyệt</td>`
                                                          else row+=`<td>Chưa duyệt</td>` ;
                                                       row+=` <td>  <a class="btn btn-info btn-sm" href="#" id="`+v.id+`"
                                                       onclick="showsua(this)">Xem</a>
                                                             <button onclick="deleteDocument(this)"
                                                              id="`+v.id+`" status = `+v.trangthai+`
                                                             class="btn btn-danger btn-sm delete "> Khóa </button>

                                                          </td>
                                                       </tr>`
                          })
                          $("#phieunhaps").html(row)
                       },
                       error: function (res) {
                          console.log(res)
                       }
                   })
})


       function showsua(e){
                var id = $(e).attr("id");
                   $.ajax({
                                         url: '/api/getDetailPhieuNhap/'+id,
                                         type:'GET',
                                         dataType:'json',
                                         contentType: "application/json",
                                         success: function (res){
                                             $("input[name='tenncc']").val(res[0].tenncc);
                                              $("input[name='tennguoitao']").val(res[0].nguoitao);
                                              $("input[name='diachi']").val(res[0].diachi);
                                               $("input[name='maCode']").val(res[0].maphieu);
                                                $("input[name='ngaytao']").val(res[0].ngaytao);
                                                $("input[name='ghichu']").val(res[0].ghichu);
                                            var row = ``;
                                                 $.each(res[1], function (i, v) {
                                                 row+=`
                                                                                     <tr>
                                                                                  <td>`+(i+1)+`</td>
                                                                                  <td>`+v.mahh+`</td>
                                                                                   <td>`+v.tenhh+`</td>
                                                                                  <td>`+v.soluong+`</td>
                                                                                  <td>`+v.gia+`</td>
                                                                                  <td>`+(v.gia*v.soluong)+`</td>

                                                                               </tr>
                                                 `

                                                 })
                                                 $("#danhsachhanghoa").html(row)
                                            $("#Modalxemchitiet").modal("show")
                                         },
                                         error: function (res) {
                                            console.log(res)
                                         }
                                     })
                }



   function showmodal(){
        gethanghoa() ;
        getNguoiDung();
        getNhaCungCap();

        $("#Modalthem").modal("show")

   }


     function chonmathang(e){
       var id = $(e).val();


       $.ajax({
                                                url: '/api/addtophieu/'+id,
                                                type:'GET',
                                                dataType:'json',
                                                contentType: "application/json",
                                                success: function (res){

                                                 var row = ``;
                                                 $.each(res, function (i, v) {
                                                 row+=`
                                                                                     <tr>
                                                                                  <td>`+(i+1)+`</td>
                                                                                  <td>`+v.maHH+`</td>
                                                                                   <td>`+v.tenHH+`</td>
                                                                                  <td><input class="form-control " id="`+v.id+`"
                                                                                   type="number" value="`+v.soluong+`" onchange="tangsoluong(this)"/></td>
                                                                                  <td>`+v.gia+`</td>
                                                                                  <td>`+(v.gia*v.soluong)+`</td>
                                                                                   <td><i class="far fa-trash-alt"  id="`+v.id+`"
                                                                                    onclick="xoaitem(this)"></i></td>
                                                                               </tr>
                                                 `

                                                 })
                                                 $("#addtophieu").html(row)
                                                },
                                                error: function (res) {
                                                   console.log(res)
                                                }
                                            })
     }



     function tangsoluong(e){
        var id = $(e).attr("id")
        var soluong = $(e).val()
       $.ajax({
                                                url: '/api/updateQuantity/'+id+"/"+soluong,
                                                type:'GET',
                                                dataType:'json',
                                                contentType: "application/json",
                                                success: function (res){

                                                 var row = ``;
                                                 $.each(res, function (i, v) {
                                                 row+=`
                                                                                     <tr>
                                                                                  <td>`+(i+1)+`</td>
                                                                                  <td>`+v.maHH+`</td>
                                                                                   <td>`+v.tenHH+`</td>
                                                                                  <td><input class="form-control " id="`+v.id+`"
                                                                                   type="number" value="`+v.soluong+`" onchange="tangsoluong(this)"/></td>
                                                                                  <td>`+v.gia+`</td>
                                                                                  <td>`+(v.gia*v.soluong)+`</td>
                                                                                   <td><i class="far fa-trash-alt" id="`+v.id+`" onclick="xoaitem(this)"></i></td>
                                                                               </tr>
                                                 `

                                                 })
                                                 $("#addtophieu").html(row)
                                                },
                                                error: function (res) {
                                                   console.log(res)
                                                }
                                            })
     }


     function getNguoiDung(){
           $.ajax({
                          url: '/api/nguoidung',
                          type:'GET',
                          dataType:'json',
                          contentType: "application/json",
                          success: function (res){
                          var row = ``;
                               $.each(res, function (i, v) {
                                 row+=`<option value="`+v.id+`" >`+v.fullName+`</option>`
                               })
                               $("#nguoidung").html(row);

                             // $("#danhsachhanghoa").html(row) <option value="0">Mới</option>
                          },
                          error: function (res) {
                             console.log(res)
                          }
                      })


      }

        function gethanghoa(){
                           $.ajax({
                                       url: '/api/hanghoa',
                                       type:'GET',
                                       dataType:'json',
                                       contentType: "application/json",
                                       success: function (res){
                                       var row = ``;
                                           $.each(res, function (i, v) {
                                                row+=`<option value="`+v.id+`" >`+v.tenHH+`</option>`
                                           })

                                           $("#hanghoa1").html(row)
                                       },
                                       error: function (res) {
                                          console.log(res)
                                       }
                                   })

            }



        function getNhaCungCap(){
              $.ajax({
                             url: '/api/nhacungcap',
                             type:'GET',
                             dataType:'json',
                             contentType: "application/json",
                             success: function (res){
                             var row = ``;
                                  $.each(res, function (i, v) {
                                   row+=`<option value="`+v.id+`" >`+v.tenNCC+`</option>`

                                  })
                                  $("#nhacungcap").html(row);

                                // $("#danhsachhanghoa").html(row) <option value="0">Mới</option>
                             },
                             error: function (res) {
                                console.log(res)
                             }
                         })


         }


function xoaitem(e){
  if(confirm("Bạn muốn xóa mặt hàng này ra khỏi phiếu nhập ?")){

     var id = $(e).attr("id")

            $.ajax({
                                                     url: '/api/deleteToPhieu/'+id,
                                                     type:'GET',
                                                     dataType:'json',
                                                     contentType: "application/json",
                                                     success: function (res){

                                                      var row = ``;
                                                      $.each(res, function (i, v) {
                                                      row+=`
                                                                                          <tr>
                                                                                       <td>`+(i+1)+`</td>
                                                                                       <td>`+v.maHH+`</td>
                                                                                        <td>`+v.tenHH+`</td>
                                                                                       <td><input class="form-control " id="`+v.id+`"
                                                                                        type="number" value="`+v.soluong+`" onchange="tangsoluong(this)"/></td>
                                                                                       <td>`+v.gia+`</td>
                                                                                       <td>`+(v.gia*v.soluong)+`</td>
                                                                                        <td><i class="far fa-trash-alt"  id="`+v.id+`"
                                                                                         onclick="xoaitem(this)"></i></td>
                                                                                    </tr>
                                                      `

                                                      })
                                                      $("#addtophieu").html(row)
                                                     },
                                                     error: function (res) {
                                                        console.log(res)
                                                     }
                                                 })
  }
}

function timkiem(){
  var name = $("#key").val();

  $.ajax({
                         url: '/api/timkiemPhieunhap/'+name,
                         type:'GET',
                         dataType:'json',
                         contentType: "application/json",
                         success: function (res){
                         var row = ``;
                            $.each(res, function (i, v) {

                              row+=`
                              <tr id="question_20338">
                                                            <td width="10px"><input id="btnCheckAll" type="checkbox"></td>
                                                            <td>`+(i+1)+`</td>
                                                            <td>
                                                               `+v.maphieu+`
                                                            </td>
                                                            <td>`+v.nguoitao+`</td>
                                                            <td>`+v.ghichu+`</td>
                                                            <td>`+v.ngaytao+`</td> ` ;
                                                            if(v.trangthai==1) row+=`<td>Đã duyệt</td>`
                                                            else row+=`<td>Chưa duyệt</td>` ;
                                                         row+=` <td>  <a class="btn btn-info btn-sm" href="#" id="`+v.id+`"
                                                         onclick="showsua(this)">Xem</a>
                                                               <button onclick="deleteDocument(this)"
                                                               id="`+v.id+`"  status = `+v.trangthai+`
                                                               class="btn btn-danger btn-sm delete "> Khóa </button>

                                                            </td>
                                                         </tr>`
                            })
                            $("#phieunhaps").html(row)
                         },
                         error: function (res) {
                            console.log(res)
                         }
                     })

}


function taophieu(){
       var ncc =  $("#nhacungcap").val();
       var nguoidung =  $("#nguoidung").val();
       var diachi =   $("input[name='diachi1']").val();
       var maphieu = $("input[name='maCode1']").val();
       var ngaytao =   $("input[name='ngaytao1']").val();
       var ghichu =   $("input[name='ghichu1']").val();

       var data ={
          "maPhieu" : maphieu ,
          "maND"  : nguoidung ,
          "maNCC" : ncc ,
          "ngaytao" : ngaytao,
          "ghichu" : ghichu,
          "diachi" : diachi

       }

       $.ajax({
             url: '/api/taophieunhap',
             type: 'POST',
             data: JSON.stringify(data),
             dataType: 'json',

             contentType: "application/json",
             success: function(res) {
              alert("Tạo phiếu nhập thành công !");
              location.reload()
             },
             error: function(res) {
                 console.log(res)
             }
         })
}


function deleteDocument(e){
var id = $(e).attr("id");
var status = $(e).attr("status")
 $.ajax({
                             url: '/api/updateStatus/'+id+"/"+status,
                             type:'GET',
                             dataType:'json',
                             contentType: "application/json",
                             success: function (res){
                                alert("Cập nhật trạng thái thành công !")
                                location.reload();
                             },
                             error: function (res) {
                                console.log(res)
                             }
                         })

}

</script>