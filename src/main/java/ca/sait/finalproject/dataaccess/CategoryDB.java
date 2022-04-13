/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sait.finalproject.dataaccess;

import ca.sait.finalproject.models.Category;
import ca.sait.finalproject.models.Item;
import ca.sait.finalproject.models.Role;
import ca.sait.finalproject.models.User;
import ca.sait.finalproject.models.*;
import ca.sait.finalproject.models.Category;
import ca.sait.finalproject.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kingston
 */
public class CategoryDB {

    public List<Category> getAll() throws Exception {
        List<Category> categories = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM CATEGORY";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            // rs = con.createStatement().executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);

                Category category = new Category(id, name);

                categories.add(category);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return categories;
    }

    public Category get(int id) throws Exception {
        Category category = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM CATEGORY WHERE category_id = ? LIMIT 1";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                int idNum = rs.getInt(1);
                String name = rs.getString(2);

                category = new Category(idNum, name);

            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return category;
    }

    public boolean insert(Category category) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO category(`category_id`, `category_name`) VALUES (?, ?)";

        boolean inserted = false;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, category.getId());
            ps.setString(2, category.getName());

            inserted = ps.executeUpdate() != 0 ? true : false;

        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return inserted;
    }

    public boolean update(Category category) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE category SET `category_id` = ?, `category_name` = ? WHERE `category_id` = ?";
        boolean updated;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, category.getId());
            ps.setString(2, category.getName());
            ps.setInt(3, category.getId());
            updated = ps.executeUpdate() != 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return updated;
    }

    public boolean delete(Category category) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "DELETE FROM CATEGORY WHERE category_id = ?";
        //String sql = "Update user SET active = 0 WHERE email = ?";

        boolean deleted;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, category.getId());
            deleted = ps.executeUpdate() != 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return deleted;
    }


}
