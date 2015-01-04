package cmdv.interfaces;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cmdv.domain.User;

public interface ILoggedInUser extends Serializable{

	public User getUser();
	public void setUser(User user);
	/**
	 * Update security context
	 * This method should be called whenever setUser is called.
	 * It's defined here to be conform with the DRY principle.
	 * @param request
	 * @param response
	 */
	public void updateSecurityContext(HttpServletRequest request, HttpServletResponse response);
}