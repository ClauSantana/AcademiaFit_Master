package br.com.academiafit.dao.impl;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academiafit.dao.ExercicioDAO;
import br.com.academiafit.entidade.Exercicio;
import br.com.academiafit.entidade.Usuario;

@Repository
public class ExercicioDAOImpl extends AbstractDAOImpl implements ExercicioDAO{

	@Override
	//inseri no banco de dados o comando incluir
	public void incluir (Exercicio exercicio){
		super.getEntityManager().persist(exercicio);
	}

	@Override
	public void alterar (Exercicio exercicio){
		super.getEntityManager().merge(exercicio);
	}

	@Override 
	//verificar se a informação solicitada pelo usuário existe no banco de dados
	public void excluir(long index) {
		Exercicio exercicios = super.getEntityManager().find(Exercicio.class, index);
		//se existir remove a informação desejada	
		super.getEntityManager().remove(exercicios);
	}

	@Override
	public List<Exercicio> consultarTodos() {
		//cria a query que vai inserir a consulta na tabela
		Query query = super.getEntityManager().createQuery("select e from Exercicio e");

		//armazena o resultado da busca na collection criada ResultList
		List<Exercicio> listaExercicios = query.getResultList();

		return listaExercicios;

	} 
	
	@Override
	public Exercicio consultarPorId(long index){
		return super.getEntityManager().find(Exercicio.class, index);
	}
}
