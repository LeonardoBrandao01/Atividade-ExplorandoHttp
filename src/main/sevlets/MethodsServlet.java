package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/methods")
public class MethodsServlet extends HttpServlet {
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Allow", "GET, POST, PUT, DELETE, OPTIONS");
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("Métodos permitidos: GET, POST, PUT, DELETE, OPTIONS");
    }
}
