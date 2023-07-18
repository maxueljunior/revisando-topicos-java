package escola;

public class Telefone {
	private String ddd;
	private String numero;

	public Telefone(String ddd, String numero) {

		if (ddd == null || !ddd.matches("[0-9]{2}"))
			throw new IllegalArgumentException("O ddd " + ddd + " está incorreto");

		if (numero == null || !numero.matches("[0-9]{9}"))
			throw new IllegalArgumentException("O numero " + numero + " está incorreto");

		this.ddd = ddd;
		this.numero = numero;
	}

	public String getDdd() {
		return ddd;
	}

	public String getNumero() {
		return numero;
	}
}
