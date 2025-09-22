package model;
import java.util.List;

public class Bank {
	private String nome;
	private List<Account> contas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Account> getContas() {
		return contas;
	}

	public void setContas(List<Account> contas) {
		this.contas = contas;
	}
}
