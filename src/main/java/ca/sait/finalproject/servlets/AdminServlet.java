package ca.sait.finalproject.servlets;

import ca.sait.finalproject.dataaccess.UserDB;
import ca.sait.finalproject.models.Role;
import ca.sait.finalproject.models.User;
import ca.sait.finalproject.services.ItemService;
import ca.sait.finalproject.services.RoleService;
import ca.sait.finalproject.services.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kingston
 */
public class AdminServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService service = new UserService();

        try {
            List<User> users = service.getAll();

            request.setAttribute("users", users);
            this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        UserService service = new UserService();
        ItemService itemService = new ItemService();
        int roleId;

        if (action != null && action.equals("add")) {
            try {
                String firstName = request.getParameter("first");
                String lastName = request.getParameter("last");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String role;
                roleId = checkRole(request.getParameter("role"));

                if (roleId == 1) {
                    role = "System Admin";
                } else if (roleId == 2) {
                    role = "Regular User";
                } else {
                    role = "Company Admin";
                }

                Role newRole = new Role(roleId, role);
                service.insert(email, true, firstName, lastName, password, newRole);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }

        } else if (action != null && action.equals("delete")) {

            try {
                String email = request.getParameter("email");
                itemService.deleteAll(email);
                service.delete(email);
               
                
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
        } else if (action != null && action.equals("edit")) {
            try {
                String firstName = request.getParameter("first");
                String lastName = request.getParameter("last");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String role;
                roleId = checkRole(request.getParameter("role"));

                if (roleId == 1) {
                    role = "System Admin";
                } else if (roleId == 2) {
                    role = "Regular User";
                } else {
                    role = "Company Admin";
                }

                Role newRole = new Role(roleId, role);
                service.update(email, true, firstName, lastName, password, newRole);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
        } else if (action != null && action.equals("activation")) {
            try {
                String email = request.getParameter("email");
                service.activate(email);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
        }

        UserService userService = new UserService();
        try {
            List<User> users = userService.getAll();

            request.setAttribute("users", users);
            this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }

    private int checkRole(String role) {
        int roleId;

        switch (role) {
            case "1":
                roleId = 1;
                break;
            case "2":
                roleId = 2;
                break;
            default:
                roleId = 3;
                break;
        }
        return roleId;
    }

}
