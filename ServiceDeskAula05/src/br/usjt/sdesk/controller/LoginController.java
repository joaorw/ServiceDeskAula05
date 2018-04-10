package br.usjt.sdesk.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.sdesk.model.entity.Usuario;
import br.usjt.sdesk.model.service.UsuarioService;


@Transactional
@Controller
public class LoginController extends IOException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final UsuarioService us;
	
	@Autowired
	public LoginController(UsuarioService us){
		this.us = us;
	}

	@RequestMapping("loginForm")
	public String loginForm(){
		return "login";
	}
	
	@RequestMapping("fazer_login")
	public String efetuaLogin(Usuario usuario, HttpSession session, Model model) throws IOException{

		if(us.validar(usuario)){
			session.setAttribute("usuarioLogado", usuario);
			return "redirect:listar_locais";
		}
		return "redirect:loginForm";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "login";
	}
}










