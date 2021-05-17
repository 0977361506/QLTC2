<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8"%>
<div class="content-wrapper">
   <div class="py-2 px-2">
      <h4 class="page-title">
         <b>Quản lý phiếu chi</b>
      </h4>
   </div>
   <div class="d-flex justify-content-between  mb-3">
      <div class="row " style="margin-left: 1.5px;">

         <div class="col col-sm-8">
            <div class="d-flex">
               <input name="name" class="form-control " id="key" placeholder="tìm kiếm ..." type="text">
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
                     <a class="btn btn-primary" href="#"  onclick="showmodal()" title="Thêm mới sản lượng không số">
                     <i class="fas fa-plus"></i>
                     </a>
                  </div>
               </div>
         </div>
      </div>
      <div >

      </div>
   </div>

   <div class="col-md-12">
                        <table class="table table-striped table-hover " id="table_document2">
                           <thead>
                              <tr>
                                 <th style="width: 10%">
                                    STT
                                 </th>
                                 <th style="width: 10%;">
                                    Mã phiếu chi
                                  </th>
                                 <th style="width: 10% ; ">
                                    Tên người tạo
                                 </th>
                                 <th style="width: 10% ;text-align: left ">
                                    Tên người nhận
                                 </th>
                                 <th style="width: 10% ;text-align: left ">
                                    Số tiền
                                 </th>
                                 <th style="width: 10% ;text-align: left ">
                                    Nội dung
                                 </th>
                                 <th style="width: 10% ;text-align: left ">
                                    Ghi chú
                                 </th>
                                 <th style="width: 10% ;text-align: left ">
                                      Chức năng
                                 </th>

                              </tr>
                           </thead>
                           <tbody id="phieuthus">


                           </tbody>
                        </table>

                        </div>
</div>


 <div class="modal" id="ModalxemphieuThu">
      <div class="modal-dialog modal-xl">
         <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
               <h4 class="modal-title">Xem chi tiết phiếu chi</h4>
               <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <!-- Modal body -->
            <div class="modal-body">
               <form>
                  <div class="row">
                     <div class="col col-sm-4">
                        <label>Tên tài khoản :</label>
                        <input name="tentk" class="form-control " type="text" disabled>
                        <label>Tên người nhận : </label>
                        <input name="doituongthu" class="form-control " type="text" disabled>
                        <label>Số tài khoản  : </label>
                        <input name="sotk" class="form-control "  type="text" disabled>
                     </div>

                     <div class="col col-sm-4">
                        <label>Tên người tạo :</label>
                        <input name="tennguoitao" class="form-control "  type="text" disabled>
                        <label>Nội dung :</label>
                        <input name="noidung" class="form-control "  type="text" disabled>
                        <label>Số tiền :</label>
                        <input name="sotien" class="form-control " type="number" disabled>
                     </div>
                     <div class="col col-sm-4" >

                         <label> Ghi chú :</label>
                        <input name="ghichu" class="form-control " type="text" disabled>
                        <label>Ngày tạo :</label>
                         <input name="ngaytao" class="form-control " type="text" disabled>
                          <label>Mã phiếu :</label>
                           <input name="maphieu" class="form-control " type="text" disabled>
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




 <div class="modal" id="ModaltaophieuThu">
      <div class="modal-dialog modal-xl">
         <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
               <h4 class="modal-title">Tạo phiếu chi</h4>
               <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <!-- Modal body -->
            <div class="modal-body">
               <form>
                  <div class="row">
                     <div class="col col-sm-4">
                        <label>Tên người tạo :</label>
                         <select id="nguoidung" class="form-control " name="state">

                                                                     </select>
                        <label>Tên người nhận : </label>
                        <input name="doituongthu1" class="form-control " type="text" >
                        <label>Số tài khoản  : </label>
                        <input name="sotk1" class="form-control "  type="text" >
                     </div>

                     <div class="col col-sm-4">
                        <label>Tên tài khoản :</label>
                        <input name="tentk1" class="form-control "  type="text" >
                        <label>Nội dung :</label>
                        <input name="noidung1" class="form-control "  type="text" >
                        <label>Số tiền :</label>
                        <input name="sotien1" class="form-control " type="number" >
                     </div>
                     <div class="col col-sm-4" >

                         <label> Ghi chú :</label>
                        <input name="ghichu1" class="form-control " type="text" >
                        <label>Ngày tạo :</label>
                         <input name="ngaytao1" class="form-control " type="date" >

                         <label>Mã phiếu :</label>
                          <input name="maphieu1" class="form-control " type="text" >

                     </div>
                  </div>
               </form>
            </div>
            <!-- Modal footer -->
            <div class="modal-footer">
              <button type="button" class="btn btn-success" onclick="them()"> Tạo</button>
               <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
            </div>
         </div>
      </div>
   </div>
</div>


<script>
$(document).ready(function () {

           $.ajax({
                       url: '/api/phieuchi',
                       type:'GET',
                       dataType:'json',
                       contentType: "application/json",
                       success: function (res){
 console.log(res)
                       var row = ``;
                           $.each(res, function (i, v) {

                                row+=`
                                 <tr id="question_20338">
                                 <td width="10px">`+(i+1)+`</td>

                                 <td>`+v.maPhieuChi+`</td>

                                 <td>
                                   admin
                                 </td>

                                 <td>`+v.tenNguoiNhan+`</td>

                                 <td>
                                    `+v.sotien+`
                                 </td>
                                 <td>`+v.noidungchi+`</td>
                                 <td>`+v.ghichu+`</td>
                                 <td>
                                    <button class="btn btn-warning btn-sm" id="`+v.id+`" onclick="showsua(this)">Xem</button>
                                 </td>
                              </tr>
                                `
                           })

                           $("#phieuthus").html(row)
                       },
                       error: function (res) {
                          console.log(res)
                       }
                   })



   })

       function showsua(e){
                var id = $(e).attr("id");
                   $.ajax({
                                         url: '/api/phieuchi/'+id,
                                         type:'GET',
                                         dataType:'json',
                                         contentType: "application/json",
                                         success: function (res){

                                            $("input[name='tentk']").val(res.doituongthanhtoan);
                                            $("input[name='doituongthu']").val(res.tenNguoiNhan);
                                            $("input[name='sotk']").val(res.soTK);
                                            $("input[name='tennguoitao']").val("admin");
                                            $("input[name='noidung']").val(res.noidungchi);
                                            $("input[name='sotien']").val(res.sotien);
                                            $("input[name='ghichu']").val(res.ghichu);
                                             $("input[name='ngaytao']").val(res.ngaytao);
                                             $("input[name='maphieu']").val(res.maPhieuChi);
                                            $("#ModalxemphieuThu").modal("show")
                                         },
                                         error: function (res) {
                                            console.log(res)
                                         }
                                     })
                }




   function showmodal(){
   getNguoiDung()
   $("#ModaltaophieuThu").modal("show")

   }

function them(){
                                            var doituongthanhtoan = $("input[name='tentk1']").val();
                                            var tenNguoiNhan = $("input[name='doituongthu1']").val();
                                            var soTK = $("input[name='sotk1']").val();
                                            var maND = $("#nguoidung").val();
                                            var noidungchi = $("input[name='noidung1']").val();
                                            var sotien = $("input[name='sotien1']").val();
                                            var ghichu = $("input[name='ghichu1']").val();
                                            var ngaytao =  $("input[name='ngaytao1']").val();
                                            var maPhieuChi =  $("input[name='maphieu1']").val();
                                                  var data = {

                                                    "doituongthanhtoan" : doituongthanhtoan,
                                                    "tenNguoiNhan" : tenNguoiNhan,
                                                    "soTK" : soTK,
                                                    "maND" : maND,
                                                    "noidungchi" : noidungchi,
                                                    "sotien" : sotien,
                                                    "ghichu" : ghichu,
                                                    "ngaytao" : ngaytao,
                                                    "maPhieuChi" : maPhieuChi
                                                  }
                                                  console.log(data)
                                                  $.ajax({
                                                                     url: '/api/phieuchi/add',
                                                                     type:'POST',
                                                                     data : JSON.stringify(data) ,
                                                                     dataType:'json',

                                                                     contentType: "application/json",
                                                                     success: function (res){
                                                                     alert("Thêm mới thành công")
                                                                        location.reload()
                                                                     },
                                                                     error: function (res) {
                                                                        console.log(res)
                                                                     }
                                                                 })

}


function timkiem(){
  var name = $("#key").val()
          $.ajax({
                         url: '/api/phieuchi/timkiem/'+name,
                         type:'GET',
                         dataType:'json',
                         contentType: "application/json",
                         success: function (res){
 var row = ``;
                           $.each(res, function (i, v) {

                                row+=`
                                 <tr id="question_20338">
                                 <td width="10px">`+(i+1)+`</td>

                                 <td>`+v.maPhieuChi+`</td>

                                 <td>
                                   admin
                                 </td>

                                 <td>`+v.tenNguoiNhan+`</td>

                                 <td>
                                    `+v.sotien+`
                                 </td>
                                 <td>`+v.noidungchi+`</td>
                                 <td>`+v.ghichu+`</td>
                                 <td>
                                    <button class="btn btn-warning btn-sm" id="`+v.id+`" onclick="showsua(this)">Xem</button>
                                 </td>
                              </tr>
                                `
                           })

                           $("#phieuthus").html(row)
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


</script>