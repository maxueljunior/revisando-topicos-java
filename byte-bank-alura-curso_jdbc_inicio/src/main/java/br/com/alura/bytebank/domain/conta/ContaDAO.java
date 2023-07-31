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
        ps.close();
        conn.close();
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
		
		resultSet.close();
		ps.close();
		conn.close();
		
		return contas;
	}
	
	public Conta listarPorNumeroDaConta(Integer numero) throws SQLException {
		
		Conta conta;
		
		//String sql = "SELECT * FROM conta WHERE numero = " + numero;
		
		String sql = "SELECT * FROM conta WHERE numero = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, numero);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next() == false) throw new IllegalArgumentException("Não existe cliente por esse numero " + numero);
		
		BigDecimal saldo = rs.getBigDecimal(2);
		String nome = rs.getString(3);
		String cpf = rs.getString(4);
		String email = rs.getString(5);
		
		rs.close();
		ps.close();
		conn.close();
		
		DadosCadastroCliente dadosCadastroCliente = new DadosCadastroCliente(nome, cpf, email);
		Cliente cliente = new Cliente(dadosCadastroCliente);
		conta = new Conta(numero, cliente);
		conta.depositar(saldo);
		return conta;
	}
	
	public void alterarValor(Integer numero, BigDecimal valor) throws SQLException {
		String sql = "UPDATE conta SET saldo = ? WHERE numero = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setBigDecimal(1, valor);
		ps.setInt(2, numero);
		
		ps.execute();
		ps.close();
		conn.close();
	}
}
