package br.com.alura.rh;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;

public class Principal {

	public static void main(String[] args) {
		Funcionario f1 = new Funcionario("Maxuel", "468.569.498-80", Cargo.ANALISTA, new BigDecimal(15000.00));
		
		f1.setDataUltimoReajuste(LocalDate.now());
		System.out.println("Salario do funcionario é " + f1.getDadosPessoais().getSalario());
		
		f1.reajustarSalario(new BigDecimal(155555.00));
		
		System.out.println("Salário com o aumento é " + f1.getDadosPessoais().getSalario());
	}

}
