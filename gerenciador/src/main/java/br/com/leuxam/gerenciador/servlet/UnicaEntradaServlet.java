package br.com.leuxam.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.leuxam.gerenciador.acao.Acao;
import br.com.leuxam.gerenciador.acao.AlteraEmpresas;
import br.com.leuxam.gerenciador.acao.ListaEmpresas;
import br.com.leuxam.gerenciador.acao.MostraEmpresa;
import br.com.leuxam.gerenciador.acao.NovaEmpresas;
import br.com.leuxam.gerenciador.acao.NovaEmpresasForm;
import br.com.leuxam.gerenciador.acao.RemovaEmpresas;

//@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		
	}

}
