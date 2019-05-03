package br.com.senai.fatesg.fabrica.entidade;

import java.sql.Date;

public interface IPessoa {

	String getNome();

	void setNome(String nome);

	Date getDataDeNascimento();

	void setDataDeNascimento(Date dataDeNascimento);

	String getIdentidade();

	void setIdentidade(String identidade);

	String getCpf_cnpj();

	void setCpf_cnpj(String cpf_cnpj);

	String getEmail();

	void setEmail(String email);

	String getTelefone();

	void setTelefone(String telefone);

	int getId();

	void setId(int id);

	String toString();

}