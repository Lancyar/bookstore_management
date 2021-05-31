package thanhhp.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CartObj implements Serializable {
    private Map<String, Integer> items;

    public Map<String, Integer> getItems() {
        return items;
    }
    
    public void addBookToCart(String id) {
        //1. Check if cart exists
        if (this.items == null) {
            this.items = new HashMap<>();
        }
        //2. Check if item exists}

        int quantity = 1;
        if (this.items.containsKey(id)) {
            quantity = this.items.get(id) + 1;
        }
        //3. update product in cart
        this.items.put(id, quantity);
    }
    
    public void removeBookFromCart (String id) {
        //1. Check if cart exists
        if (this.items == null) {
            return;
        }
        
        //2. Check if item exists
        if (this.items.containsKey(id)) {
            this.items.remove(id);
            if (this.items.isEmpty()) {
                this.items = null;
            }
        }
    }
}
