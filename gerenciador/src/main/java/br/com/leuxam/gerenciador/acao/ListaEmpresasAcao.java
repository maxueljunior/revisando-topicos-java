package br.com.leuxam.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.leuxam.gerenciador.modelo.Banco;
import br.com.leuxam.gerenciador.modelo.Empresa;

public class ListaEmpresasAcao {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();
		request.setAttribute("empresas", empresas);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listarEmpresasCriadas.jsp");
		rd.forward(request, response);
	}
	
}
