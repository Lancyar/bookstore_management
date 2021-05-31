package thanhhp.order;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import thanhhp.utils.DBHelpers;

public class OrderDAO implements Serializable {
    private List<OrderDTO> orderList;
    
    public List<OrderDTO> getOrderList() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. Connect DB
            con = DBHelpers.makeConnection();

            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT orderID, custName, custAddr "
                        + "FROM tblOrder";

                //3. Create Statement and assign Parameter value if any
                stm = con.prepareStatement(sql);

                //4. Execute Query
                rs = stm.executeQuery();

                //5. Process result
                while (rs.next()) {
                    int orderID = rs.getInt("orderID");
                    String custName = rs.getString("custName");
                    String custAddr = rs.getString("custAddr");

                    OrderDTO dto = new OrderDTO(orderID, custName, custAddr);

                    if (this.orderList == null) {
                        this.orderList = new ArrayList<>();
                    } // end if accountList is not allocated

                    this.orderList.add(dto);

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
        return orderList;
    }
    
    public void addOrder(OrderDTO dto) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1. Connect DB
            con = DBHelpers.makeConnection();

            if (con != null) {
                //2. Create SQL String
                String sql = "INSERT INTO tblOrder VALUES (?,?,?)";

                //3. Create Statement and assign Parameter value if any
                stm = con.prepareStatement(sql);
                stm.setInt(1, dto.getOrderID());
                stm.setString(2, dto.getCustName());
                stm.setString(3, dto.getCustAddr());
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
    
    public int getLastOrderID() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int lastOrderID = 0;
        try {
            //1. Connect DB
            con = DBHelpers.makeConnection();

            if (con != null) {
                //2. Create SQL String
                String sql = "SELECT COUNT(*) AS lastID "
                        + "FROM tblOrder";

                //3. Create Statement and assign Parameter value if any
                stm = con.prepareStatement(sql);

                //4. Execute Query
                rs = stm.executeQuery();

                if (rs.next()) {
                    lastOrderID = rs.getInt("lastID");
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
        return lastOrderID;
    }
}
