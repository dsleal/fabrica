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
import br.com.senai.fatesg.fabrica.persistencia.ClienteDao;

@Named("ClienteControl")
@Scope("conversation")
public class ClienteControl {

	private Cliente cliente = new Cliente();
	
	@Autowired
	private ClienteDao clienteDao;
	
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
   @PostConstruct
   public void init(){
      listar(null);
      
     
   }
   
	public void confirmar(ActionEvent evt){
		try {
			clienteDao.alterar(cliente);
         listar(evt);
         cliente = new Cliente();
		} catch (Exception e) {
		   UtilFaces.addMensagemFaces(e);
		}
	}

	public void listar(ActionEvent evt){
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

