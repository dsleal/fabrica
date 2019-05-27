package br.com.senai.fatesg.fabrica.entidade;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Cliente {

   @Id
   @GeneratedValue(generator="cliente_seq", strategy=GenerationType.SEQUENCE)
   @SequenceGenerator(name="cliente_seq", sequenceName="cliente_seq", allocationSize=1, initialValue=1)
   
   private Integer id;
   private String nome;
   private Date dataDeNascimento;
   private String identidade;
   private String cpf;
   private String cnpj;
   private String email;
   private String endereco;
   private String telefone;

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
   

}