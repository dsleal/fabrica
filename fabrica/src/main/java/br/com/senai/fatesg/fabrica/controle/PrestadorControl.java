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
import br.com.senai.fatesg.fabrica.entidade.Prestador;
import br.com.senai.fatesg.fabrica.persistencia.PrestadorDao;

@Named("PrestadorControl")
@Scope("conversation")
public class PrestadorControl {

	private Prestador prestador = new Prestador();

	@Autowired
	private PrestadorDao prestadorDao;

	private List<Prestador> prestadores = new ArrayList<Prestador>();

	@PostConstruct
	public void init() {
		listar(null);

	}

	public void confirmar(ActionEvent evt) {
		try {
			if( prestador.getId() == null) {
				prestadorDao.incluir(prestador);
				novo();
			}
			else {				
				prestadorDao.alterar(prestador);
			}
			listar(evt);			
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	public void novo() {
		try {
			prestador = new Prestador();						
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void editar(Prestador prestador) {
		try {
			this.prestador = prestador;						
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	public void excluir(int id) {
		try {
			prestador = prestadorDao.consultar(id);
			prestadorDao.excluirPorId(prestador.getId());	
			prestador = new Prestador();
			prestadores = prestadorDao.listar();
			
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}


	public void listar(ActionEvent evt) {
		try {
			prestadores = prestadorDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public Prestador getPrestador() {
		return prestador;
	}

	public void setPrestador(Prestador prestador) {
		this.prestador = prestador;
	}

	public List<Prestador> getPrestadores() {
		return prestadores;
	}

}
