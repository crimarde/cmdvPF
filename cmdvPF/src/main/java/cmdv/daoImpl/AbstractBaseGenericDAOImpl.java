package cmdv.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//import org.hibernate.Session;
//import org.hibernate.Transaction;


import org.springframework.transaction.annotation.Transactional;

import cmdv.dao.BaseDAO;

/** Setea las variables necesarias para usar el DAO*/
/** Implementas las opciones básicas del CRUD a través de BaseDAO*/
public abstract class AbstractBaseGenericDAOImpl<T, K> implements BaseDAO<T, K> {
	
	// Constructor por defecto
	public AbstractBaseGenericDAOImpl() {
		super();
	}
	
	/* ===================================
	 * 			CONFIGURACION
	 =====================================*/
	
	//Se encarga de la persistencia de datos JPA
	protected EntityManager em = null;

    /* Sets the entity manager(configurado en el persisence-context.xml) */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
	
	//Metodo de prueba
	public T genrico(T entity){
		//Así es como lo haria a pelo en java
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
	
	
	/* ===================================
	 * 		CRUD BASICO IMPLEMENTADO	
	 =====================================*/

	//@Transactional
	@Override
	public T create(T entity) {
		//TODO al anotar un metodo como transaccional spring de encarga de la transaccion por lo que no hay que 
		//abrir la transaccion ni hacer commit, se encarga spring. Es más si lo intentas da un error, no se 
		//pueden crear transacciones en una transaccion conpartida
		//Not allowed to create transaction on shared EntityManager - use Spring transactions
		//em.getTransaction().begin();
		
		System.out.println(em.contains(entity));
		em.persist(entity);
		System.out.println(em.contains(entity));
		//em.getTransaction().commit();
		
		//Session session = (Session) em.getDelegate();
		//Transaction tx = session.beginTransaction();
		//session.saveOrUpdate(entity);
		//session.flush();
		//tx.commit();
		return entity;
	}

	@Override
	public T update(T entity) {
//		Session session = (Session) em.getDelegate();
//		Transaction tx = session.beginTransaction();
//		session.update(entity);
//		session.flush();
//		tx.commit();
		return entity;
	}

	@Override
	public void delete(T entity) {
//		Session session = (Session) em.getDelegate();
//		Transaction tx = session.beginTransaction();
//		session.delete(entity);
//		session.flush();
//		tx.commit();
	}
	
}
