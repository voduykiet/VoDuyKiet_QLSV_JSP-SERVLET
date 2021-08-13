/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.Category_DAO;
import DAO.Credit_DAO;
import DAO.Subject_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Category;
import models.Credit;
import models.Subject;

/**
 *
 * @author DELL
 */
public class Load_subject_servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

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
        String id_subject = request.getParameter("id_update");

        Subject s = new Subject_DAO().checkId(id_subject);
        request.setAttribute("subject", s);

        ArrayList<Credit> list_credit = new Credit_DAO().loadCredit();
        request.setAttribute("list_credit", list_credit);

        ArrayList<Category> list_category = new Category_DAO().loadCategory();
        request.setAttribute("list_category", list_category);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/load_subject.jsp");
        dispatcher.forward(request, response);
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
        request.setCharacterEncoding("UTF-8");

        String id_subject = request.getParameter("id_subject");
        String name_subject = request.getParameter("name_subject");

        String id_credit = request.getParameter("id_credit");
        String array_credit[] = id_credit.split(" ", id_credit.length());
        String id_credit1 = array_credit[0];
        
        String id_category = request.getParameter("id_category");
        String array_category[] = id_category.split(" ", id_category.length());
        String id_category1 = array_category[0];
        

        if (new Subject_DAO().updateSubject(id_subject, name_subject, id_credit1, id_category1) == true) {
            response.sendRedirect("danh-sach-mon-hoc");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
