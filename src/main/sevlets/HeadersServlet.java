package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet("/headers")
public class HeadersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Cabeçalhos da Requisição:</h2>");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            out.println(name + ": " + value + "<br>");
        }

        out.println("<br><strong>IP do usuário:</strong> " + request.getRemoteAddr());
        out.println("<br><strong>Versão HTTP:</strong> " + request.getProtocol());
    }
}
