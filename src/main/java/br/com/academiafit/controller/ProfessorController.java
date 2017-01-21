package br.com.academiafit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.academiafit.service.ProfessorService;
import br.com.academiafit.service.UsuarioService;
import br.com.academiafit.vo.ProfessorVO;
import br.com.academiafit.vo.UsuarioVO;

@ManagedBean(name = "professorMbean")
@SessionScoped
public class ProfessorController extends AbstractController{

	public static String TELA_LISTA_TODOS = "/professor/listarTodos.xhtml";
	public static String TELA_CADASTRAR = "/professor/cadastrar_professor.xhtml";

	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	private List<ProfessorVO> listaProfessorVO;
	private List<UsuarioVO> listaUsuarioVO;

	private ProfessorVO professor = new ProfessorVO();
	private UsuarioVO usuario = new UsuarioVO();

	@PostConstruct
	private void init() {
		// obtem o objeto da superclasse	
		super.getConfigSpring();
		this.listaUsuarioVO = usuarioService.consultarTodos();
	}

	public ProfessorVO getProfessor() {
		return professor;
	}

	public void setProfessor(ProfessorVO employee) {
		this.professor = professor;
	}

	public List<ProfessorVO> getListaProfessorVO() {
		return listaProfessorVO;
	}
	
	public static String getTELA_LISTA_TODOS() {
		return TELA_LISTA_TODOS;
	}

	public static void setTELA_LISTA_TODOS(String tELA_LISTA_TODOS) {
		TELA_LISTA_TODOS = tELA_LISTA_TODOS;
	}

	public static String getTELA_CADASTRAR() {
		return TELA_CADASTRAR;
	}

	public static void setTELA_CADASTRAR(String tELA_CADASTRAR) {
		TELA_CADASTRAR = tELA_CADASTRAR;
	}

	public ProfessorService getProfessorService() {
		return professorService;
	}

	public void setProfessorService(ProfessorService professorService) {
		this.professorService = professorService;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public List<UsuarioVO> getListaUsuarioVO() {
		return listaUsuarioVO;
	}

	public void setListaUsuarioVO(List<UsuarioVO> listaUsuarioVO) {
		this.listaUsuarioVO = listaUsuarioVO;
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}

	public void setListaProfessorVO(List<ProfessorVO> listaProfessorVO) {
		this.listaProfessorVO = listaProfessorVO;
	}

	public String chamarTelaCadastro(){
		this.listaUsuarioVO = usuarioService.consultarTodos();
		return TELA_CADASTRAR;
	}

	public String chamarTelaListarTodos(){
		listaProfessorVO = professorService.listarTodos();
		return TELA_LISTA_TODOS;
	}

	public String incluir() {
		professorService.incluir(professor);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Professor salvo com sucesso!"));
		return "";
	}

	public String excluir(ProfessorVO professorVO){		
		professorService.excluir(professorVO.getCpf());
		this.listaProfessorVO = professorService.listarTodos();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Professor salvo com sucesso!"));
		return "";
	}
	
	public void alterar(RowEditEvent event) {
		ProfessorVO professorVOAlterado = ((ProfessorVO) event.getObject());
		professorService.alterar(professorVOAlterado);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Professor alterado com sucesso!"));

	}

	public void cancelarEdicao(RowEditEvent event) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Edição Cancelada!"));
	}
}
