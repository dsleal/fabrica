package br.com.senai.fatesg.fabrica.persistencia;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.senai.fatesg.fabrica.entidade.Prestador;

@Repository("prestadorDao")
public class PrestadorDaoJpa extends PersistenciaJpa<Prestador> implements PrestadorDao{

   private static final long serialVersionUID = 1L;


}
