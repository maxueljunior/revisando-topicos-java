package br.com.leuxam.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.leuxam.gerenciador.acao.AlteraEmpresasAcao;
import br.com.leuxam.gerenciador.acao.ListaEmpresasAcao;
import br.com.leuxam.gerenciador.acao.MostraEmpresaAcao;
import br.com.leuxam.gerenciador.acao.NovaEmpresasAcao;
import br.com.leuxam.gerenciador.acao.RemovaEmpresasAcao;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");

		if (paramAcao.equals("ListaEmpresas")) {
			System.out.println("listando empresas..");
			
			ListaEmpresasAcao acao = new ListaEmpresasAcao();
			acao.executa(request, response);
			
		} else if (paramAcao.equals("RemovaEmpresa")) {
			System.out.println("removendo empresas..");
			
			RemovaEmpresasAcao acao = new RemovaEmpresasAcao();
			acao.executa(request, response);
			
		} else if (paramAcao.equals("MostraEmpresa")) {
			System.out.println("mostrando empresas..");
			
			MostraEmpresaAcao acao = new MostraEmpresaAcao();
			acao.executa(request, response);
		} else if (paramAcao.equals("AlteraEmpresa")) {
			System.out.println("alterando empresas..");
			
			AlteraEmpresasAcao acao = new AlteraEmpresasAcao();
			acao.executa(request, response);
		} else if (paramAcao.equals("NovaEmpresa")) {
			System.out.println("alterando empresas..");
			
			NovaEmpresasAcao acao = new NovaEmpresasAcao();
			acao.executa(request, response);
		}
	}

}
