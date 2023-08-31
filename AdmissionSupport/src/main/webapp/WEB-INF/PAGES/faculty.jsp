<%-- 
    Document   : faculty
    Created on : Aug 19, 2023, 10:54:46 PM
    Author     : PC
--%>

<%-- 
    Document   : news
    Created on : Aug 12, 2023, 11:38:38 AM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info mt-1">QUẢN LÝ TIN KHOA</h1>

<c:url value="/admin/facultys/" var="action" />
<form:form modelAttribute="facultys" method="post" 
           action="${action}" enctype="multipart/form-data">
    <form:hidden path="id"/>
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="name" id="name" 
                    placeholder="Tiêu đề" name="name" />
        <label for="name">Tên Khoa</label>
        <form:errors path="name" element="div" cssClass="title" />
    </div>

    <div class="form-floating mb-3 mt-3">
        <form:textarea class="form-control" path="description" 
                       id="description" placeholder="Nội dung tin" name="description"></form:textarea>
            <label for="description">Mô Tả Khoa</label>
        <form:errors path="description" element="div" cssClass="text-danger" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="location" id="location" 
                    placeholder="Tiêu đề" name="location" />
        <label for="location">Địa Điểm</label>
        <form:errors path="location" element="div" cssClass="title" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="email" class="form-control" path="email" id="email" 
                    placeholder="Tiêu đề" name="title" />
        <label for="email">Địa Chỉ Email</label>
        <form:errors path="email" element="div" cssClass="title" />
    </div>
    <div class="form-floating mb-3 mt-3">
        
        <form:radiobutton path="active" value="true" name="active" id="active"/> Hoạt Động
        <form:radiobutton path="active" value="false" name="active" id="active"/> Không Hoạt Động
    </div>

    <div class="form-floating mb-3 mt-3">
        <button type="submit" class="btn btn-info" >
            <c:choose>
                <c:when test="${facultys.id != null}">Cập nhật Khoa</c:when>
                <c:otherwise>Thêm Khoa</c:otherwise>
            </c:choose>

        </button>
    </div>
</form:form>

