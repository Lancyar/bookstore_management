/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanhhp.bookstore;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import thanhhp.utils.DBHelpers;

/**
 *
 * @author PC
 */
public class BookstoreDAO implements Serializable {

    private List<BookstoreDTO> bookList;

    public List<BookstoreDTO> getBookList() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. Connect DB
            con = DBHelpers.makeConnection();

            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT bookID, title, price, quantity "
                        + "FROM bookstore";

                //3. Create Statement and assign Parameter value if any
                stm = con.prepareStatement(sql);

                //4. Execute Query
                rs = stm.executeQuery();

                //5. Process result
                while (rs.next()) {
                    String id = rs.getString("bookID");
                    String title = rs.getString("title");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    BookstoreDTO dto = new BookstoreDTO(id, title, price, quantity);

                    if (this.bookList == null) {
                        this.bookList = new ArrayList<>();
                    } // end if accountList is not allocated

                    this.bookList.add(dto);

                } // end while traversion is executed
            }//end if con is opened
        } finally {
            if (rs != null) {
                rs.close();
            }

            if (stm != null) {
                stm.close();
            }

            if (con != null) {
                con.close();
            }
        }
        return bookList;
    }

    public BookstoreDTO getOneBook(String id) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Connect DB
            con = DBHelpers.makeConnection();

            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT title, price, quantity "
                        + "FROM bookstore "
                        + "WHERE bookID = ?";

                //3. Create Statement and assign Parameter value if any
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                //4. Execute Query
                rs = stm.executeQuery();

                //5. Process result
                while (rs.next()) {
                    String title = rs.getString("title");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    
                    BookstoreDTO dto = new BookstoreDTO(id, title, price, quantity);

                    return dto;

                } // end while traversion is executed
            }//end if con is opened
        } finally {
            if (rs != null) {
                rs.close();
            }

            if (stm != null) {
                stm.close();
            }

            if (con != null) {
                con.close();
            }
        }
        return new BookstoreDTO();
    }
    
    public int getQuantity(String id) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Connect DB
            con = DBHelpers.makeConnection();

            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT quantity "
                        + "FROM bookstore "
                        + "WHERE bookID = ?";

                //3. Create Statement and assign Parameter value if any
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                //4. Execute Query
                rs = stm.executeQuery();

                //5. Process result
                if (rs.next()) {
                    return rs.getInt("quantity");
                }
            }//end if con is opened
        } finally {
            if (rs != null) {
                rs.close();
            }

            if (stm != null) {
                stm.close();
            }

            if (con != null) {
                con.close();
            }
        }
        return -1;
    }
    public boolean updateQuantity(String bookID, int quantity) 
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1. Connect Database
            con = DBHelpers.makeConnection();
            if (con != null) {
                //2. Create SQL String using DML
                String sql = "UPDATE bookstore "
                        + "SET quantity = (quantity - ?) "
                        + "WHERE bookID = ?";
                //3. Create Statement and assign Parameter value if any
                stm = con.prepareStatement(sql);
                stm.setInt(1, quantity);
                stm.setString(2, bookID);
                //4. Execute Query
                int rowEffect = stm.executeUpdate();
                //5. Process Result
                if (rowEffect > 0) {
                    return true;
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
            if (stm != null) {
                stm.close();
            }
        }

        return false;
    }
}
