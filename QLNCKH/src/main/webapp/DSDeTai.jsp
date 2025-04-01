<!--  
	@model IEnumerable < QLNCKH.Models.DTO.DTDeTai >
	@{
	    ViewBag.Title = "DsDeTai";
	    Layout = "~/Views/Shared/_LayoutQuanLyTong.html";
	}
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script> 

<head>

<title>Đề Tài</title>
<style>
    #txtLink:hover {
        border: 1px solid #6bacb2;
        cursor: pointer
    }

    h4 {
        margin: auto;
        font-weight: 600;
        font-size: 21px;
    }

    .modal-header {
        display: flex;
    }

        .modal-header .close {
            padding: 0;
            margin: 0;
        }

    .badge-color-success {
        background-color: #d6f0e0;
        color: #0d6832;
    }

    .badge-color-primary {
        background-color: #dfe7f6;
        color: #2c58a0;
    }

    .badge-color-warning {
        background-color: #fbf0da;
        color: #73510d;
    }
</style>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>
	<!--  <script src="~/Theme/toast/js/js-toast.js"></script>-->
	<!-- <script>
	
	    $(document).ready(function () {
	        $('#mytable').DataTable();
	    });
	
	</script>-->
	
	<header>
	
	<div class="content-wrapper">
    <div id="toast">
    </div>
    <div class="row">
        <div class="col-md-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h2 style="text-align:center">Danh Sách Đề Tài</h2>
                    <br />
                    <br />
                    <div style="display:flex;justify-content:space-between">                                       
                    </div>
                    <br />
                    <div class="row">
                        <div class="col-12">
                            <div class="table-responsive">

                                <table class="table" id="mytable">
                                    <thead class="bg-light">
                                        <tr>
                                   		<th>
                                               <label></label>  
                                            </th>                                          
                                            <th>
                                                <h5>Tên Đề Tài</h5>
                                            </th>
                                            <th>
                                                <h5>Mã Ngành</h5>
                                            </th>
                                            <th>
                                                <h5>Link </h5>
                                            </th>
                                            <th>
                                                <h5>Ngày thực hiện</h5>
                                            </th>
                                            <th>
                                                <h5>Ngày kết thúc</h5>
                                            </th>
                                            <th>
                                                <h5>Kinh phí</h5>
                                            </th>
                                            <th>
                                                <h5>GVHD</h5>
                                            </th>
                                                    </tr>                                                                                                       
                                            <c:forEach var="detai" items="${listdetai}">				
											<tr id ="">		
												<td><a style="display: none;"><c:out value="${detai.madetai}" /> </a></td>									
												<td><a><c:out value="${detai.tendetai}" /></a></td>
												<td><a><c:out value="${detai.makhoa}" /></a></td>
												<td><a><c:out value="${detai.linkdetai}" /></a></td>					
											 	<td><a><c:out value="${detai.ngaythuchien}" /></a></td>
											 	<td><a><c:out value="${detai.ngayketthuc}" /></a></td>
											 	<td><a><c:out value="${detai.kinhphidukien}" /></a></td>
											 	<td><a><c:out value="${detai.msgv}" /></a></td>
											 		<td style="text-align:center">
	                                     <button  class=" btn btn-sm btn-info" name="view" ><i class="fa fa-bars"></i></button>
	                                  	<button class="btn btn-sm btn-warning" name="plus" onclick ="insert()"><i class="fa fa-plus"></i></button>
	                                    <a class="btn btn-sm btn-warning"  onclick ="ShowMess('${detai.madetai}')"><i class=" fa fa-trash"></i></a>
	                                    <a class="btn btn-sm btn-warning" onclick ="UpdateDT('${detai.madetai}')" ><i class="fa fa-edit"></i></a>                                                                         
                                </td>
                                         </tr>
                                         </c:forEach> 
                                          </thead>    																		                                                                                                                                                                										                                                                            
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>


	<div class="modal fade" id="modalPCDetai" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	    <div class="modal-dialog" role="document">
	        <div class="modal-content">
	            <div class="modal-body">
	                <h5 id="textbody">Bạn Có chắc chắn muốn xóa!</h5>
	                <div id="body" class="form-group">
	                    <label>Phân công: </label>
	                    <select class="form-control" id="Select_DsHD">
	                    </select>
	                </div>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-success" id="btn-addPCDT">Xác nhận</button>
	                <button type="button" class="btn btn-success" id="btn-HuyPCDT">Hủy</button>
	                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
	            </div>
	        </div>
	    </div>
	</div>
</header>	
<form method ="get" action ="edit">
	<input type ="hidden" name ="madetai" >
	<div class="modal fade bd-example-modal-lg" id="modalDeTai" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog " role="document">
        <div class="modal-content">  
       
					
            <div class="card-body">
                <h3 style="font-weight:700;text-align:center;" class="modal-title" id="modalTitle"></h3>
            </div>
            <div class="modal-body">
           
                <table class="table">  
                    <tr>                
                        <td>                     
                        <fieldset>
                            <label>Mã đề tài:</label>                           
                            <input type="text" value="${detai.madetai }"  class="form-control" name="txtMaDT" />
                       	</fieldset>	
                        </td>
                       <td>	
                       		<fieldset>	
                            <label>Ngày thực hiện:</label>                            
                            <input type="date"value="${detai.ngaythuchien }"   class="form-control" name="txtNgayTH" />
                        	</fieldset>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <fieldset>                       
                            <label>Tên đề tài</label>
                            <input type="text" value="${detai.tendetai }"  class="form-control" name="txtTenDT" />
                        	</fieldset>	
                        </td>
                        <td>
                        	<fieldset>
                            <label>Ngày kết thúc:</label>                           
                            <input type="date" value="${detai.ngayketthuc }"  class="form-control" name="txtNgayKT" />
                        	</fieldset>	
                        </td>
                    </tr>
                    <tr>
                        <td>
                         	<fieldset>
                            <label>Khoa:</label>                          
                            <input type="text" value="${detai.makhoa }"   class="form-control" name="txtkhoa" />
                        	</fieldset>	
                        </td>
                        <td>
                         	<fieldset>
                            <label>Kinh Phí:</label>
                            <input type="text" value="${detai.kinhphidukien }"  class="form-control" name="txtKinhPhi" />
                        	</fieldset>	
                        </td>
                    </tr>
                    <tr>
                        <td>
                        	<fieldset>
                            <label>Link Đề Tài:</label>                         	
                            <input type="text" value="${detai.madetai }"  class="form-control" name="txtLinkDT" />
                            </fieldset>	
                        </td>       
                         <td>
                        	<fieldset>
                            <label>Giảng Viên HD:</label>                         	
                            <input type="text" value="${detai.msgv }"   class="form-control" name="txtgv" />
                            </fieldset>	
                        </td>                   
                    </tr>                
                </table>
               
            </div>
            <div class="modal-footer">
                <button type="button" id ="btnDong"class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                <button type="submit"  id ="btnLuu" class="btn btn-secondary" data-dismiss="modal" >Lưu</button>
            </div>
         
        </div>    
       
    </div>
</div>
</form>
	
   <!--   //$(document).ready(function () {
   //     Get_DSHD();
    //});-->
    <script>
	   
    function ShowMess(id) {
    	
	      	var option = confirm ("Bạn có chắc chắn muốn xóa!");
	      	if (option === true)
      		{
      			window.location.href ='delete?MaDeTai='+id;
      		} 
        };
        </script>
        <script>
        function UpdateDT(id) {
        	
	      	var option = confirm ("Bạn có chắc chắn muốn xóa!");
	      	if (option === true)
      		{
      			window.location.href ='edit?madetai='+id;
      		} 
        };
        </script>
          <script>
        $(document).on('click', "button[name='plus']", function () {  
            console.log("Button 'update' clicked!");
            let id = $(this).closest('tr').attr('id');
           
            $('#body').show();
            $('#btnDong').hide();
            $('#btnLuu').show();
            $('#textbody').hide();
            $('#modalDeTai').modal();      
            
        });
    $(document).on('click', "button[name='update']", function () {  
        console.log("Button 'update' clicked!");
        let id = $(this).closest('tr').attr('id');
        $('#ModalTitleDeTai').text("PhÃ¢n cÃ´ng há»i Äá»ng cho Äá» tÃ i");
        $('#body').show();
        $('#btnDong').hide();
        $('#btnLuu').show();
        $('#textbody').hide();
        
        // Hiển thị modal
        $('#modalDeTai').modal();      
        
    });
    $(document).on('click', "button[name='view']", function () {  
        console.log("Button 'view' clicked!");
        $('#body').show();
        $('#btnDong').show();
        $('#btnLuu').hide();
        // Lấy dữ liệu từ hàng được chọn
        let tendetai = $(this).closest('tr').find('td:eq(1)').text();
        let makhoa = $(this).closest('tr').find('td:eq(2)').text();
        let linkdetai = $(this).closest('tr').find('td:eq(3)').text();
        let ngaythuchien = $(this).closest('tr').find('td:eq(4)').text();
        let ngayketthuc = $(this).closest('tr').find('td:eq(5)').text();
        let kinhphi = $(this).closest('tr').find('td:eq(6)').text();
        let msgv = $(this).closest('tr').find('td:eq(7)').text();

        // Hiển thị thông tin trong modal
        $('#txtTenDT').val(tendetai);
        $('#txtkhoa').val(makhoa);
        $('#txtLinkDT').val(linkdetai);
        $('#txtNgayTH').val(ngaythuchien);
        $('#txtNgayKT').val(ngayketthuc);
        $('#txtKinhPhi').val(kinhphi);
        $('#txtgv').val(msgv);

        // Hiển thị modal
        $('#modalDeTai').modal();
    });
   
</script>
</body>
</html>