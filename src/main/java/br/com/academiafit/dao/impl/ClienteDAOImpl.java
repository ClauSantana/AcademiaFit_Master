package br.com.academiafit.dao.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.academiafit.dao.ClienteDAO;
import br.com.academiafit.entidade.Cliente;
import br.com.academiafit.entidade.Usuario;

@Repository
public class ClienteDAOImpl extends AbstractDAOImpl implements ClienteDAO{

	@Override
	public void incluir(Cliente cliente) {
		this.getEntityManager().persist(cliente);
	}

	@Override
	public void alterar(Cliente cliente) {
		this.getEntityManager().merge(cliente);
	}

	@Override
	public List<Cliente> listarTodos() {
	
		Query query = super.getEntityManager().createQuery("select af from Cliente af");
		List<Cliente> listaCliente = query.getResultList();
		super.getEntityManager().close();
	
		return listaCliente;
	}

	@Override
	public void excluir(long index) {
		Cliente cliente = super.getEntityManager().find(Cliente.class,index);
		super.getEntityManager().remove(cliente);
	}

	@Override
	public Cliente consultarPorId(long index) {
		return this.getEntityManager().find(Cliente.class, index);
	}

}