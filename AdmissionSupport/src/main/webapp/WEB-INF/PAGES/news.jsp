<%-- 
    Document   : news
    Created on : Aug 12, 2023, 11:38:38 AM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info mt-1">QUẢN LÝ TIN TUYỂN SINH</h1>

<c:url value="/news" var="action" />
<form:form modelAttribute="news" method="post" 
           action="${action}" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <form:hidden path="id"/>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="title" id="title" 
                    placeholder="Tiêu đề" name="title" />
        <label for="title">Tiêu đề</label>
        <form:errors path="title" element="div" cssClass="title" />
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:textarea class="form-control" path="content" 
                       id="contents" placeholder="Nội dung tin" name="contents"></form:textarea>
            <label for="contents">Nội dung tin tuyển sinh</label>
        <form:errors path="content" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating">
        <form:select class="form-select" id="type" name="type" 
                     path="typesId">
            <c:forEach items="${typeNews}" var="type">
                <c:choose>
                    <c:when test="${type.id == news.typesId.id}"> <option value="${type.id}" selected>${type.name}</option></c:when>
                    <c:otherwise> <option value="${type.id}">${type.name}</option></c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="type" class="form-label">Loại Tin Tuyển Sinh</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" id="facultys" name="facultys" 
                     path="facultysId">
            <c:forEach items="${faculty}" var="facul">
                <c:choose>
                    <c:when test="${facul.id == news.facultysId.id}"> <option value="${facul.id}" selected>${facul.name}</option></c:when>
                    <c:otherwise> <option value="${facul.id}">${facul.name}</option></c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="facultys" class="form-label">Khoa</label>
    </div>
    <div class="form-floating">
        <form:input type="date" class="form-control" path="date" id="date" 
                    name="date"/>
        <label for="date">Ngày tạo</label>
        <form:errors path="date" element="div" cssClass="title" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <button type="submit" class="btn btn-info" >
            <c:choose>
                <c:when test="${news.id != null}">Cập nhật Tin Tuyển Sinh</c:when>
                <c:otherwise>Thêm Tin Tuyển Sinh</c:otherwise>
            </c:choose>

        </button>
    </div>
</form:form>
