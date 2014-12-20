package cmdv.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cmdv.dao.UserDAO;
import cmdv.domain.User;

@Transactional
@Repository("userDao")
public class UserDAOImpl extends AbstractBaseGenericDAOImpl<User, Long> implements UserDAO {

	@Override
	public User findById(Long id) {
		User coc = (User) ((Session) em.getDelegate())		//em.getDelegate obtine la sesión de hibernate (para los criteria)
				.createCriteria(User.class)
				.add(Restrictions.eq("idSap", id))
				.uniqueResult();

		return coc;
	}

}
