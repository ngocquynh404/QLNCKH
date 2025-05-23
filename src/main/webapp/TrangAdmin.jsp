<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.List" %>
<%@ page import ="Models.taikhoan" %>
<%@ page import ="Models.detai" %>
<html lang="en">
<head>  
    <title>Admin</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        body {
            background: #f4f3ef;
        }

        #article {
            display: inline-block;
            width: calc(50% - 20px);
            /* 50% chiều rộng, trừ đi khoảng cách giữa các article */
            margin: 10px;
            /* Khoảng cách giữa các article */
            vertical-align: top;
            /* Canh lề trên của các article */
        }

        #wrapper {
            padding-left: 0;
            -webkit-transition: all 0.5s ease;
            -moz-transition: all 0.5s ease;
            -o-transition: all 0.5s ease;
            transition: all 0.5s ease;
        }

        #wrapper.toggled {
            padding-left: 250px;
        }

        #sidebar-wrapper {
            z-index: 1000;
            position: fixed;
            left: 250px;
            width: 0;
            height: 100%;
            margin-left: -250px;
            overflow-y: auto;
            background: #fff;
            -webkit-transition: all 0.5s ease;
            -moz-transition: all 0.5s ease;
            -o-transition: all 0.5s ease;
            transition: all 0.5s ease;
        }

        #sidebar-wrapper {
            box-shadow: inset -1px 0px 0px 0px #DDDDDD;
        }

        #wrapper.toggled #sidebar-wrapper {
            width: 250px;
        }

        #page-content-wrapper {
            width: 100%;
            position: absolute;
            padding: 15px;
        }

        #wrapper.toggled #page-content-wrapper {
            position: absolute;
            margin-right: -250px;
        }

        /* Sidebar Styles */

        .sidebar-nav {
            position: absolute;
            top: 0;
            width: 250px;
            margin: 0;
            padding: 0;
            list-style: none;
        }

        .sidebar-nav li {
            text-indent: 20px;
            line-height: 40px;
        }

        .sidebar-nav li a {
            display: block;
            text-decoration: none;
            color: #1A7986;
        }

        .sidebar-nav li a:hover {
            text-decoration: none;
        }

        .sidebar-nav li a:active,
        .sidebar-nav li a:focus {
            text-decoration: none;
        }

        .sidebar-nav>.sidebar-brand {
            height: 65px;
            font-size: 18px;
            line-height: 60px;
        }

        .sidebar-nav>.sidebar-brand a {
            color: #999999;
        }

        .sidebar-nav>.sidebar-brand a:hover {
            color: #fff;
            background: none;
        }

        @media(min-width:768px) {
            #wrapper {
                padding-left: 250px;
            }

            #wrapper.toggled {
                padding-left: 0;
            }

            #sidebar-wrapper {
                width: 250px;
            }

            #wrapper.toggled #sidebar-wrapper {
                width: 0;
            }

            #page-content-wrapper {
                padding: 20px;
                position: relative;
            }

            #wrapper.toggled #page-content-wrapper {
                position: relative;
                margin-right: 0;
            }
        }

        #sidebar-wrapper li.active>a:after {
            border-right: 17px solid #f4f3ef;
            border-top: 17px solid transparent;
            border-bottom: 17px solid transparent;
            content: "";
            display: inline-block;
            position: absolute;
            right: -1px;
        }

        .sidebar-brand {
            border-bottom: 1px solid rgba(102, 97, 91, 0.3);
            color: #1A7986;
        }

        .sidebar-brand {
            padding: 18px 0px;
            margin: 0 20px;
        }

        .navbar .navbar-nav>li>a p {
            display: inline-block;
            margin: 0;
            color: #ffffff
        }

        p {
            font-size: 16px;
            line-height: 1.4em;
        }

        .navbar-default {
            background-color: #454F85;
            border: 0px;
            border-bottom: 1px solid #DDDDDD;
        }

        btn-menu {
            border-radius: 3px;
            padding: 4px 12px;
            margin: 14px 5px 5px 20px;
            font-size: 14px;
            float: left;
        }

        
    </style>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>

    <div id="wrapper" class="wrapper-content">
        <div id="sidebar-wrapper">
            <div class="col-md-4">
                <ul class="sidebar-nav">
                    <li class="sidebar-brand">
                        <a href="/TrangAdmin.jsp">Trang Chủ</a>
                    </li>
                    <li>					
                       <a href="<%=request.getContextPath()%>/list" onclick="openDT()">Quản lý đề tài</a>
                    </li>
                    <li>
                        <a href="#" onclick ="openSV()">Quản lý sinh viên</a>
                    </li>
                    <li>
                        <a href="#" onclick ="openGV()">Quản lý giảng viên</a>
                    </li>
					<li>
                        <a href="#" onclick ="openNQL()">Quản lý người quản lý</a>
                    </li>
                </ul>
            </div>
        </div>      
        <div class="col-md-12">
            <div id="page-content-wrapper">
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
						<div class="navbar-header">
	                        <button class="btn-menu btn btn-success btn-toggle-menu" type="button">
	                            <i class="fa fa-bars"></i>
	                        </button>
	                    </div>
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav navbar-right">
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                        <i class="ti-panel"></i>
                                        <span style="color: white;" class="glyphicon glyphicon-bell"></span>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <!-- Các mục menu của dropdown -->
                                        <li><a href="#">Thông báo 1</a></li>
                                        <li><a href="#">Thông báo 2</a></li>
                                        <!-- Thêm các thông báo khác nếu cần -->
                                    </ul>
                                </li>

                                <li>
                                    <a href="#">
                                        <i class="ti-settings"></i>
                                        <p>Admin</p>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" id ="" class="dropdown-toggle" data-toggle="dropdown" onclick="openXemChiTiet()">
                                        <i class="ti-panel"></i>
                                        <span style="color: white;" class="glyphicon glyphicon-user"></span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>        
        </div>
        <iframe id="loginFrame" 
                    style="display: none; width: 80%; height:90vh ;border: none;position: fixed; top: 80px; right: -0px ;"></iframe>
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script type="text/javascript">
            $(function () {
                $(".btn-toggle-menu").click(function () {   
                    $("#wrapper").toggleClass("toggled");
                });
            })
        </script>
         <script>
                    function openSV() {
                        // Hiển thị iframe và đặt src là trang Login.html	            	
                        document.getElementById('loginFrame').style.display = 'block';
                        document.getElementById('loginFrame').src = 'DSSinhVien.html';
                    }
                </script>
        <script>
                    function openGV() {
                        // Hiển thị iframe và đặt src là trang Login.html	            	
                        document.getElementById('loginFrame').style.display = 'block';
                        document.getElementById('loginFrame').src ='DSGiangVien.html';
                    }
                </script>       
                <script>
                    function openNQL() {
                        // Hiển thị iframe và đặt src là trang Login.html	            	
                        document.getElementById('loginFrame').style.display = 'block';
                        document.getElementById('loginFrame').src ='DSNQL.html';
                    }
                </script>
                <script>
                    function openDT() {
                    	
                        // Hiển thị iframe và đặt src là trang Login.html	            	
                        document.getElementById('loginFrame').style.display = 'block';
                        document.getElementById('loginFrame').src ="<%= request.getContextPath()%>/DSDeTai.jsp";
                       
                    }
                </script>
                 <script>
                    function openXemChiTiet() {
                        // Hiển thị iframe và đặt src là trang Login.html	            	
                        document.getElementById('loginFrame').style.display = 'block';
                        document.getElementById('loginFrame').src ='ChiTietAdmin.html';
                    }
                </script>
    </div>
 <script>
 $(document).on('click', "button[name='view']", function () {  
     console.log("Button 'update' clicked!");
     let id = $(this).closest('tr').attr('id');
     $('#ModalTitleDeTai').text("Chi Tiết Đề Tài");
     $('#body').show();
     $('#modalDeTai').modal();      
 });
 </script>
</body>
</html>