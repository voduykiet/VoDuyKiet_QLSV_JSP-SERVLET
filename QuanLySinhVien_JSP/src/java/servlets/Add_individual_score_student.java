/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.Category_DAO;
import DAO.Credit_DAO;
import DAO.Lecturer_DAO;
import DAO.Schoolyear_DAO;
import DAO.Score_DAO;
import DAO.Semester_DAO;
import DAO.Student_DAO;
import DAO.Subject_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Category;
import models.Credit;
import models.Lecturer;
import models.School_year;
import models.Score;
import models.Semester;
import models.Student;
import models.Subject;

/**
 *
 * @author DELL
 */
public class Add_individual_score_student extends HttpServlet {

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

        ArrayList<Student> list_stu = new Student_DAO().loadStudent();
        request.setAttribute("list_student", list_stu);

        ArrayList<Subject> list_sub = new Subject_DAO().loadSubject();
        request.setAttribute("list_subject", list_sub);

        ArrayList<Credit> list_cre = new Credit_DAO().loadCredit();
        request.setAttribute("list_credit", list_cre);

        ArrayList<Category> list_cat = new Category_DAO().loadCategory();
        request.setAttribute("list_category", list_cat);

        ArrayList<Semester> list_sem = new Semester_DAO().loadSemester();
        request.setAttribute("list_semester", list_sem);

        ArrayList<School_year> list_sch = new Schoolyear_DAO().loadSchoolYear();
        request.setAttribute("list_school_year", list_sch);

        request.setAttribute("msg", "");
        request.setAttribute("msg_1", "");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_individual_score_student.jsp");
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

        String id_score = request.getParameter("id_score");
        String score_1 = request.getParameter("score_1");
        String score_4 = request.getParameter("score_4");
        String score_test = request.getParameter("score_test");
        String avg_score = request.getParameter("avg_score");

        String id_lecturer = request.getParameter("id_lecturer");

        String id_student = request.getParameter("id_student");
        String array_stu[] = id_student.split(" ", id_student.length());
        String id_student1 = array_stu[0];

        String id_subject = request.getParameter("id_subject");
        String array_sub[] = id_subject.split(" ", id_subject.length());
        String id_subject1 = array_sub[0];

        String id_credit = request.getParameter("id_credit");
        String array_cre[] = id_credit.split(" ", id_credit.length());
        String id_credit1 = array_cre[0];

        String id_category = request.getParameter("id_category");
        String array_cat[] = id_category.split(" ", id_category.length());
        String id_category1 = array_cat[0];

        String id_semester = request.getParameter("id_semester");
        String array_sem[] = id_semester.split(" ", id_semester.length());
        String id_semester1 = array_sem[0];

        String id_school_year = request.getParameter("id_school_year");
        String array_sch[] = id_school_year.split(" ", id_school_year.length());
        String id_school_year1 = array_sch[0];

        Score s = new Score(id_score, Float.parseFloat(score_1), Float.parseFloat(score_4), Float.parseFloat(score_test),
                Float.parseFloat(avg_score), id_lecturer, id_student1, id_subject1, id_credit1, id_category1, id_semester1, id_school_year1);

        if (id_score.equals(new Score_DAO().checkId(id_score))) {
            request.setAttribute("msg", "Mã điểm đã tồn tại");
            request.setAttribute("msg_1", "");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_individual_score_student.jsp");
            dispatcher.forward(request, response);
        } else {
            if (new Score_DAO().addScore(s) == true) {
                response.sendRedirect("diem-ca-nhan?id_lecturer="+id_lecturer);
            } else {
                request.setAttribute("msg_1", "Thông tin không hợp lệ");
                request.setAttribute("msg", "");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/session/add_individual_score_student.jsp");
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
