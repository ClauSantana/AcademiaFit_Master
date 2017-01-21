package br.com.academiafit.dao.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academiafit.dao.MaquinarioDAO;
import br.com.academiafit.entidade.Maquinario;
import br.com.academiafit.entidade.Usuario;

@Repository
public class MaquinarioDAOImpl extends AbstractDAOImpl implements MaquinarioDAO {

	@Override
	public void incluir (Maquinario maquinario){
		super.getEntityManager().persist(maquinario);
	}

	@Override
	public void alterar (Maquinario maquinario){
		this.getEntityManager().merge(maquinario);
	}

	@Override
	public void excluir(long index) {
		Maquinario mamaquinario = super.getEntityManager().find(Maquinario.class, index);
		super.getEntityManager().remove(mamaquinario);
	}

	@Override
	public List<Maquinario> consultarTodos() {
		Query query = super.getEntityManager().createQuery("select m from Maquinario m");
		List<Maquinario> listaMaquinario = query.getResultList();
		return listaMaquinario;
	}

	@Override
	public Maquinario consultarPorId(long index) {
		return this.getEntityManager().find(Maquinario.class, index);
	}
}
