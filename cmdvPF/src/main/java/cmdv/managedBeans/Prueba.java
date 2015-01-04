package cmdv.managedBeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cmdv.domain.User;
import cmdv.service.IServicioUser;
 
@Controller
@Scope("session")
public class Prueba implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
//	@Inject
//	EntityManagerFactory emf;
//
//	@Inject
//	EntityManager em;
	
	@Inject
	@Qualifier("servicioUser")
	private IServicioUser servicioUser;
	
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
		yo.setNombre(name);
		
		User resp = servicioUser.findById(1l);
		System.out.println("La respuesta es: " + resp.getNombre());
		resp = servicioUser.findById(2l);
		System.out.println("La respuesta es: " + resp.getNombre());
		resp = servicioUser.findById(3l);
		System.out.println("La respuesta es: " + resp.getNombre());
		//yo.setId(5l);	
	}
	
	public void welcome2(){
//		User yo = new User();
//		yo.setNombre(name);
//		//yo.setId(5l);
//		emf = Persistence.createEntityManagerFactory("UnidadPersonas");
//		em = emf.createEntityManager();
//		 try {
//		 em.getTransaction().begin();
//		 em.persist(yo);
//		 em.getTransaction().commit();
//		 } catch (Exception e) {
//		 
//		 e.printStackTrace();
//		 }finally {
//		 em.close();
//		 }
		
	}

}