/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sait.finalproject.services;

import ca.sait.finalproject.dataaccess.CategoryDB;
import ca.sait.finalproject.models.Category;

import java.util.List;

/**
 *
 * @author Kingston
 */
public class CategoryService {
    private CategoryDB categoryDB = new CategoryDB();
    
        public Category get(int id) throws Exception {
        Category category = this.categoryDB.get(id);
        return category;
    }
    
    public List<Category> getAll() throws Exception {
        List<Category> categories = this.categoryDB.getAll();
        return categories;
    }
    
    public boolean insert(int id, String name) throws Exception {
        Category category = new Category(id, name);
       return this.categoryDB.insert(category);
    }
    
    public boolean update(int id, String name) throws Exception {
        Category category = new Category(id, name);
        return this.categoryDB.update(category);
    }
    
    public boolean delete(int id) throws Exception {
      
        Category category = new Category();
        category.setId(id);

        return this.categoryDB.delete(category);
    }
    

    
}
