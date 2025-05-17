package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/status")
public class StatusServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String codeParam = request.getParameter("code");
        int code = 200;

        try {
            code = Integer.parseInt(codeParam);
        } catch (NumberFormatException e) {
            code = 400;
        }

        response.setStatus(code);
        PrintWriter out = response.getWriter();
        out.println("Status HTTP enviado: " + code);
    }
}
