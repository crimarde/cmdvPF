package cmdv.ManagedBeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cmdv.domain.User;

import java.io.Serializable;
 
@ManagedBean
@SessionScoped
public class Prueba implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
//	@Inject
	EntityManagerFactory emf;
//
//	@Inject
	EntityManager em;
	
	@PostConstruct
	public void init() {
//		em = emf.createEntityManager();
	}
 
	private String name;
 
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void welcome(){
		User yo = new User();
		yo.setNombre("Pedro");
		yo.setId(5l);
		emf = Persistence.createEntityManagerFactory("UnidadPersonas");
		em = emf.createEntityManager();
		 try {
		 em.getTransaction().begin();
		 em.persist(yo);
		 em.getTransaction().commit();
		 } catch (Exception e) {
		 
		 e.printStackTrace();
		 }finally {
		 em.close();
		 }
		
	}
}