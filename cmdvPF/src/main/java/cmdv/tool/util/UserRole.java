package cmdv.tool.util;


public enum UserRole {
	ADMIN ("Administrador funcional del sistema"),
	ADMIN_EP ("Administrador del proveïdor"),
	USER ("Usuari");
	
	UserRole(String nom) {
		this.nom = nom;
	}
	
	public String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public static String returnNom(String value) {
		String nom = "";
		for (UserRole role : UserRole.values()) {
			if (role.name().equals(value)) {
				nom = role.getNom();
			}
		}
		return nom;
	}

}
