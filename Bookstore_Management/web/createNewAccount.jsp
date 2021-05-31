<%-- 
    Document   : createNewAccount
    Created on : Mar 15, 2021, 8:58:29 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>T - Create New Account</title>
    </head>
    <body>
        <h1>Create New Account</h1>
        <form action="createNewAccount" method="POST">
            <c:set var="errors" value="${requestScope.CREATE_ERROR}"></c:set>
            Username <input type="text" name="txtUsername" value="${param.txtUsername}" />(6 - 30 chars)<br/>
            <c:if test="${not empty errors.usernameLengthErr}">
                <font color="red">
                    ${errors.usernameLengthErr}
                </font><br/>
            </c:if>
            Password <input type="password" name="txtPassword" value="" />(6 - 20 chars)<br/>
            <c:if test="${not empty errors.passwordLengthErr}">
                <font color="red">
                    ${errors.passwordLengthErr}
                </font><br/>
            </c:if>
            Confirm <input type="password" name="txtConfirm" value="" /><br/>
            <c:if test="${not empty errors.confirmNoMatch}">
                <font color="red">
                    ${errors.confirmNoMatch}
                </font><br/>
            </c:if>
            Full name <input type="text" name="txtFullName" value="${param.txtFullName}" />(2 - 50 chars)<br/>
            <c:if test="${not empty errors.fullNameLengthErr}">
                <font color="red">
                    ${errors.fullNameLengthErr}
                </font><br/>
            </c:if>
            <input type="submit" value="Create New Account" name="btAction" />
            <input type="reset" value="Reset" />
        </form><br/>
        <c:if test="${not empty errors.usernameExist}">
                <font color="red">
                    ${errors.usernameExist}
                </font><br/>
            </c:if>
        <a href="onlineBookStore">Don't Like It? Go To Bookstore</a><br/>        
    </body>
</html>
