package ca.sait.finalproject.servlets;

import ca.sait.finalproject.models.Item;
import ca.sait.finalproject.models.Role;
import ca.sait.finalproject.models.User;
import ca.sait.finalproject.services.ItemService;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kingston
 */
public class UserServlet extends HttpServlet {

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
        ItemService itemService = new ItemService();
        HttpSession session = request.getSession();

        //String email = (String) session.getAttribute("email");
        try {
            String email = (String) session.getAttribute("email");
            List<Item> items = itemService.getAll(email);

            request.setAttribute("items", items);
            this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
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
        ItemService itemService = new ItemService();
        String email = (String) session.getAttribute("email");
        try {
            List<Item> items = itemService.getAll(email);

            request.setAttribute("items", items);
            this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }

//        if (action != null && action.equals("add")) {
//            String item = request.getParameter("item");
//            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
//            items.add(item);
//            session.setAttribute("items", items);
//        } else if (action != null && action.equals("delete")) {
//            String item = request.getParameter("item");
//            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
//            items.remove(item);
//            session.setAttribute("items", items);
//        } else {
//
//            
//            ArrayList<String> items = new ArrayList<>();
//           
//            session.setAttribute("items", items);
//        }
        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);

    }
}
