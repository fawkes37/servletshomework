package ee.homework.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/display")
public class FormDataDisplayServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.println("<b>First name:</b> " + req.getParameter("name"));
        out.println("<br/><b>Last name:</b> " + req.getParameter("surname"));
        out.println("<br/><b>Employment status:</b> " + req.getParameter("employment"));
        out.println("<br/><b>Favourite musical artist:</b> " + req.getParameter("artist"));
        out.println("<br/><b>Hobby:</b> " + req.getParameter("hobby"));
        out.println("<br/><b>Relationship status:</b> " + req.getParameter("relationship"));
    }
}
