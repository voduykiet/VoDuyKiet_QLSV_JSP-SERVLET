<%-- 
    Document   : load_schoolyear
    Created on : Aug 7, 2021, 12:27:37 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý năm học</title>
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
                        <h3 class="text-center">Thông tin năm học</h3>
                    </div>
                    <div class="panel-body">    
                        <form method="post">
                            <div class="form-group">
                                <label>Mã năm học</label>
                                <input value=${schoolyear.id_school_year} class="form-control" type="text" name="id_school_year" placeholder="Nhập mã năm học..." id="id_school_year" readonly="">
                            </div>
                            <div class="form-group">
                                <label>Tên năm học</label>
                                <input value=${schoolyear.name_school_year} class="form-control" type="text" name="name_school_year" placeholder="Nhập tên năm học..." id="name_school_year">
                            </div>

                            <button class="btn btn-success">Cập nhật</button>                    
                        </form>
                    </div>
                </div>
            </div>

        <jsp:include page="/layout/footer.jsp"></jsp:include>
    </body>
</html>
