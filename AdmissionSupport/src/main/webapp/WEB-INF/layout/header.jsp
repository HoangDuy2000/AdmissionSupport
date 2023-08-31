<%-- 
    Document   : header
    Created on : Aug 11, 2023, 8:12:09 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/" var="action" />
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Admission Support</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="${action}">Trang chủ</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Thông Tin Tuyển Sinh</a>
                    <ul class="dropdown-menu">
                        <c:forEach items="${typeNews}" var="type">
                            <c:url value="/" var="searchUrl">
                                <c:param name="typeNewsId" value="${type.id}" />
                            </c:url>
                            <li>
                                <a class="dropdown-item" href="${searchUrl}">${type.name}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Tư Vấn Tuyển Sinh</a>
                    <ul class="dropdown-menu">
                        <c:url value="/lives" var="liveUrl"/>
                        <li><a class="dropdown-item" href="${liveUrl}">Lịch Livestream</a></li>
                        <c:url value="/questions" var="quesUrl"/>
                        <li><a class="dropdown-item" href="${quesUrl}">Câu Hỏi</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Thông Tin Khoa</a>
                    <ul class="dropdown-menu">
                        <c:url value="/admin/facultys" var="facultyUrl"/>
                        <li><a class="dropdown-item" href="${facultyUrl}">Danh Sách Khoa</a></li>
                        <c:url value="/admin/scores" var="scoreUrl"/>
                        <li><a class="dropdown-item" href="${scoreUrl}">Điểm Tuyển Sinh</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <c:url value="/admin/accounts" var="accountUrl"/>
                    <a class="nav-link" href="${accountUrl}">Quản Lý Tài Khoản</a>
                </li>
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <li class="nav-item">
                            <a class="nav-link text-danger" href="<c:url value="/" />">Chào ${pageContext.request.userPrincipal.name} !</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-info" href="<c:url value="/logout" />">Đăng xuất</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link text-success" href="<c:url value="/login" />">Đăng nhập</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
                
</nav>