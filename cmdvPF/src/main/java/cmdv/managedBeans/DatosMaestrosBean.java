package cmdv.managedBeans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cmdv.domain.User;

@Component
@Scope("session")
public class DatosMaestrosBean {

	private User usuarioLogueado;

	public User getUsuarioLogueado() {
		return usuarioLogueado;
	}

	public void setUsuarioLogueado(User usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
	}

}
