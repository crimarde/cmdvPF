package cmdv.managedBeans;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cmdv.interfaces.ILoggedInUser;

public abstract class BaseManagedBean implements Serializable{
	private static final long serialVersionUID = 7497937904070681285L;

	protected abstract ILoggedInUser getLoggedInUser();
	
	protected void updateSecurityContext(){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		getLoggedInUser().updateSecurityContext(request, response);
	}
	
	
}
