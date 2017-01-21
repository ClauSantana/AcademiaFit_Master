package br.com.academiafit.service.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.academiafit.dao.ProfessorDAO;
import br.com.academiafit.dao.impl.AbstractDAOImpl;
import br.com.academiafit.entidade.Professor;
import br.com.academiafit.service.ProfessorService;
import br.com.academiafit.vo.ProfessorVO;
import br.com.academiafit.vo.converter.ConverterProfessor;



@Service
public class ProfessorServiceImpl extends AbstractDAOImpl implements ProfessorService{

	@Autowired(required=true)
	private ProfessorDAO dao;
	
	@Override
	@Transactional
	public void incluir(ProfessorVO professor) {
		dao.incluir(ConverterProfessor.ConverterProfessorVoParaProfessor(professor));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Professor salvo com sucesso"));	
	}

	@Override
	@Transactional
	public void excluir(String index) {
		dao.excluir(index);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Professor excluido com sucesso!"));
	}

	@Override
	@Transactional
	public void alterar(ProfessorVO professor) {
		dao.alterar(ConverterProfessor.ConverterProfessorVoParaProfessor(professor));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Alteração salva com sucesso!"));	
	}

	@Override
	public List<ProfessorVO> listarTodos() {
		return ConverterProfessor.ConverterProfessorListaParaVo(dao.listarTodos());
	}

	@Override
	public ProfessorVO consultarID(String index) {
		Professor professor = dao.consultarPorCPF(index);
		ProfessorVO professorVO = ConverterProfessor.ConverterProfessorParaVO(professor);
		return professorVO;
	}
	
	
}
