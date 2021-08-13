/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.Account_DAO;
import DAO.Lecturer_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Account;
import models.Lecturer;

/**
 *
 * @author DELL
 */
public class Add_lecturer_servlet extends HttpServlet {

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

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_lecturer.jsp");
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

        String id_lecturer = request.getParameter("id_lecturer").toString();
        String name_lecturer = request.getParameter("name_lecturer").toString();
        String birthday = request.getParameter("birthday").toString();
        String email = request.getParameter("email").toString();
        String phone = request.getParameter("phone").toString();
        String address = request.getParameter("address").toString();

        Lecturer lec = new Lecturer(id_lecturer, name_lecturer, birthday, email, phone, address);

        if (id_lecturer.equals(new Lecturer_DAO().checkId(id_lecturer))) {
            request.setAttribute("msg", "Mã giáo viên đã được sử dụng!!!");
            request.setAttribute("msg_1", "");

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_lecturer.jsp");
            dispatcher.forward(request, response);
        } else {
            if (new Lecturer_DAO().addLecturer(lec) == true) {
                if (new Account_DAO().addAccount(new Account(id_lecturer, id_lecturer, "123123", 0, 1, 0)) == true) {
                    response.sendRedirect("danh-sach-giang-vien");
                }

            } else {
                request.setAttribute("msg_1", "Thông tin đăng ký không hợp lệ!!!");
                request.setAttribute("msg", "");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_lecturer.jsp");
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
