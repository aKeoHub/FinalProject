package ca.sait.finalproject.dataaccess;

import ca.sait.finalproject.models.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDB {

    public List<Role> getAll() throws Exception {
        List<Role> roles = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM role ";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            // rs = con.createStatement().executeQuery(sql);

            while (rs.next()) {
               int id = rs.getInt(1);
               String name = rs.getString(2);

                Role role = new Role(id, name);

                
                roles.add(role);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return roles;
    }



}
