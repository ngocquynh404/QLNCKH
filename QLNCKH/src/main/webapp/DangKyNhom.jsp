<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	 <div class="modal js-modal">
        <div class="modal-container js-modal-container">
            <div class="modal-close js-modal-close">
                <i class="ti-close"></i>
            </div>
            <header class="modal-header">
                <i class="modal-heading-icon ti-list">
                    Thành Viên Nhóm
                </i>
            </header>
            <div id="md-body" class="modal-body col-md-12">
	            <div class ="row">             
                      <label class="modal-label mt-6">
                          <i class="ti-user"></i>
                          Tên Sinh Viên
                      </label>
                      <input type="text" id="HoTen0" class="modal-input" value="@sv.HoTen" readonly>	               
                       <label class="modal-label mt-4">
                           <i class="ti-hand-point-right"></i>
                           Mã Số Sinh Viên
                       </label  >
                       <input  type="text" id="MSSV0" class="modal-input modal-label " value="@sv.MaSoSinhVien" readonly>                
	                   
	                    <div class=" mt-2col-2-Nhom ">
	                        <button style="padding: 12px; background: red; border: none " type="button">
	                            <i style="color: #fff; padding: 12px 10px" class="mt-1 fa fa-trash" id="remove">
	                            </i>
	                        </button>
	                    </div>
	                </div>
                </div>
                <div id="Nhom0" class="js-add">
                    <div class="col-md-5 col-2-Nhom">
                        <label class="modal-label">
                            <i class="ti-user"></i>
                            Tên Sinh Viên
                        </label>
                        <input type="text" id="HoTen0" class="modal-input" value="@tv.HoTen" readonly>
                    </div>
                    <div class="col-md-5 col-2-Nhom">
                        <label class="modal-label">
                            <i class="ti-hand-point-right"></i>
                            Mã Số Sinh Viên
                        </label>
                        <input type="text" id="MSSV0" class="modal-input" value="@tv.MaSoSinhVien" readonly>
                    </div>
                </div>
               
            </div>
            <button class="luu_nhom" id="btn-add" type="button">
                LƯU
                <i class="ti-check"></i>
            </button>            
        </div>
    </div>
</body>
</html>