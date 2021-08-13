/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.Classroom_DAO;
import DAO.Specialist_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Classroom;
import models.Specialist;

/**
 *
 * @author DELL
 */
public class Add_classroom_servlet extends HttpServlet {

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
        ArrayList<Specialist> list_specialist = new Specialist_DAO().loadSpecialist();
        request.setAttribute("list_specialist", list_specialist);

        request.setAttribute("msg", "");
        request.setAttribute("msg_1", "");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_classroom.jsp");
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

        String id_class = request.getParameter("id_class");
        String name_class = request.getParameter("name_class");

        String id_specialist_name = request.getParameter("id_specialist");
        String array[] = id_specialist_name.split(" ", id_specialist_name.length());
        String id_specialist = array[0];
        
        Classroom c = new Classroom(id_class, name_class, id_specialist);

        if (id_class.equals(new Classroom_DAO().checkId(id_class))) {
            request.setAttribute("msg", "Mã lớp đã tồn tại!!!");
            request.setAttribute("msg_1", "");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_classroom.jsp");
            dispatcher.forward(request, response);
        } else {
            if (new Classroom_DAO().addClassroom(c) == true) {
                response.sendRedirect("danh-sach-lop-hoc");
            } else {
                request.setAttribute("msg", "");
                request.setAttribute("msg_1", "Thông tin đăng ký không hợp lệ!!!");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_classroom.jsp");
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
