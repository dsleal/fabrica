package br.com.senai.fatesg.fabrica.entidade;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Prestador extends Cliente implements IPessoa{
	
	private char tipo; 	
	private String codigo_banco;
	private String agencia;
	private String conta;
	
	public Prestador(String nome, Date dataDeNascimento, String identidade, String cpf_cnpj, String email,
			String telefone, char tipo, String codigo_banco, String agencia, String conta) {
		super(nome, dataDeNascimento, identidade, cpf_cnpj, email, telefone);
		this.tipo = tipo;
		this.codigo_banco = codigo_banco;
		this.agencia = agencia;
		this.conta = conta;
	}	
	
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public String getCodigo_banco() {
		return codigo_banco;
	}
	public void setCodigo_banco(String codigo_banco) {
		this.codigo_banco = codigo_banco;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}

	@Override
	public String toString() {
		return "Prestador [Nome:" + getNome() + ", Data De Nascimento:" + getDataDeNascimento()
				+ ", Identidade:" + getIdentidade() + ", Cpf_cnpj:" + getCpf_cnpj() + ", Email:"
				+ getEmail() + ", Telefone:" + getTelefone() + ", Id;" + getId() + "]";
	}

	
	
	
	
}
