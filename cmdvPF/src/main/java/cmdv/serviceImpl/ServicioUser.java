package cmdv.serviceImpl;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cmdv.dao.UserDAO;
import cmdv.domain.User;
import cmdv.service.IServicioUser;

@Service
@Qualifier("servicioUser")
@Transactional
public class ServicioUser implements IServicioUser{

	@Inject
	private UserDAO userDAO;
	
	@Override
	public User findById(Long id) {
		return userDAO.findById(id);
	}


}
