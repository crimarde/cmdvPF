package cmdv.dao;

import cmdv.domain.User;

public interface UserDAO {

	public User findById(Long id);
	
}
