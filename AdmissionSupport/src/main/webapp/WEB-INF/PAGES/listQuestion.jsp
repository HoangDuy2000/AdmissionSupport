<%-- 
    Document   : listQuestion
    Created on : Aug 22, 2023, 1:20:02 PM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/questions" var="action" />
<nav class="container mt-5">
    <h2 class="mb-5">Danh Sách Câu Hỏi</h2>     
    <table class="table table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nội Dung</th>
                <th>Tên Tài Khoản</th>
                <th>Tên Người Dùng</th>
                <th>Thao Tác</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${ques}" var="q">
            <tr>
                <td>${q.id}</td>
                <td>${q.content}</td>
                <td>${q.accountsId.username}</td>
                <td>${q.accountsId.first_name}</td>
                <td>
                    <c:url value="/questions/${q.id}" var="api" />
                    <a href="${api}" class="btn btn-warning ms-2">Cập Nhập</a>
                    <a onclick="deleteItems('${api}')" class="btn btn-danger ms-2">Xoá</a> 
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="<c:url value="/questions/" />" class="btn btn-success">Thêm Câu Hỏi</a>
</nav>
