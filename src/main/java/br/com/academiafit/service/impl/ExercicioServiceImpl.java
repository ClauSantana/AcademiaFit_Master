package br.com.academiafit.service.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiafit.dao.ExercicioDAO;
import br.com.academiafit.dao.impl.AbstractDAOImpl;
import br.com.academiafit.entidade.Exercicio;
import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.service.ExercicioService;
import br.com.academiafit.vo.ExercicioVO;
import br.com.academiafit.vo.converter.ConverterExercicio;

@Service
public class ExercicioServiceImpl extends AbstractDAOImpl implements ExercicioService{
	@Autowired(required=true)
	private ExercicioDAO dao;

	
	@Override
	@Transactional
	public void incluir(ExercicioVO exercicioVO) throws BusinessException {
		Exercicio status = dao.consultarPorId(exercicioVO.getId());
		if (status != null){
			throw new BusinessException("Exercício já existe!");
		}else{
			Exercicio exercicio = ConverterExercicio.ConverterExercicioVoParaExercicio(exercicioVO);
			dao.incluir(exercicio);
		}
	}
	
	
    @Override
    @Transactional
    public void excluir(ExercicioVO exercicioVO) throws BusinessException{
    	Exercicio status = dao.consultarPorId(exercicioVO.getId());
    	System.out.println(exercicioVO.getId() + " - " + status);

	if (status != null){
		Exercicio exercicio = ConverterExercicio.ConverterExercicioVoParaExercicio(exercicioVO);
		System.out.println(exercicio.getId());
		dao.excluir(exercicio.getId());

	}else{
		System.out.println("nada!");
		throw new BusinessException("Exercício não foi encontrado!");
	}
}

    @Override
	@Transactional
	public void alterar(ExercicioVO exercicioVO) throws BusinessException{
		Exercicio status = dao.consultarPorId(exercicioVO.getId());

		if (status != null){
			Exercicio exercicio = ConverterExercicio.ConverterExercicioVoParaExercicio(exercicioVO);
			dao.alterar(exercicio);

		}else{
			throw new BusinessException("Exercício não foi encontrado!");

		}

	}

	

	@Override
	public List<ExercicioVO> listarTodos() {
		return ConverterExercicio.ConverterExercicioListaParaListaVO(dao.consultarTodos());
	}	
	
}
