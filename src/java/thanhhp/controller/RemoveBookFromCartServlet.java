package thanhhp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import thanhhp.cart.CartObj;

public class RemoveBookFromCartServlet extends HttpServlet {
    private final String SHOPPING_PAGE = "onlineBookStore.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String urlRewriting = SHOPPING_PAGE;
        try {
            // 1. cust go to cart place, check session exist
            HttpSession session = request.getSession(false);
            // 2. Cust takes a cart
            if (session != null) {
                CartObj cart = (CartObj) session.getAttribute("CART");
                if(cart != null){
                    // 3. cust gets items
                    Map<String, Integer> items = cart.getItems();
                    if(items != null){
                        //4. cust chooses removed items
                        String[] removedItems = request.getParameterValues("chkAdmin");
                        if(removedItems != null){
                            // 5. remove items from cart
                            for(String id : removedItems){
                                cart.removeBookFromCart(id);
                            }
                            session.setAttribute("CART", cart);
                        }// items are checked
                    }
                } // end if cart is existed
            } // if session is existed
            //6. Refresh or call view cart function
            urlRewriting = "DispatchServlet"
                           +"?btAction=View Your Cart";
        } finally {
            response.sendRedirect(urlRewriting);
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
