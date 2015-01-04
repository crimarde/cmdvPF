package cmdv.service;

import cmdv.domain.User;

public interface IServicioUser {

	public User findById(Long id);
	public User findByUserPass(String user, String pass);
	public void saveUser(User user);
	
}
