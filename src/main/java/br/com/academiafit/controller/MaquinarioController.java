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

import br.com.academiafit.exception.BusinessException;
import br.com.academiafit.service.MaquinarioService;
import br.com.academiafit.vo.MaquinarioVO;

@ManagedBean(name = "maquinarioMbean")
@SessionScoped
public class MaquinarioController extends AbstractController{

	public static String TELA_LISTA_TODOS = "/maquinario/listarTodos.xhtml";
	public static String TELA_CADASTRAR = "/maquinario/cadastrar_maquinario.xhtml";

	@Autowired
	private MaquinarioService maquinarioService;

	private List<MaquinarioVO> listaMaquinarioVO;

	private MaquinarioVO maquinario = new MaquinarioVO();

	@PostConstruct
	private void init() {
		super.getConfigSpring();
	}

	public MaquinarioVO getMaquinario() {
		return maquinario;
	}

	public void setMaquinario(MaquinarioVO employee) {
		this.maquinario = maquinario;
	}

	public List<MaquinarioVO> getListaMaquinarioVO() {
		return listaMaquinarioVO;
	}

	public String chamarTelaCadastro(){
		return TELA_CADASTRAR;
	}

	public String chamarTelaListarTodos(){
		listaMaquinarioVO = maquinarioService.listarTodos();
		return TELA_LISTA_TODOS;
	}

	public void incluir() {
		maquinarioService.incluir(maquinario);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Maquinario salvo com sucesso!"));
	}

	public void excluir(MaquinarioVO maquinarioVO){		
		try {
			maquinarioService.excluir(maquinarioVO);
			this.listaMaquinarioVO = maquinarioService.listarTodos();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Maquinario salvo com sucesso!"));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void alterar() {
		maquinarioService.alterar(maquinario);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,"Alteração salva com sucesso!"));
	}

}