package cmdv.managedBeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cmdv.domain.User;
import cmdv.interfaces.ILoggedInUser;
import cmdv.service.IServicioUser;
import cmdv.tool.util.UserRole;
 
@Controller("loginController")
@Scope("session")
public class LoginController extends BaseManagedBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	private static final String ADMIN_HOME="pretty:home";
	private static final String USER_HOME="pretty:home";
	
	private String user;
	private String pass;
	
	private boolean loginError = false;
	private String userLogin;
	
	@Inject
	@Qualifier("servicioUser")
	private IServicioUser servicioUser;
	
	@Inject
	@Qualifier("datosMaestrosBean")
	private DatosMaestrosBean datosMaestrosBean;
	
	@Inject
	@Qualifier("loggedInUser")
	private ILoggedInUser loggedInUser;
						  
	@PostConstruct
	public void init() {
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
	
	public String login(){
		if(user != null && pass != null){
			return someLoginMethod();
		}
		return "pretty:login";
	}
	
	public void logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
	
	private String someLoginMethod(){
		
		//entornBean.setEntorn(entorn);
		
		User user = servicioUser.findByUserPass(getUser(), getPass());

		//Si el usuario no es nulo (existe en la base de datos)
		if (user == null) {
			this.loginError = true;
			this.userLogin = "";
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario o contraseña son incorrectos", ""));
			context.getExternalContext().getFlash().setKeepMessages(true);
			return "pretty:login";
		} else if(user.isInactivo() == true){
			this.loginError = true;
			this.userLogin = "";
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario no está activo en el sistema", ""));
			context.getExternalContext().getFlash().setKeepMessages(true);
			return "pretty:login";
		}else {
			this.loginError = false;
			loggedInUser.setUser(user);
			datosMaestrosBean.setUsuarioLogueado(loggedInUser.getUser());
			updateSecurityContext();		
			
			String home;
			
			if(user.hasRole(UserRole.ADMIN.toString())){
				home =  ADMIN_HOME;
			} else {
				home =  USER_HOME;
			}
			
			/*ELIMINAR LA LINEA*/
			home = "ok";
			return home;
		}
	
	}
	
	public void reset(){
		
	}

	public String pruebaExito(){
		User u = new User(58L, "Marc", "Martinez", "del Vals", "cmdv", "pass", false ,(UserRole.ADMIN.name()));
		servicioUser.saveUser(u);
		System.out.println(servicioUser.findById(1L).getNombre());
		return "ok";
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isLoginError() {
		return loginError;
	}

	public void setLoginError(boolean loginError) {
		this.loginError = loginError;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	@Override
	protected ILoggedInUser getLoggedInUser() {
		return this.loggedInUser;
	}
}