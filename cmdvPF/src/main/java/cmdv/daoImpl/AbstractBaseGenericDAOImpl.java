package cmdv.daoImpl;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cmdv.dao.BaseDAO;

public abstract class AbstractBaseGenericDAOImpl<T, K> implements BaseDAO<T, K> {
	
	//@Inject
	EntityManagerFactory emf;

	EntityManager em;
	
	public AbstractBaseGenericDAOImpl() {
		super();
		//em = emf.createEntityManager();
	}
	
	@Override
	public T genrico(T entity){
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPersonas");
		//EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return entity;
	}

	@Override
	public T create(T entity) {
		Session session = (Session) em.getDelegate();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(entity);
		session.flush();
		tx.commit();
		return entity;
	}

	@Override
	public T update(T entity) {
		Session session = (Session) em.getDelegate();
		Transaction tx = session.beginTransaction();
		session.update(entity);
		session.flush();
		tx.commit();
		return entity;
	}

	@Override
	public void delete(T entity) {
		Session session = (Session) em.getDelegate();
		Transaction tx = session.beginTransaction();
		session.delete(entity);
		session.flush();
		tx.commit();
	}
}
