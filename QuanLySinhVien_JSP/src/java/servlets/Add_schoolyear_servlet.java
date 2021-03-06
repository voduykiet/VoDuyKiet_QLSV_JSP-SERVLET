/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.Schoolyear_DAO;
import DAO.Semester_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.School_year;

/**
 *
 * @author DELL
 */
public class Add_schoolyear_servlet extends HttpServlet {

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

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_schoolyear.jsp");
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

        String id_school_year = request.getParameter("id_school_year");
        String name_school_year = request.getParameter("name_school_year");

        School_year s = new School_year(id_school_year, name_school_year);

        if (id_school_year.equals(new Schoolyear_DAO().checkId(id_school_year))) {
            request.setAttribute("msg", "M?? n??m h???c ???? t???n t???i!!!");
            request.setAttribute("msg_1", "");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_schoolyear.jsp");
            dispatcher.forward(request, response);
        } else {
            if (new Schoolyear_DAO().addSchoolYear(s) == true) {
                response.sendRedirect("danh-sach-hoc-ki-nam-hoc");
            } else {
                request.setAttribute("msg", "");
                request.setAttribute("msg_1", "Th??ng tin ????ng k?? kh??ng h???p l???!!!");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_schoolyear.jsp");
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
