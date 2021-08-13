/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.Classroom_DAO;
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
import models.Student;

/**
 *
 * @author DELL
 */
public class Load_student_servlet extends HttpServlet {

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
        String id_student = request.getParameter("id_update");
        
        Student s = new Student_DAO().checkId(id_student);
        request.setAttribute("student", s);
        

        ArrayList<Classroom> list = new Classroom_DAO().loadClassroom();
        request.setAttribute("list_class", list);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/load_student.jsp");
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

        String id_student = request.getParameter("id_student").toString();
        String fullname = request.getParameter("fullname").toString();
        String birthday = request.getParameter("birthday").toString();
        String email = request.getParameter("email").toString();
        String phone = request.getParameter("phone").toString();
        String address = request.getParameter("address").toString();

        String id_class = request.getParameter("id_class").toString();
        String array_class[] = id_class.split(" ", id_class.length());
        String id_class1 = array_class[0];

        if (new Student_DAO().updateStudent(fullname, birthday, email, phone, address, id_class1, id_student)) {
            response.sendRedirect("danh-sach-sinh-vien");
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
