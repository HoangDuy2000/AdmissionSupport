<%-- 
    Document   : score
    Created on : Aug 22, 2023, 1:30:30 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info mt-1">QUẢN LÝ ĐIỂM TUYỂN SINH</h1>

<c:url value="/admin/scores/" var="action" />
<form:form modelAttribute="scores" method="post" 
           action="${action}" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <form:hidden path="id"/>
    <div class="form-floating mb-3 mt-3">
        <form:input type="date" class="form-control" path="date" id="date" 
                    name="date"/>
        <label for="date">Thời Gian Tuyển Sinh</label>
        <form:errors path="date" element="div" cssClass="title" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" class="form-control" path="score" id="score" 
                    placeholder="Điểm tuyển sinh" name="title" />
        <label for="score">Điểm Tuyển Sinh</label>
        <form:errors path="score" element="div" cssClass="title" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" id="facultys" name="facultys" 
                     path="facultysId">
            <c:forEach items="${faculty}" var="facul">
                <c:choose>
                    <c:when test="${facul.id == scores.facultysId.id}"> <option value="${facul.id}" selected>${facul.name}</option></c:when>
                    <c:otherwise> <option value="${facul.id}">${facul.name}</option></c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="facultys" class="form-label">Khoa</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button type="submit" class="btn btn-info" >
            <c:choose>
                <c:when test="${scores.id != null}">Cập nhật Điểm Tuyển Sinh</c:when>
                <c:otherwise>Thêm Điểm Tuyển Sinh</c:otherwise>
            </c:choose>

        </button>
    </div>
</form:form>
