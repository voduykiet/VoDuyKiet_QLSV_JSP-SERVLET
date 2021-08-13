<%-- 
    Document   : load_semester
    Created on : Aug 7, 2021, 12:27:26 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý học kì</title>
        <link rel="stylesheet" type="text/css" href="home.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="/layout/header.jsp"></jsp:include>
            <div class="container" style="width: 600px">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="text-center">Thông tin học kì</h3>
                    </div>
                    <div class="panel-body">    
                        <form method="post">
                            <div class="form-group">
                                <label>Mã học kì</label>
                                <input value="${semester.id_semester}" readonly="" class="form-control" type="text" name="id_semester" placeholder="Nhập mã học kì..." id="id_semester">
                            </div>
                            <div class="form-group">
                                <label>Tên học kì</label>
                                <input value="${semester.name_semester}" class="form-control" type="text" name="name_semester" placeholder="Nhập tên học kì..." id="name_semester">
                            </div>

                            <button class="btn btn-success">Cập nhật</button>                    
                        </form>
                    </div>
                </div>
            </div>

        <jsp:include page="/layout/footer.jsp"></jsp:include>
    </body>
</html>
