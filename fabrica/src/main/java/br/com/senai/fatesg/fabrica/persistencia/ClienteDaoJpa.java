package br.com.senai.fatesg.fabrica.persistencia;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.ambientinformatica.util.UtilLog;
import br.com.senai.fatesg.fabrica.entidade.Cliente;

@Repository("clienteDao")
public class ClienteDaoJpa extends PersistenciaJpa<Cliente> implements ClienteDao {

	private static final long serialVersionUID = 1L;

	@Override
	public List<Cliente> listarPorNome(String nome) throws PersistenciaException {
		try {
			String sql = "select distinct i from Clientes i where 1=1 ";

			if (nome != null && !nome.isEmpty()) {
				sql += " and upper(i.nome) like upper(:nome)";
			}

			TypedQuery<Cliente> query = em.createQuery(sql, Cliente.class);

			if (nome != null && !nome.isEmpty()) {
				query.setParameter("nome", "%" + nome + "%");
			}

			return query.getResultList();

		} catch (Exception e) {
			UtilLog.getLog().error(e.getMessage(), e);
			throw new PersistenciaException("Erro ao listar instituições", e);
		}

	}
}
