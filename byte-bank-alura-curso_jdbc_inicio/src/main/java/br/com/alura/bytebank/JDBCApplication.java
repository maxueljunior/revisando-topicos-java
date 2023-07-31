package br.com.alura.bytebank;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

import br.com.alura.bytebank.domain.conta.Conta;
import br.com.alura.bytebank.domain.conta.ContaService;

public class JDBCApplication {
	
	private static ContaService service = new ContaService();
	
	public static void main(String[] args) {
		
		Integer numeroDaConta = 1235;
		String nome = "Maxuel1";
		String cpf = "1234123";
		String email = "maxuel123@hotmail.com";
		Set<Conta> contas;
		Conta conta;
		
		try {
			/*service.abrir(new DadosAberturaConta(numeroDaConta, new DadosCadastroCliente(nome, cpf, email)));
			contas = service.listarContasAbertas();
			contas.forEach(x -> {
				System.out.println(x);
			});
			conta = service.buscarContaPorNumero(1235);
			System.out.println(conta);*/
			
			//service.realizarDeposito(1235, new BigDecimal("1000.00"));
			
			service.realizarSaque(1235, new BigDecimal("150.00"));
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		
		
		
	}

}
