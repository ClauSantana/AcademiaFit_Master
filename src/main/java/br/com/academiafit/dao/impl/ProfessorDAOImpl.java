package br.com.academiafit.dao.impl;

import java.util.List;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academiafit.dao.ProfessorDAO;
import br.com.academiafit.entidade.Professor;

@Repository
public class ProfessorDAOImpl extends AbstractDAOImpl implements ProfessorDAO{

	@Override
	public void incluir(Professor professor) {
		this.getEntityManager().persist(professor);		
	}

	@Override
	public void alterar(Professor professor) {
		this.getEntityManager().merge(professor);
	}

	@Override
	public void excluir(String index) {
		Professor professor = super.getEntityManager().find(Professor.class,index);
		super.getEntityManager().remove(professor);
	}

	@Override
	public List<Professor> listarTodos() {
		Query query = super.getEntityManager().createQuery("select p from Professor p");
		List<Professor> listaProfessor = query.getResultList();
		super.getEntityManager().close();
		return listaProfessor;
	}

	@Override
	public Professor consultarPorCPF(String index) {
		return super.getEntityManager().find(Professor.class, index);
	}
}
