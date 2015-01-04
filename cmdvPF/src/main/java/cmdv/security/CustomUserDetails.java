package cmdv.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cmdv.domain.User;
import cmdv.tool.util.UserRole;



public class CustomUserDetails implements UserDetails{
	private static final long serialVersionUID = 2270217112782820892L;
	
	private User user;
	
	public CustomUserDetails(User user) {
		super();
		this.user = user;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public String getUsername() {
		return user.getNombre();
	}
	
	@Override
	public String getPassword() {
		return user.getPass();
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Authority> auths = new ArrayList<Authority>();
		if(user.getRole().equals(UserRole.ADMIN.getNom()) || user.getRole().equals(UserRole.ADMIN_EP.getNom())){
			auths.add(new Authority("ROLE_ADMIN")); //Role here, like "admin"
			auths.add(new Authority("ROLE_USER"));
		}else {
			auths.add(new Authority(user.getRole())); //Role here, like "admin"
		}
		return auths;
	}
}
