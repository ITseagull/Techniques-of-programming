
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleForm extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String p1 = request.getParameter("p1");
        String p2 = request.getParameter("p2");
        try {
            int pp1 = Integer.parseInt(p1);
            int pp2 = Integer.parseInt(p2);
            int sum = pp1 + pp2;
            out.println("Result of doGet method: " + sum);
        } catch (NumberFormatException ex) {
            out.print(
                    "<!DOCTYPE html>" +
                            "<html><head>" +
                            "<meta charset=\"UTF-8\">" +
                            "<title>TPO assigment number 3</title>" +
                            "</head>" +
                            "<body>");
            out.println("Invalid numbers, please put integer number!");
            out.println("<FORM>" +
                    "<INPUT Type=\"button\" VALUE=\"Back\" onClick=\"history.go(-1);" +
                    "return true;" +
                    "\"></FORM>");
            out.println("</body></html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String p3 = request.getParameter("p3");
        String p4 = request.getParameter("p4");
        try {
            int pp3 = Integer.parseInt(p3);
            int pp4 = Integer.parseInt(p4);
            int sum = pp3 + pp4;
            out.println("Result of doPost method: " + sum);
        } catch (NumberFormatException ex) {
            out.print(
                    "<!DOCTYPE html>" +
                            "<html>" +
                            "<head>" +
                            "<meta charset=\"UTF-8\"><title>TPO assigment number 3</title>" +
                            "</head>" +
                            "<body>");
            out.println("Invalid numbers, please put integer number!");
            out.println("<FORM>" +
                    "<INPUT Type=\"button\" VALUE=\"Back\" onClick=\"history.go(-1);" +
                    "return true;\">" +
                    "</FORM>");
            out.println("</body></html>");
        }
    }
}