<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8"%>
<div class="content-wrapper" style="min-height: 350px;">
<div class="container-fluid">
   <!-- /.row -->
   <div class="row  margin_top">
      <div class="col-12">
         <div class="card">
            <div class="card-header">
               <div class="container-fluid back_ground_search">
                  <div class="row">
                     <div class="col-md-4">
                        <div class="card card-warning">
                           <div class="card-header backgroung_while">
                              <h3 class="card-title color_title_icon_blue"><i class="fas fa-layer-group"></i>&nbsp;<span id="name_cate_group">DANH SÁCH NGƯỜI DÙNG</span></h3>
                           </div>
                           <!-- /.card-header -->
                           <div class="card-body">
                              <table class="table">
                                 <thead>
                                    <tr>
                                       <th>STT</th>
                                       <th>Mã nhân viên</th>
                                       <th>Tên nhân viên</th>
                                    </tr>
                                 </thead>
                                 <tbody id="nguoidungs">

                                 </tbody>
                              </table>
                           </div>
                        </div>
                     </div>
                     <div class="col-md-8">
                        <div class="card card-warning">
                           <div class="card-header backgroung_while ">
                              <h3 class="card-title color_title_icon_blue"><i class="fas fa-folder"></i>&nbsp;CHI TIẾT HOẠT ĐỘNG</h3>
                           </div>
                           <div class="card  card-outline" style="margin-bottom: 0px; margin-top:15px ; height:500px">
                              <div class="card-body p-0" style="height: 400px; overflow: auto; ">
                                    <table id="todotable" class="table table-striped">
                                		<thead>

                                		<tr>
                                		  <th>Hành động</th>
                                		  <th>Nội dung</th>
                                		  <th>Url</th>
                                		  <th>Thời gian</th>
                                		</tr>
                                		</thead>
                                    </table>
                              </div>
                              <!-- /.card -->
                           </div>
                           <!-- /.card-body -->
                        </div>
                     </div>
                     <!-- /.row -->
                  </div>
               </div>
            </div>
            <!-- /.row -->
         </div>
      </div>
   </div>
</div>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css" />
<script src = "http://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js" defer ></script>


<script >
    $(document).ready(function() {
      $.ajax({
                                    url: '/api/nguoidung',
                                    type:'GET',
                                    dataType:'json',
                                    contentType: "application/json",
                                    success: function (res){

                                     var row = ``;
                                     $.each(res,function(i,v){
                                        row+=`  <tr onClick="xemchitiet(this)" id="`+v.id+`">
                                                                <td>`+(i+1)+`</td>
                                                                <td>
                                                                   `+v.maND+`
                                                                </td>
                                                                <td>`+v.fullName+`</td>

                                                            </tr>`
                                       })

                                       $("#nguoidungs").html(row)

                                     },
                                    error: function (res) {
                                       console.log(res)
                                    }
                                })

    })

    function xemchitiet(e){
    var idND = $(e).attr("id")

     if ( $.fn.dataTable.isDataTable( '#todotable' ) ) {

             $.ajax({
                                                url:"/api/getAllByMaND/"+idND,
                                                type:'GET',
                                                dataType:'json',
                                                contentType: "application/json",
                                                success: function (res){
                                                   if(res.length>0){
                                                    $('#todotable').dataTable().fnClearTable();
                                                    $('#todotable').dataTable().fnAddData(res);
                                                   }else {
                                                    alert("Không tìm thấy dữ liệu")
                                                    $('#todotable').dataTable().fnClearTable();
                                                   }
                                                 },
                                                error: function (res) {
                                                   console.log(res)
                                                }
                                            })


     }
     else {

          var table = $('#todotable').DataTable({
                                			"sAjaxSource": "/api/getAllByMaND/"+idND,
                                			"sAjaxDataProp": "",
                                			"order": [[ 0, "asc" ]],
                                		"columns": [
                                				{ "data": "action"},
                                				{ "data": "note"},
                                				{ "data": "url"},
                                				{ "data": "time"},
                                			]
                                		 })
     }


   }

 </script>