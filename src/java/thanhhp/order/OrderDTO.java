package thanhhp.order;

import java.io.Serializable;

public class OrderDTO implements Serializable {
    private int orderID;
    private String custName;
    private String custAddr;

    public OrderDTO() {
        
    }
    
    public OrderDTO(int orderID, String custName, String custAddr) {
        this.orderID = orderID;
        this.custName = custName;
        this.custAddr = custAddr;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddr() {
        return custAddr;
    }

    public void setCustAddr(String custAddr) {
        this.custAddr = custAddr;
    }
    
    
}
