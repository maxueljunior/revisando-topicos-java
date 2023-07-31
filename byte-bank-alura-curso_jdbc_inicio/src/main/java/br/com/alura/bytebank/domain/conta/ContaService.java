package br.com.alura.bytebank.domain.conta;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import br.com.alura.bytebank.ConnectionFactory;
import br.com.alura.bytebank.domain.RegraDeNegocioException;
import br.com.alura.bytebank.domain.cliente.Cliente;

public class ContaService {
	
	private ConnectionFactory connection;
	
	public ContaService() {
		this.connection = new ConnectionFactory();
	}

    private Set<Conta> contas = new HashSet<>();

    public Set<Conta> listarContasAbertas() throws SQLException {
        Connection conn = connection.recuperarConexao();
        return new ContaDAO(conn).listar();
    }

    public BigDecimal consultarSaldo(Integer numeroDaConta) throws SQLException {
        var conta = buscarContaPorNumero(numeroDaConta);
        return conta.getSaldo();
    }

    public void abrir(DadosAberturaConta dadosDaConta) throws SQLException {
        Connection conn = connection.recuperarConexao();
        new ContaDAO(conn).salvar(dadosDaConta);
    }

    public void realizarSaque(Integer numeroDaConta, BigDecimal valor) throws SQLException {
    	
        var conta = buscarContaPorNumero(numeroDaConta);
        
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RegraDeNegocioException("Valor do saque deve ser superior a zero!");
        }

        if (valor.compareTo(conta.getSaldo()) > 0) {
            throw new RegraDeNegocioException("Saldo insuficiente!");
        }
        
        BigDecimal novoValor = conta.getSaldo().subtract(valor);
        Connection conn = connection.recuperarConexao();
        new ContaDAO(conn).alterarValor(numeroDaConta, novoValor);
    }

    public void realizarDeposito(Integer numeroDaConta, BigDecimal valor) throws SQLException {
    	
        var conta = buscarContaPorNumero(numeroDaConta);
        
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RegraDeNegocioException("Valor do deposito deve ser superior a zero!");
        }
        
        BigDecimal valorNovo = conta.getSaldo().add(valor);
        Connection conn = connection.recuperarConexao();
        new ContaDAO(conn).alterarValor(conta.getNumero(), valorNovo);
    }
    
    public void realizarTransferencia(Integer numeroDaContaOrigem, Integer numeroDaContaDestino, BigDecimal valor) throws SQLException {
    	this.realizarSaque(numeroDaContaOrigem, valor);
    	this.realizarDeposito(numeroDaContaDestino, valor);
    }

    public void encerrar(Integer numeroDaConta) throws SQLException {
        var conta = buscarContaPorNumero(numeroDaConta);
        if (conta.possuiSaldo()) {
            throw new RegraDeNegocioException("Conta não pode ser encerrada pois ainda possui saldo!");
        }
        
       Connection conn = connection.recuperarConexao();
       new ContaDAO(conn).deletar(numeroDaConta);
    }

    public Conta buscarContaPorNumero(Integer numero) throws SQLException {
    	Connection conn = connection.recuperarConexao();
        return new ContaDAO(conn).listarPorNumeroDaConta(numero);
    }
}
