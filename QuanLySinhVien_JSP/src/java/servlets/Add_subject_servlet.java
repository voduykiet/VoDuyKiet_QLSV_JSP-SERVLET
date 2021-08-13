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
public class Add_subject_servlet extends HttpServlet {

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
        request.setAttribute("msg", "");
        request.setAttribute("msg_1", "");

        ArrayList<Credit> list_credit = new Credit_DAO().loadCredit();
        request.setAttribute("list_credit", list_credit);

        ArrayList<Category> list_category = new Category_DAO().loadCategory();
        request.setAttribute("list_category", list_category);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_subject.jsp");
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
        
        String id_credit_number = request.getParameter("id_credit");
        String array[] = id_credit_number.split(" ", id_credit_number.length());
        String id_credit = array[0];
        
        String id_category_name = request.getParameter("id_category");
        String array1[] = id_category_name.split(" ", id_category_name.length());
        String id_category = array1[0];
        
        Subject sub = new Subject(id_subject, name_subject, id_credit, id_category);

        if (id_subject.equals(new Subject_DAO().checkId(id_subject))) {
            request.setAttribute("msg", "Mã môn học đã tồn tại");
            request.setAttribute("msg_1", "");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_subject.jsp");
            dispatcher.forward(request, response);
        } else {
            if (new Subject_DAO().addSubject(sub) == true) {
                response.sendRedirect("danh-sach-mon-hoc");
            } else {
                request.setAttribute("msg_1", "Thông tin không hợp lệ");
                request.setAttribute("msg", "");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_subject.jsp");
                dispatcher.forward(request, response);
            }
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
