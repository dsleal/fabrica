package br.com.senai.fatesg.fabrica.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.senai.fatesg.fabrica.entidade.Prestador;
import br.com.senai.fatesg.fabrica.entidade.TipoDeItemServico;
import br.com.senai.fatesg.fabrica.entidade.TipoDePrestador;
import br.com.senai.fatesg.fabrica.persistencia.TipoDePrestadorDao;

@Named("TipoDePrestadorControl")
@Scope("conversation")
public class TipoDePrestadorControl {

	private TipoDePrestador tipoDeprestador = new TipoDePrestador();

	@Autowired
	private TipoDePrestadorDao tipoDePrestadorDao;

	private List<TipoDePrestador> tipoDeprestadores = new ArrayList<TipoDePrestador>();

	@PostConstruct
	public void init() {
		listar(null);

	}

	public void confirmar(ActionEvent evt) {
		try {
			if (tipoDeprestador.getId()==null) {
				tipoDePrestadorDao.incluir(tipoDeprestador);
				novo();
			} else {
				tipoDePrestadorDao.alterar(tipoDeprestador);
			}
				
			listar(evt);
			
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void novo() {
		try {
			tipoDeprestador = new TipoDePrestador();						
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void editar(TipoDePrestador tipoDeprestador) {
		try {
			this.tipoDeprestador = tipoDeprestador;						
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void excluir(int id) {
		try {
			tipoDeprestador = tipoDePrestadorDao.consultar(id);
			tipoDePrestadorDao.excluirPorId(tipoDeprestador.getId());	
			tipoDeprestador = new TipoDePrestador();
			tipoDeprestadores = tipoDePrestadorDao.listar();
			
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void listar(ActionEvent evt) {
		try {
			tipoDeprestadores = tipoDePrestadorDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public TipoDePrestador getTipoDePrestador() {
		return tipoDeprestador;
	}

	public void setPrestador(TipoDePrestador tipoDeprestador) {
		this.tipoDeprestador = tipoDeprestador;
	}

	public List<TipoDePrestador> getTipoDePrestadores() {
		return tipoDeprestadores;
	}

}
