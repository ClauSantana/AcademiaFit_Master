package br.com.academiafit.service;
import java.util.List;

import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.vo.ExercicioVO;

public interface ExercicioService {	
	
	public void incluir(ExercicioVO exercicio) throws BusinessException;
	public void excluir(ExercicioVO exercicio) throws BusinessException;
	public void alterar (ExercicioVO exercicio) throws BusinessException;
	public List<ExercicioVO> listarTodos();
	
}
