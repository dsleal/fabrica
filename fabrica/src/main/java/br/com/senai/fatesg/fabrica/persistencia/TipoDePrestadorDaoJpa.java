package br.com.senai.fatesg.fabrica.persistencia;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.senai.fatesg.fabrica.entidade.TipoDePrestador;

@Repository("tipoDePrestadorDao")
public class TipoDePrestadorDaoJpa extends PersistenciaJpa<TipoDePrestador> implements TipoDePrestadorDao{

   private static final long serialVersionUID = 1L;


}
