package br.com.leuxam.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.leuxam.gerenciador.modelo.Banco;
import br.com.leuxam.gerenciador.modelo.Empresa;

public class MostraEmpresaAcao {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
