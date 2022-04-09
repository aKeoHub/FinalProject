package ca.sait.finalproject.services;


import ca.sait.finalproject.dataaccess.RoleDB;
import ca.sait.finalproject.models.Role;
import java.util.List;


public class RoleService {
    private RoleDB roleDB = new RoleDB();
    
    public List<Role> getAll() throws Exception {
        List<Role> roles = this.roleDB.getAll();
        return roles;
    }
    
}
