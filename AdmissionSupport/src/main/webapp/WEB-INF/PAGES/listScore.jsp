<%-- 
    Document   : listScore
    Created on : Aug 22, 2023, 1:30:47 PM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/admin/score" var="action" />
<nav class="container mt-5">
    <h2 class="mb-5">Danh Sách Điểm Tuyển Sinh</h2>     
    <table class="table table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th>Số Điểm</th>
                <th>Năm</th>
                <th>Khoa</th>
                <th>Thao Tác</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${score}" var="s">
            <tr>
                <td>${s.id}</td>
                <td>${s.score}</td>
                <td>${s.date}</td>
                <td>${s.facultyId.name}</td>
                <td>
                    <c:url value="/admin/scores/${s.id}" var="api" />
                    <a href="${api}" class="btn btn-warning ms-2">Cập Nhập</a>
                    <a type="button" onclick="deleteItems('${api}')" class="btn btn-danger ms-2">Xoá</a> 
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="<c:url value="/admin/scores/" />" class="btn btn-success">Thêm Điểm Tuyển Sinh</a>
</nav>
<script src="<c:url value="/js/main.js" />"></script>