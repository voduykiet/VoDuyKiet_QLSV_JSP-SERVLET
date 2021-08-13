/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.Account_DAO;
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
import javax.servlet.http.HttpSession;
import models.Account;
import models.Classroom;
import models.Student;

/**
 *
 * @author DELL
 */
public class Add_student_servlet extends HttpServlet {

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

        ArrayList<Classroom> list_class = new Classroom_DAO().loadClassroom();
        request.setAttribute("list_class", list_class);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_student.jsp");
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

        Student s = new Student(id_student, fullname, birthday, email, phone, address, id_class);
        if (new Student_DAO().addStudent(s)) {
            if (new Account_DAO().addAccount(new Account(id_student, id_student, "123456", 1, 0, 0))) {
                response.sendRedirect("danh-sach-sinh-vien");
            }
        } else {
            request.setAttribute("msg", "Thêm sinh viên không hợp lệ");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_student.jsp");
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
