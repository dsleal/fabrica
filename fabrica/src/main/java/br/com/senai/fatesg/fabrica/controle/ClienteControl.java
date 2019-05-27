package br.com.senai.fatesg.fabrica.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.senai.fatesg.fabrica.entidade.Cliente;
import br.com.senai.fatesg.fabrica.entidade.Contato;
import br.com.senai.fatesg.fabrica.entidade.TipoDeItemServico;
import br.com.senai.fatesg.fabrica.persistencia.ClienteDao;

@Named("ClienteControl")
@Scope("conversation")
public class ClienteControl {

	private Cliente cliente = new Cliente();

	@Autowired
	private ClienteDao clienteDao;
	
	private String nome;

	private List<Cliente> clientes = new ArrayList<Cliente>();

	@PostConstruct
	public void init() {
		listar(null);

	}

	public void confirmar(ActionEvent evt) {
		try {
			if (cliente.getId() == null) {
				clienteDao.incluir(cliente);
				novo();
			} else {
				clienteDao.alterar(cliente);
			}
			listar(evt);
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void novo() {
		try {
			cliente = new Cliente();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void editar(Cliente cliente) {
		try {
			this.cliente = cliente;
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void excluir(int id) {
		try {
			cliente = clienteDao.consultar(id);
			clienteDao.excluirPorId(cliente.getId());
			cliente = new Cliente();
			clientes = clienteDao.listar();

		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void listarPorNome() {
		try {
			clientes = clienteDao.listarPorNome(this.nome);
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void listar(ActionEvent evt) {
		try {
			clientes = clienteDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

}
