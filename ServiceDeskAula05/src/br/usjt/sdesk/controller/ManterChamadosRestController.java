package br.usjt.sdesk.controller;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.sdesk.model.entity.Chamado;
import br.usjt.sdesk.model.service.ChamadoService;
import br.usjt.sdesk.model.service.FilaService;

@RestController
public class ManterChamadosRestController {
	private ChamadoService chamadoService;
	private FilaService filaService;
	
	
	@Autowired
	public ManterChamadosRestController(ChamadoService cs, FilaService fs) {
		chamadoService = cs;
		filaService = fs;		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="rest/chamados")	
	public @ResponseBody List<Chamado> listarChamados(){
				
		try {
			return chamadoService.listarChamados();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	@Transactional
	@RequestMapping(method=RequestMethod.POST, value="rest/chamado")
	public ResponseEntity<Chamado> inserirChamado(@RequestBody Chamado chamado) {
		
		try {
			int id = chamadoService.novoChamado(chamado);
			chamado.setNumero(id);
			return new ResponseEntity<Chamado>(chamado, HttpStatus.OK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Chamado>(chamado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		
	}
}
