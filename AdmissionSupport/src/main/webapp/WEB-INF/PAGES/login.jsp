<%-- 
    Document   : login
    Created on : Aug 19, 2023, 11:06:28 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/login" var="action" />
<form method="post" action="${action}"> 
    <nav class="container mt-5">
        <h2 class="mb-5 text-center">Đăng Nhập</h2> 
        <c:if test="${param.error != null}">
            <div class="alert alert-danger">
                Hệ Thống Đang Xảy Ra Lỗi! Vui Lòng Thử Lại Sau!
            </div>
        </c:if>
        <c:if test="${param.accessDenied != null}">
            <div class="alert alert-danger">
                Bạn Không Có Quyền Truy Cập
            </div>
        </c:if>
        <div class="form-floating mb-3 mt-3">
            <input type="text" class="form-control" id="name" placeholder="Tên đăng nhập" name="username">
            <label for="name">Tên đăng nhập</label>
        </div>

        <div class="form-floating mt-3 mb-3">
            <input type="password" class="form-control" id="pwd" placeholder="Mật khẩu" name="password">
            <label for="pwd">Mật khẩu</label>
        </div>

        <div class="form-floating mt-3 mb-3">
            <input type="submit" value="Đăng nhập" class="btn btn-danger" />
        </div>
    </nav>
</form>


