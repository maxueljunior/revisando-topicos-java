package escola;

public class Email {
	
	//Value Object
	
	private String endereco;

	public Email(String endereco) {
		if (endereco == null || !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))
			throw new IllegalArgumentException("O email " + endereco + " invalido!");
		
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}
}
