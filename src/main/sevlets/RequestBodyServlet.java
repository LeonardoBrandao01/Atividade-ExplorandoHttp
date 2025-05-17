package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jdk.internal.icu.text.UTF16;

import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.jdt.internal.compiler.ast.InstanceOfExpression;

public class RequestBodyServlet extends HttpServlet {
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws  IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h2>Corpo da Requisição</h2>");
        out.println("Nome: " + request.getParameter("nome") + "<br>");
        out.println("Email: " + request.getParameter("email") + "<br>");
        out.println("Mensagem: " + request.getParameter("mensagem") + "<br>");
		

		
	
	}

	
	
}