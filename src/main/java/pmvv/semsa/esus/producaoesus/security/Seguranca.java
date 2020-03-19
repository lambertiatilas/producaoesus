package pmvv.semsa.esus.producaoesus.security;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import pmvv.semsa.esus.producaoesus.model.Usuario;

@Named
@RequestScoped
public class Seguranca {

	private UsuarioSistema usuarioLogado = getUsuarioLogado();
	
	public Usuario getUsuario() {
		Usuario usuario = null;

		if (usuarioLogado != null) {
			usuario = usuarioLogado.getUsuario();
		}
		
		return usuario;
	}
	
	@Produces
	@UsuarioLogado
	public UsuarioSistema getUsuarioLogado() {
		UsuarioSistema usuario = null;
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();

		if (auth != null && auth.getPrincipal() != null) {
			usuario = (UsuarioSistema) auth.getPrincipal();
		}
		
		return usuario;
	}
}