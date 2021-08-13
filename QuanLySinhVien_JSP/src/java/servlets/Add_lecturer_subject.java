/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.Lecturer_DAO;
import DAO.Lecturer_Subject_DAO;
import DAO.Subject_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Lecturer;
import models.Subject;
import models.Subject_Lecturer;

/**
 *
 * @author DELL
 */
public class Add_lecturer_subject extends HttpServlet {

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

        ArrayList<Lecturer> list_lecturer = new Lecturer_DAO().loadLecturer();
        request.setAttribute("list_lecturer", list_lecturer);

        ArrayList<Subject> list_subject = new Subject_DAO().loadSubject();
        request.setAttribute("list_subject", list_subject);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_lecturer_subject.jsp");
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

        String id_lecturer = request.getParameter("id_lecturer");
        String array_lecturer[] = id_lecturer.split(" ", id_lecturer.length());
        String id_lecturer1 = array_lecturer[0];

        String id_subject = request.getParameter("id_subject");
        String array_subject[] = id_subject.split(" ", id_subject.length());
        String id_subject1 = array_subject[0];

        Subject_Lecturer sl = new Subject_Lecturer(id_subject1, id_lecturer1);

        if (new Lecturer_Subject_DAO().addSubject_Lecturer(sl) == true) {
            response.sendRedirect("danh-sach-giang-vien-mon-hoc");
        } else {
            request.setAttribute("msg", "Thông tin đăng kí không hợp lý!!!");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_lecturer_subject.jsp");
            dispatcher.forward(request, response);
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
