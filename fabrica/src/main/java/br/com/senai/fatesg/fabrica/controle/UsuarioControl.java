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
import br.com.senai.fatesg.fabrica.entidade.Usuario;
import br.com.senai.fatesg.fabrica.persistencia.TipoDeItemServicoDao;
import br.com.senai.fatesg.fabrica.persistencia.TipoDePrestadorDao;
import br.com.senai.fatesg.fabrica.persistencia.UsuarioDao;

@Named("UsuarioControl")
@Scope("conversation")
public class UsuarioControl {

	private Usuario usuario = new Usuario();

	@Autowired
	private UsuarioDao usuarioDao;

	private List<Usuario> usuarios = new ArrayList<Usuario>();

	@PostConstruct
	public void init() {
		listar(null);

	}

	public void confirmar(ActionEvent evt) {
		try {
			if (usuario.getId()==null) {
				usuarioDao.incluir(usuario);
				novo();
			} else {
				usuarioDao.alterar(usuario);
			}		
			
			listar(evt);
			
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void novo() {
		try {
			usuario = new Usuario();						
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void editar(Usuario usuario) {
		try {
			this.usuario = usuario;						
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}
	
	public void excluir(int id) {
		try {
			usuario = usuarioDao.consultar(id);
			usuarioDao.excluirPorId(usuario.getId());	
			usuario = new Usuario();
			usuarios = usuarioDao.listar();
			
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void listar(ActionEvent evt) {
		try {
			usuarios = usuarioDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public Usuario getTipodeitemservico() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	

}
