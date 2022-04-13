/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sait.finalproject.services;

import ca.sait.finalproject.dataaccess.CategoryDB;
import ca.sait.finalproject.models.Category;
import ca.sait.finalproject.models.Role;
import ca.sait.finalproject.models.User;
import java.util.List;

/**
 *
 * @author Kingston
 */
public class CategoryService {
    private CategoryDB categoryDB = new CategoryDB();
    
        public User get(String email) throws Exception {
        User user = this.categoryDB.get(email);
        return user;
    }
    
    public List<Category> getAll() throws Exception {
        List<Category> categories = this.categoryDB.getAll();
        return categories;
    }
    
    public boolean insert(String email, boolean active, String firstName, String lastName, String password, Role role) throws Exception {
        User user = new User(email, active, firstName, lastName, password, role);
       return this.categoryDB.insert(user);
    }
    
    public boolean update(String email, boolean active, String firstName, String lastName, String password, Role role) throws Exception {
        User user = new User(email, active, firstName, lastName, password, role);
        return this.categoryDB.update(user);
    }
    
    public boolean delete(String email) throws Exception {
        
        User user = new User();
        user.setEmail(email);
        return this.categoryDB.delete(user);
    }
    
    public boolean activate(String email) throws Exception {
        User user = new User();
        user.setEmail(email);
        return this.categoryDB.activate(user);
    }
    
        public boolean deactivate(String email) throws Exception {
        User user = new User();
        user.setEmail(email);
        return this.categoryDB.deactivate(user);
    }
}
