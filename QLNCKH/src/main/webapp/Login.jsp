<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="Models.taikhoan" %>

<head>
	<title>Đăng Nhập</title>
	<link rel="icon" href="~/Theme/images/tdmu-icon-ldpi.png" />
	<link href="CSS/login.css" rel="stylesheet" />
	<link href="CSS/loginutil.css" rel="stylesheet" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="CSS/Style.css">
	<link href="CSS/login.css" rel="stylesheet"/>
</head>
<div class="limiter">
    <div class="container-login100" ">
        <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
        <%String errMsg = (String) request.getAttribute("errMsg"); %>
        <%taikhoan tk = (taikhoan) session.getAttribute("user");%>                
	    <% if (errMsg != null) { %>
	        <p style="color:red ;font-weight :bold"><%=errMsg%></p>
	    <% } %>
            <form class="login100-form validate-form" action="<%= request.getContextPath()%>/login" method="post">
                <span class="login100-form-title p-b-49" style="font-weight:600">
                    Đăng Nhập
                </span>
                <div class="wrap-input100 validate-input m-b-23" data-validate="Username is reauired">
                    <span class="label-input100" style="font-weight:600">Tên Tài Khoản</span>
                    <input class="input100" type="text" name="username" placeholder="Mã Số Sinh Viên">
                </div>

                <div class="wrap-input100 validate-input" data-validate="Password is required">
                    <span class="label-input100" style="font-weight:600">Mật Khẩu</span>
                    <input class="input100" type="password" name="password" placeholder="Mật Khẩu">
                
                </div>

                <div class="text-right p-t-8 p-b-31">
                    <a href="#" style="font-weight:600">
                        Quên Mật Khẩu?
                    </a>
                </div>
                <!--  
                @if (!string.IsNullOrEmpty(ViewBag.Message))
                {
                    <p class="alert alert-warning" style=" text-align: center; color: red; font-size: 16px;">@ViewBag.Message</p>
                }
                -->
                <div class="container-login100-form-btn">
                    <div class="wrap-login100-form-btn">
                        <div class="login100-form-bgbtn"></div>
                        <button class="login100-form-btn">
                            Đăng Nhập
                        </button>
                    </div>
                </div>

                <div class="txt1 text-center p-t-54 p-b-20">
                    <span style="font-weight:600">
                        Hoặc Đăng Nhập Với
                    </span>
                </div>

                <div class="flex-c-m">
                    <a href="#" class="login100-social-item bg1">
                        <i class="fa fa-facebook"></i>
                    </a>

                    <a href="#" class="login100-social-item bg2">
                        <i class="fa fa-twitter"></i>
                    </a>

                    <a href="#" class="login100-social-item bg3">
                        <i class="fa fa-google"></i>
                    </a>
                </div>
            </form>
        </div>
    </div>
</div>
