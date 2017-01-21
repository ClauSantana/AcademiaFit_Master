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
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;

import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.service.ExercicioService;
import br.com.academiafit.service.MaquinarioService;
import br.com.academiafit.vo.ExercicioVO;
import br.com.academiafit.vo.MaquinarioVO;
import br.com.academiafit.vo.UsuarioVO;

@ManagedBean(name = "exercicioMbean")
@SessionScoped
public class ExercicioController extends AbstractController {
	
	//declara a tela listar_todos
	public static String TELA_LISTAR_TODOS = "/exercicio/listarTodos.xhtml";
	
	//declara a tela cadastro
	public static String TELA_CADASTRAR_EXERCICIO = "/exercicio/cadastrar_exercicio.xhtml";

	@Autowired //informa as variaveis que iram acessar a SERVICE e a SERVICE IMPL
	private ExercicioService exercicioService; //tem acesso a service
	private List<ExercicioVO> listExercicioVO; //lista do banco
	private ExercicioVO exercicio = new ExercicioVO(); //é o que vem da tela do usuario
	
	@Autowired
	private MaquinarioService maquinarioService;
	private List<MaquinarioVO> listaMaquinarioVO;
	private MaquinarioVO maquinario = new MaquinarioVO();

	@PostConstruct //a primeira coisa que executa quando chama a Classe
	private void init() {
		super.getConfigSpring(); //SUPER - vai para entidade Pai nesse caso ABSTRACT - ConfgSpring - Permissão para acessar a ABSTRACT
		this.listaMaquinarioVO = maquinarioService.listarTodos();
	}

	//Get e Set dos atributos para acessar a SERVICE e IMPL
	public static String getTELA_LISTAR_TODOS() {
		return TELA_LISTAR_TODOS;
	}

	public static void setTELA_LISTAR_TODOS(String tELA_LISTAR_TODOS) {
		TELA_LISTAR_TODOS = tELA_LISTAR_TODOS;
	}

	public static String getTELA_CADASTRAR_EXERCICIO() {
		return TELA_CADASTRAR_EXERCICIO;
	}

	public static void setTELA_CADASTRAR_EXERCICIO(String tELA_CADASTRAR_EXERCICIO) {
		TELA_CADASTRAR_EXERCICIO = tELA_CADASTRAR_EXERCICIO;
	}

	public ExercicioService getExercicioService() {
		return exercicioService;
	}

	public void setExercicioService(ExercicioService exercicioService) {
		this.exercicioService = exercicioService;
	}

	public List<ExercicioVO> getListExercicioVO() {
		return listExercicioVO;
	}

	public void setListExercicioVO(List<ExercicioVO> listExercicioVO) {
		this.listExercicioVO = listExercicioVO;
	}

	public ExercicioVO getExercicio() {
		return exercicio;
	}

	public void setExercicio(ExercicioVO exercicio) {
		this.exercicio = exercicio;
	}

	public MaquinarioService getMaquinarioService() {
		return maquinarioService;
	}

	public void setMaquinarioService(MaquinarioService maquinarioService) {
		this.maquinarioService = maquinarioService;
	}

	public List<MaquinarioVO> getListaMaquinarioVO() {
		return listaMaquinarioVO;
	}

	public void setListaMaquinarioVO(List<MaquinarioVO> listaMaquinarioVO) {
		this.listaMaquinarioVO = listaMaquinarioVO;
	}
	
	public MaquinarioVO getMaquinario() {
		return maquinario;
	}

	public void setMaquinario(MaquinarioVO maquinario) {
		this.maquinario = maquinario;
	}

	//chama a tela cadastro
	public String chamarTelaCadastro(){
		this.listaMaquinarioVO = maquinarioService.listarTodos();
		return TELA_CADASTRAR_EXERCICIO;
	}
	
	public String chamarTelaListarTodos(){
		listExercicioVO = exercicioService.listarTodos(); 
		return TELA_LISTAR_TODOS;
	}	

	public String incluir() {

		try {
			exercicioService.incluir(exercicio);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Exercício salvo com sucesso!"));
		
		} catch (BusinessException exception) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,exception.getMessage()));
			
		}

		return "";
	}

	public String excluir(ExercicioVO exercicioVO){
		if(exercicioVO != null && exercicioVO.getId() != 0){
			try {
				this.exercicioService.excluir(exercicioVO);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Exercício excluído com sucesso!"));
			
			} catch (BusinessException exception) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,exception.getMessage()));
				
			}		
		}
		this.listExercicioVO = exercicioService.listarTodos();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Exercicio excluido com sucesso!"));
		return "";
	}

	private void limparCampos() {
		this.getExercicio().setMusculo(null);
		this.getExercicio().setExercicio(null);
	}
}


