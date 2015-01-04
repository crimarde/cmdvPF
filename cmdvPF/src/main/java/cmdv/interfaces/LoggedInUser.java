package cmdv.interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import cmdv.domain.User;
import cmdv.security.Authority;
import cmdv.security.CustomUserDetails;
import cmdv.tool.util.UserRole;

@Component("loggedInUser")
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
public class LoggedInUser  implements ILoggedInUser{
	
	private static final long serialVersionUID = -1033377115353626379L;
		
	private User user;
	
	@PostConstruct
	public void init(){
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void updateSecurityContext(HttpServletRequest request, HttpServletResponse response){
		List<Authority> auths = new ArrayList<Authority>();
		if(user.getRole().equals(UserRole.ADMIN.getNom()) || user.getRole().equals(UserRole.ADMIN_EP.getNom())){
			auths.add(new Authority("ROLE_ADMIN")); //Role here, like "admin"
			auths.add(new Authority("ROLE_USER"));
		}else {
			//auths.add(new Authority(user.getRole())); //Role here, like "admin"
			auths.add(new Authority("ROLE_USER"));
		}
		
		Authentication authentication =  new UsernamePasswordAuthenticationToken(new CustomUserDetails(user), null, auths);
		SecurityContextHolder.getContext().setAuthentication(authentication);	
	}
	
}