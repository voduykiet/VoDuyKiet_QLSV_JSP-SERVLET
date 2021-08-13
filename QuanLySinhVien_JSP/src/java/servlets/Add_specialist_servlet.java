/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.Specialist_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Specialist;

/**
 *
 * @author DELL
 */
public class Add_specialist_servlet extends HttpServlet {

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

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_specialist.jsp");
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

        String id_specialist = request.getParameter("id_specialist");
        String name_specialist = request.getParameter("name_specialist");
        String contact_specialist = request.getParameter("contact_specialist");

        Specialist s = new Specialist(id_specialist, name_specialist, contact_specialist);

        if (id_specialist.equals(new Specialist_DAO().checkId(id_specialist))) {
            request.setAttribute("msg", "Mã khoa đã tồn tại!!!");
            request.setAttribute("msg_1", "");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_specialist.jsp");
            dispatcher.forward(request, response);
        } else {
            if (new Specialist_DAO().addSpecialist(s) == true) {
                response.sendRedirect("danh-sach-phong-khoa");
            } else {
                request.setAttribute("msg", "");
                request.setAttribute("msg_1", "Thông tin đăng ký không hợp lệ!!!");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_specialist.jsp");
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
