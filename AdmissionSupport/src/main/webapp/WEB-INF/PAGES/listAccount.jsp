<%-- 
    Document   : listAccount
    Created on : Aug 22, 2023, 1:40:18 PM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/admin/accounts/" var="action" />
<nav class="container mt-5">
    <h2 class="mb-5">Quản Lý Tài Khoản</h2>     
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Tên Tài Khoản</th>
                <th>Mật Khẩu</th>
                <th>Họ</th>
                <th>Tên</th>
                <th>Email</th>
                <th>Loại Tài Khoản</th>
                <th>Trạng Thái</th>
                <th>Thao Tác</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${accounts}" var="a">
            <tr>
                <td>${a.username}</td>
                <td>${a.password}</td>
                <td>${a.first_name}</td>
                <td>${a.last_name}</td>
                <td>${a.email}</td>
                <td>${a.roles.name}</td>
                <c:choose>
                    <c:when test="${a.active == true}">
                        <td><i class="bi bi-check-circle-fill"></i></td>
                    </c:when>
                    <c:otherwise>
                        <td><i class="bi bi-x-circle-fill"></i></td>
                    </c:otherwise>
                </c:choose>
                <td>
                    <c:url value="/admin/accounts/${a.id}" var="api" />
                    <a href="${api}" class="btn btn-warning ms-2">Cập Nhập</a>
                    <a type="button" onclick="deleteItems('${api}')" class="btn btn-danger ms-2">Xoá</a> 
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="<c:url value="/admin/accounts/" />" class="btn btn-success">Thêm tài khoản</a>
</nav>
<script src="<c:url value="/js/main.js" />"></script>
