package br.com.alura.bytebank;

import java.sql.SQLException;

import br.com.alura.bytebank.domain.cliente.DadosCadastroCliente;
import br.com.alura.bytebank.domain.conta.ContaService;
import br.com.alura.bytebank.domain.conta.DadosAberturaConta;

public class JDBCApplication {
	
	private static ContaService service = new ContaService();
	
	public static void main(String[] args) {
		
		Integer numeroDaConta = 1235;
		String nome = "Maxuel1";
		String cpf = "1234123";
		String email = "maxuel123@hotmail.com";
		try {
			service.abrir(new DadosAberturaConta(numeroDaConta, new DadosCadastroCliente(nome, cpf, email)));
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}

}
