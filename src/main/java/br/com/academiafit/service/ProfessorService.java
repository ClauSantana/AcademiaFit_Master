package br.com.academiafit.service;
import java.util.List;


import br.com.academiafit.vo.ProfessorVO;

public interface ProfessorService {

	public void incluir(ProfessorVO professor);
	public void excluir(String index);
	public void alterar (ProfessorVO professor);
	public ProfessorVO consultarID (String index);
	public List<ProfessorVO> listarTodos();

}
