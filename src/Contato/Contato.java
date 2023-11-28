package Contato;

import java.util.Objects;

public class Contato {
    private String nome;
    private String telefone;
    private String nascimento;
    private String email;
    private String celular;
    
	public Contato(String nome, String telefone, String nascimento, String email, String celular) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.email = email;
		this.celular = celular;
	}

	public String getNome() {
		return nome;
	}public void setNome(String nome) {
		this.nome = nome;
	}public String getTelefone() {
		return telefone;
	}public void setTelefone(String telefone) {
		this.telefone = telefone;
	}public String getNascimento() {
		return nascimento;
	}public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}public String getEmail() {
		return email;
	}public void setEmail(String email) {
		this.email = email;
	}public String getCelular() {
		return celular;
	}public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "Contato [nome=" + nome + ", telefone=" + telefone + ", nascimento=" 
				+ nascimento + ", email=" + email + ", celular=" + celular + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(celular, email, nascimento, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(celular, other.celular) && Objects.equals(email, other.email)
				&& Objects.equals(nascimento, other.nascimento) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}
	
	
	
	
	
	

    

}
