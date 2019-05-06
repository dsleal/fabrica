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
import br.com.senai.fatesg.fabrica.persistencia.TipoDeItemServicoDao;
import br.com.senai.fatesg.fabrica.persistencia.TipoDePrestadorDao;

@Named("TipoDeItemServicoControl")
@Scope("conversation")
public class TipoDeItemServicoControl  {

	private TipoDeItemServico tipodeitemservico = new TipoDeItemServico();

	@Autowired
	private TipoDeItemServicoDao tipoDeItemServicoDao;

	private List<TipoDeItemServico> tipoDeItensServicos = new ArrayList<TipoDeItemServico>();

	@PostConstruct
	public void init() {
		listar(null);

	}

	public void confirmar(ActionEvent evt) {
		try {
			if (tipodeitemservico.getId()==null) {
				tipoDeItemServicoDao.incluir(tipodeitemservico);
				novo();
			} else {
				tipoDeItemServicoDao.alterar(tipodeitemservico);
			}		
			
			listar(evt);
			
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void novo() {
		try {
			tipodeitemservico = new TipoDeItemServico();						
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void editar(TipoDeItemServico tipodeitemservico) {
		try {
			this.tipodeitemservico = tipodeitemservico;						
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void excluir(int id) {
		try {
			tipodeitemservico = tipoDeItemServicoDao.consultar(id);
			tipoDeItemServicoDao.excluirPorId(tipodeitemservico.getId());	
			tipodeitemservico = new TipoDeItemServico();
			tipoDeItensServicos = tipoDeItemServicoDao.listar();
			
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void listar(ActionEvent evt) {
		try {
			tipoDeItensServicos = tipoDeItemServicoDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public TipoDeItemServico getTipodeitemservico() {
		return tipodeitemservico;
	}

	public void setTipodeitemservico(TipoDeItemServico tipodeitemservico) {
		this.tipodeitemservico = tipodeitemservico;
	}

	public TipoDeItemServicoDao getTipoDeItemServicoDao() {
		return tipoDeItemServicoDao;
	}

	public void setTipoDeItemServicoDao(TipoDeItemServicoDao tipoDeItemServicoDao) {
		this.tipoDeItemServicoDao = tipoDeItemServicoDao;
	}

	public List<TipoDeItemServico> getTipoDeItensServicos() {
		return tipoDeItensServicos;
	}

	public void setTipoDeItensServicos(List<TipoDeItemServico> tipoDeItensServicos) {
		this.tipoDeItensServicos = tipoDeItensServicos;
	}

	

}
