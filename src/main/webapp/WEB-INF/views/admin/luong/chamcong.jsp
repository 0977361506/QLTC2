<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8"%>
<div class="content-wrapper">
   <div class="py-2 px-2">
      <h4 class="page-title">
         <b>Chấm công nhân viên</b>
      </h4>
   </div>
   <div class="px-2">
      <div class="card">
         <div class="card-body">
            <form id="formSubmit">
               <input type="hidden" id="idUnit" value="">
               <input type="hidden" id="checkBlock" value="0">
               <div class="row align-items-end">
                  <div class="col col-2">
                     <div>
                        <label>Ngày làm việc</label>
                     </div>
                     <div>
                       <input type="date" id="ngaylamviec" class="form-control ngaylamviec" />
                     </div>
                  </div>


                                  <div class="col col-2">
                                        <div>
                                           <label>Số ngày làm việc</label>
                                        </div>
                                        <div >
                                          <select id="songaylamviec"  name="select_honnor" class="form-control">
                                                      <option value="0">0</option>
                                                      <option value="0.5">0.5</option>
                                                      <option value="1">1</option>
                                          </select>
                                        </div>
                                     </div>

                              <div class="col col-2">
                                                          <div>
                                                             <label>Nhân viên</label>
                                                          </div>
                                                          <div>
                                                            <select id="nhanvien"  name="nhanvien" class="form-control js-example-basic-single">

                                                            </select>
                                                          </div>
                                                       </div>



                  <div class="col d-flex col-sm-auto justify-content-end" style="margin-left:100px">
                     <div class="col-auto">
                        <button id="collection-salary" type="button"
 onClick="xuatfile()"
                        style=" border-radius: 27px; " class="btn btn-info cursor-pointer">
                    <i class="fas fa-file-download" style="margin-right: 10px;"></i>Xuất file</button>
                     </div>
                      <div class="col-auto" id="khoaso">
                                                   <button  type="button"
                                              onClick="khoaso()"
                                                   style=" border-radius: 27px; " class="btn btn-danger cursor-pointer" >
                                                     <i class="fas fa-lock" style="margin-right: 10px;"></i>Khóa sổ</button>
                      </div>
                          <div class="col-auto" style="display:none" id="moso" check="1">
                                                                         <button  type="button"
                                                                    onClick="moso()"
                                                                         style=" border-radius: 27px; " class="btn btn-success cursor-pointer"  >
                                                                           <i class="fas fa-lock-open" style="margin-right: 10px;"></i>Mở sổ</button>
                                            </div>

                 <div class="col-auto">
                        <button id="chamcong" type="button"
                   onClick="taobaocao()"
                        style=" border-radius: 27px; " class="btn btn-success cursor-pointer" >
                           <i class="fa fa-file-text-o" style="margin-right: 10px;"></i> Chấm công</button>
                     </div>

                  </div>
               </div>
            </form>
         </div>
         <!-- /.card-header -->
         <div class="  p-0 mt-5">
            <div>
               <h4>Bảng công nhân viên theo ngày làm việc : </h4>
            </div>
            <table class="table table-hover  table_competition">
               <tbody>
                  <tr>
                     <th>STT</th>
                     <th >Mã nhân viên</th>
                     <th>Tên nhân viên</th>
                     <th >Ngày công</th>
                     <th>Ngày chấm công</th>
                     <th>Thao tác</th>
                  </tr>
               </tbody>
               <tbody id="bangcong">

               </tbody>
            </table>
          <div class=" text-center" >
               <button class="btn btn-primary" type="button" onclick="saveChamCong()">Lưu</button>
            </div>
         </div>
      </div>
   </div>
</div>


<script>

 const CART = {
            KEY: 'chamcongnhanvien',
            contents: [],
            init(){
                //check localStorage and initialize the contents of CART.contents
                let _contents = localStorage.getItem(CART.KEY);
                if(_contents){
                    CART.contents = JSON.parse(_contents);
                }else{
                    //dummy test data
                    CART.contents = [];
                    CART.sync();
                }
            },
            async sync(){
                let _cart = JSON.stringify(CART.contents);
                await localStorage.setItem(CART.KEY, _cart);
            },
            find(id,ngaylamviec){
                //find an item in the cart by it's id
                let match = CART.contents.filter(item=>{
                    if(item.id == id && item.ngaylamviec==ngaylamviec)
                        return true;
                });
                if(match && match[0])
                    return match[0];
            },
            add(id,element,obj,ngaylamviec){
                //add a new item to the cart
                //check that it is not in the cart already
                if(CART.find(id,ngaylamviec)){
                    if(confirm("Bạn muộn cập nhật lại thông tin ngày công ?")){
                       CART.increase(id,element);
                    }
                }else{
                        CART.contents.push(obj);
                        //update localStorage
                        CART.sync();

                }
            },
            increase(id, qty){
                //increase the quantity of an item in the cart
                CART.contents = CART.contents.map(item=>{
                    if(item.id === id)
                        item.songaylamviec = qty;
                    return item;
                });
                //update localStorage
                CART.sync()
            }
            ,
            remove(id,ngaylamviec){
                //remove an item entirely from CART.contents based on its id
                CART.contents = CART.contents.filter(item=>{
                      if(item.id !== id && item.ngaylamviec!==ngaylamviec) return true;
                });
                //update localStorage
                CART.sync()
            },
            empty(){
                //empty whole cart
                CART.contents = [];
                //update localStorage
                CART.sync()
            },
            logContents(prefix){
                console.log(prefix, CART.contents)
            }
        };





    $(document).ready(function () {
        CART.init();
        getNguoiDung();
        showbangcong()
         $('.js-example-basic-single').select2();

    })

function showbangcong(){
   var baocaos =JSON.parse(localStorage.getItem("chamcongnhanvien"));
   var row = ``;

     $.each(baocaos, function (i, v) {

                                   row+=`
                                    <tr id="question_20338">
                                    <td width="10px">`+(i+1)+`</td>

                                    <td>`+v.manv+`</td>

                                    <td>
                                      `+v.hoten+`
                                    </td>

                                    <td>`+v.songaylamviec+`</td>

                                    <td>
                                       `+v.ngaylamviec+`
                                    </td>

                                    <td>
                                       <button class="btn btn-warning btn-sm" id="`+v.id+`"
                                       ngay="`+v.ngaylamviec+`"
                                       onclick="xoaChamCong(this)"><i class="far fa-trash-alt"></i></button>
                                    </td>
                                 </tr>
                                   `
                              })

              $("#bangcong").html(row)
}

function xoaChamCong(e){
  var id = $(e).attr("id");
  var ngay = $(e).attr("ngay");

  if(confirm("Bạn chắc chắn muốn xóa ?")){
      CART.remove(id,ngay);
      showbangcong();
  }
}




function taobaocao(){
     var nhanvien = $("#nhanvien").val()
     var songaylamviec = $("#songaylamviec").val();
     var ngaylamviec =$(".ngaylamviec").val()
   var data ={
        "thanglamviec" : ngaylamviec ,
        "mand" : nhanvien
     }

if(ngaylamviec){
 $.ajax({
                                                                     url: '/api/checkChamcong',
                                                                     type:'POST',
                                                                     data : JSON.stringify(data) ,
                                                                     dataType:'json',
                                                                     contentType: "application/json",
                                                                     success: function (res){

                                                                            var maid = res.maND;
                                                                            var hoten = res.fullName;
                                                                         var obj ={
                                                                                   "id" : res.id,
                                                                                  "manv" : maid ,
                                                                                  "hoten" :  hoten,
                                                                                  "songaylamviec" : songaylamviec ,
                                                                                  "ngaylamviec" : ngaylamviec
                                                                               }
                                                                           CART.add(res.id,songaylamviec,obj,ngaylamviec)
                                                                           showbangcong();
                                                                           alert("Chấm công thành công !")

                                                                     },
                                                                     error: function (res) {
                                                                     alert("Nhân viên này đẫ được chấm công !")
                                                                     }
                                                                 })
}else alert("Chọn ngày chấm công !")


}



function xuatfile(){  //chamcong
  var check = $("#checkBlock").val();
  if(check==1){
  var data =JSON.parse(localStorage.getItem("chamcongnhanvien"));
    if(data.length>0){
       $.ajax({
                                                                           url: '/api/report/exportChamCong',
                                                                           type:'POST',
                                                                           data : JSON.stringify(data) ,
                                                                           dataType:'json',
                                                                           contentType: "application/json",
                                                                           success: function (res){
                                                                              window.location.assign('/download/baocaokho?nameFile=' + res);

                                                                           },
                                                                           error: function (res) {
                                                                           var name = res.responseText
                                                                           console.log(name)
                                                                              window.location.assign('/download/baocaokho?nameFile=' + name);
                                                                           }
                                                                       })
    }else alert("Chưa có dữ liệu !")


  }else alert("Bạn cần chốt sổ để có thể xuất file !")
}

function saveChamCong(){
var data =JSON.parse(localStorage.getItem("chamcongnhanvien"));
  var check = $("#checkBlock").val();
  if(check==1){

  if(data.length>0){
     $.ajax({
                                                                         url: '/api/saveChamCong',
                                                                         type:'POST',
                                                                         data : JSON.stringify(data) ,
                                                                         dataType:'json',
                                                                         contentType: "application/json",
                                                                         success: function (res){
                                                                         if(res==200) {
                                                                         localStorage.removeItem("chamcongnhanvien");
                                                                         alert("Tạo bảng công thành công !")
                                                                         location.reload()
                                                                         }

                                                                         },
                                                                         error: function (res) {
                                                                            console.log(res)
                                                                         }
                                                                     })
     }else alert("Chưa có dữ liệu !")
  }else alert("Bạn cần chốt sổ để có thể lưu bảng công !")


}



function khoaso(){

    if(confirm("Bạn chắc chắn muốn chốt sổ công ?")){

          var nhanvien = $("#nhanvien").attr('readonly', true);
         var songaylamviec = $("#songaylamviec").attr('readonly', true);
         var ngaylamviec =$(".ngaylamviec").attr('readonly', true);

         $("#chamcong").css("display","none")
         $("#moso").css("display","block")
         $("#khoaso").css("display","none")
         $("#checkBlock").val(1)
    }

}
function moso(){

    if(confirm("Bạn chắc chắn muốn mở sổ công ?")){

          var nhanvien = $("#nhanvien").attr('readonly', false);
         var songaylamviec = $("#songaylamviec").attr('readonly', false);
         var ngaylamviec =$(".ngaylamviec").attr('readonly', false);

         $("#chamcong").css("display","block")
         $("#khoaso").css("display","block")
          $("#moso").css("display","none")
          $("#checkBlock").val(0)
    }

}

  function getNguoiDung(){
           $.ajax({
                          url: '/api/filterNguoidung/1',
                          type:'GET',
                          dataType:'json',
                          contentType: "application/json",
                          success: function (res){
                          var row = ``;
                               $.each(res, function (i, v) {
                                 row+=`<option value="`+v.id+`" maid="`+v.maND+`">`+v.fullName+`</option>`
                               })
                               $("#nhanvien").html(row);

                             // $("#danhsachhanghoa").html(row) <option value="0">Mới</option>
                          },
                          error: function (res) {
                             console.log(res)
                          }
                      })


      }

</script>

