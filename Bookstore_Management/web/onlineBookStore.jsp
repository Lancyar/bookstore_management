<%-- 
    Document   : onlineBookStore
    Created on : Mar 5, 2021, 5:21:52 PM
    Author     : PC
--%>

<%@page import="thanhhp.bookstore.BookstoreDTO"%>
<%@page import="java.util.List"%>
<%@page import="thanhhp.bookstore.BookstoreDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>T - Store</title>
    </head>
    <body>
        <c:if test="${not empty sessionScope.FULLNAME}">
            <font color="red">Welcome, ${sessionScope.FULLNAME}</font>
            <form action="logout">
            <input type="submit" value="logout" name="btAction" /><br/><br/>
            </form>
        </c:if>
        <h1>Book Store</h1>

        Choose your books
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Price</th>
                    <th>Add To Cart</th>
                </tr>
            </thead>
            <tbody>
                <c:set var="books" value="${requestScope.BOOK_LIST}"></c:set>
                <c:forEach var="book" items="${books}" varStatus="counter">
                <form action="addBookToCart">
                    <tr>
                        <td>
                            ${counter.count}
                        </td>
                        <td>
                            ${book.getId()}
                        </td>
                        <td>
                            ${book.getTitle()}
                        </td>
                        <td>
                            ${book.getPrice()}
                        </td>
                        <th>
                            <input type="submit" value="AddToCart" name="btAction" />
                            <input type="hidden" value="${book.getId()}" name="id"/>
                        </th>
                    </tr>
                </form>
            </c:forEach>
<%--            <%
                BookstoreDAO dao = new BookstoreDAO();
                List<BookstoreDTO> books = dao.getBookList();
                int count = 0;

                for (BookstoreDTO book : books) {
//                            String urlRewriting = "DispatchServlet"
//                                    + "?btAction=AddToCart"
//                                    + "&id=" + book.getId();
%>
            <form action = "DispatchServlet">
                <tr>
                    <th>
                        <%= ++count%>
                    </th>
                    <th>
                        <%= book.getId()%>
                    </th>
                    <th>
                        <%= book.getTitle()%>
                    </th>
                    <th>
                        <%= book.getPrice()%>
                    </th>
                    <th>
                        <input type="submit" value="AddToCart" name="btAction" />
                    </th>
                    <th style="display: none;">
                        <input type="hidden" value="<%= book.getId()%>" name="id"/>
                    </th>
                </tr>
            </form>
            <%
                }
            %>
--%>
        </tbody>
    </table>
    <form action="viewcart.jsp">
        <input type="submit" name="btAction" value="View Your Cart" />
    </form>

</body>
</html>
