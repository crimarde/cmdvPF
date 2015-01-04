package cmdv.dao;

import cmdv.domain.User;

public interface UserDAO {

	/** Busca un usuario en la base de datos por su id */
	public User findById(Long id);

	/** Busca un usuario en la base de datos por la pareja de login-pass */
	public User findByUserPass(String user, String pass);

	/** Inserta un usuario en la base de datos */
	void addUser(User user);
	
}
