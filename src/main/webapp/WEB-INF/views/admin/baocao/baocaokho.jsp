<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8"%>
<div class="content-wrapper">
   <div class="py-2 px-2">
      <h4 class="page-title">
         <b>Báo cáo tồn kho</b>
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
                  <div class="col d-flex col-sm-auto justify-content-end" style="margin-left:100px">
                     <div class="col-auto">
                        <button id="collection-salary" type="button"
                        onClick="taobaocao()"
                        style=" border-radius: 27px; " class="btn btn-info cursor-pointer">
                        <i class="fa fa-file-text-o"></i> Tạo báo cáo</button>
                     </div>


                  </div>
               </div>
            </form>
         </div>
         <!-- /.card-header -->
         <div class="  p-0 mt-5">
            <div>
               <h4>Danh sách file lương nhân viên : </h4>
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


<script>
    $(document).ready(function () {
       $.ajax({
                               url: '/api/report/4',
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
                                                               <td class="text-center"><a href="/download/baocaokho?nameFile=`+v.ten+`"
                                                               style="font-size: 20px"><i class="fa fa-download" aria-hidden="true"></i></a>
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
   $.ajax({
                                    url: '/api/report/baocaokho?thang='+month,
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


}

</script>