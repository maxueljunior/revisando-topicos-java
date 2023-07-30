package br.com.alura.bytebank.domain.conta;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import br.com.alura.bytebank.domain.cliente.Cliente;
import br.com.alura.bytebank.domain.cliente.DadosCadastroCliente;

public class ContaDAO {
	
	private Connection conn;
	
	public ContaDAO(Connection connection) {
		this.conn = connection;
	}
	
	public void salvar(DadosAberturaConta dadosDaConta) throws SQLException {
		
		var cliente = new Cliente(dadosDaConta.dadosCliente());
        var conta = new Conta(dadosDaConta.numero(), cliente);
		String sql = "INSERT INTO conta (numero, saldo, cliente_nome, cliente_cpf, cliente_email)"
        		+ "VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, conta.getNumero());
        ps.setBigDecimal(2, BigDecimal.ZERO);
        ps.setString(3, dadosDaConta.dadosCliente().nome());
        ps.setString(4, dadosDaConta.dadosCliente().cpf());
        ps.setString(5, dadosDaConta.dadosCliente().email());
        ps.execute();
	}
	
	public Set<Conta> listar() throws SQLException{
		Set<Conta> contas = new HashSet<>();
		
		String sql = "SELECT * FROM conta";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet resultSet = ps.executeQuery();
		
		while(resultSet.next()) {
			Integer numero = resultSet.getInt(1);
			BigDecimal saldo = resultSet.getBigDecimal(2);
			String nome = resultSet.getString(3);
			String cpf = resultSet.getString(4);
			String email = resultSet.getString(5);
			DadosCadastroCliente dadosCadastroCliente = new DadosCadastroCliente(nome, cpf, email);
			Cliente cliente = new Cliente(dadosCadastroCliente);
			contas.add(new Conta(numero, cliente));
		}
		
		return contas;
	}
	
}
