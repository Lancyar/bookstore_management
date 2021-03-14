/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanhhp.order;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import thanhhp.utils.DBHelpers;

/**
 *
 * @author PC
 */
public class OrderDetailsDAO implements Serializable {
    private List<OrderDetailsDTO> orderDetailsList;
    
    public void addOrderDetails(OrderDetailsDTO dto) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1. Connect DB
            con = DBHelpers.makeConnection();

            if (con != null) {
                //2. Create SQL String
                String sql = "INSERT INTO tblOrderDetails VALUES (?,?,?)";

                //3. Create Statement and assign Parameter value if any
                stm = con.prepareStatement(sql);
                stm.setInt(1, dto.getQuantity());
                stm.setString(2, dto.getBookID());
                stm.setInt(3, dto.getOrderID());
                //4. Execute Query
                stm.executeUpdate();

            }//end if con is opened
        } finally {
            if (stm != null) {
                stm.close();
            }

            if (con != null) {
                con.close();
            }
        }
    }
}
