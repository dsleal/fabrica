package br.com.senai.fatesg.fabrica.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class TipoDeItemServico {
	
	@Id
	@GeneratedValue(generator = "tipodeitemservico_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "tipodeitemservico_seq", sequenceName = "tipodeitemservico_seq", allocationSize = 1, initialValue = 1)

	private Integer id;
	private String descricao;
	private boolean desativado;
	
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
	public boolean isDesativado() {
		return desativado;
	}
	public void setDesativado(boolean desativado) {
		this.desativado = desativado;
	}
	
	

}
