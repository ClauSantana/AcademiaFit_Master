package br.com.academiafit.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exercicio")	
public class Exercicio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
		
	@Column(name="exercicio")
	private String exercicio;
	
	@Column(name="musculo")
	private String musculo;
	
	@OneToOne
	@JoinColumn(name="id_maquinario")
	private Maquinario maquinario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMusculo() {
		return musculo;
	}

	public void setMusculo(String musculo) {
		this.musculo = musculo;
	}

	public String getExercicio() {
		return exercicio;
	}

	public void setExercicio(String exercicio) {
		this.exercicio = exercicio;
	}

	public Maquinario getMaquinario() {
		return maquinario;
	}

	public void setMaquinario(Maquinario maquinario) {
		this.maquinario = maquinario;
	}
}
