/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanhhp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import thanhhp.bookstore.BookstoreDAO;
import thanhhp.bookstore.BookstoreDTO;
import thanhhp.cart.CartObj;
import thanhhp.order.OrderDAO;
import thanhhp.order.OrderDTO;
import thanhhp.order.OrderDetailsDAO;
import thanhhp.order.OrderDetailsDTO;

/**
 *
 * @author PC
 */
public class CheckoutServlet extends HttpServlet {
    private final String CHECKOUT_PAGE = "checkout.html";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String custName = request.getParameter("txtCustName");
        String custAddr = request.getParameter("txtCustAddr");
        String url = CHECKOUT_PAGE;
        try {
            //1. Cust goes to his/her cart place
            HttpSession session = request.getSession();
            //2. Cust takes his/her cart
            if (session != null) {
                CartObj cart = (CartObj) session.getAttribute("CART");
                if (cart != null) {
                    Map<String, Integer> items = cart.getItems();
                    if (items != null) {
                        
                        //Add to tblOrder
                        OrderDAO orderDAO = new OrderDAO();
                        OrderDTO orderDTO = new OrderDTO();
                        int newOrderID = orderDAO.getLastOrderID()+1;
                        
                        orderDTO.setOrderID(newOrderID);
                        orderDTO.setCustName(custName);
                        orderDTO.setCustAddr(custAddr);
                        
                        orderDAO.addOrder(orderDTO);
                        
                        //Add to tblOrderDetails
//                        BookstoreDAO bookstoreDAO = new BookstoreDAO();
//                        BookstoreDTO bookstoreDTO = new BookstoreDTO();
                        OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();
                        OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO(); 
                        for (String id: items.keySet()) {
//                            bookstoreDTO = bookstoreDAO.getOneBook(id);
                            orderDetailsDTO.setOrderID(newOrderID);
                            orderDetailsDTO.setBookID(id);
                            orderDetailsDTO.setQuantity(items.get(id));
                            orderDetailsDAO.addOrderDetails(orderDetailsDTO);
                        }
                    } // end if items is null
                    cart = new CartObj();
                    session.setAttribute("CART", cart);
                } // end if cart is null
            } // end if session is null
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(NamingException e) {
            e.printStackTrace(); 
        } finally {
            response.sendRedirect(url);
            out.close();
        } 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
