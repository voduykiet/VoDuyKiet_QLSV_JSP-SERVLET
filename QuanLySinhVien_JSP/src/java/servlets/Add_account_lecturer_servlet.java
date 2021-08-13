/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.Account_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Account;

/**
 *
 * @author DELL
 */
public class Add_account_lecturer_servlet extends HttpServlet {

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
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_account.jsp");
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
        String id_account = request.getParameter("id_account").toString();
        String username = request.getParameter("username").toString();
        String password = request.getParameter("password").toString();
        String confirm_password = request.getParameter("confirm_password").toString();

        if (!password.equals(confirm_password)) {
            request.setAttribute("msg_1", "Mật khẩu không khớp!!!");
            request.setAttribute("msg", "");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_account.jsp");
            dispatcher.forward(request, response);
        }

        if (!id_account.equals(new Account_DAO().checkIdAccount(id_account))
                && !username.equals(new Account_DAO().checkUsername(username))) {
            Account acc = new Account(id_account, username, password, 0, 1, 0);
            if (new Account_DAO().addAccount(acc) == true) {
                response.sendRedirect("danh-sach-tai-khoan-giang-vien");
            } else {
                request.setAttribute("msg", "Thông tin đăng ký không hợp lệ!!!");
                request.setAttribute("msg_1", "");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_account.jsp");
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
