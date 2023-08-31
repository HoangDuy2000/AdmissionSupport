<%-- 
    Document   : question
    Created on : Aug 22, 2023, 1:20:18 PM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info mt-1">QUẢN LÝ CÂU HỎI</h1>

<c:url value="/questions/" var="action" />
<form:form modelAttribute="question" method="post" 
           action="${action}" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <form:hidden path="id"/>
    <div class="form-floating mb-3 mt-3">
        <form:textarea class="form-control" path="content" 
                       id="contents" placeholder="Nội dung câu hỏi" name="contents"></form:textarea>
            <label for="contents">Nội dung câu hỏi</label>
        <form:errors path="content" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:select class="form-select" id="lives" name="lives" 
                     path="livesId">
            <c:forEach items="${live}" var="l">
                <c:choose>
                    <c:when test="${l.id == questions.livesId.id}"> <option value="${l.id}" selected>${l.tiltle}</option></c:when>
                    <c:otherwise> <option value="${l.id}">${l.tiltle}</option></c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="lives" class="form-label">Tiêu Đề Lịch Live</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button type="submit" class="btn btn-info" >
            <c:choose>
                <c:when test="${question.id != null}">Cập nhật Câu Hỏi</c:when>
                <c:otherwise>Thêm Câu Hỏi</c:otherwise>
            </c:choose>

        </button>
    </div>
</form:form>
