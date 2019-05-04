package br.com.senai.fatesg.fabrica.entidade;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class TipoDePrestador {

	@Id
	@GeneratedValue(generator = "tipodeprestor_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "tipodeprestor_seq", sequenceName = "tipodeprestor_seq", allocationSize = 1, initialValue = 1)

	private Integer id;
	private String descricao;
	private boolean status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}