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
public class Load_classroom_servlet extends HttpServlet {

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

        String id_class = request.getParameter("id_update");
        Classroom cla = new Classroom_DAO().checkId(id_class);

        request.setAttribute("classroom", cla);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/load_classroom.jsp");
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
        
        String id_specialist = request.getParameter("id_specialist");
        String array_specialist[] = id_specialist.split(" ", id_specialist.length());
        String id_specialist1 = array_specialist[0];
        
        if (new Classroom_DAO().updateClassroom(id_class, name_class, id_specialist1) == true) {
            response.sendRedirect("danh-sach-lop-hoc");
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
