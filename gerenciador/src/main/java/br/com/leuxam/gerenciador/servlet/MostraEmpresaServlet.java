package br.com.leuxam.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Long id = Long.valueOf(paramId);
		
		Banco banco = new Banco();
		
		Empresa emp = banco.buscarEmpresa(id);
		
		System.out.println(emp.getNome());
		request.setAttribute("empresa", emp);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		rd.forward(request, response);
	}

}
