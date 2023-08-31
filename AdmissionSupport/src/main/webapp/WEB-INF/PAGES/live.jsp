<%-- 
    Document   : live
    Created on : Aug 22, 2023, 1:23:30 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info mt-1">QUẢN LÝ LỊCH LIVESTREAM</h1>

<c:url value="/lives/" var="action" />
<form:form modelAttribute="live" method="post" 
           action="${action}" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <form:hidden path="id"/>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="tiltle" id="title" 
                    placeholder="Tiêu đề" name="title" />
        <label for="title">Tiêu đề</label>
        <form:errors path="tiltle" element="div" cssClass="title" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:textarea class="form-control" path="description" 
                       id="descriptions" placeholder="Nội dung livestream" name="descriptions"></form:textarea>
            <label for="descriptions">Nội Dung Livestream</label>
        <form:errors path="description" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating">
        <form:input type="datetime-local" class="form-control" path="date" id="date" 
                    name="date"/>
        <label for="date">Thời Gian Live</label>
        <form:errors path="date" element="div" cssClass="title" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="location" id="locations" 
                    placeholder="Địa điểm" name="locations" />
        <label for="locations">Địa Điểm</label>
        <form:errors path="location" element="div" cssClass="title" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <button type="submit" class="btn btn-info" >
            <c:choose>
                <c:when test="${live.id != null}">Cập nhật Lịch Live</c:when>
                <c:otherwise>Thêm Lịch Live</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>

