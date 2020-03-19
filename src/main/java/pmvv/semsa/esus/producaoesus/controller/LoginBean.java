package pmvv.semsa.esus.producaoesus.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pmvv.semsa.esus.producaoesus.util.jsf.FacesUtil;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesContext facesContext;

	@Inject
	private HttpServletRequest request;

	@Inject
	private HttpServletResponse response;
	private String username;

	public void preRender() {
		if ("true".equals(request.getParameter("invalid"))) {
			FacesUtil.addErrorMessage("O nome de usuário ou a senha não estão corretos. Tente digitá-los novamente.");
		}
	}

	public void login() throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.xhtml");
		dispatcher.forward(request, response);
		facesContext.responseComplete();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}