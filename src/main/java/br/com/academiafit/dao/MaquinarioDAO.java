package br.com.academiafit.dao;

import java.util.List;


import br.com.academiafit.entidade.Maquinario;


public interface MaquinarioDAO {
		public void incluir(Maquinario maquinario);
		public void alterar(Maquinario maquinario);
		public void excluir (long index);
		public Maquinario consultarPorId(long index);
		public List<Maquinario> consultarTodos();
}