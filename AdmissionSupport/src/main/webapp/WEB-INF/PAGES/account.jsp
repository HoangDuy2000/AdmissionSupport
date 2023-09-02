<%-- 
    Document   : account
    Created on : Aug 19, 2023, 10:54:20 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info mt-1">QUẢN LÝ TÀI KHOẢN</h1>

<c:url value="/admin/accounts/" var="action" />
<form:form modelAttribute="accounts" method="post" 
           action="${action}" enctype="multipart/form-data">
    <form:hidden path="id"/>
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="username" id="name" 
                    placeholder="Tài Khoản" name="name" />
        <label for="name">Tên Tài Khoản</label>
        <form:errors path="username" element="div" cssClass="title" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:password class="form-control" path="password" id="pass" 
                       name="pass" showPassword="true"/>
        <label for="password">Mật Khẩu</label>
        <form:errors path="password" element="div" cssClass="title" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="first_name" id="first_name" 
                    placeholder="Tên người dùng" name="first_name" />
        <label for="first_name">Tên Người Dùng</label>
        <form:errors path="first_name" element="div" cssClass="title" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" path="last_name" id="last-name" 
                    placeholder="Họ người dùng" name="last-name" />
        <label for="last-name">Họ Người Dùng</label>
        <form:errors path="last_name" element="div" cssClass="title" />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="email" class="form-control" path="email" id="email" 
                    placeholder="email" name="name" />
        <label for="email">Địa Chỉ Email</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:radiobutton path="active" value="true" name="active" id="active"/> Hoạt Động
        <form:radiobutton path="active" value="false" name="active" id="active"/> Không Hoạt Động
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" path="file" id="file"/>
        <label for="file">Avatar</label>
        <c:if test="${accounts.avatar != null}">
            <img src="${accounts.avatar}" width="120" />
        </c:if>
    </div>
    <div class="form-floating">
        <form:select class="form-select" id="roles" name="roles" 
                     path="roles">
            <c:forEach items="${role}" var="r">
                <c:choose>
                    <c:when test="${r.id == accounts.roles.id}"> <option value="${r.id}" selected>${r.name}</option></c:when>
                    <c:otherwise> <option value="${r.id}">${r.name}</option></c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="roles" class="form-label">Loại Tài Khoản</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button type="submit" class="btn btn-info" >
            <c:choose>
                <c:when test="${accounts.id != null}">Cập nhật Tài Khoản</c:when>
                <c:otherwise>Thêm Tài Khoản</c:otherwise>
            </c:choose>

        </button>
    </div>
</form:form>
