<%-- 
    Document   : header
    Created on : Aug 9, 2021, 4:25:14 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <div class="dropdown" style="margin-top: 10px">
                    <button class="btn btn-default dropdown-toggle" type="button" >
                        <a href="trang-chu"> Trang chủ</a>  
                    </button>
                </div>
            </ul>
            <!--Quyền sinh viên-->
            <c:if test="${sessionScope.account != null && sessionScope.account.role_sv == 1}">
                <ul class="nav navbar-nav">
                    <div class="dropdown" style="margin-top: 10px">
                        <button class="btn btn-default dropdown-toggle" type="button">
                            <a href="diem-ca-nhan?id_student=${sessionScope.account.id_account}">Điểm sinh viên</button>
                    </div>
                </ul>
            </c:if>
            <c:if test="${sessionScope.account != null && sessionScope.account.role_sv == 1}">
                <ul class="nav navbar-nav">
                    <div class="dropdown" style="margin-top: 10px">
                        <button class="btn btn-default dropdown-toggle" type="button">
                            <a href="thong-tin-ca-nhan?id_student=${sessionScope.account.id_account}">  Thông tin cá nhân
                        </button>
                    </div>
                </ul>
            </c:if>
            <c:if test="${sessionScope.account != null && sessionScope.account.role_sv == 1}">
                <ul class="nav navbar-nav">
                    <div class="dropdown" style="margin-top: 10px">
                        <button class="btn btn-default dropdown-toggle" type="button">
                            <a href="thong-tin-tai-khoan?id_student=${sessionScope.account.id_account}">  Thông tin tài khoản
                        </button>
                    </div>
                </ul>
            </c:if>

            <!--Quyền giảng viên-->
            <c:if test="${sessionScope.account != null && sessionScope.account.role_lecturer == 1}">
                <ul class="nav navbar-nav">
                    <div class="dropdown" style="margin-top: 10px">
                        <button class="btn btn-default dropdown-toggle" type="button">
                            <a href="diem-ca-nhan?id_lecturer=${sessionScope.account.id_account}">Danh sách điểm sinh viên</button>
                    </div>
                </ul>
            </c:if>
            <c:if test="${sessionScope.account != null && sessionScope.account.role_lecturer == 1}">
                <ul class="nav navbar-nav">
                    <div class="dropdown" style="margin-top: 10px">
                        <button class="btn btn-default dropdown-toggle" type="button">
                            <a href="thong-tin-ca-nhan?id_lecturer=${sessionScope.account.id_account}">  Thông tin cá nhân
                        </button>
                    </div>
                </ul>
            </c:if>
            <c:if test="${sessionScope.account != null && sessionScope.account.role_lecturer == 1}">
                <ul class="nav navbar-nav">
                    <div class="dropdown" style="margin-top: 10px">
                        <button class="btn btn-default dropdown-toggle" type="button">
                            <a href="thong-tin-tai-khoan?id_lecturer=${sessionScope.account.id_account}">  Thông tin tài khoản
                        </button>
                    </div>
                </ul>
            </c:if>

            <!--Quyền admin-->
            <c:if test="${sessionScope.account != null && sessionScope.account.role_admin == 1}">
                <ul class="nav navbar-nav">
                    <div class="dropdown" style="margin-top: 10px">
                        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Quản lý sinh viên
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu" class="nav navbar-nav">
                            <li><a href="danh-sach-sinh-vien">Danh sách sinh viên</a></li>
                            <li class="divider"></li>
                            <li><a href="danh-sach-diem-sinh-vien">Danh sách điểm sinh viên</a></li>
                        </ul>
                    </div>
                </ul>
            </c:if>
            <c:if test="${sessionScope.account != null && sessionScope.account.role_admin == 1}">
                <ul class="nav navbar-nav">
                    <div class="dropdown" style="margin-top: 10px">
                        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Quản lý giảng viên
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu" class="nav navbar-nav">
                            <li><a href="danh-sach-giang-vien">Danh sách giảng viên</a></li>
                            <li class="divider"></li>
                            <li><a href="danh-sach-giang-vien-mon-hoc">Danh sách giảng viên-môn học</a></li>
                        </ul>
                    </div> 
                </ul>
            </c:if>
            <c:if test="${sessionScope.account != null && sessionScope.account.role_admin == 1}">
                <ul class="nav navbar-nav">
                    <div class="dropdown" style="margin-top: 10px">
                        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Quản lý môn học
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu" class="nav navbar-nav">
                            <li><a href="danh-sach-mon-hoc">Danh sách môn học</a></li>
                            <li class="divider"></li>
                            <li><a href="danh-sach-the-loai-tin-chi">Danh sách thể loại-tín chỉ</a></li>
                            <li class="divider"></li>
                            <li><a href="danh-sach-hoc-ki-nam-hoc">Danh sách học kì-năm học</a></li>
                        </ul>
                    </div>
                </ul>      
            </c:if>
            <c:if test="${sessionScope.account != null && sessionScope.account.role_admin == 1}">
                <ul class="nav navbar-nav">
                    <div class="dropdown" style="margin-top: 10px">
                        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Quản lý lớp-khoa
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu" class="nav navbar-nav">
                            <li><a href="danh-sach-lop-hoc">Danh sách lớp học</a></li>
                            <li class="divider"></li>
                            <li><a href="danh-sach-phong-khoa">Danh sách phòng khoa</a></li>
                        </ul>
                    </div>
                </ul>      
            </c:if>
            <c:if test="${sessionScope.account != null && sessionScope.account.role_admin == 1}">
                <ul class="nav navbar-nav">
                    <div class="dropdown" style="margin-top: 10px">
                        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Quản lý tài khoản
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu" class="nav navbar-nav">
                            <li><a href="danh-sach-tai-khoan-sinh-vien">Danh sách tài khoản sinh viên</a></li>
                            <li class="divider"></li>
                            <li><a href="danh-sach-tai-khoan-giang-vien">Danh sách tài khoản giảng viên</a></li>
                            <li class="divider"></li>
                            <li><a href="danh-sach-tai-khoan-admin">Danh sách tài khoản admin</a></li>
                        </ul>
                    </div>
                </ul>
            </c:if>

            <!--Đăng nhâp/Đăng xuất-->
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${sessionScope.account != null}">
                    <a class="navbar-brand" href="#">Hello ${sessionScope.account.username}</a>
                    <li><a href="dang-xuat"><span class="glyphicon glyphicon-log-out"></span> Đăng Xuất</a></li>
                    </c:if>

                <c:if test="${sessionScope.account == null}">
                    <li><a href="dang-nhap"><span class="glyphicon glyphicon-log-in"></span> Đăng Nhập</a></li>
                    </c:if>
            </ul>
        </div>
    </div>
</nav>
