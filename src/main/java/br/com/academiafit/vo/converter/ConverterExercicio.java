package br.com.academiafit.vo.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.academiafit.entidade.Exercicio;
import br.com.academiafit.vo.ExercicioVO;

public class ConverterExercicio {

	public static Exercicio ConverterExercicioVoParaExercicio(ExercicioVO exercicioVO) {
		Exercicio exercicio = new Exercicio();
		exercicio.setId(exercicioVO.getId());
		exercicio.setMusculo(exercicioVO.getMusculo());
		exercicio.setExercicio(exercicio.getExercicio());
			
		return exercicio;
	}
	
	public static ExercicioVO ConverterExercicioParaExercicioVO(Exercicio exercicio) {
		ExercicioVO exercicioVO = new ExercicioVO();
		exercicioVO.setExercicio(exercicio.getExercicio());
		exercicioVO.setMusculo(exercicio.getMusculo());
		exercicioVO.setExercicio(exercicio.getExercicio());
		
		return exercicioVO; 		
	}

	
	public static List<ExercicioVO> ConverterExercicioListaParaListaVO (List<Exercicio> listaEntidade){
		List<ExercicioVO> listGrupoMuscularVO = new ArrayList <ExercicioVO>();
		if (listaEntidade != null &&  !listaEntidade.isEmpty()){
			for (Exercicio exercicio : listaEntidade){
				ExercicioVO  exercicioVO  = ConverterExercicioParaExercicioVO(exercicio);
				listGrupoMuscularVO.add(exercicioVO);
			}
			
		}
		
		return listGrupoMuscularVO;
		
	}
	
	
}
