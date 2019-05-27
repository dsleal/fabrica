package br.com.senai.fatesg.fabrica.controle;

import java.awt.event.ActionEvent;
import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ambientinformatica.ambientjsf.controle.GerenciadorSessao;

@Controller("MenuControlador")
@Scope("session")
public class MenuControlador implements Serializable{
	
	private static final long serialVersionUID = 1L;

    public void gerenciarSessao(ActionEvent evento){
        GerenciadorSessao.limparSessoes();
    }

}
