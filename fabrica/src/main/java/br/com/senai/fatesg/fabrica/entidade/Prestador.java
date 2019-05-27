package br.com.senai.fatesg.fabrica.entidade;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Prestador {

	@Id
	@GeneratedValue(generator = "prestador_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "prestador_seq", sequenceName = "prestador_seq", allocationSize = 1, initialValue = 1)
	private Integer id;
	private String nome;
	private Date dataDeNascimento;
	private String identidade;
	private String cpf;
	private String cnpj;
	private String telefone;
	private String email;
	private String endereco;
	private String codigo_banco;
	private String agencia;
	private String conta;	
	@ManyToOne
	private TipoDePrestador tipoDePrestador;

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public TipoDePrestador getTipoDePrestador() {
		return tipoDePrestador;
	}

	public void setTipoDePrestador(TipoDePrestador tipoDePrestador) {
		this.tipoDePrestador = tipoDePrestador;
	}

}