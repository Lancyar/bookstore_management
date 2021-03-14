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
    private Integer price;
    
    public BookstoreDTO() {
    
    }

    public BookstoreDTO(String id, String title, Integer price) {
        this.title = title;
        this.id = id;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    
    
}
