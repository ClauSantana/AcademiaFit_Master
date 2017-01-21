package br.com.academiafit.service.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.academiafit.dao.ClienteDAO;
import br.com.academiafit.service.ClienteService;
import br.com.academiafit.vo.ClienteVO;
import br.com.academiafit.vo.converter.ConverterCliente;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired(required = true)
	private ClienteDAO dao;
	
	@Override
	@Transactional
	public void incluir(ClienteVO cliente) {
		dao.incluir(ConverterCliente.ConverterClienteVoParaCliente(cliente));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente cadastrado com sucesso."));	
	}
	
	@Override
	@Transactional
	public void excluir(ClienteVO cliente) {
		dao.excluir(cliente.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente excluido com sucesso"));
	}

	@Override
	@Transactional
	public void alterar(ClienteVO cliente) {
		dao.alterar(ConverterCliente.ConverterClienteVoParaCliente(cliente));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alteração salva com sucesso"));
	}
	
	@Override
	@Transactional
	public List<ClienteVO> listarTodos() {
		return ConverterCliente.ConverterClienteParaListaVo(dao.listarTodos());
	}
}