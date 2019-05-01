package ee.homework.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/form")
public class FormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        boolean verified = true;
        Enumeration<String> paramNames = req.getParameterNames();

        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            if (req.getParameter(paramName).length() == 0) {
                verified = false;
                resp.getWriter().print("<font color='red'>The '" + paramName
                        + "' field has to contain a value!</font><br/>");
            }
        }

        if (verified) {
            RequestDispatcher rd = req.getRequestDispatcher("display");
            rd.forward(req, resp);
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("/form.html");
            rd.include(req, resp);
        }
    }
}
