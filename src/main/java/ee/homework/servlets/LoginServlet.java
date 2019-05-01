package ee.homework.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        if (req.getParameter("user").equals("john")
                && req.getParameter("password").equals("12345")) {
            RequestDispatcher rd = req.getRequestDispatcher("/form.html");
            rd.forward(req, resp);
        } else {
            resp.getWriter().print("<font color='red'>Invalid login credentials!</font><br/>");
            RequestDispatcher rd = req.getRequestDispatcher("/index.html");
            rd.include(req, resp);
        }
    }
}
