
package ca.sait.finalproject.servlets;

import ca.sait.finalproject.models.Role;
import ca.sait.finalproject.services.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kingston
 */
public class AccountServlet extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        getServletContext().getRequestDispatcher("/WEB-INF/account.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
                if (action != null && action.equals("edit")) {
            try {
                String firstName = request.getParameter("first");
                String lastName = request.getParameter("last");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String role = "Regular User";

                Role newRole = new Role(2, role);
                service.update(email, true, firstName, lastName, password, newRole);
                getServletContext().getRequestDispatcher("/WEB-INF/account.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
        } else if (action != null && action.equals("deactivate")) {
            try {
                String email = request.getParameter("email");
                service.deactivate(email);

            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
        } 
        getServletContext().getRequestDispatcher("/WEB-INF/account.jsp").forward(request, response);
        
    }

}
