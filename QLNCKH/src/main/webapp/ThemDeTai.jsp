<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
                            <input type="text" value="${detai.madetai}"  class="form-control" name="txtMaDT" />
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
                            <input type="text" value="${detai.linkdetai }"  class="form-control" name="txtLinkDT" />
                            </fieldset>	
                        </td>       
                         <td>
                        	<fieldset>
                            <label>Giảng Viên HD:</label>                         	
                            <input type="text" value="${detai.msgv }"  class="form-control" name="txtgv" />
                            </fieldset>	
                        </td>                   
                    </tr>                
                </table>
               
            </div>
            <div class="modal-footer">
                <button type="button" id ="btnDong"class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                <button type="submit"  id ="btnLuu" class="btn btn-secondary" data-dismiss="modal" ">Lưu</button>
            </div>
         
        </div>    
       
    </div>
</div>
</form>
</body>
</html>