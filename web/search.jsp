<%-- 
    Document   : search
    Created on : Feb 25, 2021, 9:28:42 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="thanhhp.registeration.RegistrationDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <font color="red">
        Welcome, ${sessionScope.USERNAME} -- coi chung 0 diem
        </font>
        <h1>Search Page</h1>
        <form action="DispatchServlet">
            Search Value <input type="text" name="txtSearchValue" 
                                value="${param.txtSearchValue}" /><br/>
            <input type="submit" value="Search" name="btAction" />
        </form><br/>

        <c:set var="searchValue" value="${param.txtSearchValue}"/>
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCHRESULT}" />
            <c:if test="${not empty result}" >
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Full name</th>
                            <th>Role</th>
                            <th></th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto"  items="${result}" varStatus="counter">
                        <form action="DispatchServlet">
                            <tr>
                                <th>
                                    ${counter.count}
                                    .</th>
                                <th>
                                    ${dto.username}
                                    <input type="hidden" name="txtUsername" value="${dto.username}" />
                                </th>
                                <th>
                                    <input type="text" name="txtPassword" value="${dto.password}" />
                                </th>
                                <th>
                                    ${dto.fullName}
                                </th>
                                <th>
                                    ${dto.role}
                                </th>
                                <td>
                                    <input type="checkbox" name="chkAdmin" value="ON" 
                                           <c:if test="${dto.role}">
                                               checked="checked"
                                           </c:if>
                                           />
                                </td>
                                <td>
                                    <c:url var="deleteLink" value="DispatchServlet">
                                        <c:param name="btAction" value="Delete"/>
                                        <c:param name="pk" value="${dto.username}"/>
                                        <c:param name="lastSearchValue" value="${searchValue}"/>
                                    </c:url>
                                    <a href="${deleteLink}">Delete</a>
                                </td>
                                <td>
                                    <input type="submit" value="Update" name="btAction" />
                                    <input type="hidden" value="lastSearchValue" name="${searchValue}" />
                                </td>
                            </tr>

                        </form>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>
        <c:if test="${empty result}">
            <h2>No record is matched!</h2>
        </c:if>
    </c:if>
    <%--<% 
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            String username = "";
            for (Cookie c: cookies) {
                String temp = c.getName();
                if (!temp.equals("JSESSIONID")) {
                    username = temp;
                }
            }
            %> 
            <font color="red">
            Welcome, <%= username %><br/>
            </font>
            <form action="DispatchServlet">
                <input type="submit" value="Logout" name="btAction" />
            </form>
    <%
        }
    %>
    <h1>Search Page</h1>
    <form action="DispatchServlet">
        Search Value <input type="text" name="txtSearchValue" 
                            value="<%= request.getParameter("txtSearchValue") %>" /><br/>
        <input type="submit" value="Search" name="btAction" />
    </form><br/>
    
    <%
        String searchValue = request.getParameter("txtSearchValue");
        if (searchValue != null) {
            List<RegistrationDTO> result = (List<RegistrationDTO>) request.getAttribute("SEARCHRESULT");
            if (result != null) {
                %> 
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Full name</th>
                            <th>Role</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        int count = 0;
                        for (RegistrationDTO dto: result) {
                            String urlRewriting = "DispatchServlet"
                                    + "?btAction=Delete"
                                    + "&pk=" + dto.getUsername()
                                    + "&lastSearchValue=" + searchValue;
                            %> 
                    <form action="DispatchServlet" method="POST">
                            <tr>
                            <th>
                                <%= ++count %>
                            .</th>
                            <th>
                                <%= dto.getUsername() %>
                                <input type="hidden" name="txtUsername" 
                                       value="<%= dto.getUsername() %>" />
                            </th>
                            <th>
                                <input type="text" name="txtPassword" 
                                       value="<%= dto.getPassword() %>" />
                            </th>
                            <th>
                                <%= dto.getFullName() %>
                            </th>
                            <th>
                                <input type="checkbox" name="chkAdmin" 
                                       value="ON" 
                                       <% 
                                       if (dto.isRole()) {
                                           %> 
                                           checked="checked"
                                       <%
                                       }
                                       %>
                                       />
                            </th>
                            <td>
                                <a href="<%= urlRewriting %>">Delete</a>
                            </td>
                            <td>
                                <input type="submit" value="Update" name="btAction" />
                                <input type="hidden" name="lastSearchValue" 
                                       value="<%= searchValue %>" />
                            </td>
                        </tr>
                    </form>    
                        <%
                        } // end after iterating every element of result
                        %>
                    </tbody>
                </table>

        <%
                } else { // end if result has records
                    %> 
                    <h2>
                        No record is matched!
                    </h2>
        <%
                }
            } // end if searchValue is not null (first time loading)
        %>
    --%>
</body>
</html>
