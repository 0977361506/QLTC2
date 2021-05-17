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
                     <a href="/admin/document/category/" style="text-align: center">Quản lý giá mặt hàng</a> </span>
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
                                 <input name="name" id="key" class="form-control " placeholder="Tìm kiếm ..." type="text">
                                 <div class="input-group-btn">
                                    <button class="btn btn-default"
                                    onclick="timkiem()"
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
                     <table class="table table-striped table-hover " id="table_document2">
                        <thead>
                           <tr>
                              <th style="width: 10%;">
                                 STT
                              </th>

                              <th style="width: 10% ;">
                                 Mã giá
                              </th>
                              <th style="width: 10% ;text-align: left ">
                                 Tên
                              </th>
                              <th style="width: 10% ;text-align: left ">
                                 Giá tiền
                              </th>

                              <th style="width: 10% ;text-align: left ">
                                 Chức năng
                              </th>
                           </tr>
                        </thead>
                        <tbody id="gias">


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
</div>


 <div class="modal" id="Modalthemgia">
      <div class="modal-dialog modal-xs">
         <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
               <h4 class="modal-title">Thêm đơn giá</h4>
               <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <!-- Modal body -->
            <div class="modal-body">
               <form>
                  <div class="row">
                     <div class="col col-sm-12">

                        <label>Tên giá : </label>
                        <input name="tengia1" class="form-control " type="text" >

                         <label>Số tiền  : </label>
                        <input name="gia1" class="form-control " type="text" >

                        <label>Hàng hóa : </label>

                        <select id="hanghoa1" class="js-example-basic-single" name="state">
                          <option value="AL">Alabama</option>

                          <option value="WY">Wyoming</option>
                        </select>
                        <label>Ghi chú : </label>
                       <textarea id="ghichu1" name="w3review" cols="50" class="form-control " style="width: 465px; !important;
                                             height: 100px;"></textarea>

                  </div>
               </form>
            </div>
            <!-- Modal footer -->
            <div class="modal-footer">
             <button type="button" class="btn btn-primary" onclick="themgia()" >Thêm</button>
               <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
            </div>
         </div>
      </div>
   </div>
</div>


 <div class="modal" id="Modalsuagia">
      <div class="modal-dialog modal-xs">
         <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
               <h4 class="modal-title">Sửa thông tin gia</h4>
               <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <!-- Modal body -->
            <div class="modal-body">
               <form>
                  <div class="row">
                     <div class="col col-sm-12">
                        <label>Mã giá :</label>
                        <input name="magia" class="form-control " type="text" readonly>
                        <label>Tên giá : </label>
                        <input name="tengia" class="form-control " type="text" >
                         <label>Số tiền  : </label>
                                                <input name="gia" class="form-control " type="text" >

                        <label>Hàng hóa : </label>

                                                <select id="hanghoa" class="js-example-basic-single" name="state">
                                                  <option value="AL">Alabama</option>

                                                  <option value="WY">Wyoming</option>
                                                </select>
                                                <label>Ghi chú : </label>
                                               <textarea id="ghichu" name="w3review" cols="50" class="form-control " style="width: 465px; !important;
                                                                     height: 100px;"></textarea>


                  </div>
               </form>
            </div>
            <!-- Modal footer -->
            <div class="modal-footer">
             <button type="button" class="btn btn-success magiaKey" id="" onclick="suagia()" >Sửa</button>
               <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
            </div>
         </div>
      </div>
   </div>
</div>

  <script type="text/javascript" src="//js.nicedit.com/nicEdit-latest.js"></script>
  <script type="text/javascript">
  $(document).ready(function() {
      $('.js-example-basic-single').select2();
  });

  </script>


<script >
    $(document).ready(function() {

        $.ajax({
            url: '/api/gia',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            success: function(res) {
                var row = ``;
                $.each(res, function(i, v) {
                    row += `
                                   <tr id="question_20338">
                                                                <td width="10px">` + (i + 1) + `</td>

                                                                <td>
                                                                  ` + v.id + `
                                                                </td>

                                                                <td>` + v.tenGia + `</td>
                                                                <td>` + v.gia + `</td>
                                                                <td>  <a class="btn btn-info btn-sm"
                                                                id="` + v.id + `"
                                                                href="#" onclick="showsua(this)"> Sửa</a>

                                                                   <button class="btn btn-warning btn-sm" onclick="showmodal()" >Thêm</button>
                                                                </td>
                                                             </tr>`
                })

                $("#gias").html(row)
            },
            error: function(res) {
                console.log(res)
            }
        })



    })

function showsua(e) {
    var id = $(e).attr("id");
    $.ajax({
        url: '/api/gia/' + id,
        type: 'GET',
        dataType: 'json',
        contentType: "application/json",
        success: function(res) {
            $("input[name='magia']").val(res.id);
            $("input[name='tengia']").val(res.tenGia);
            $("input[name='gia']").val(res.gia);
            $(".magiaKey").attr("id", res.id)
            $("#ghichu").val(res.ghichu)
            getCategory(res.hang_hoaid)
            //  $(".btnsua").attr("idp",)
            $("#Modalsuagia").modal("show")
        },
        error: function(res) {
            console.log(res)
        }
    })
}


function suagia() {
    var hang_hoaid = $("#hanghoa").val();
    var tenGia = $("input[name='tengia']").val();
    var gia = $("input[name='gia']").val();
    var id = $(".magiaKey").attr("id")
    var ghichu = $("#ghichu").val() ;
    var data = {
        "hang_hoaid": hang_hoaid,
        "tenGia": tenGia,
        "gia": gia,
        "id" : id,
        "ghichu" : ghichu
    }
    console.log(data)
    $.ajax({
        url: '/api/gia/update',
        type: 'POST',
        data: JSON.stringify(data),
        dataType: 'json',

        contentType: "application/json",
        success: function(res) {
            alert("Cập nhật thanh công")
            location.reload()
        },
        error: function(res) {
            console.log(res)
        }
    })

}



function getCategory(id) {
    $.ajax({
        url: '/api/hanghoa',
        type: 'GET',
        dataType: 'json',
        contentType: "application/json",
        success: function(res) {
            console.log(res)
            var row = ``;
            $.each(res, function(i, v) {
                if (v.id == id) row += `<option value="` + v.id + `" selected>` + v.tenHH + `</option>`
                else row += `<option value="` + v.id + `">` + v.tenHH + `</option>`

            })
            $("#hanghoa").html(row);

            // $("#danhsachhanghoa").html(row) <option value="0">Mới</option>
        },
        error: function(res) {
            console.log(res)
        }
    })


}

function getCategory1(id) {
    $.ajax({
        url: '/api/hanghoa',
        type: 'GET',
        dataType: 'json',
        contentType: "application/json",
        success: function(res) {
            console.log(res)
            var row = ``;
            $.each(res, function(i, v) {
                if (v.id == id) row += `<option value="` + v.id + `" selected>` + v.tenHH + `</option>`
                else row += `<option value="` + v.id + `">` + v.tenHH + `</option>`

            })
            $("#hanghoa1").html(row);

            // $("#danhsachhanghoa").html(row) <option value="0">Mới</option>
        },
        error: function(res) {
            console.log(res)
        }
    })

}



function showmodal() {

    getCategory1(1)
    $("#Modalthemgia").modal("show")

}

function themgia() {
    var hang_hoaid = $("#hanghoa1").val();
    var tenGia = $("input[name='tengia1']").val();
    var gia = $("input[name='gia1']").val();
    var ghichu = $("#ghichu1").val()
    var data = {
        "hang_hoaid": hang_hoaid,
        "tenGia": tenGia,
        "gia": gia,
        "ghichu" : ghichu
    }
    console.log(data)
    $.ajax({
        url: '/api/gia/add',
        type: 'POST',
        data: JSON.stringify(data),
        dataType: 'json',

        contentType: "application/json",
        success: function(res) {
            alert("Thêm mới thành công")
            location.reload()
        },
        error: function(res) {
            console.log(res)
        }
    })

}


function timkiem() {
    var name = $("#key").val()
    $.ajax({
        url: '/api/gia/timkiem/' + name,
        type: 'GET',
        dataType: 'json',
        contentType: "application/json",
        success: function(res) {
            console.log(res)
            var row = ``;
            $.each(res, function(i, v) {
                row += `
                                                             <tr id="question_20338">
                                                                                          <td width="10px">` + (i + 1) + `</td>

                                                                                          <td>
                                                                                            ` + v.id + `
                                                                                          </td>

                                                                                          <td>` + v.tenGia + `</td>
                                                                                          <td>` + v.gia + `</td>
                                                                                          <td>  <a class="btn btn-info btn-sm"
                                                                                          id="` + v.id + `"
                                                                                          href="#" onclick="showsua(this)"> Sửa</a>

                                                                                             <button class="btn btn-warning btn-sm" onclick="showmodal()" >Thêm</button>
                                                                                          </td>
                                                                                       </tr>`
            })

            $("#gias").html(row)
        },
        error: function(res) {
            console.log(res)
        }
    })
}

 </script>