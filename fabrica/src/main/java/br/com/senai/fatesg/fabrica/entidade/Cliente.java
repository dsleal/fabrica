package br.com.senai.fatesg.fabrica.entidade;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Cliente implements IPessoa {
	@Id
	@GeneratedValue(generator="cliente_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="cliente_seq", sequenceName="cliente_seq", allocationSize=1, initialValue=1)
	private int id;
	private String nome;
	private Date dataDeNascimento;
	private String identidade;
	private String cpf_cnpj;
	private String email;
	private String telefone;	
	
	public Cliente(String nome, Date dataDeNascimento, String identidade, String cpf_cnpj, String email,
			String telefone) {
		super();		
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.identidade = identidade;
		this.cpf_cnpj = cpf_cnpj;
		this.email = email;
		this.telefone = telefone;
	}
	
	@Override
	public String getNome() {
		return nome;
	}
	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	@Override
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	@Override
	public String getIdentidade() {
		return identidade;
	}
	@Override
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
	@Override
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}
	@Override
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	@Override
	public String getEmail() {
		return email;
	}
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String getTelefone() {
		return telefone;
	}
	@Override
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Override
	public int getId() {
		return id;
	}
	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", dataDeNascimento=" + dataDeNascimento + ", identidade="
				+ identidade + ", cpf_cnpj=" + cpf_cnpj + ", email=" + email + ", telefone=" + telefone + "]";
	}
	
	
	
	

}
