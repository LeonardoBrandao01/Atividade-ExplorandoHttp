package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String nomeUsuario = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("usuario".equals(c.getName())) {
                    nomeUsuario = c.getValue();
                    break;
                }
            }
        }

        if (nomeUsuario == null) {
            nomeUsuario = "X";
            Cookie novoCookie = new Cookie("usuario", nomeUsuario);
            novoCookie.setMaxAge(3600); // 1 hora
            response.addCookie(novoCookie);
            out.println("Primeira visita. Cookie criado!");
        } else {
            out.println("Bem-vindo de volta, usuário '" + nomeUsuario + "'!");
        }
    }
}
