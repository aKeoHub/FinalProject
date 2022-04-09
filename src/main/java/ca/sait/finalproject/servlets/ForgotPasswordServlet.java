package ca.sait.finalproject.servlets;

import ca.sait.finalproject.services.AccountService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kingston
 */
public class ForgotPasswordServlet extends HttpServlet {

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

        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
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

        String email = request.getParameter("email");
        String path = getServletContext().getRealPath("/WEB-INF");
        AccountService service = new AccountService();
        HttpSession session = request.getSession();

        if (service.forgotPassword(email, path)) {
            String alert = "If the address you enetered is valid, you will receieve an email very soon. Please check your email for your password.";
            request.setAttribute("alert", alert);
            getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
        } else {
            String alert = "The email address you entered was not found in the system.";
            request.setAttribute("alert", alert);
            getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
        }

    }

}
