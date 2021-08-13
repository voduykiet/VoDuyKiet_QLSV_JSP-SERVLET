/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.Classroom_DAO;
import DAO.Lecturer_DAO;
import DAO.Student_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Classroom;
import models.Lecturer;
import models.Student;

/**
 *
 * @author DELL
 */
public class Individual_Information_servlet extends HttpServlet {

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
        String id_student = request.getParameter("id_student");
        String id_lecturer = request.getParameter("id_lecturer");

        if (id_lecturer == null && id_student != null) {
            Student s = new Student_DAO().checkId(id_student);
            ArrayList<Classroom> list = new Classroom_DAO().loadClassroom();

            request.setAttribute("list_class", list);
            request.setAttribute("load_inf", s);
        } else if (id_lecturer != null && id_student == null) {
            Lecturer l = new Lecturer_DAO().checkId(id_lecturer);
            request.setAttribute("load_inf", l);
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/individual_information.jsp");
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

        String id_stu = request.getParameter("id_student");
        String id_lec = request.getParameter("id_lecturer");

        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        if (id_stu != null && id_lec == null) {
            String id_class = request.getParameter("id_class");
            String array[] = id_class.split(" ", id_class.length());
            String id_class1 = array[0];

            new Student_DAO().updateStudent(name, birthday, email, phone, address, id_class1, id_stu);
            response.sendRedirect("thong-tin-ca-nhan?id_student=" + id_stu);
        } else if (id_stu == null && id_lec != null) {
            new Lecturer_DAO().updateLecturer(name, birthday, email, phone, address, id_lec);
            response.sendRedirect("thong-tin-ca-nhan?id_lecturer=" + id_lec);
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
