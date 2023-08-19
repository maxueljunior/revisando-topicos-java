package br.com.leuxam.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.leuxam.gerenciador.modelo.Banco;
import br.com.leuxam.gerenciador.modelo.Usuario;

public class Login implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramLogin = request.getParameter("login");
		String paramSenha = request.getParameter("senha");
		
		System.out.println(paramLogin + "\n" + paramSenha);
		
		Banco banco = new Banco();
		Usuario usuario = banco.existeUsuario(paramLogin, paramSenha);
		
		if(usuario != null) {
			System.out.println("Usuario existe");
			return "redirect:entrada?acao=ListaEmpresas";
		}else {
			return "redirect:entrada?acao=LoginForm";
		}
	}

}
