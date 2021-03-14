/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanhhp.order;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class OrderDetailsDTO implements Serializable {
    private int quantity;
    private String bookID;
    private int orderID;

    public OrderDetailsDTO() {
    }

    
    public OrderDetailsDTO(int quantity, String bookID, int orderID) {
        this.quantity = quantity;
        this.bookID = bookID;
        this.orderID = orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
}
