<%-- 
    Document   : load_category
    Created on : Aug 6, 2021, 3:14:48 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý thể loại</title>
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
                        <h3 class="text-center">Thông tin thể loại</h3>
                    </div>
                    <div class="panel-body">    
                        <form method="post">
                            <div class="form-group">
                                <label>Mã thể loại</label>
                                <input value="${category.id_category}"class="form-control" type="text" name="id_category" placeholder="Nhập mã thể loại..." id="id_category" readonly="">
                            </div>
                            <div class="form-group">
                                <label>Tên thể loại</label>
                                <input value="${category.name_category}" class="form-control" type="text" name="name_category" placeholder="Nhập tên thể loại..." id="name_category">
                            </div>

                            <button class="btn btn-success">Cập nhật</button>                    
                        </form>
                    </div>
                </div>
            </div>

        <jsp:include page="/layout/footer.jsp"></jsp:include>
    </body>
</html>F
