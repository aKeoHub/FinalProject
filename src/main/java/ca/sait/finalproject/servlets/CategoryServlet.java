package ca.sait.finalproject.servlets;

import ca.sait.finalproject.models.Category;
import ca.sait.finalproject.models.Item;
import ca.sait.finalproject.services.ItemService;
import ca.sait.finalproject.services.UserService;
import ca.sait.finalproject.services.*;
import java.io.IOException;
import java.io.PrintWriter;
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
public class CategoryServlet extends HttpServlet {

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
        CategoryService catService = new CategoryService();
        HttpSession session = request.getSession();
        ItemService itemService = new ItemService();

        String email = (String) session.getAttribute("email");

        try {
            List<Category> categories = catService.getAll();

            request.setAttribute("categories", categories);
            this.getServletContext().getRequestDispatcher("/WEB-INF/category.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/category.jsp").forward(request, response);
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
        CategoryService catService = new CategoryService();
        HttpSession session = request.getSession();


        String email = (String) session.getAttribute("email");

        try {
            List<Category> categories = catService.getAll();

            request.setAttribute("categories", categories);
            this.getServletContext().getRequestDispatcher("/WEB-INF/category.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        if (action != null && action.equals("add")) {
            try {

                String name = request.getParameter("name");
                String idParam = request.getParameter("id");
                int id = Integer.parseInt(idParam);


                catService.insert(id, name);
                // itemService.insert(category, name, price, email);
                // this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }

        } else if (action != null && action.equals("delete")) {
            try {
                String idParam = request.getParameter("categoryId");
                int id = Integer.parseInt(idParam);
                catService.delete(id);
                //this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
        } else if (action != null && action.equals("edit")) {
            try {
                String idParam = request.getParameter("id");
                int id = Integer.parseInt(idParam);
                String category = request.getParameter("name");

                catService.update(id, category);
                //this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }

        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/category.jsp").forward(request, response);
    }

}
