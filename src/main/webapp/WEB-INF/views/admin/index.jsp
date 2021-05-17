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
                                      <th style="width: 10% ;text-align: left ">
                                        Ghi chú
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
                                      <td>Riêng cho các học liệu,khóa học</td>
                                      <td>20/10/2021</td>
                                      <td>Đã duyệt</td>
                                      <td>  <a class="btn btn-info btn-sm" href="#" data-toggle="modal" data-target="#Modalxemchitiet">Xem</a>
                                         <button onclick="deleteDocument(20338)" class="btn btn-danger btn-sm delete "> Khóa </button>
                                         <button class="btn btn-warning btn-sm" data-toggle="modal" data-target="#Modalthem">Thêm</button>
                                      </td>
                                   </tr>
                                </tbody>
                             </table>
      </div>
   </div>

</div>