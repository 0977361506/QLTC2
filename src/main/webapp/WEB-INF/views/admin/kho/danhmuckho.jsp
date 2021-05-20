<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8"%>
<div class="content-wrapper" style="min-height: 350px;">
<div class="container-fluid">
   <!-- /.row -->
   <div class="row  margin_top">
      <div class="col-12">
         <div class="card">
            <div class="card-header">
               <div class="caption"><i class="fas fa-layer-group font-green"></i>
                  <span class="caption-subject font-green sbold uppercase">Danh mục kho
                  </span>
               </div>
            </div>
            <div class="card-header">
               <div class="container-fluid back_ground_search">
                  <div class="row">
                     <div style="    margin-bottom: 10px;">
                        <div class="d-flex add-on">
                                                        <input name="key" id="key" class="form-control " placeholder="Tìm kiếm" type="text">
                                                        <div class="input-group-btn">
                                                            <button class="btn btn-default" onClick="timkiem()"
                                                            style="margin: 0px" id="btnSearch" type="button"><i class="fas fa-search "></i></button>
                                                        </div>
                                                    </div>
                     </div>


                     <!-- /.card-header -->
                     <div class="card-body table-responsive p-0 table_competition">
                        <table class="table table-head-fixed text-nowrap">
                           <thead>
                              <tr>
                                 <th>STT</th>
                                 <th>Mã danh mục</th>
                                 <th>Tên danh mục</th>
                                 <th>Ngày tạo</th>
                                 <th class="col_action">Chức năng</th>
                              </tr>
                           </thead>
                           <tbody id="danhmucs">

                           </tbody>
                        </table>
                        <div class="float-right">
                           <span><span id="count_record" count="1">1 Bản ghi dữ liệu</span></span>
                           <div class="btn-group">
                              <a href="#data_list_competition" id="id_page_left" type="button" class="btn btn-default btn-sm"><i class="fas fa-chevron-left"></i></a>
                              <input id="number_pages" min="1" class="input_page" type="number" value="1">
                              <a href="#data_list_competition" id="id_page_right" type="button" class="btn btn-default btn-sm"><i class="fas fa-chevron-right"></i></a>
                           </div>
                        </div>
                     </div>
                     <div class="position-absolute loader " style="display: none;">
                        <div class="spinner-border " style="position:fixed;width: 3rem; height: 3rem;top: 50%;left: 50%" role="status">
                           <span class="sr-only">Loading...</span>
                        </div>
                     </div>
                     <!-- /.card-body -->
                  </div>
                  <!-- /.card -->
               </div>
            </div>
            <!-- /.row -->
         </div>
      </div>
   </div>
</div>

 <div class="modal" id="Modalthemdanhmuc">
      <div class="modal-dialog modal-xs">
         <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
               <h4 class="modal-title">Thêm danh mục kho</h4>
               <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <!-- Modal body -->
            <div class="modal-body">
               <form>
                  <div class="row">
                     <div class="col col-sm-12">

                        <label>Tên danh mục: </label>
                        <input name="tendm" class="form-control " type="text" >

                  </div>
               </form>
            </div>
            <!-- Modal footer -->
            <div class="modal-footer">
             <button type="button" class="btn btn-primary" onClick="them()"  >Thêm</button>
               <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
            </div>
         </div>
      </div>
   </div>
</div>


 <div class="modal" id="Modalsuadanhmuc">
      <div class="modal-dialog modal-xs">
         <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
               <h4 class="modal-title">Sửa thông tin danh mục</h4>
               <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <!-- Modal body -->
            <div class="modal-body">
               <form>
                  <div class="row">
                     <div class="col col-sm-12">
                        <label>Mã danh mục :</label>
                                               <input name="madm1" class="form-control " type="text"  readonly>
                                               <label>Tên danh mục: </label>
                                               <input name="tendm1" class="form-control " type="text" >

                                                                </div>

                  </div>
               </form>
            </div>
            <!-- Modal footer -->
            <div class="modal-footer">
             <button type="button" class="btn btn-success suadm" id="" onClick="suadm(this)"  >Sửa</button>
               <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
            </div>
         </div>
      </div>
   </div>
</div>


<script>
$(document).ready(function () {

           $.ajax({
                       url: '/api/danhmuckho',
                       type:'GET',
                       dataType:'json',
                       contentType: "application/json",
                       success: function (res){
                       var row = ``;
                           $.each(res, function (i, v) {
                                row+=`<tr id="tr_test62">             <td>`+(i+1)+`</td>
                                                                       <td>`+v.id+`</td>
                                                                       <td>`+v.tenDM+`</td>


                                                                       <td>`+v.ngaytao+`</td>
                                                                       <td>
                                                                          <div class="input-group-addon">
                                                                             <div class="label label-info" data-toggle="dropdown" style="    width: 31px;"><i class="fas fa-th icon-th"></i></div>
                                                                             <ul class="dropdown-menu item-drop-competition">
                                                                                <a href="#" onClick="showmodal()">
                                                                                   <li class="dropdown-item"><i class="far fa-plus-square"></i>&nbsp;Thêm</li>
                                                                                </a>
                                                                                <a id=`+v.id+` onclick="showsua(this)" href="#"
                                                                                href="#">
                                                                                   <li class="dropdown-item"><i class="far fa-edit"></i>&nbsp;Sửa</li>
                                                                                </a>
                                                                             </ul>
                                                                          </div>
                                                                       </td>
                                                                    </tr>`
                           })

                           $("#danhmucs").html(row)
                       },
                       error: function (res) {
                          console.log(res)
                       }
                   })



   })

       function showsua(e){
                var id = $(e).attr("id");
                   $.ajax({
                                         url: '/api/danhmuckho/'+id,
                                         type:'GET',
                                         dataType:'json',
                                         contentType: "application/json",
                                         success: function (res){
                                            $("input[name='madm1']").val(res.id);
                                            $("input[name='tendm1']").val(res.tenDM);
                                            $(".suadm").attr("id",res.id)

                                          //  $(".btnsua").attr("idp",)
                                            $("#Modalsuadanhmuc").modal("show")
                                         },
                                         error: function (res) {
                                            console.log(res)
                                         }
                                     })
                }


   function suadm(){

                                            var tenDM = $("input[name='tendm1']").val();
                                            var id = $(".suadm").attr("id")
                                              var data = {

                                                "tenDM" : tenDM,
                                                "id" : id
                                              }
                                              console.log(data)
                                              $.ajax({
                                                                 url: '/api/danhmuckho/update',
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



   function showmodal(){

   $("#Modalthemdanhmuc").modal("show")

   }

function them(){

                                                var tenDM = $("input[name='tendm']").val();

                                                  var data = {

                                                    "tenDM" : tenDM,
                                                  }
                                                  console.log(data)
                                                  $.ajax({
                                                                     url: '/api/danhmuckho/add',
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
                         url: '/api/danhmuckho/timkiem/'+name,
                         type:'GET',
                         dataType:'json',
                         contentType: "application/json",
                         success: function (res){
                         console.log(res)
                                var row = ``;
                                                         $.each(res, function (i, v) {
                                                              row+=`<tr id="tr_test62">             <td>`+(i+1)+`</td>
                                                                                                     <td>`+v.id+`</td>
                                                                                                     <td>`+v.tenDM+`</td>


                                                                                                     <td>`+v.ngaytao+`</td>
                                                                                                     <td>
                                                                                                        <div class="input-group-addon">
                                                                                                           <div class="label label-info" data-toggle="dropdown" style="    width: 31px;"><i class="fas fa-th icon-th"></i></div>
                                                                                                           <ul class="dropdown-menu item-drop-competition">
                                                                                                              <a href="#" onClick="showmodal()">
                                                                                                                 <li class="dropdown-item"><i class="far fa-plus-square"></i>&nbsp;Thêm</li>
                                                                                                              </a>
                                                                                                              <a id=`+v.id+` onclick="showsua(this)" href="#"
                                                                                                              href="#">
                                                                                                                 <li class="dropdown-item"><i class="far fa-edit"></i>&nbsp;Sửa</li>
                                                                                                              </a>
                                                                                                           </ul>
                                                                                                        </div>
                                                                                                     </td>
                                                                                                  </tr>`
                                                         })

                                                         $("#danhmucs").html(row)
                         },
                         error: function (res) {
                            console.log(res)
                         }
                     })
}
</script>