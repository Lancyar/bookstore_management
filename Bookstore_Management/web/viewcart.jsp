<%-- 
    Document   : viewcart
    Created on : Mar 5, 2021, 10:00:39 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="thanhhp.bookstore.BookstoreDTO"%>
<%@page import="thanhhp.bookstore.BookstoreDAO"%>
<%@page import="java.util.Map"%>
<%@page import="thanhhp.cart.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>T - Store</title>
    </head>
    <body>
        <h1>Your cart includes: </h1>
        <c:if test="${not empty sessionScope}">
            <c:set var="cart" value="${sessionScope.CART}"></c:set>
            <c:if test="${not empty cart}">
                <c:set var="items" value="${cart.getItems()}"></c:set>
                <c:if test="${not empty items}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Title</th>
                                <th>Quantity</th>
                                <th>Total Price</th>
                            </tr>
                        </thead>
                        <tbody>
                        <form action="removeBookFromCart">
                            <c:set var="bookDAO" value="${sessionScope.BOOKDAO}"></c:set>
                            <c:forEach var="bookID" items="${items.keySet()}" varStatus="counter">
                                <c:set var="bookDTO" value="${bookDAO.getOneBook(bookID)}"></c:set>
                                <c:set  var="title" value="${bookDTO.getTitle()}"></c:set>
                                <c:set  var="quantity" value="${items.get(bookID)}"></c:set>
                                <c:set  var="price" value="${bookDTO.getPrice()*quantity}"></c:set>
                                    <tr>    
                                        <td>
                                        ${counter.count}
                                    </td>
                                    <td>
                                        ${title}
                                    </td>
                                    <td>
                                        ${quantity}
                                    </td>
                                    <td>
                                        ${price}
                                    </td>
                                    <td>
                                        <input type="checkbox" name="chkAdmin" value="${bookID}" />
                                    </td>
                                <tr>

                                </c:forEach>
                            <tr>
                                <td colspan="3">
                                    <a href="onlineBookStore">add more books to cart</a>
                                </td>
                                <td>
                                    <input type="submit" name="btAction" value="Remove From Cart" />
                                </td>
                            </tr>
                        </form>
                    </tbody>
                </table>
                <c:set var="errors" value="${requestScope.CHECKOUT_ERROR}"></c:set>
                <form action="checkout" method="POST">
                    Name <input type="text" name="txtCustName" value="${param.txtCustName}" /></br>
                    <c:if test="${not empty errors.nullName}">
                    <font color="red">
                        ${errors.nullName}
                    </font><br/>
                    </c:if>
                    Address <input type="text" name="txtCustAddr" value="${param.txtCustAddr}" /></br>
                    <c:if test="${not empty errors.nullAddress}">
                    <font color="red">
                        ${errors.nullAddress}
                    </font><br/>
                    </c:if>
                    <input type="submit" value="checkout" name="btAction" /><br/>
                </form>
                    <c:if test="${not empty errors.notEnoughQuantity}">
                        <c:forEach var="quantityError" items="${errors.notEnoughQuantity}">
                            <font color="red">
                                ${quantityError}
                            </font><br/>
                        </c:forEach>
                    </c:if>
            </c:if>
        </c:if>
        <c:if test="${empty cart}">
        <h2>Your cart is empty!</h2>
        <a href="onlineBookStore">Go To BookStore</a><br/>
    </c:if>
    </c:if>
    <c:if test="${empty sessionScope}">
        <h2>Your cart is lost!</h2>
        <a href="onlineBookStore">Go To BookStore</a><br/>
    </c:if>
    <%--        <%
                //1. Customer goes to her/his cart place
                if (session != null) {
                    //2. Customer takes her/his cart place
                    CartObj cart = (CartObj) session.getAttribute("CART");
                    if (cart != null) {
                        //3. Customer checks her/his cart
                        Map<String, Integer> items = cart.getItems();
                        if (items != null) {
            %> 
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Title</th>
                        <th>Quantity</th>
                        <th>Total Price</th>
                    </tr>
                </thead>
                <form action="DispatchServlet">
                    <tbody>
                        <%
                            int count = 0;
                            BookstoreDAO dao = new BookstoreDAO();
                            for (String id : items.keySet()) {
                                BookstoreDTO dto = dao.getOneBook(id);
                                String title = dto.getTitle();
                                int quantity = items.get(id);
                                int totalPrice = dto.getPrice() * quantity;
                        %>  
                        <tr>
                            <td>
                                <%= ++count%>
                                .</td>
                            <td>
                                <%= title %>
                            </td>
                            <td>
                                <%= quantity %>
                            </td>
                            <td>
                                <%= totalPrice %>
                            </td>
                            <td>
                                <input type="checkbox" name="chkAdmin" value="<%= id %>" />
                            </td>
                        </tr>
                        <%
                            }
                        %>
                        <tr>
                            <td colspan="3">
                                <a href="onlineBookStore.jsp">add more books to cart</a>
                            </td>
                            <td>
                                <input type="submit" name="btAction" value="Remove From Cart" />
                            </td>
                        </tr>
                    </tbody>
                </form>
            </table>
             <form action="DispatchServlet" method="POST">
                Name <input type="text" name="txtCustName" value="" /></br>
                Address 
                <select name="txtCustAddr" >
                    <option>Ho Chi Minh</option>
                    <option>Ha Noi</option>
                    <option>Da Nang</option>
                    <option>Thua Thien Hue</option>
                    <option>Quang Tri</option>
                    <option>Other</option>
                </select></br>
                <input type="submit" value="Checkout" name="btAction" />
            </form>           
            <%
                            return;
                        } // end if items exist
                    } // end if cart exists
                } // end if session exists
            %>

        <h2>
            Your cart is lost!!!
        </h2>
    --%> 
</body>
</html>
