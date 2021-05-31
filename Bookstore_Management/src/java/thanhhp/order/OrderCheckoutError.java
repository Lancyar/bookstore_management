/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanhhp.order;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class OrderCheckoutError implements Serializable{
    private ArrayList<String> notEnoughQuantity = new ArrayList<>();
    private String nullName;
    private String nullAddress;

    public OrderCheckoutError() {
    }

    public void addNotEnoughQuantity(String error) {
        this.notEnoughQuantity.add(error);
    }
    
    public ArrayList<String> getNotEnoughQuantity() {
        return notEnoughQuantity;
    }

    public void setNotEnoughQuantity(ArrayList<String> notEnoughQuantity) {
        this.notEnoughQuantity = notEnoughQuantity;
    }

    public String getNullName() {
        return nullName;
    }

    public void setNullName(String nullName) {
        this.nullName = nullName;
    }

    public String getNullAddress() {
        return nullAddress;
    }

    public void setNullAddress(String nullAddress) {
        this.nullAddress = nullAddress;
    }
    
    
}
