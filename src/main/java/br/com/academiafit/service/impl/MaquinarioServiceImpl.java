package br.com.academiafit.service.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiafit.dao.MaquinarioDAO;
import br.com.academiafit.dao.impl.AbstractDAOImpl;
import br.com.academiafit.entidade.Maquinario;
import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.service.MaquinarioService;
import br.com.academiafit.vo.MaquinarioVO;
import br.com.academiafit.vo.converter.ConverterMaquinario;

@Service
public class MaquinarioServiceImpl extends AbstractDAOImpl implements MaquinarioService{
	@Autowired(required=true)
	private MaquinarioDAO dao;
	
	@Override
	@Transactional
	public void incluir(MaquinarioVO maquinario) {
		Maquinario maquina = ConverterMaquinario.ConverterMaquinarioVoParaMaquinario(maquinario);
		dao.incluir (maquina);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Maquinário incluído com sucesso."));
		
	}

	@Override
	@Transactional
	public void excluir(MaquinarioVO maquinario) throws BusinessException {
		
		dao.excluir(maquinario.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Maquinário excluído com sucesso."));
	}

	@Override
	@Transactional
	public void alterar(MaquinarioVO maquinario) {
		Maquinario maquina = ConverterMaquinario.ConverterMaquinarioVoParaMaquinario(maquinario);
		dao.alterar(maquina);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Maquinário alterado com sucesso."));
		
	}

	@Override
	@Transactional
	public List<MaquinarioVO> listarTodos() {
		return ConverterMaquinario.ConverterMaquinaListaParaListaVO(dao.consultarTodos());
	}
	
	@Override
	@Transactional
	public MaquinarioVO consultarMaquinarioPorId(long id) {
		Maquinario maquinario = dao.consultarPorId(id);
		return ConverterMaquinario.ConverterMaquinarioParaMaquinarioVO(maquinario);
	}

}
