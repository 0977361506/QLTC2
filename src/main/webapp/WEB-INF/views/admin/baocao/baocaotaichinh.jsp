<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8"%>
<div class="content-wrapper">
   <div class="py-2 px-2">
      <h4 class="page-title">
         <b>Báo cáo tài chính</b>
      </h4>
   </div>
   <div class="px-2">
      <div class="card">
         <div class="card-body">
            <form id="formSubmit">
               <input type="hidden" id="idUnit" value="">
               <input type="hidden" id="time" value="">
               <div class="row align-items-end">
                  <div class="col col-2">
                     <div>
                        <label>Tháng Năm</label>
                     </div>
                     <div>
                        <input class="form-control dateDistribution" id="month" autocomplete="off" type="month" name="month">
                     </div>
                  </div>
                          <div class=" col col-sm-2 d-flex add-on">
                                                                                                          <input name="key" id="key" class="form-control " placeholder="Tìm kiếm" type="text">
                                                                                                           <div class="input-group-btn">
                                                                                                               <button class="btn btn-default" onclick="timkiem()" style="margin: 0px" id="btnSearch" type="button"><i class="fas fa-search "></i></button>
                                                                                                           </div>


                                                                                            </div>

                  <div class="col d-flex col-sm-auto justify-content-end" style="margin-left:100px">
                     <div class="col-auto">
                        <button id="collection-salary" type="button"
                        onClick="taobaocao()"
                        style=" border-radius: 27px; " class="btn btn-info cursor-pointer">
                        <i class="fa fa-file-text-o"></i> Tạo báo cáo</button>
                     </div>
  <div class="col-auto">
                                                                  <button id="xemtruoc" type="button"
                                                                   onClick="showxemtruoc(this)"
                                                                   style=" border-radius: 27px; " class="btn btn-success cursor-pointer">
                                                                  <i class="fas fa-eye"></i> Xem trước </button>

                  </div>


                  </div>
               </div>
            </form>
         </div>
         <!-- /.card-header -->
         <div class="  p-0 mt-5">
            <div>
               <h4>Danh sách file báo cáo: </h4>
            </div>
            <table class="table table-hover  table_competition">
               <tbody>
                  <tr>
                     <th class="text-center">STT</th>
                     <th class="text-center">Tên báo cáo</th>
                     <th class="text-center">Ngày tạo</th>
                     <th class="text-center">Người tạo</th>
                     <th class="text-center">Thao tác</th>
                  </tr>
               </tbody>
               <tbody id="data-list">

               </tbody>
            </table>
            <div class="row text-center" style="padding-right: 1%;float: right;margin-top: 30px;">
               <ul id="pagination-test" class="pagination">
                  <li class="page-item first disabled"><a href="#" class="page-link">Đầu tiên</a></li>
                  <li class="page-item prev disabled"><a href="#" class="page-link">Phía trước</a></li>
                  <li class="page-item active"><a href="#" class="page-link">1</a></li>
                  <li class="page-item next disabled"><a href="#" class="page-link">Tiếp theo</a></li>
                  <li class="page-item last disabled"><a href="#" class="page-link">Cuối cùng</a></li>
               </ul>
            </div>
         </div>
      </div>
   </div>
</div>


 <div class="modal" id="xemchitiet">
      <div class="modal-dialog modal-xl">
         <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">

               <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <!-- Modal body -->
            <div class="modal-body ">
               <form>
                  <div class="row">
                     <div class="col col-sm-12" >
                        <h3 class="showtime text-center" ><b>Chi tiết tồn kho theo tháng </b></h4>
                        <table class="table table-striped" style="margin-top:15px">
                           <thead>
                              <tr>
                                 <th>STT</th>
                                 <th>Mã hàng hóa</th>
                                 <th>Mã code</th>
                                 <th >Tên hàng hóa</th>
                                 <th >Số lượng nhập</th>
                                 <th>Số lượng xuất</th>
                                 <th>Số lượng bán ra</th>
                                 <th>Số lượng còn lại</th>
                              </tr>
                           </thead>
                           <tbody id="danhsachluong">

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




<script>
    $(document).ready(function () {
       $.ajax({
                               url: '/api/report/2',
                               type:'GET',
                               dataType:'json',
                               contentType: "application/json",
                               success: function (res){

                                var row = ``;
                                $.each(res,function(i,v){
                                   row+=`  <tr>
                                                               <td class="text-center">`+(i+1)+`</td>
                                                               <td class="text-center"><span>`+v.ten+`</span></td>
                                                               <td class="text-center"><span>`+v.ngaytao+`</span></td>
                                                               <td class="text-center"><span>`+v.nguoitao+`</span></td>
                                                               <td class="text-center"><a href="/download/baocaodoanhthu?nameFile=`+v.ten+`"
                                                               style="font-size: 20px"><i class="fa fa-download" aria-hidden="true"></i></a>
                                                                  <a class="ml-3 delete-report" href='#'
                                                                                                   id="`+v.id+`"
                                                                                                   onClick="xoabanghi(this)" style="font-size: 20px; cursor: pointer">
                                                                                                  <i class="fa fa-trash" aria-hidden="true"></i></a>
                                                             </td>
                                                            </tr>`
                                  })

                                  $("#data-list").html(row)

                                },
                               error: function (res) {
                                  console.log(res)
                               }
                           })
    })


function taobaocao(){
  var month = $("#month").val()
   if(month){
        $.ajax({
                                         url: '/api/report/baocaodoanhthu?thang='+month,
                                         type:'GET',
                                         dataType:'json',
                                         contentType: "application/json",
                                         success: function (res){
                                           //window.location.assign('/download/baocaoluong?nameFile=' + name);
                                           if(res==500) alert("Không tìm thấy dữ liệu !")
                                           else{
                                            alert("Tạo báo cáo thành công !")
                                            location.reload();

                                            }
                                           console.log(res)
                                          },
                                         error: function (res) {
                                           //  window.location.assign('/download/baocaoluong?nameFile=baocaoQLTCv2.xlsx');
                                           alert("Tạo báo cáo thành công!")
                                           location.reload();
                                         }
                                     })
   }else alert("Chọn tháng cần xuất báo cáo !")



}

function timkiem(){
var name = $("#key").val()
  $.ajax({
                               url: '/api/report/2/'+name,
                               type:'GET',
                               dataType:'json',
                               contentType: "application/json",
                               success: function (res){

                                var row = ``;
                                $.each(res,function(i,v){
                                   row+=`  <tr>
                                                               <td class="text-center">`+(i+1)+`</td>
                                                               <td class="text-center"><span>`+v.ten+`</span></td>
                                                               <td class="text-center"><span>`+v.ngaytao+`</span></td>
                                                               <td class="text-center"><span>`+v.nguoitao+`</span></td>
                                                              <td class="text-center"><a href="/download/baocaodoanhthu?nameFile=`+v.ten+`"
                                                                                                                             style="font-size: 20px"><i class="fa fa-download" aria-hidden="true"></i></a>

                                                                  <a class="ml-3 delete-report" href='#'
                                                                                                                                                                   id="`+v.id+`"
                                                                                                                                                                   onClick="xoabanghi(this)" style="font-size: 20px; cursor: pointer">
                                                                                                                                                                  <i class="fa fa-trash" aria-hidden="true"></i></a>
                                                                 </td>
                                                            </tr>`
                                  })

                                  $("#data-list").html(row)

                                },
                               error: function (res) {
                                  console.log(res)
                               }
                           })
}


function showxemtruoc(e){
  var month = $("#month").val()
  if(month){
   $.ajax({
                                      url: '/api/report/showDetail/baocaokho?thang='+month,
                                      type:'GET',
                                      dataType:'json',
                                      contentType: "application/json",
                                      success: function (res){
                                        console.log(res)
                                  var row = ``;
                                $.each(res,function(i,v){
                                   row+=`  <tr>
                                                               <td class="text-center">`+(i+1)+`</td>
                                                               <td class="text-center"><span>`+v.maHH+`</span></td>
                                                               <td class="text-center"><span>`+v.maCode+`</span></td>
                                                               <td class="text-center"><span>`+v.tenHH+`</span></td>
                                                               <td class="text-center"><span>`+((v.soluongnhap !=null)?v.soluongnhap:0)+`</span></td>
                                                               <td class="text-center"><span>`+((v.soluongxuat !=null)?v.soluongxuat:0)+`</span></td>
                                                               <td class="text-center">`+((v.soluongbanra !=null)?v.soluongbanra:0)+`</td>
                                                                <td class="text-center">`+((v.soluongconlai !=null)?v.soluongconlai:0)+`</td>

                                                            </tr>`
                                  })

                                    $("#danhsachluong").html(row)
                                     $("#xemchitiet").modal("show")
                                       },
                                      error: function (res) {
                                        console.log(res)
                                      }
                                  })
  }else alert("Chọn tháng cần xem trước !")


}



function xoabanghi(e){
var id = $(e).attr("id")
if(confirm("Bạn chắc chắn muốn xóa ?")){
          $.ajax({
                                  url: '/api/report/deleteBaoCao/'+id,
                                  type:'GET',
                                  dataType:'json',
                                  contentType: "application/json",
                                  success: function (res){
                                        alert("Xóa bản ghi thành công !")
                                       location.reload()
                                    }
                                  ,error: function (res) {
                                     console.log(res)
                                  }
                              })
 }
}



</script>