
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "A simple servlet", urlPatterns = { "/SimpleServletPath" })
public class SimpleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
        PrintWriter writer = response.getWriter();
        writer.print(
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "<meta charset=\"UTF-8\"><title>Simple Web Calculator</title>" +
                        "</head>" +
                        "<body>");

        writer.println("<form method=\"get\">doGet Method<br>Parameter a : <input name=\"p1\" /> <br>");
        writer.println(
                "Parameter b : <input name=\"p2\" /> <br> </br> <input	type=\"submit\" value=\"Send\"/></form><br>");

        writer.println("</body></html>");

        String p1 = request.getParameter("p1");
        String p2 = request.getParameter("p2");

        if (p1 != null && p2 != null) {
            try {

                int pp1 = Integer.parseInt(p1);
                int pp2 = Integer.parseInt(p2);
                int sum = pp1 + pp2;

                writer.println("<p>DoGet method sum: " + sum + "</p>");

            } catch (NumberFormatException ex) {
                writer.println("<p>Invalid numbers, please put integer number!</p>");
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.print(
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head><meta charset=\"UTF-8\"><title>Simple Web Calculator</title>" +
                        "</head>" +
                        "<body>");

        writer.println("<form method=\"post\">doPost Method<br>Parameter a : <input name=\"p4\" /> <br>");
        writer.println(
                "Parameter b : <input name=\"p3\" /> <br> </br> <input	type=\"submit\" value=\"Send\"/></form><br>");

        writer.println("</body></html>");

        String p3 = request.getParameter("p3");
        String p4 = request.getParameter("p4");

        if (p3 != null && p4 != null) {
            try {

                int pp3 = Integer.parseInt(p3);
                int pp4 = Integer.parseInt(p4);
                int sum = pp3 + pp4;

                writer.println("<p>DoPost method sum: " + sum + "</p>");

            } catch (NumberFormatException ex) {
                writer.println("<p>Invalid numbers, please put integer number!</p>");
            }
        }
    }

}