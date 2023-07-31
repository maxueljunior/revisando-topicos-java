package br.com.alura.bytebank;

import java.sql.SQLException;
import java.util.Set;

import br.com.alura.bytebank.domain.cliente.DadosCadastroCliente;
import br.com.alura.bytebank.domain.conta.Conta;
import br.com.alura.bytebank.domain.conta.ContaService;
import br.com.alura.bytebank.domain.conta.DadosAberturaConta;

public class JDBCApplication {
	
	private static ContaService service = new ContaService();
	
	public static void main(String[] args) {
		
		Integer numeroDaConta = 144;
		String nome = "Maxuel1";
		String cpf = "1234123";
		String email = "maxuel123@hotmail.com";
		Set<Conta> contas;
		Conta conta;
		
		try {
			//service.abrir(new DadosAberturaConta(numeroDaConta, new DadosCadastroCliente(nome, cpf, email)));
			contas = service.listarContasAbertas();
			contas.forEach(x -> {
				System.out.println(x);
			});
			//conta = service.buscarContaPorNumero(1235);
			//System.out.println(conta);
			
			//service.realizarDeposito(1235, new BigDecimal("1000.00"));
			
			//service.realizarSaque(1235, new BigDecimal("150.00"));
			
			//service.realizarTransferencia(1234, 1235, new BigDecimal("188.88"));
			
			//service.realizarSaque(1234, new BigDecimal("811.00"));
			//service.encerrar(1234);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		
		
		
	}

}
