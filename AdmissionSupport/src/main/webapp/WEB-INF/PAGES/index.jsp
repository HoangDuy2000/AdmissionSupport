<%-- 
    Document   : index
    Created on : Jul 21, 2023, 2:39:46 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/" var="action" />
<nav class="container mt-5">
    <nav>
        <h1 class="mt-4 mb-4 text-uppercase text-center"><strong>Danh Sách Tin Tuyển Sinh</strong></h1>
        <div class="row mt-3">
            <c:forEach items="${news}" var="n">
                <div class="card-body" style="height: 270px">
                    <h3 class="text-uppercase text-center"><strong><a href="#" class="text-decoration-none">${n.title}</a></strong></h3>
                    <h5 class="mt-3">
                        <a href="#" class="badge bg-secondary text-decoration-none">${n.typesId.name}</a>
                        <a href="#" class="badge bg-secondary text-decoration-none">${n.facultysId.name}</a>
                    </h5>
                    <div class="card-text overflow-hidden" style="height: 100px">
                        <p>${n.content}</p>
                    </div>
                    <div class="d-flex flex-row-reverse">
                        <c:url value="/news/${n.id}" var="api" />
                        <button class="btn btn-danger ms-2" onclick="deleteItems('${api}')">Xoá</button>
                        <a href="${api}" class="btn btn-warning ms-2">Cập Nhập</a>
                    </div> 
                </div>
            </c:forEach>
        </div>
    </nav>
    <c:if test="${pages > 1}">
        <ul class="pagination justify-content-center" style="margin:20px 0">
            <li class="page-item">
                <a class="page-link" href="${action}">Tất cả</a>
            </li>
            <c:forEach begin="1" end="${pages}" var="i">
                <c:url value="/" var="pageUrl">
                    <c:param name="page" value="${i}" />
                </c:url>
                <li class="page-item">
                    <a class="page-link" href="${pageUrl}" >${i}</a>
                </li>
            </c:forEach>
        </ul>
    </c:if>
    <a href="<c:url value="/news" />" class="btn btn-success">Thêm tin tuyển sinh</a>
</nav>
<script src="<c:url value="/js/main.js" />"></script>