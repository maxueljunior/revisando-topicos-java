package br.com.leuxam.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet(urlPatterns = "/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("abrindo nova empresa...");
		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data");
		
		Empresa empresa = new Empresa(null, nomeEmpresa);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			empresa.setDataAbertura(sdf.parse(dataEmpresa));
		} catch (ParseException e) {
			throw new ServletException("Data está incorreta... " + e);
		}
		
		Banco banco = new Banco();
		
		banco.adiciona(empresa);
		
		request.setAttribute("empresa", empresa.getNome());
		
		response.sendRedirect("listaEmpresas");
		
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
	}
}
