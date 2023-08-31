<%-- 
    Document   : listLive
    Created on : Aug 20, 2023, 11:18:43 PM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/lives" var="action" />
<nav class="container mt-5">
    <h2 class="mb-5">Lịch Livestream</h2>     
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Tiêu Đề</th>
                <th>Mô Tả Nội Dung</th>
                <th>Ngày Live</th>
                <th>Địa Điểm</th>
                <th>Thao Tác</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${live}" var="l">
            <tr>
                <td>${l.tiltle}</td>
                <td>${l.description}</td>
                <td>${l.date}</td>
                <td>${l.location}</td>
                <td>
                    <c:url value="/lives/${l.id}" var="api" />
                    <a href="${api}" class="btn btn-warning ms-2">Cập Nhập</a>
                    <a type="button" onclick="deleteItems('${api}')" class="btn btn-danger ms-2">Xoá</a> 
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="<c:url value="/lives/" />" class="btn btn-success">Thêm Lịch Live</a>
</nav>
<script src="<c:url value="/js/main.js" />"></script>
