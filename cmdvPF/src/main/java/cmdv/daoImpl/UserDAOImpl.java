package cmdv.daoImpl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cmdv.dao.UserDAO;
import cmdv.domain.User;

@Repository("userDao")
public class UserDAOImpl extends AbstractBaseGenericDAOImpl<User, Long> implements UserDAO {
	
	private static final Logger LOG = Logger.getLogger(UserDAOImpl.class);

	//Constuctor por defecto
	public UserDAOImpl() {
		super();
	}
	
	@Override
	public User findById(Long id) {
		long t1 = System.currentTimeMillis();
		User user = (User) ((Session) em.getDelegate())		//em.getDelegate obtine la sesión de hibernate (para los criteria)
				.createCriteria(User.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
		
		long t2 = System.currentTimeMillis();
		
		LOG.debug("Query getUserByLoginPassword execution time:" + (t2-t1));
		return user;
	}
	
	@Override
	public User findByUserPass(String user, String pass){
		return null;	
	}
	
	@Override
	public void addUser(User user){
		//Hace la llamada al metod de la clase abstracta de la que hereda
		this.create(user);
	}

}
