<%-- 
    Document   : individual_score_student
    Created on : Aug 9, 2021, 11:40:45 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Điểm sinh viên</title>
        <link rel="stylesheet" type="text/css" href="home.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            int index = 1;
        %>
        <jsp:include page="/layout/header.jsp"></jsp:include>    
            <div class="container">
                <div class="panel-primary">
                    <div class="panel-heading">
                        <div class="text-center">
                            <h2>Danh sách điểm</h2>
                        </div>
                    </div>
                <c:if test="${sessionScope.account.role_sv == 1}">
                    <div class="panel-body">
                        <table class="table table-bordered" >
                            <thead>
                                <tr>
                                    <th>Số</th>
                                    <th>Mã điểm</th>
                                    <th>Điểm hệ 1(10%)</th>
                                    <th>Điểm hệ 4(40%)</th>
                                    <th>Điểm thi(50%)</th>
                                    <th>Điểm trung bình</th>
                                    <th>Tên giảng viên</th>
                                    <th>Môn học</th>
                                    <th>Tín chỉ</th>
                                    <th>Thể loại</th>
                                    <th>Học kì</th>
                                    <th>Năm học</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="sco" items="${list_score}">
                                    <tr>
                                        <td><%=index++%></td>
                                        <td>${sco.id_score}</td>
                                        <td>${sco.score_1}</td>
                                        <td>${sco.score_4}</td>
                                        <td>${sco.score_test}</td>
                                        <td>${sco.avg_score}</td>
                                        <td>${sco.id_lecturer}</td>
                                        <td>${sco.id_subject}</td>
                                        <td>${sco.id_credit}</td>
                                        <td>${sco.id_category}</td>
                                        <td>${sco.id_semester}</td>
                                        <td>${sco.id_school_year}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:if>

                <c:if test="${sessionScope.account.role_lecturer == 1}">
                    <div class="panel-body">
                        <div style="margin-bottom: 5px">
                            <a href="them-diem-ca-nhan?id_lecturer=${sessionScope.account.id_account}"><button class="btn btn-primary">Thêm điểm sinh viên</button></a>
                        </div>
                        <table class="table table-bordered" >
                            <thead>
                                <tr>
                                    <th>Số</th>
                                    <th>Mã điểm</th>
                                    <th>Điểm hệ 1(10%)</th>
                                    <th>Điểm hệ 4(40%)</th>
                                    <th>Điểm thi(50%)</th>
                                    <th>Điểm trung bình</th>
                                    <th>Tên sinh viên</th>
                                    <th>Môn học</th>
                                    <th>Tín chỉ</th>
                                    <th>Thể loại</th>
                                    <th>Học kì</th>
                                    <th>Năm học</th>
                                    <th>Chức năng</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="sco" items="${list_score}">
                                    <tr>
                                        <td><%=index++%></td>
                                        <td>${sco.id_score}</td>
                                        <td>${sco.score_1}</td>
                                        <td>${sco.score_4}</td>
                                        <td>${sco.score_test}</td>
                                        <td>${sco.avg_score}</td>
                                        <td>${sco.id_student}</td>
                                        <td>${sco.id_subject}</td>
                                        <td>${sco.id_credit}</td>
                                        <td>${sco.id_category}</td>
                                        <td>${sco.id_semester}</td>
                                        <td>${sco.id_school_year}</td>
                                        <td style="width: 125px">
                                            <a href="hien-thi-diem-ca-nhan?id_update=${sco.id_score}-${sessionScope.account.id_account}"<button class="btn btn-success" style="width: 80px">Sửa</button</a>
                                        </td> 
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:if>

            </div>

        </div>
    </body>
</html>

