<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<aside class="main-sidebar sidebar-dark-primary elevation-4">
   <!-- Brand Logo -->
   <a href="index3.html" class="brand-link">
   <%--    <img src="https://vnpost.vnpt.edu.vn/assets/global/img/logo/logo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"--%>
   <%--    style="opacity: .8">--%>
   <span class="brand-text font-weight-light">Hệ Thống QLTC</span>
   </a>
   <!-- Sidebar -->
   <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <!-- Sidebar Menu -->
      <nav class="mt-2">
         <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
         <!-- Add icons to the links using the .nav-icon class
            with font-awesome or any other icon font library -->
         <li class="nav-item">
            <a href="/admin" class="nav-link">
               <i class="nav-icon fas fa-tachometer-alt"></i>
               <p>
                  Bảng điều khiển
               </p>
            </a>
         </li>
         <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
               <i class="nav-icon fas fa-table"></i>
               <p>
                  Kế toán hàng hóa
                  <i class="fas fa-angle-left right"></i>
               </p>
            </a>
            <ul class="nav nav-treeview">
               <li class="nav-item">
                  <a href="/admin/hanghoa/quanlyhanghoa" class="nav-link">
                     <i class="far fa-circle nav-icon"></i>
                     <p>Quản lý hàng hóa</p>
                  </a>
               </li>
               <li class="nav-item">
                  <a href="/admin/hanghoa/danhmuchanghoa" class="nav-link">
                     <i class="fa fa-folder-o nav-icon"></i>
                     <p>Quản lý danh mục hàng hóa</p>
                  </a>
               </li>
               <li class="nav-item">
                  <a href="/admin/hanghoa/giaban" class="nav-link">
                     <i class="far fa-user nav-icon"></i>
                     <p>Quản lý giá bán</p>
                  </a>
               </li>
            </ul>
         </li>
         <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
               <i class="nav-icon fas fa-table"></i>
               <p>
                  Kế toán kho
                  <i class="fas fa-angle-left right"></i>
               </p>
            </a>
            <ul class="nav nav-treeview">
               <li class="nav-item">
                  <a href="/admin/kho/danhmuckho" class="nav-link">
                     <i class="far fa-circle nav-icon"></i>
                     <p>Quản lý danh mục kho</p>
                  </a>
               </li>
               <li class="nav-item">
                  <a href="/admin/kho/quanlykho" class="nav-link">
                     <i class="far fa-circle nav-icon"></i>
                     <p>Quản lý thông tin kho</p>
                  </a>
               </li>
               <li class="nav-item">
                  <a href="/admin/kho/phieunhap" class="nav-link">
                     <i class="far fa-circle nav-icon"></i>
                     <p>Quản lý phiếu nhập</p>
                  </a>
               </li>
               <li class="nav-item">
                  <a href="/admin/kho/phieuxuat" class="nav-link">
                     <i class="far fa-circle nav-icon"></i>
                     <p>Quản lý phiếu xuất</p>
                  </a>
               </li>

            </ul>
         </li>
         </li>
         <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
               <i class="fas fa-comments" ></i>
               <p>
                  Quản lý Thu chi
                  <i class="fas fa-angle-left right"></i>
               </p>
            </a>
            <ul class="nav nav-treeview">
               <li class="nav-item">
                  <a href="/admin/thucthi/phieuthu" class="nav-link">
                     <i class="far fa-circle nav-icon"></i>
                     <p>Lập phiếu Thu</p>
                  </a>
               </li>
               <li class="nav-item">
                  <a href="/admin/thuchi/phieuchi" class="nav-link">
                     <i class="far fa-circle nav-icon"></i>
                     <p>Lập phiếu chi</p>
                  </a>
               </li>
            </ul>
         </li>

 <c:if test = "${sessionScope.user.quyen == 1}">
         <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
               <i class="nav-icon fas fa-book"></i>
               <p>
                  Kế toán lương
                  <i class="fas fa-angle-left right"></i>
               </p>
            </a>
            <ul class="nav nav-treeview">
               <li class="nav-item">
                  <a href="/admin/luong/nguoidung" class="nav-link">
                     <i class="far fa-circle nav-icon"></i>
                     <p>Quản lý người dùng</p>
                  </a>
               </li>
               <li class="nav-item">
                                 <a href="/admin/luong/chamcong" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Chấm công nhân viên</p>
                                 </a>
                              </li>

               <li class="nav-item">
                  <a href="/admin/luong/tinhluongnhanvien" class="nav-link">
                     <i class="far fa-circle nav-icon"></i>
                     <p>Tính lương nhân viên</p>
                  </a>
               </li>

            </ul>
         </li>
         <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
               <i class="nav-icon fas fa-chart-pie"></i>
               <p>
                  Báo cáo
                  <i class="fas fa-angle-left right"></i>
               </p>
            </a>
            <ul class="nav nav-treeview">
               <li class="nav-item">
                  <a href="/admin/baocao/baocaotaichinh" class="nav-link">
                     <i class="far fa-circle nav-icon"></i>
                     <p>Báo cáo tài chính</p>
                  </a>
               </li>
               <li class="nav-item">
                  <a href="/admin/baocao/baocaobanhang" class="nav-link">
                     <i class="far fa-circle nav-icon"></i>
                     <p>Báo cáo bán hàng</p>
                  </a>
               </li>

                <li class="nav-item">
                     <a href="/admin/baocao/baocaokho" class="nav-link">
                           <i class="far fa-circle nav-icon"></i>
                           <p>Báo cáo kho</p>
                     </a>
                 </li>

            </ul>
         </li>

                   <li class="nav-item has-treeview">
                                      <a href="#" class="nav-link">
                                         <i class="nav-icon fas fa-table"></i>
                                         <p>
                                            Bảo mật
                                            <i class="fas fa-angle-left right"></i>
                                         </p>
                                      </a>
                                      <ul class="nav nav-treeview">
                                         <li class="nav-item">
                                            <a href="/admin/baomat/luuvet" class="nav-link">
                                               <i class="far fa-circle nav-icon"></i>
                                               <p>Lưu vết người dùng</p>
                                            </a>
                                         </li>

                                      </ul>
                   </li>
          </c:if>


      </nav>
      <!-- /.sidebar-menu -->
   </div>
   <!-- /.sidebar -->
</aside>
<script src="/template/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="/template/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
   $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="/template/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="/template/plugins/chart.js/Chart.min.js"></script>
<!-- Sparkline -->
<script src="/template/plugins/sparklines/sparkline.js"></script>
<!-- JQVMap -->
<script src="/template/plugins/jqvmap/jquery.vmap.min.js"></script>
<script src="/template/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
<!-- jQuery Knob Chart -->
<script src="/template/plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="/template/plugins/moment/moment.min.js"></script>
<script src="/template/plugins/daterangepicker/daterangepicker.js"></script>
<script src="/template/plugins/select2/js/select2.full.min.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="/template/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="/template/plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="/template/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="/template/dist/js/adminlte.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="/template/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/template/dist/js/demo.js"></script>
<%--<script src="/template/hill/js/jquery-3.4.1.min.js"></script>--%>
<%-- <script src="/template/hill/js/roundtest/roundTestJs.js"></script>
   <script src="/template/hill/js/checkAll.js"></script>
   <script src=/template/hil<script src="/template/hill/js/jquery-3.4.1.min.js"></script>l/js/commom.js></script>--%>
<script src="/ckfinder/ckfinder.js"></script>
<script src="/template/ckeditor/ckeditor.js"></script>