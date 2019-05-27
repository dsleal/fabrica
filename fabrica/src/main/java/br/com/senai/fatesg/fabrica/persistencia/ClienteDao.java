package br.com.senai.fatesg.fabrica.persistencia;

import java.util.List;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.Persistencia;
import br.com.senai.fatesg.fabrica.entidade.Cliente;

public interface ClienteDao extends Persistencia<Cliente>{

	List<Cliente> listarPorNome(String nome) throws PersistenciaException;
}
