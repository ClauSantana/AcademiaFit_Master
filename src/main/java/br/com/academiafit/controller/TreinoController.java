package br.com.academiafit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.service.ExercicioService;
import br.com.academiafit.service.TreinoService;
import br.com.academiafit.vo.ExercicioVO;
import br.com.academiafit.vo.TreinoVO;

@ManagedBean(name = "treinoMbean")
@SessionScoped
public class TreinoController extends AbstractController {
	
	public static String TELA_LISTA_TODOS = "/treino/listarTodos.xhtml";
	public static String TELA_CADASTRAR = "/treino/cadastrar_treino.xhtml";

	@Autowired
	private TreinoService treinoService;
	private List<TreinoVO> listaTreinoVO;
	private TreinoVO treino = new TreinoVO();

	@Autowired
	private ExercicioService exercicioService;
	private List<ExercicioVO> listaExercicioVO;
	private ExercicioVO exercicio = new ExercicioVO();
	
	public static String getTELA_LISTA_TODOS() {
		return TELA_LISTA_TODOS;
	}

	public static void setTELA_LISTA_TODOS(String TELA_LISTA_TODOS) {
		TELA_LISTA_TODOS = TELA_LISTA_TODOS;
	}

	public static String getTELA_CADASTRAR() {
		return TELA_CADASTRAR;
	}

	public static void setTELA_CADASTRAR(String TELA_CADASTRAR) {
		TELA_CADASTRAR = TELA_CADASTRAR;
	}

	public TreinoService getTreinoService() {
		return treinoService;
	}

	public void setTreinoService(TreinoService treinoService) {
		this.treinoService = treinoService;
	}

	public List<TreinoVO> getListaTreinoVO() {
		return listaTreinoVO;
	}

	public void setListaTreinoVO(List<TreinoVO> listaTreinoVO) {
		this.listaTreinoVO = listaTreinoVO;
	}

	public TreinoVO getTreino() {
		return treino;
	}

	public void setTreino(TreinoVO treino) {
		this.treino = treino;
	}

	public ExercicioService getExercicioService() {
		return exercicioService;
	}

	public void setExercicioService(ExercicioService exercicioService) {
		this.exercicioService = exercicioService;
	}

	public List<ExercicioVO> getListaExercicioVO() {
		return listaExercicioVO;
	}

	public void setListaExercicioVO(List<ExercicioVO> listaExercicioVO) {
		this.listaExercicioVO = listaExercicioVO;
	}

	public ExercicioVO getExercicio() {
		return exercicio;
	}

	public void setExercicio(ExercicioVO exercicio) {
		this.exercicio = exercicio;
	}

	@PostConstruct
	private void init() {
		super.getConfigSpring();
		listaExercicioVO = exercicioService.listarTodos();
		// obtem o objeto da superclasse
	}

	public String chamarTelaCadastro(){
		listaExercicioVO = exercicioService.listarTodos();
		return TELA_CADASTRAR;
	}

	public String chamarTelaListarTodos(){
		listaTreinoVO = treinoService.consultarTodos();
		return TELA_LISTA_TODOS;
	}

	public String incluir() {
		try{
			treinoService.incluir(treino);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Treino salvo com sucesso!"));

		}catch (BusinessException exception){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,exception.getMessage()));
		}		
		return "";
	}

	public String excluir(TreinoVO treinoVO){		
		try{
			treinoService.excluir(treinoVO);
			this.listaTreinoVO = treinoService.consultarTodos();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Treino excluído com sucesso!"));

		}catch (BusinessException exception){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,exception.getMessage()));
		}
		return "";
	}

	public String consultar(TreinoVO treinoVO){
		try {
			treinoService.consultar(treinoVO);

			List<TreinoVO> listaSimples = new ArrayList<TreinoVO> ();
			listaSimples.add(treinoVO);
			this.listaTreinoVO = listaSimples;

		} catch (BusinessException exception) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,exception.getMessage()));

		}
		return "";
	}
}
