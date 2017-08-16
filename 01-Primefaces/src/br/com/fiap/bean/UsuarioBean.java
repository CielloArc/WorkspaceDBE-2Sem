package br.com.fiap.bean;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.DBException;

@ManagedBean
@SessionScoped
public class UsuarioBean {

	private Usuario usuario;

	private UsuarioBO bo;

	@PostConstruct
	private void init() {
		// Inicializar os objetos
		usuario = new Usuario();
		usuario.setDataNascimento(Calendar.getInstance());
		bo = new UsuarioBO();
	}

	public String cadastrar() {
		FacesMessage msg;
		try {
			if (usuario.getCodigo() == 0) {
				bo.cadastrar(usuario);
				msg = new FacesMessage("Cadastrado!");
			} else {
				bo.atualizar(usuario);
				msg = new FacesMessage("Atualizado");
			}

			usuario = new Usuario();
			usuario.setDataNascimento(Calendar.getInstance());
		} catch (DBException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro...");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "usuario?faces-redirect=true";
	}

	public void subirFoto(FileUploadEvent event) {
		try {
			usuario.setFoto(IOUtils.toByteArray(event.getFile().getInputstream()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * //Cadastra no disco try { File file = new File("D:\\temp\\",
		 * event.getFile().getFileName()); FileOutputStream stream = new
		 * FileOutputStream(file); stream.write(event.getFile().getContents());
		 * stream.close();
		 * 
		 * // Grava o nome do arquivo no banco
		 * usuario.setFoto(event.getFile().getFileName()); } catch (Exception e)
		 * { e.printStackTrace(); }
		 */

	}

	public StreamedContent getFoto() {
		FacesContext context = FacesContext.getCurrentInstance();
		DefaultStreamedContent content = new DefaultStreamedContent();
		content.setContentType("image/jpg");
		try {
			if (context.getRenderResponse() || usuario.getFoto() == null) {
				content.setStream(new FileInputStream("D:\\temp\\default.jpg"));
			} else {			
				content.setStream(new ByteArrayInputStream(usuario.getFoto()));
				//content.setStream(new FileInputStream("D:\\temp\\" + usuario.getFoto()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return content;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
