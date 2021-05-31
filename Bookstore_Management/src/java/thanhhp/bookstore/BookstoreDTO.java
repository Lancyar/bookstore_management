/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thanhhp.bookstore;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class BookstoreDTO implements Serializable {
    private String title;
    private String id;
    private float price;
    private int quantity;
    
    public BookstoreDTO() {
    
    }

    public BookstoreDTO(String id, String title, float price, int quantity) {
        this.title = title;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
