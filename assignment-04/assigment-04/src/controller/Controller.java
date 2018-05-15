package controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Model model = null;

        PrintWriter out = response.getWriter();
        String p1 = request.getParameter("p1");
        String p2 = request.getParameter("p2");
        ParsableLogic logic = new ParsableLogic(p1,p2);

        if(logic.isParsable()){
            model = logic.result();
        } else {
            model = new Model("Please enter correct integers"); // error when input not integer numbers
        }


        ServletContext  con = getServletContext();
        RequestDispatcher d = con.getRequestDispatcher("/result");
        request.setAttribute("model", model);
        d.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Model model = null;

        PrintWriter out = response.getWriter();
        String p3 = request.getParameter("p3");
        String p4 = request.getParameter("p4");
        ParsableLogic logic = new ParsableLogic(p3,p4);

        if(logic.isParsable()){
            model = logic.result();
        } else {
            model = new Model("Please enter correct integers"); // error when input not integer numbers
        }


        ServletContext  con = getServletContext();
        RequestDispatcher d = con.getRequestDispatcher("/result");
        request.setAttribute("model", model);
        d.forward(request, response);
    }

}
