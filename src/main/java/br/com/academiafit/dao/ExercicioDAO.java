package br.com.academiafit.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.academiafit.entidade.Exercicio;
import br.com.academiafit.vo.ExercicioVO;


public interface ExercicioDAO {
	public void incluir (Exercicio grupomuscular);
	public void alterar (Exercicio grupomuscular);
	public void excluir(long index);
	public List<Exercicio> consultarTodos();
	public Exercicio consultarPorId(long index);		

}