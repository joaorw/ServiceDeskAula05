package br.usjt.sdesk.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.sdesk.model.dao.FilaDAO;
import br.usjt.sdesk.model.entity.Fila;
/**
 * 
 * @author Jo�o Victor Bonfim Rocha 816118224
 *
 */
@Service
public class FilaService {
	private FilaDAO dao;
	
	@Autowired
	public FilaService(FilaDAO dao) {
		this.dao = dao;
	}
	public List<Fila> listarFilas() throws IOException{
		return dao.listarFilas();
	}
	public Fila carregar(int id) throws IOException{
		return dao.carregar(id);
	}
	
	public int novaFila(Fila fila) throws IOException{
		return dao.inserirFila(fila);
	}
	public String excluirFila(Fila fila) throws IOException {
		return dao.excluirFila(fila);
	}
	
}

