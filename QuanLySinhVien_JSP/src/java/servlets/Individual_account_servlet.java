/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.Account_DAO;
import DAO.Classroom_DAO;
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
public class Individual_account_servlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

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
        String id_lec = request.getParameter("id_lecturer");
        String id_stu = request.getParameter("id_student");

        if (id_lec == null && id_stu != null) {
            Account acc = new Account_DAO().checkIdAccount(id_stu);
            request.setAttribute("account_load", acc);
        } else if (id_lec != null && id_stu == null) {
            Account acc = new Account_DAO().checkIdAccount(id_lec);
            request.setAttribute("account_load", acc);
        }

        request.setAttribute("msg", "");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/individual_account.jsp");
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
        String id_account = request.getParameter("id_account");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Account acc = new Account_DAO().checkIdAccount(id_account);
        int role_sv = acc.getRole_sv();
        int role_lec = acc.getRole_lecturer();

        if (role_lec == 1 && new Account_DAO().updateAccount(username, password, id_account) == true) {
            request.setAttribute("msg", "Cập nhật thành công");
            response.sendRedirect("thong-tin-tai-khoan?id_lecturer=" + id_account);
        } else if (role_sv == 1 && new Account_DAO().updateAccount(username, password, id_account) == true) {
            request.setAttribute("msg", "Cập nhật thành công");
            response.sendRedirect("thong-tin-tai-khoan?id_student=" + id_account);
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
