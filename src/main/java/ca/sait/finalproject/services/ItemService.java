
package ca.sait.finalproject.services;

import ca.sait.finalproject.dataaccess.ItemDB;
import ca.sait.finalproject.dataaccess.UserDB;
import ca.sait.finalproject.models.Item;
import ca.sait.finalproject.models.Role;
import ca.sait.finalproject.models.User;
import java.util.List;

/**
 *
 * @author Kingston
 */
public class ItemService {

        private ItemDB itemDB = new ItemDB();
    
    public Item get(String email) throws Exception {
        Item item = this.itemDB.get(email);
        return item;
    }
    
    public List<Item> getAll(String email) throws Exception {
        List<Item> items = this.itemDB.getAll(email);
        return items;
    }
    
//    public boolean insert(int id, int category, String name, double price, String email) throws Exception {
//        Item item = new Item(id, category, name, price, email);
//       return this.itemDB.insert(item);
//    }
        public boolean insert(int category, String name, double price, String email) throws Exception {
        Item item = new Item(category, name, price, email);
       return this.itemDB.insert(item);
    }
    
    public boolean update(int id, int category, String name, double price, String email) throws Exception {
        Item item = new Item(id, category, name, price, email);
        return this.itemDB.update(item);
    }
    
    public boolean deleteAll(String email) throws Exception {
        
        Item item = new Item();
        item.setEmail(email);
        return this.itemDB.deleteAll(email);
    }

        public boolean delete(int id) throws Exception {
        
        Item item = new Item();
        item.setId(id);
        return this.itemDB.delete(item);
    }

    

}
