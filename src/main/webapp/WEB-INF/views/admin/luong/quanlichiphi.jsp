<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8"%>
<div class="content-wrapper">
   <div class="py-2 px-2">
      <h4 class="page-title">
         <b>Quản lý chi phí trả trước</b>
      </h4>
   </div>
   <div class="row">
      <div class="col col-sm-12">
         <table class="table table-striped table-hover " id="table_document2">
            <thead>
               <tr>
                  <th style="width: 10%;">
                     STT
                  </th>
                  <th style="width: 10% ;">
                     Mã chi phí
                  </th>
                  <th style="width: 10% ;text-align: left ">
                     Mục đích chi tiêu
                  </th>
                  <th style="width: 10% ;">
                     Số tiền
                  </th>
                  <th style="width: 10% ;text-align: left ">
                     Ngày tạo
                  </th>
                  <th style="width: 15% ;text-align: left " class="text-center">
                     Chức năng
                  </th>
               </tr>
            </thead>
            <tbody id="listDocument">
               <tr id="question_20338">
                  <td>1</td>
                  <td>
                     BCC293
                  </td>
                  <td>lê thế hiếu</td>
                  <td>20/10/2021</td>
                  <td>Đã duyệt</td>
                  <td>  <a class="btn btn-info btn-sm" href="#" data-toggle="modal" data-target="#Modalsuagia"> Sửa</a>
                     <button onclick="deleteDocument(20338)" class="btn btn-danger btn-sm delete "> Khóa </button>
                     <button class="btn btn-warning btn-sm" data-toggle="modal" data-target="#Modalthemgia" >Thêm</button>
                  </td>
               </tr>
            </tbody>
         </table>
      </div>
   </div>
</div>
<div class="modal" id="Modalthemgia">
   <div class="modal-dialog modal-xs">
      <div class="modal-content">
         <!-- Modal Header -->
         <div class="modal-header">
            <h4 class="modal-title">Thêm chi phí trá trước</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
         </div>
         <!-- Modal body -->
         <div class="modal-body">
            <form>
               <div class="row">
                  <div class="col col-sm-12">
                     <label>Mã chi phí :</label>
                     <input name="tenNCC" class="form-control " type="text" >
                     <label>Số tiền : </label>
                     <input name="tenNv" class="form-control " type="number" >
                     <label>Ghi chú : </label>
                     <textarea id="w3review" name="w3review" cols="50" class="form-control " style="width: 465px; !important;
                        height: 100px;"></textarea>
                  </div>
            </form>
            </div>
            <!-- Modal footer -->
            <div class="modal-footer">
               <button type="button" class="btn btn-primary"  >Thêm</button>
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
            <h4 class="modal-title">Sửa thông tin danh mục</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
         </div>
         <!-- Modal body -->
         <div class="modal-body">
            <form>
               <div class="row">
                  <div class="col col-sm-12">
                     <label>Mã chi phí :</label>
                     <input name="tenNCC" class="form-control " type="text" >
                     <label> : </label>
                     <input name="tenNv" class="form-control " type="number" >
                     <label> : </label>
                                          <input name="tenNv" class="form-control " type="number" >

                      <label>Số tiền : </label>
                                           <input name="tenNv" class="form-control " type="number" >
                     <label>Ghi chú : </label>
                     <textarea id="w3review" name="w3review" cols="50" class="form-control " style="width: 465px; !important;
                        height: 100px;"></textarea>
                  </div>
            </form>
            </div>
            <!-- Modal footer -->
            <div class="modal-footer">
               <button type="button" class="btn btn-success"  >Sửa</button>
               <button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
            </div>
         </div>
      </div>
   </div>
</div>
<script type="text/javascript" src="//js.nicedit.com/nicEdit-latest.js"></script>
<script type="text/javascript">

</script>