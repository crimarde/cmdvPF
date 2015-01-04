package cmdv.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="USER")
public class User {
	
	@Id
	//@GenericGenerator(name="gen",strategy="increment")
	//@GeneratedValue(generator="gen")
    @Column(name = "ID")
	private Long id;
	
    @Column(name="NOMBRE", length = 5)
	private String nombre;

    @Column(name="PRIMER_APELLIDO", length = 5)
	private String ape1;

    @Column(name="SEGUNDO_APELLIDO", length = 5)
	private String ape2;
    
    @Column(name="LOGIN", length = 5)
	private String login;

    @Column(name="PASSWORD", length = 5)
	private String pass;
    
    @Column(name="INACTIVO")
    private boolean inactivo;
    
    @Column(name="ROLE", length = 5)
	private String role;
    
    public User() {
	}
     
    public User(Long id, String nombre, String ape1, String ape2, String login,
			String pass, boolean inactivo, String role) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.login = login;
		this.pass = pass;
		this.inactivo = inactivo;
		this.role = role;
	}



	public Boolean hasRole(String role){
		if(role != null){
			return role.equals(this.role);
		}
		return false;
	}
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isInactivo() {
		return inactivo;
	}

	public void setInactivo(boolean inactivo) {
		this.inactivo = inactivo;
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}