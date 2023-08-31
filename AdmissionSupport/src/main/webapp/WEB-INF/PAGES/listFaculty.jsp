<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/score" var="action" />
<nav class="container mt-5">
    <h2 class="mb-5">Danh Sách Khoa</h2>     
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Tên Khoa</th>
                <th>Mô Tả Khoa</th>
                <th>Địa Điểm</th>
                <th>Địa Chỉ</th>
                <th>Trạng Thái</th>
                <th>Thao Tác</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${facultys}" var="f">
            <tr>
                <td>${f.name}</td>
                <td>${f.description}</td>
                <td>${f.location}</td>
                <td>${f.email}</td>
                <c:choose>
                    <c:when test="${f.active == true}">
                        <td><i class="bi bi-check-circle-fill"></i></td>
                    </c:when>
                    <c:otherwise>
                        <td><i class="bi bi-x-circle-fill"></i></td>
                    </c:otherwise>
                </c:choose>
                <td>
                    <c:url value="/admin/facultys/${f.id}" var="api" />
                    <a href="${api}" class="btn btn-warning ms-2">Cập Nhập</a>
                    <button onclick="deleteItems('${api}')" class="btn btn-danger ms-2">Xoá</button> 
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="<c:url value="/admin/facultys/" />" class="btn btn-success">Thêm Khoa</a>
</nav>
<script src="<c:url value="/js/main.js" />"></script>