<%-- 
    Document   : onlineBookStore
    Created on : Mar 5, 2021, 5:21:52 PM
    Author     : PC
--%>

<%@page import="thanhhp.bookstore.BookstoreDTO"%>
<%@page import="java.util.List"%>
<%@page import="thanhhp.bookstore.BookstoreDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>T - Store</title>
    </head>
    <body>
        <h1>Book Store</h1>
        <% 
//            String urlRewriting = "DispatchServlet"; 
        %>
            
            Choose your book drop
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
                    <% 
                        BookstoreDAO dao = new BookstoreDAO();
                        List<BookstoreDTO> books = dao.getBookList();
                        int count = 0;
                        
                        for (BookstoreDTO book: books) {
//                            String urlRewriting = "DispatchServlet"
//                                    + "?btAction=AddToCart"
//                                    + "&id=" + book.getId();
                            %>
                    <form action = "DispatchServlet">
                            <tr>
                                <th>
                                    <%= ++count %>
                                </th>
                                <th>
                                    <%= book.getId()%>
                                </th>
                                <th>
                                    <%= book.getTitle() %>
                                </th>
                                <th>
                                    <%= book.getPrice() %>
                                </th>
                                <th>
                                    <input type="submit" value="AddToCart" name="btAction" />
                                </th>
                                <th style="display: none;">
                                    <input type="hidden" value="<%= book.getId() %>" name="id"/>
                                </th>
                            </tr>
                     </form>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <form action="DispatchServlet">
                <input type="submit" name="btAction" value="View Your Cart" />
            </form>
        
    </body>
</html>
