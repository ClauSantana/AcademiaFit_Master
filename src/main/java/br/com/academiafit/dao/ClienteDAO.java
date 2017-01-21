package br.com.academiafit.dao;

import java.util.List;
import br.com.academiafit.entidade.Cliente;

public interface ClienteDAO {
	public void incluir(Cliente cliente);
	public void alterar(Cliente cliente);
	public Cliente consultarPorId(long index);
	public List<Cliente> listarTodos();
	public void excluir(long index);
}