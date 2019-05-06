package br.com.senai.fatesg.fabrica.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.senai.fatesg.fabrica.entidade.Contato;
import br.com.senai.fatesg.fabrica.entidade.Prestador;
import br.com.senai.fatesg.fabrica.persistencia.ContatoDao;

@Named("ContatoControl")
@Scope("conversation")
public class ContatoControl {

	private Contato contato = new Contato();
	
	@Autowired
	private ContatoDao contatoDao;
	
	private List<Contato> contatos = new ArrayList<Contato>();
	
	

   @PostConstruct
   public void init(){
      listar(null);
      
     
   }
   
	public void confirmar(ActionEvent evt){
		try { 
			if(contato.getId() == null) {
				contatoDao.incluir(contato);
				novo();
			} else {
				contatoDao.alterar(contato);
			}		
			
         listar(evt);
         
		} catch (Exception e) {
		   UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void novo() {
		try {
			contato = new Contato();						
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void editar(Contato contato) {
		try {
			this.contato = contato;						
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void listar(ActionEvent evt){
		try {
			contatos = contatoDao.listar();
		} catch (Exception e) {
		   UtilFaces.addMensagemFaces(e);
		}
	}
	
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	public List<Contato> getContatos() {
		return contatos;
	}

}
