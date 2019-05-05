package br.com.senai.fatesg.fabrica.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.senai.fatesg.fabrica.entidade.TipoDeItemServico;

@Repository("TipoDeItemServicoDao")
public class TipoDeItemServicoDaoJpa extends PersistenciaJpa<TipoDeItemServico> implements TipoDeItemServicoDao{
	
	private static final long serialVersionUID = 1L;

}
