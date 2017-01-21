package br.com.academiafit.dao;

import java.util.List;


import br.com.academiafit.entidade.Professor;


public interface ProfessorDAO {

	public void incluir(Professor professor);
	public void alterar(Professor professor);
	public void excluir (String index);
	public Professor consultarPorCPF(String index);
	public List<Professor> listarTodos();

}