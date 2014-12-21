package cmdv.daoImpl;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cmdv.dao.UserDAO;
import cmdv.domain.User;

@Repository("userDao")
public class UserDAOImpl extends AbstractBaseGenericDAOImpl<User, Long> implements UserDAO {
	
	@Override
	public User findById(Long id) {
		User user = (User) ((Session) em.getDelegate())		//em.getDelegate obtine la sesión de hibernate (para los criteria)
				.createCriteria(User.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
		return user;
	}

}
