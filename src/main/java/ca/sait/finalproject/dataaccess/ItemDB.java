
package ca.sait.finalproject.dataaccess;

import ca.sait.finalproject.models.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kingston
 */
public class ItemDB {
        public List<Item> getAll(String email) throws Exception {
        List<Item> items = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM ITEM INNER JOIN user ON owner = user.email WHERE owner = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            // rs = con.createStatement().executeQuery(sql);
           

            while (rs.next()) {
                int id = rs.getInt(1);
                int category = rs.getInt(2);
                String name = rs.getString(3);
                double price = rs.getDouble(4);
                String owner = rs.getString(5);



                Item item = new Item(id, category, name, price, owner);
                items.add(item);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return items;
    }

    public Item get(String email) throws Exception {
        Item item = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM ITEM INNER JOIN user ON owner = user.email WHERE owner = ? LIMIT 1";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                int category = rs.getInt(2);
                String name = rs.getString(3);
                double price = rs.getDouble(4);
                String owner = rs.getString(5);


                item = new Item(id, category, name, price, owner);

            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return item;
    }

    public boolean insert(Item item) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        //String sql = "INSERT INTO item(`item_id`, `category`, `item_name`, `price`, `owner`) VALUES (?, ?, ?, ?, ?)";
        String sql = "INSERT INTO item(`category`, `item_name`, `price`, `owner`) VALUES (?, ?, ?, ?)";
       // String itemId = "item.item_id = item.item_id + 1";

        boolean inserted = false;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, item.getCategory());
            ps.setString(2, item.getName());
            ps.setDouble(3, item.getPrice());
            ps.setString(4, item.getEmail());

            inserted = ps.executeUpdate() != 0 ? true : false;

        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return inserted;
    }

    public boolean update(Item item) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE item SET `category` = ?, `item_name` = ?, `price` = ? WHERE `item_id` = ?";
        boolean updated;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, item.getCategory());
            ps.setString(2, item.getName());
            ps.setDouble(3, item.getPrice());
            ps.setInt(4, item.getId());
            updated = ps.executeUpdate() != 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return updated;
    }

    public boolean delete(Item item) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "DELETE FROM item WHERE item_id = ?";


        boolean deleted;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, item.getId());
            deleted = ps.executeUpdate() != 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return deleted;
    }
    
        public boolean deleteAll(String email) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "DELETE FROM item WHERE owner = ?";


        boolean deletedAll;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            deletedAll = ps.executeUpdate() != 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return deletedAll;
    }
}
