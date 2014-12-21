package cmdv.dao;

import cmdv.domain.User;

public interface UserDAO {

	//Selec de todos los objetos de la base de datos
	public User findById(Long id);
	
}
